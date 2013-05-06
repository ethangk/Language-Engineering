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
"NONE", "NONE", "NONE", "NONE", "BEGIN", "END", "WRITE", "WRITELN", "ELSE", "IF", "READ", "REPEAT", "UNTIL", "WHILE", "SEMICOLON", "OPENPAREN", "CLOSEPAREN", "GREATER", "LESSER", "EQUALS", "DEQUALS", "GEQUALS", "LEQUALS", "PLUS", "MINUS", "TIMES", "DIVIDE", "ASSIGN", "INT", "EXPONENT", "REALNUM", "CHAR", "STRING", "COMMENT", "WS", "CHARORINT", "IDENT"};
  public static final int CLOSEPAREN=16;
  public static final int GEQUALS=21;
  public static final int EXPONENT=29;
  public static final int WHILE=13;
  public static final int ELSE=8;
  public static final int CHAR=31;
  public static final int INT=28;
  public static final int SEMICOLON=14;
  public static final int EQUALS=19;
  public static final int MINUS=24;
  public static final int WRITE=6;
  public static final int LEQUALS=22;
  public static final int DEQUALS=20;
  public static final int IF=9;
  public static final int LESSER=18;
  public static final int WS=34;
  public static final int GREATER=17;
  public static final int WRITELN=7;
  public static final int READ=10;
  public static final int UNTIL=12;
  public static final int BEGIN=4;
  public static final int REALNUM=30;
  public static final int ASSIGN=27;
  public static final int IDENT=36;
  public static final int PLUS=23;
  public static final int REPEAT=11;
  public static final int OPENPAREN=15;
  public static final int END=5;
  public static final int TIMES=25;
  public static final int COMMENT=33;
  public static final int CHARORINT=35;
  public static final int DIVIDE=26;
  public static final int STRING=32;
// CAMLE TOKENS END

  public static int labelcount = 0;
  private static boolean preProcess = true;

  public static String addLabel()
  {
    labelcount++;
    return "L" + String.valueOf(labelcount);
  }

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
      System.out.println("STATEMENTSSSSS error");
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


      IRTree e1 = new IRTree();
      IRTree e2 = new IRTree();

      expression((CommonTree)ast.getChild(0).getChild(0), e1);
      expression((CommonTree)ast.getChild(0).getChild(1), e2);
      if(e1.getOp() == "CONST" && e2.getOp() == "CONST" && preProcess)
      {
          boolean breakOut = false;
          double v1 = Double.parseDouble(e1.getSub(0).getOp());
          double v2 = Double.parseDouble(e2.getSub(0).getOp());
          String whatDo = ast.getChild(0).getText();
          if(whatDo.equals("<"))
          {
              breakOut = v1 < v2;
          }
          else if(whatDo.equals(">"))
          {
              breakOut = v1 > v2;
          }
          else if(whatDo.equals("="))
          {
              breakOut = v1 == v2;
          }
          else if(whatDo.equals("!="))
          {
              breakOut = v1 != v2;
          }
          else if(whatDo.equals(">="))
          {
              breakOut = v1 >= v2;
          }
          else if(whatDo.equals("<="))
          {
              breakOut = v1 <= v2;
          }
          if(!breakOut && ast.getChildCount() <= 2)
          {
            irt.setOp("NOOP");
            return;
          }
      }
      
      irt.setOp("SEQ");
      irt1.setOp("CJUMP");
      irt.addSub(irt1);

      //Add op, left side of op and right side of op, labels
      irt1.addSub(new IRTree(ast.getChild(0).getText()));
      irt1.addSub(e1);
      irt1.addSub(e2);
      String preLabel =   Irt.addLabel();
      String midLabel =   Irt.addLabel();
      String postLabel =  Irt.addLabel();


      if(ast.getChildCount() > 2)
      {
        //theres an else statement, add else label
        irt1.addSub(new IRTree(midLabel));
      }
      else
        irt1.addSub(new IRTree(postLabel));

      IRTree irt2 = new IRTree("SEQ", new IRTree("LABEL", new IRTree(preLabel)));
      IRTree ifCode = new IRTree();
      statements((CommonTree)ast.getChild(1), ifCode);
      IRTree irt3 = new IRTree("SEQ", ifCode);

      if(ast.getChildCount() > 2)
      {
        //build the entire else tree
        IRTree irt4 = new IRTree("SEQ", new IRTree("JUMP", new IRTree(postLabel)));

        IRTree irt5 = new IRTree("SEQ", new IRTree("LABEL", new IRTree(midLabel)));

        IRTree irt6 = new IRTree("SEQ");
        IRTree elseCode = new IRTree();
        statements((CommonTree)ast.getChild(2), elseCode);
        irt6.addSub(elseCode);
        irt6.addSub(new IRTree("LABEL", new IRTree(postLabel)));

        irt5.addSub(irt6);
        irt4.addSub(irt5);
        irt3.addSub(irt4);

      }
      else
      {
        irt3.addSub(new IRTree("LABEL", new IRTree(postLabel)));
      }
      irt2.addSub(irt3);
      irt.addSub(irt2);

    }
    else if(tt == REPEAT)
    {
       irt.setOp("SEQ");
        
       String preLabel =      Irt.addLabel();
       IRTree preLabelTree =  new IRTree("LABEL",  new IRTree(preLabel));

        String postLabel =      Irt.addLabel();
        IRTree postLabelTree =  new IRTree("LABEL",  new IRTree(postLabel));

        
        irt.addSub(preLabelTree);
        
        irt1.setOp("SEQ");
        IRTree whileCode = new IRTree();
        statements((CommonTree)ast.getChild(0), whileCode);
        irt1.addSub(whileCode);
        
        IRTree irt2 = new IRTree("SEQ");
        IRTree irt3 = new IRTree("CJUMP");


        //left and right side of the comparison
        IRTree e1 = new IRTree();
        IRTree e2 = new IRTree();
        expression((CommonTree)ast.getChild(1).getChild(0), e1);
        expression((CommonTree)ast.getChild(1).getChild(1), e2);

        
        irt3.addSub(new IRTree(ast.getChild(1).getText()));
        irt3.addSub(e1);
        irt3.addSub(e2);
        irt3.addSub(new IRTree(preLabel));
        irt2.addSub(irt3);
        irt2.addSub(new IRTree("NOOP"));
        irt1.addSub(irt2);
        irt.addSub(irt1);
    }
    else if(tt == WHILE)
    {
        irt.setOp("SEQ");
        
         String preLabel =      Irt.addLabel();
         IRTree preLabelTree =  new IRTree("LABEL",  new IRTree(preLabel));

        String postLabel =      Irt.addLabel();
        IRTree postLabelTree =  new IRTree("LABEL",  new IRTree(postLabel));

        
        IRTree postLabelHold = new IRTree("SEQ", new IRTree("JUMP", new IRTree(preLabel)));
        postLabelHold.addSub(postLabelTree);

        irt.addSub(preLabelTree);
        
        IRTree whileTree = new IRTree("SEQ");
        IRTree whileCode = new IRTree();
        statements((CommonTree)ast.getChild(1), whileCode);
        whileTree.addSub(whileCode);
        whileTree.addSub(postLabelHold);
        
        IRTree seqTree = new IRTree("SEQ");
        IRTree jumpTree = new IRTree("CJUMP");


        //left and right side of the comparison
        IRTree e1 = new IRTree();
        IRTree e2 = new IRTree();
        expression((CommonTree)ast.getChild(0).getChild(0), e1);
        expression((CommonTree)ast.getChild(0).getChild(1), e2);

        //System.out.println(ast.getChild(0).getText());
        jumpTree.addSub(new IRTree(ast.getChild(0).getText()));
        jumpTree.addSub(e1);
        jumpTree.addSub(e2);
        jumpTree.addSub(new IRTree(postLabel));
        seqTree.addSub(jumpTree);
        seqTree.addSub(whileTree);
        irt.addSub(seqTree);
    }
    else {
      System.out.println("Statement error");
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
      
      CommonTree ex1 = (CommonTree)ast.getChild(0);
      CommonTree ex2 = (CommonTree)ast.getChild(1);
      IRTree irt2 = new IRTree();
      expression(ex1, irt1);
      expression(ex2, irt2);
      if(irt1.getOp() == "CONST" && irt2.getOp() == "CONST")
      {
            //two realnums, lets preprocess
            double n1 = Double.parseDouble(irt1.getSub(0).getOp());
            double n2 = Double.parseDouble(irt2.getSub(0).getOp());
            double outVal = 0.0;
            switch(tt)
            {
              case PLUS: outVal = n1+n2; break;
              case MINUS: outVal = n1-n2; break;
              case TIMES: outVal = n1*n2; break;
              case DIVIDE: outVal = n1/n2; break;
            }

            String s = String.valueOf(outVal);
            irt1.setOp(s.substring(0, Math.min(s.length(), 10)));
            irt.setOp("CONST");
            irt.addSub(irt1);
      }
      else
      {
          irt.setOp("BINOP");

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
    }
    else if(tt == IDENT)
    {
       irt.setOp("MEM");
       irt.addSub(new IRTree("CONST", new IRTree(String.valueOf(Memory.allocateReal(ast.getText())))));

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
      System.out.println("Constant error");
      error(tt);
    }
  }


  private static void error(int tt)
  {
    System.out.println("IRT error: "+tokenNames[tt]);
    System.exit(1);
  }
}
