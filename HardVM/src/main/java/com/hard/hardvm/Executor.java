package com.hard.hardvm;

import com.hard.hardbase.utils.HSEDefinition;

/**
 * <h3></h3>
 * Created by root on 2016/11/14.
 */
public class Executor {

    public static void executeAdd(int type1, Object operand1, int type2, Object operand2){
        if (type1 == HSEDefinition.TOKEN_TYPE_INT && type2 == HSEDefinition.TOKEN_TYPE_INT){
            System.out.println((int) operand1 + (int) operand2);
        }
        if (type1 == HSEDefinition.TOKEN_TYPE_INT && type2 == HSEDefinition.TOKEN_TYPE_FLOAT){
            System.out.println((int) operand1 + (float) operand2);
        }
        if (type1 == HSEDefinition.TOKEN_TYPE_FLOAT && type2 == HSEDefinition.TOKEN_TYPE_INT){
            System.out.println((float) operand1 + (int) operand2);
        }
        if (type1 == HSEDefinition.TOKEN_TYPE_FLOAT && type2 == HSEDefinition.TOKEN_TYPE_FLOAT){
            System.out.println((float) operand1 + (float) operand2);
        }

    }

    public static void executeSub(int type1, Object operand1, int type2, Object operand2){
        if (type1 == HSEDefinition.TOKEN_TYPE_INT && type2 == HSEDefinition.TOKEN_TYPE_INT){
            System.out.println((int) operand1 - (int) operand2);
        }
        if (type1 == HSEDefinition.TOKEN_TYPE_INT && type2 == HSEDefinition.TOKEN_TYPE_FLOAT){
            System.out.println((int) operand1 - (float) operand2);
        }
        if (type1 == HSEDefinition.TOKEN_TYPE_FLOAT && type2 == HSEDefinition.TOKEN_TYPE_INT){
            System.out.println((float) operand1 - (int) operand2);
        }
        if (type1 == HSEDefinition.TOKEN_TYPE_FLOAT && type2 == HSEDefinition.TOKEN_TYPE_FLOAT){
            System.out.println((float) operand1 - (float) operand2);
        }
    }

    public static void executeMul(int type1, Object operand1, int type2, Object operand2){
        if (type1 == HSEDefinition.TOKEN_TYPE_INT && type2 == HSEDefinition.TOKEN_TYPE_INT){
            System.out.println((int) operand1 * (int) operand2);
        }
        if (type1 == HSEDefinition.TOKEN_TYPE_INT && type2 == HSEDefinition.TOKEN_TYPE_FLOAT){
            System.out.println((int) operand1 * (float) operand2);
        }
        if (type1 == HSEDefinition.TOKEN_TYPE_FLOAT && type2 == HSEDefinition.TOKEN_TYPE_INT){
            System.out.println((float) operand1 * (int) operand2);
        }
        if (type1 == HSEDefinition.TOKEN_TYPE_FLOAT && type2 == HSEDefinition.TOKEN_TYPE_FLOAT){
            System.out.println((float) operand1 * (float) operand2);
        }
    }

    public static void executeDiv(int type1, Object operand1, int type2, Object operand2){
        if (type1 == HSEDefinition.TOKEN_TYPE_INT && type2 == HSEDefinition.TOKEN_TYPE_INT){
            System.out.println((int) operand1 / (int) operand2);
        }
        if (type1 == HSEDefinition.TOKEN_TYPE_INT && type2 == HSEDefinition.TOKEN_TYPE_FLOAT){
            System.out.println((int) operand1 / (float) operand2);
        }
        if (type1 == HSEDefinition.TOKEN_TYPE_FLOAT && type2 == HSEDefinition.TOKEN_TYPE_INT){
            System.out.println((float) operand1 / (int) operand2);
        }
        if (type1 == HSEDefinition.TOKEN_TYPE_FLOAT && type2 == HSEDefinition.TOKEN_TYPE_FLOAT){
            System.out.println((float) operand1 / (float) operand2);
        }
    }

}
