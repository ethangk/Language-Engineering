// COMS22303: Code generation

import java.util.*;
import java.io.*;
import java.lang.reflect.Array;
import antlr.collections.AST;
import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;

public class Cg
{
  // Generate code from a program (in IRTree form)
  public static void program(IRTree irt, PrintStream o)
  {
    emit(o, "XOR R0,R0,R0");   // Initialize R0 to 0
    statement(irt, o);
    emit(o, "HALT");           // Program must end with HALT
    Memory.dumpData(o);        // Dump DATA lines: initial memory contents
  }

  // Generate code from a statement (in IRTree form)
  private static void statement(IRTree irt, PrintStream o)
  {
    if (irt.getOp().equals("SEQ")) {
      statement(irt.getSub(0), o);
      statement(irt.getSub(1), o);
    }
    else if (irt.getOp().equals("WRS") && irt.getSub(0).getOp().equals("MEM") && 
             irt.getSub(0).getSub(0).getOp().equals("CONST")) {
      String a = irt.getSub(0).getSub(0).getSub(0).getOp();
      emit(o, "WRS "+a);
    }
    else if (irt.getOp().equals("WRR")) {
      String e = expression(irt.getSub(0), o);
      emit(o, "WRR "+e);
    }
    else if(irt.getOp().equals("MOVE"))
    {
      //deal with assignment
      System.out.println("here(L) " + irt.getSub(0).getSub(0).getSub(0).getOp() );
      System.out.println("here(R) " + irt.getSub(1).getSub(0).getOp() );
      if(irt.getSub(1).getSub(0).getOp().equals("CONST"))
      {
           //deal with memory loading
	    System.out.println("MEM LOADING");
	    String rightMemOffset = irt.getSub(1).getSub(0).getSub(0).getOp();
	    String leftMemOffset = irt.getSub(0).getSub(0).getSub(0).getOp();
           String loadReg = Reg.newReg();
           emit(o, "LOAD "+loadReg+",R0,"+rightMemOffset);
           emit(o, "STORE "+loadReg+",R0,"+leftMemOffset);
      }
      else
      {
          //Its a constant value, just use this;
	   String memOffset = irt.getSub(0).getSub(0).getSub(0).getOp();
	   String constVal = irt.getSub(1).getSub(0).getOp();
          String constReg = Reg.newReg();
          emit(o, "MOVIR "+constReg+","+constVal);
	   emit(o, "STORE "+constReg+",R0,"+memOffset);
      }
    }
    else {
      error(irt.getOp());
    }
  }

  // Generate code from an expression (in IRTree form)
  private static String expression(IRTree irt, PrintStream o)
  {
    String result = "";
    if (irt.getOp().equals("CONST"))
    {
          String t = irt.getSub(0).getOp();
          result = Reg.newReg();
          emit(o, "MOVIR "+result+","+t);
    }
    else if (irt.getOp().equals("BINOP"))
    {
          String e = expression(irt.getSub(1), o);
          String f = expression(irt.getSub(2), o);
          result = Reg.newReg();
          if (irt.getSub(0).getOp().equals("+"))
          {
              emit(o, "ADDR " + result + "," + e + "," + f);
          }
          else if(irt.getSub(0).getOp().equals("-"))
          {
              emit(o, "SUBR " + result + "," + e + "," + f);
          }
          else if(irt.getSub(0).getOp().equals("*"))
          {
              emit(o, "MULR " + result + "," + e + "," + f);
          }
          else if(irt.getSub(0).getOp().equals("/"))
          {
              emit(o, "DIVR " + result + "," + e + "," + f);
          }
    }
    else if(irt.getOp().equals("MEM"))
    {
          String memAddr = irt.getSub(0).getSub(0).getOp();
	   result = Reg.newReg();
	   emit(o, "LOAD "+result+",R0,"+memAddr);
    }
    else {
      error(" - expression - " + irt.getOp());
    }
    return result;  // Return name of the register holding expression's value
  }

  // Generate an instruction
  private static void emit(PrintStream o, String s)
  {
    o.println(s);
  }

  // Error
  private static void error(String op)
  {
    System.out.println("CG error: "+op);
    System.exit(1);
  }
}
