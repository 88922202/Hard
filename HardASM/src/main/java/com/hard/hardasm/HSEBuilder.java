package com.hard.hardasm;


import com.hard.hardbase.utils.CharUtils;
import com.hard.hardbase.utils.FileUtils;
import com.hard.hardbase.utils.HSEDefinition;

import java.util.List;

/**
 * <h3></h3>
 * Created by root on 2016/11/11.
 */
public class HSEBuilder {

    public static void buildHSEFile(){
        String fileName = "first.hse";

        //写入MagicNumber
        String magicNumber = "HASM";
        FileUtils.writeBytes(fileName, magicNumber);

        //写入文件的版本号
        int version = 1;
        FileUtils.appendBytes(fileName, CharUtils.int2byte(version));

        //写入指令区长度
        List<Object> instructions = Assembler.getInstructions();
        FileUtils.appendBytes(fileName, CharUtils.int2byte(instructions.size()));

        int i = 0;
        while (i < instructions.size()){
            int instruction = (int) instructions.get(i);
            switch (instruction){
                case HSEDefinition.ADD_CODE:
                    i = appendInstructions(fileName, instructions, i);
                    break;
                case HSEDefinition.SUB_CODE:
                    i = appendInstructions(fileName, instructions, i);
                    break;
                case HSEDefinition.MUL_CODE:
                    i = appendInstructions(fileName, instructions, i);
                    break;
                case HSEDefinition.DIV_CODE:
                    i = appendInstructions(fileName, instructions, i);
                    break;
            }
        }

    }

    private static int appendInstructions(String fileName, List instructions, int start){
        int instruction = (int) instructions.get(start);
        //写命令
        FileUtils.appendBytes(fileName, CharUtils.int2byte(instruction));
        start++;
        int type1 = (int) instructions.get(start);
        //写操作数类型
        FileUtils.appendBytes(fileName, CharUtils.int2byte(type1));
        //写操作数值
        start++;
        if (type1 == HSEDefinition.TOKEN_TYPE_INT){
            FileUtils.appendBytes(fileName, CharUtils.int2byte((int) instructions.get(start)));
        }else if (type1 == HSEDefinition.TOKEN_TYPE_FLOAT){
            FileUtils.appendBytes(fileName, CharUtils.float2byte((float) instructions.get(start)));
        }else {

        }
        start++;
        int type2 = (int) instructions.get(start);
        //写操作数类型
        FileUtils.appendBytes(fileName, CharUtils.int2byte(type2));
        //写操作数值
        start++;
        if (type2 == HSEDefinition.TOKEN_TYPE_INT){
            FileUtils.appendBytes(fileName, CharUtils.int2byte((int) instructions.get(start)));
        }else if (type2 == HSEDefinition.TOKEN_TYPE_FLOAT){
            FileUtils.appendBytes(fileName, CharUtils.float2byte((float) instructions.get(start)));
        }else {

        }

        return ++start;
    }
}
