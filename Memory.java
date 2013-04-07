import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.io.*;

public class Memory {

  static ArrayList<Byte> memory = new ArrayList<Byte>();
  static Hashtable<String,Integer> varToMem = new Hashtable<String,Integer>();

  static public int allocateString(String text)
  {
    int addr = memory.size();
    int size = text.length();
    for (int i=0; i<size; i++) {
      memory.add(new Byte("", text.charAt(i)));
    }
    memory.add(new Byte("", 0));
    return addr;
  }

  static public int allocateReal(String varname)
  {
      if(varToMem.containsKey(varname))
          return varToMem.get(varname);
      else
      {
        int mBefore = memory.size();
	 while(memory.size()%4 != 0)
          memory.add(new Byte("", 0));
        System.out.println("Memory size = " + memory.size() + ", m%4 = " + memory.size()%4 + ", mBefore = " + mBefore);
        varToMem.put(varname, memory.size());
        for(int i = 0; i<4; i++)
            memory.add(new Byte("", 0));
        return memory.size()-4;
      }
  }

  static public void dumpData(PrintStream o)
  {
    Byte b;
    String s;
    int c;
    int size = memory.size();
    for (int i=0; i<size; i++) {
      b = memory.get(i);
      c = b.getContents();
      if (c >= 32) {
        s = String.valueOf((char)c);
      }
      else {
        s = ""; // "\\"+String.valueOf(c);
      }
      o.println("DATA "+c+" ; "+s+" "+b.getName());
    }
  }
}

class Byte {
  String varname;
  int contents;

  Byte(String n, int c)
  {
    varname = n;
    contents = c;
  }

  String getName()
  {
    return varname;
  }

  int getContents()
  {
    return contents;
  }
}
