package com.hard.hardasm;


import com.hard.hardbase.utils.CharUtils;
import com.hard.hardbase.utils.FileUtils;

import java.util.List;

/**
 * <h3></h3>
 * Created by root on 2016/11/11.
 */
public class HSEBuilder {

    public static void buildHSEFile(){
        String fileName = "first.hse";

        String magicNumber = "HASM";
        FileUtils.writeBytes(fileName, magicNumber);

        int version = 1;
        FileUtils.appendBytes(fileName, new String(CharUtils.int2byte(version)));

        List<Integer> instructions = Assembler.getInstructions();
        FileUtils.appendBytes(fileName, new String(CharUtils.int2byte(instructions.size())));
        for (int i = 0; i < instructions.size(); i++){
            FileUtils.appendBytes(fileName, new String(CharUtils.int2byte(instructions.get(i))));
        }
    }
}
