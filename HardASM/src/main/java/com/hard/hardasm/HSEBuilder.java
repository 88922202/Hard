package com.hard.hardasm;


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
        FileUtils.appendBytes(fileName, magicNumber);
        float version = 0.1f;
        FileUtils.appendFloat(fileName, version);
        List<Integer> instructions = Assembler.getInstructions();
        for (int i = 0; i < instructions.size(); i++){
            FileUtils.appendInt(fileName, instructions.get(i));
        }
    }
}
