// COMS22303: IR tree construction
//
// This program converts an Abstract Syntax Tree produced by ANTLR to an IR tree.
// The Abstract Syntax Tree has type CommonTree and can be walked using 5 simple
// methods.  If ast is a CommonTree and t is a Token:
//   
//   int        ast.getChildCount();                       // Get # of subtrees
//   CommonTree (CommonTree)ast.getChild(int childNumber); // Get a subtree
//   Token      ast.getToken();                            // Get a node's token
//   int        t.getType();                               // Get token type
//   String     t.getText();                               // Get token text
//
// Every method below has two parameters: the AST (input) and IR tree (output).
// Some methods (arg()) return the type of the item processed.

import java.util.*;
import java.io.*;
import java.lang.reflect.Array;
import antlr.collections.AST;
import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;

public class Irt
{
// The code below is generated automatically from the ".tokens" file of the 
// ANTLR syntax analysis, using the TokenConv program.
//c
// CAMLE TOKENS BEGIN
  public static final String[] tokenNames = new String[] {
"NONE", "NONE", "NONE", "NONE", "BEGIN", "END", "WRITE", "WRITELN", "ELSE", "IF", "READ", "REPEAT", "UNTIL", "SEMICOLON", "OPENPAREN", "CLOSEPAREN", "GREATER", "LESSER", "EQUALS", "DEQUALS", "GEQUALS", "LEQUALS", "PLUS", "MINUS", "TIMES", "DIVIDE", "ASSIGN", "INT", "EXPONENT", "REALNUM", "CHAR", "IDENT", "STRING", "COMMENT", "WS"};
  public static final int CLOSEPAREN=15;
  public static final int GEQUALS=20;
  public static final int EXPONENT=28;
  public static final int ELSE=8;
  public static final int CHAR=30;
  public static final int INT=27;
  public static final int SEMICOLON=13;
  public static final int EQUALS=18;
  public static final int MINUS=23;
  public static final int WRITE=6;
  public static final int LEQUALS=21;
  public static final int IF=9;
  public static final int DEQUALS=19;
  public static final int WS=34;
  public static final int GREATER=16;
  public static final int LESSER=17;
  public static final int WRITELN=7;
  public static final int READ=10;
  public static final int UNTIL=12;
  public static final int BEGIN=4;
  public static final int REALNUM=29;
  public static final int ASSIGN=26;
  public static final int IDENT=31;
  public static final int PLUS=22;
  public static final int REPEAT=11;
  public static final int OPENPAREN=14;
  public static final int END=5;
  public static final int TIMES=24;
  public static final int COMMENT=33;
  public static final int DIVIDE=25;
  public static final int STRING=32;
// CAMLE TOKENS END

  public static int labelcount = 0;

  public static IRTree convert(CommonTree ast)
  {
    IRTree irt = new IRTree();
    program(ast, irt);
    return irt;
  }

  // Convert a program AST to IR tree
  public static void program(CommonTree ast, IRTree irt)
  {
    statements(ast, irt);
  }

  // Convert a compoundstatement AST to IR tree
  public static void statements(CommonTree ast, IRTree irt)
  {
    Token t = ast.getToken();
    int tt = t.getType();
    if (tt == BEGIN) {
      int n = ast.getChildCount();
      if (n == 0) {
        irt.setOp("NOOP");
      }
      else {
        CommonTree ast1 = (CommonTree)ast.getChild(0);
        statements1(ast, 0, n-1, irt);
      }
    }
    else {
      error(tt);
    }
  }

  public static void statements1(CommonTree ast, int first, int last, IRTree irt)
  {
    CommonTree ast1 = (CommonTree)ast.getChild(first);
    if (first == last) {
      statement(ast1, irt);
    }
    else {
      IRTree irt1 = new IRTree();
      IRTree irt2 = new IRTree();
      statement(ast1, irt1);
      statements1(ast, first+1, last, irt2);
      irt.setOp("SEQ");
      irt.addSub(irt1);
      irt.addSub(irt2);
    }
  }

  // Convert a statement AST to IR tree
  public static void statement(CommonTree ast, IRTree irt)
  {


    labelcount++;
    CommonTree ast1;
    IRTree irt1 = new IRTree();
    Token t = ast.getToken();
    int tt = t.getType();
    if (tt == WRITELN)
    {
      String a = String.valueOf(Memory.allocateString("\n"));
      irt.setOp("WRS");
      irt.addSub(new IRTree("MEM", new IRTree("CONST", new IRTree(a))));
    }
    else if (tt == WRITE)
    {
      ast1 = (CommonTree)ast.getChild(0);
      String type = arg(ast1, irt1);
      if (type.equals("real")) {
        irt.setOp("WRR");
        irt.addSub(irt1);
      }
      else {
        irt.setOp("WRS");
        irt.addSub(irt1);
      }
    }
    else if(tt == ASSIGN)
    {
      //try deailng with assign here
      irt.setOp("MOVE");
      String varName = ast.getChild(0).getText();
      IRTree iHold = new IRTree();
      expression((CommonTree)ast.getChild(0), iHold);
      expression((CommonTree)ast.getChild(1), irt1);
      irt.addSub(iHold);
      irt.addSub(irt1);
    }
    else if(tt == READ)
    {
      irt.setOp("READIN");
      String varName = ast.getChild(0).getText();
      IRTree iHold = new IRTree();
      expression((CommonTree)ast.getChild(0), iHold);
      irt.addSub(iHold);

    }
    else if(tt == IF)
    {
      irt.setOp("IF");

      IRTree ifTree = new IRTree();
      IRTree elseTree = new IRTree("ELSETREE");
      IRTree ifType = new IRTree("IFTYPE");
      ifTree.addSub(convert((CommonTree)ast.getChild(1)));
      IRTree labels = new IRTree();
      int labelHold = labelcount;
      if(ast.getChildCount() > 2)
      {
         elseTree.addSub(convert((CommonTree)ast.getChild(2)));
         ifType = new IRTree("ELSETYPE");
         labels.addSub(new IRTree("LABEL", new IRTree("ELSEL"+labelHold)));
      }
      labels.addSub(new IRTree("LABEL", new IRTree("POSTL"+labelHold)));

      IRTree ifConditions = new IRTree();
      expression((CommonTree)ast.getChild(0), ifConditions);
      ifConditions.setOp("IFCONDITIONS");
      ifConditions.addSub(labels);
      irt.addSub(ifType);
      irt.addSub(ifConditions);
      irt.addSub(ifTree);
      irt.addSub(elseTree);

    }
    else if(tt == REPEAT)
    {
      IRTree conditions     = new IRTree();
      IRTree labels         = new IRTree();
      IRTree postLabel      = new IRTree("LABEL", new IRTree("POSTL"+labelcount));
      IRTree conditionLabel = new IRTree("LABEL", new IRTree("CONDL"+labelcount));
      //make sure it matches the IF stuff, so I can run it through expression->conditions
      labels.addSub(postLabel);
      System.out.println("REPEAT OP = "+ ast.getChild(1).getText());
      expression((CommonTree)ast.getChild(1), conditions);
      conditions.setOp("REPEATCONDITIONS");
      conditions.addSub(labels);
      irt.setOp("REPEAT");
      irt.addSub(convert((CommonTree)ast.getChild(0)));
      irt.addSub(conditions);
      irt.addSub(conditionLabel);
    }
    else {
      error(tt);
    }
  }

  // Convert an arg AST to IR tree
  public static String arg(CommonTree ast, IRTree irt)
  {
    Token t = ast.getToken();
    int tt = t.getType();
    if (tt == STRING) {
      String tx = t.getText();
      int a = Memory.allocateString(tx); 
      String st = String.valueOf(a);
      irt.setOp("MEM");
      irt.addSub(new IRTree("CONST", new IRTree(st)));
      return "string";
    }
    else {
      expression(ast, irt);
      return "real";
    }
  }

  // Convert an expression AST to IR tree
  public static void expression(CommonTree ast, IRTree irt)
  {
    CommonTree ast1;
    IRTree irt1 = new IRTree();
    Token t = ast.getToken();
    int tt = t.getType();
    if (tt == REALNUM)
    {
      constant(ast, irt1);
      irt.setOp("CONST");
      irt.addSub(irt1);
    }
    else if(tt == PLUS || tt == MINUS || tt == TIMES || tt == DIVIDE)
    {
      //do something
      irt.setOp("BINOP");
      IRTree irt2 = new IRTree();
      expression((CommonTree)ast.getChild(0), irt1);
      expression((CommonTree)ast.getChild(1), irt2);
    	if(tt == PLUS)
         	 irt.addSub(new IRTree("+")); 
    	else if(tt == MINUS)
    		irt.addSub(new IRTree("-"));
    	else if(tt == TIMES)
    		irt.addSub(new IRTree("*"));
    	else if(tt == DIVIDE)
    		irt.addSub(new IRTree("/"));
       irt.addSub(irt1);
       irt.addSub(irt2);
    }
    else if(tt == IDENT)
    {
       irt.setOp("MEM");
       irt.addSub(new IRTree("CONST", new IRTree(String.valueOf(Memory.allocateReal(ast.getText())))));

    }
    else if(tt == EQUALS || tt == GREATER || tt == LESSER || tt == DEQUALS || tt == GEQUALS || tt == LEQUALS)
    {
	       //move to cg, check the op (if its equals, use the opcode for one side minus the other)
      	
      	switch(tt)
      	{
      	  case EQUALS:  irt.addSub(new IRTree("EQUALS"));   break;
      	  case GREATER: irt.addSub(new IRTree("GREATER"));  break;
      	  case LESSER:  irt.addSub(new IRTree("LESSER"));   break;
      	  case DEQUALS: irt.addSub(new IRTree("DEQUALS"));  break;
      	  case GEQUALS: irt.addSub(new IRTree("GEQUALS"));  break;
      	  case LEQUALS: irt.addSub(new IRTree("LEQUALS"));  break;
      	}
      	IRTree irt2 = new IRTree();
      	expression((CommonTree)ast.getChild(0), irt1);
      	expression((CommonTree)ast.getChild(1), irt2);
      	irt.addSub(irt1);
      	irt.addSub(irt2);
    } 
    else
    {
       System.out.println("LOST TYPE = " + tt);
    }
  }

  // Convert a constant AST to IR tree
  public static void constant(CommonTree ast, IRTree irt)
  {
    Token t = ast.getToken();
    int tt = t.getType();
    if (tt == REALNUM) {
      String tx = t.getText();
      irt.setOp(tx);
    }
    else {
      error(tt);
    }
  }


  private static void error(int tt)
  {
    System.out.println("IRT error: "+tokenNames[tt]);
    System.exit(1);
  }
}
