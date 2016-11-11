package main.java.com.hard.hardasm;

import java.util.HashMap;
import java.util.Map;

/**
 * <h3></h3>
 * Created by root on 2016/11/11.
 */
public class Instruction {

    public static final String ADD = "ADD";

    private static Map<String, Integer> INSTRUCTION_MAP = initInstructionMap();

    public static int getInstructionCode(String instruction){
        return INSTRUCTION_MAP.get(instruction);
    }

    private static Map initInstructionMap(){
        Map<String, Integer> map = new HashMap<>();
        map.put(Instruction.ADD, 0);
        return map;
    }
}
