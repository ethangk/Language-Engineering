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
      Reg.freeLast(1);
    }
    else if(irt.getOp().equals("MOVE"))
    {
      //deal with assignment
      String memOffset = irt.getSub(0).getSub(0).getSub(0).getOp();
      String e = expression(irt.getSub(1), o);
      emit(o, "STORE "+e+",R0,"+memOffset);
    }
    else if(irt.getOp().equals("READIN"))
    {
      String memOffset = irt.getSub(0).getSub(0).getSub(0).getOp();
      String inReg = Reg.newReg();
      emit(o, "RDR "+ inReg);
      emit(o, "STORE "+inReg+",R0,"+memOffset);
      Reg.freeLast(1);
    }
    else if(irt.getOp().equals("IF"))
    {

      String postLabel = irt.getSub(1).getSub(3).getSub(0).getSub(0).getOp();

      expression(irt.getSub(1), o);
      statement(irt.getSub(2).getSub(0), o);
      
      if(!irt.getSub(0).getOp().equals("IFTYPE"))
      {
         postLabel = irt.getSub(1).getSub(3).getSub(1).getSub(0).getOp();
         String elseLabel = irt.getSub(1).getSub(3).getSub(0).getSub(0).getOp();
         emit(o, "JMP " + postLabel);
         emit(o, elseLabel + ":NOP");
         statement(irt.getSub(3).getSub(0), o);
      }
      emit(o, postLabel + ":NOP");




    }
    else if(irt.getOp().equals("NOOP"))
    {
	//do nuthin
    }
    else if(irt.getOp().equals("REPEAT"))
    {
        String condLabel = irt.getSub(2).getSub(0).getOp();
        String postLabel = irt.getSub(1).getSub(3).getSub(0).getSub(0).getOp();
        System.out.println("conl = " + postLabel);
        emit(o, condLabel + ":NOP");
        expression(irt.getSub(1), o);
        statement(irt.getSub(0), o);
        emit(o, "JMP "+condLabel);
        emit(o, postLabel + ":NOP");
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
          if(t == "0.0")
          {
              result = "R0";
          }
          else
          {
              result = Reg.newReg();
              emit(o, "MOVIR "+result+","+t);
          }
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
    else if(irt.getOp().equals("IFCONDITIONS"))
    {
        String operator = irt.getSub(0).getOp();
        String leftCondReg = expression(irt.getSub(1), o);
        String rightCondReg = expression(irt.getSub(2), o);
        String regHold = Reg.newReg();
        String jumpLabel = irt.getSub(3).getSub(0).getSub(0).getOp();
        if(operator.equals("EQUALS"))
        {
            emit(o, "SUBR " + regHold + "," + leftCondReg + "," + rightCondReg);
            emit(o, "BNEZR " + regHold + "," + jumpLabel);
        }
        else if(operator.equals("GREATER"))
        {
            emit(o, "SUBR " + regHold + "," + rightCondReg + "," + leftCondReg);
            emit(o, "BGEZR " + regHold + "," + jumpLabel);
        }
        else if(operator.equals("LESSER"))
        {
            emit(o, "SUBR " + regHold + "," + leftCondReg + "," + rightCondReg);
            emit(o, "BGEZR " + regHold + "," + jumpLabel);
        }
        else if(operator.equals("DEQUALS"))
        {
            emit(o, "SUBR " + regHold + "," + leftCondReg + "," + rightCondReg);
            emit(o, "BEQZR " + regHold + "," + jumpLabel);
        }
        else if(operator.equals("LEQUALS"))
        {
            emit(o, "SUBR " + regHold + "," + rightCondReg + "," + leftCondReg);
            emit(o, "BLTZR " + regHold + "," + jumpLabel);
        }
        else if(operator.equals("GEQUALS"))
        {
            emit(o, "SUBR " + regHold + "," + leftCondReg + "," + rightCondReg);
            emit(o, "BLTZR " + regHold + "," + jumpLabel);
        }
    }
    else if(irt.getOp().equals("REPEATCONDITIONS"))
    {
        String operator = irt.getSub(0).getOp();
        String leftCondReg = expression(irt.getSub(1), o);
        String rightCondReg = expression(irt.getSub(2), o);
        String regHold = Reg.newReg();
        String jumpLabel = irt.getSub(3).getSub(0).getSub(0).getOp();
        if(operator.equals("DEQUALS"))
        {
            emit(o, "SUBR " + regHold + "," + leftCondReg + "," + rightCondReg);
            emit(o, "BNEZR " + regHold + "," + jumpLabel);
        }
        else if(operator.equals("LESSER"))
        {
            emit(o, "SUBR " + regHold + "," + rightCondReg + "," + leftCondReg);
            emit(o, "BGEZR " + regHold + "," + jumpLabel);
        }
        else if(operator.equals("GREATER"))
        {
            emit(o, "SUBR " + regHold + "," + leftCondReg + "," + rightCondReg);
            emit(o, "BGEZR " + regHold + "," + jumpLabel);
        }
        else if(operator.equals("EQUALS"))
        {
            emit(o, "SUBR " + regHold + "," + leftCondReg + "," + rightCondReg);
            emit(o, "BEQZR " + regHold + "," + jumpLabel);
        }
        else if(operator.equals("GEQUALS"))
        {
            emit(o, "SUBR " + regHold + "," + rightCondReg + "," + leftCondReg);
            emit(o, "BLTZR " + regHold + "," + jumpLabel);
        }
        else if(operator.equals("LEQUALS"))
        {
            emit(o, "SUBR " + regHold + "," + leftCondReg + "," + rightCondReg);
            emit(o, "BLTZR " + regHold + "," + jumpLabel);
        }
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
