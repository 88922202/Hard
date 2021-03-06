package com.hard.hardbase.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * <h3></h3>
 * Created by root on 2016/11/14.
 */
public class HSEDefinition {

    public static final int  TOKEN_TYPE_INT              = 0;           // An integer literal
    public static final int  TOKEN_TYPE_FLOAT            = 1;           // An floating-point literal
    public static final int  TOKEN_TYPE_STRING           = 2;           // An string literal
    public static final int  TOKEN_TYPE_QUOTE            = 3;           // A double-quote
    public static final int  TOKEN_TYPE_IDENT            = 4;           // An identifier
    public static final int  TOKEN_TYPE_COLON            = 5;           // A colon
    public static final int  TOKEN_TYPE_OPEN_BRACKET     = 6;           // An openening bracket
    public static final int  TOKEN_TYPE_CLOSE_BRACKET    = 7;           // An closing bracket
    public static final int  TOKEN_TYPE_COMMA            = 8;           // A comma
    public static final int  TOKEN_TYPE_OPEN_BRACE       = 9;           // An openening curly brace
    public static final int  TOKEN_TYPE_CLOSE_BRACE      = 10;          // An closing curly brace
    public static final int  TOKEN_TYPE_NEWLINE          = 11;          // A newline

    public static final int  TOKEN_TYPE_INSTR			= 12;			// An instruction

    public static final int  TOKEN_TYPE_SETSTACKSIZE     = 13;          // The SetStackSize directive
    public static final int  TOKEN_TYPE_VAR              = 14;          // The Var/Var [] directives
    public static final int  TOKEN_TYPE_FUNC             = 15;          // The Func directives
    public static final int  TOKEN_TYPE_PARAM            = 16;          // The Param directives
    public static final int  TOKEN_TYPE_REG_RETVAL       = 17;          // The _RetVal directives

    public static final int  TOKEN_TYPE_INVALID          = 18;          // Error code for invalid tokens
    public static final int  END_OF_TOKEN_STREAM         = 19;          // The end of the stream has been

    //XSE文件头的MagicNumber,用来确定一个文件是否是“HardVM”的可执行文件.
    public static final String MAGICNUMBER = "HASM";

    //XSE文件的版本号。
    public static final int VERSION = 1;

    //指令，两个操作数相加
    public static final String ADD = "ADD";
    public static final int ADD_CODE = 0;

    //两个操作数相减
    public static final String SUB = "SUB";
    public static final int SUB_CODE = 1;

    //两个操作数相乘
    public static final String MUL = "MUL";
    public static final int MUL_CODE = 2;

    //两个操作数相除
    public static final String DIV = "DIV";
    public static final int DIV_CODE = 3;


    private static Map<String, Integer> INSTRUCTION_MAP = initInstructionMap();

    public static int getInstructionCode(String instruction){
        return INSTRUCTION_MAP.get(instruction);
    }

    private static Map<String, Integer> initInstructionMap(){
        Map<String, Integer> map = new HashMap<>();
        map.put(ADD, ADD_CODE);
        map.put(SUB, SUB_CODE);
        map.put(MUL, MUL_CODE);
        map.put(DIV, DIV_CODE);
        return map;
    }
}
