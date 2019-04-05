package com.yavuz.yipsc.symbols;
import com.yavuz.yipsc.lexer.*;
public class Array extends Type {
   public Type of;                  // array *of* type
   public int size = 1;             // number of elements
   public Array(int sz, Type p) {
      super("[]", Tag.INDEX, sz*p.width); size = sz;  of = p;
   }
   @Override
   public String toString() { return "[" + size + "] " + of.toString(); }

}
