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
  static String lastLabel = "none";

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
      Reg.freeReg(e);
    }
    else if(irt.getOp().equals("MOVE"))
    {
      //deal with assignment
      String memOffset = irt.getSub(0).getSub(0).getSub(0).getOp();
      String e = expression(irt.getSub(1), o);
      emit(o, "STORE "+e+",R0,"+memOffset);
      Reg.freeReg(e);
    }
    else if(irt.getOp().equals("READIN"))
    {
      String memOffset = irt.getSub(0).getSub(0).getSub(0).getOp();
      String inReg = Reg.newReg();
      emit(o, "RDR "+ inReg);
      emit(o, "STORE "+inReg+",R0,"+memOffset);
      Reg.freeReg(inReg);
    }
    else if(irt.getOp().equals("IF"))
    {

      System.out.println("GOT IF");

    }
    else if(irt.getOp().equals("CJUMP"))
    {
        String op = irt.getSub(0).getOp();
        String leftCond = expression(irt.getSub(1), o);
        String rightCond = expression(irt.getSub(2), o);
        String jumpLabel = irt.getSub(3).getOp();
        String tempReg = Reg.newReg();
        if(op.equals("=")){
            emit(o, "SUBR " + tempReg + "," + leftCond + "," + rightCond);
            emit(o, "BNEZR " + tempReg + "," + jumpLabel);
        }
        else if(op.equals(">"))
        {
            emit(o, "SUBR " + tempReg + "," + rightCond + "," + leftCond);
            emit(o, "BGEZR " + tempReg + "," + jumpLabel);
        }
        else if(op.equals("<"))
        {
            emit(o, "SUBR " + tempReg + "," + leftCond + "," + rightCond);
            emit(o, "BGEZR " + tempReg + "," + jumpLabel);
        }else if(op.equals(">="))
        {
            emit(o, "SUBR " + tempReg + "," + leftCond + "," + rightCond);
            emit(o, "BLTZR " + tempReg + "," + jumpLabel);
        }
        else if(op.equals("<="))
        {
            emit(o, "SUBR " + tempReg + "," + rightCond + "," + leftCond);
            emit(o, "BLTZR " + tempReg + "," + jumpLabel);
        }
        else if(op.equals("!="))
        {
            emit(o, "SUBR " + tempReg + "," + leftCond + "," + rightCond);
            emit(o, "BEQZR " + tempReg + "," + jumpLabel);
        }else{
            error(op + " in CJUMP");
        }
        Reg.freeReg(tempReg);
        Reg.freeReg(leftCond);
        Reg.freeReg(rightCond);
    }
    else if(irt.getOp().equals("JUMP"))
    {
        emit(o, "JMP " + irt.getSub(0).getOp());
    }
    else if(irt.getOp().equals("NOOP"))
    {
	//do nuthin
    }
    else if(irt.getOp().equals("REPEAT"))
    {
        /*
        String condLabel = irt.getSub(2).getSub(0).getOp();
        String postLabel = irt.getSub(1).getSub(3).getSub(0).getSub(0).getOp();
        System.out.println("conl = " + postLabel);
        emit(o, condLabel + ":NOP");
        expression(irt.getSub(1), o);
        statement(irt.getSub(0), o);
        emit(o, "JMP "+condLabel);
        emit(o, postLabel + ":NOP");*/
    }
    else if(irt.getOp().equals("LABEL"))
    {
      //emit(o, irt.getSub(0).getOp() + ":");
      emitLabel(o, irt.getSub(0).getOp());
    }
    else {
      error("statement - " + irt.getOp());
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
          Reg.freeReg(e);
          Reg.freeReg(f);
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
    if(lastLabel.equals("none"))
      o.println(s);
    else
    {
      o.println(lastLabel + ":" + s);
      lastLabel = "none";
    }
  }

  public static void emitLabel(PrintStream o, String labelName)
  {
    System.out.println("storing " + labelName);
    if(!lastLabel.equals("none"))
        o.println(lastLabel+":");
    lastLabel = labelName;
  }

  // Error
  private static void error(String op)
  {
    System.out.println("CG error: "+op);
    System.exit(1);
  }
}
