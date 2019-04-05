package com.yavuz.yipsc.asm;
import com.yavuz.yipsc.lexer.*;
import com.yavuz.yipsc.symbols.*;

public abstract class Register {
    
    Token token;
    Type type;
    
    public Register(Token tok, Type typ) {
        token = tok;
        type = typ;
    }
    
    public abstract String getAddress();
    
    @Override
    public abstract String toString();
    
    public abstract int getRegisterAddress();
    
}
