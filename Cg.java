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
      String memOffset = irt.getSub(0).getSub(0).getSub(0).getOp();
      String e = expression(irt.getSub(1), o);
      emit(o, "STORE "+e+",R0,"+memOffset);
    }
    else if(irt.getOp().equals("READIN"))
    {
      System.out.println("here(L) " + irt.getSub(0).getSub(0).getSub(0).getOp() );
      String memOffset = irt.getSub(0).getSub(0).getSub(0).getOp();
      String inReg = Reg.newReg();
      emit(o, "RDR "+ inReg);
      emit(o, "STORE "+inReg+",R0,"+memOffset);
    }
    else if(irt.getOp().equals("IF"))
    {
      //System.out.println("here(L) " + irt.getSub(3).getSub(0).getOp() + ", " + irt.getSub(3).getSub(1).getOp());
    	String leftCondReg = expression(irt.getSub(3).getSub(1), o);
    	String rightCondReg = expression(irt.getSub(3).getSub(2), o);
      String regHold = Reg.newReg();
      System.out.println("condition = " + irt.getSub(3).getSub(0).getOp());
      if(irt.getSub(3).getSub(0).getOp().equals("EQUALS"))
      {
          emit(o, "SUBR " + regHold + "," + leftCondReg + "," + rightCondReg);
          emit(o, "BNEZR " + regHold + "," + irt.getSub(2).getSub(0).getSub(0).getOp());
      }
      else if(irt.getSub(3).getSub(0).getOp().equals("GREATER"))
      {
          emit(o, "SUBR " + regHold + "," + rightCondReg + "," + leftCondReg);
          emit(o, "BGEZR " + regHold + "," + irt.getSub(2).getSub(0).getSub(0).getOp());
      }
      else if(irt.getSub(3).getSub(0).getOp().equals("LESSER"))
      {
          emit(o, "SUBR " + regHold + "," + rightCondReg + "," + leftCondReg);
          emit(o, "BLTZR " + regHold + "," + irt.getSub(2).getSub(0).getSub(0).getOp());
      }
      else if(irt.getSub(3).getSub(0).getOp().equals("DEQUALS"))
      {
          emit(o, "SUBR " + regHold + "," + leftCondReg + "," + rightCondReg);
          emit(o, "BEQZR " + regHold + "," + irt.getSub(2).getSub(0).getSub(0).getOp());
      }
      else if(irt.getSub(3).getSub(0).getOp().equals("LEQUALS"))
      {
          emit(o, "SUBR " + regHold + "," + leftCondReg + "," + rightCondReg);
          emit(o, "BGEZR " + regHold + "," + irt.getSub(2).getSub(0).getSub(0).getOp());
      }
      else if(irt.getSub(3).getSub(0).getOp().equals("GEQUALS"))
      {
          emit(o, "SUBR " + regHold + "," + leftCondReg + "," + rightCondReg);
          emit(o, "BLTZR " + regHold + "," + irt.getSub(2).getSub(0).getSub(0).getOp());
      }

      //emit(o, irt.getSub(1).getSub(0).getSub(0).getOp() + ":NOP");
      //Generate the code for the IF part
      statement(irt.getSub(1).getSub(1), o);
      System.out.println("ENDL = " + irt.getSub(1).getSub(0).getSub(0).getOp());
      emit(o, "JMP " + irt.getSub(1).getSub(0).getSub(0).getOp());
      emit(o, irt.getSub(2).getSub(0).getSub(0).getOp() + ":NOP");
      if(!irt.getSub(0).getOp().equals("IFTYPE"))
        statement(irt.getSub(2).getSub(1), o);
      emit(o, irt.getSub(1).getSub(0).getSub(0).getOp() + ":NOP");


    }
    else if(irt.getOp().equals("NOOP"))
    {
	//do nuthin
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
