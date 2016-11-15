package com.hard.hardbase.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * <h3></h3>
 * Created by root on 2016/11/14.
 */
public class HSEDefinition {

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


    private static Map<String, Integer> INSTRUCTION_MAP = initInstructionMap();

    public static int getInstructionCode(String instruction){
        return INSTRUCTION_MAP.get(instruction);
    }

    private static Map<String, Integer> initInstructionMap(){
        Map<String, Integer> map = new HashMap<>();
        map.put(ADD, ADD_CODE);
        map.put(SUB, SUB_CODE);
        return map;
    }
}
