package com.hard.hardvm;

import com.hard.hardbase.utils.CharUtils;
import com.hard.hardbase.utils.FileUtils;
import com.hard.hardbase.utils.HSEDefinition;
import com.hard.hardbase.utils.Log;


/**
 * <h3></h3>
 * Created by root on 2016/11/14.
 */
public class HSELoader {

    private static final String TAG = "HSELoader";

    private static final int HARDVM_VERSION = 1;

    private static int mInstructionStartIndex = 12;

    public static void loadHSEFile(String fileName){
        byte file[] = FileUtils.readFileByByte(fileName, 1024);
        if (!loadHSEHeader(file)){
            return;
        }

        loadHSEVersion(file);
        int length = loadHSEInstructionsLength(file);
        while (mInstructionStartIndex < length * 4 + 12){
            try {
                loadHSEInstructions(file);
            }catch (IllegalInstructionException e){
                e.printStackTrace();
                Log.e(TAG, e.getMessage());
            }
        }
    }

    private static boolean loadHSEHeader(byte file[]){
        byte[] bMagicNumber = new byte[4];
        System.arraycopy(file, 0, bMagicNumber, 0, 4);

        String sMagicNumber = new String(bMagicNumber);
        if (!HSEDefinition.MAGICNUMBER.equals(sMagicNumber)){
            Log.d(TAG, "Invalid .hse file");
            return false;
        }
        Log.d(TAG, "file header " + sMagicNumber);

        return true;
    }

    private static boolean loadHSEVersion(byte file[]){
        byte[] bVersion = new byte[4];
        System.arraycopy(file, 4, bVersion, 0, 4);
        Integer version = CharUtils.byte2int(bVersion);
        if (HARDVM_VERSION < version){
            Log.e(TAG, "Invalid .xse file version " + version);
            return false;
        }

        Log.d(TAG, ".xse file version " + version);
        return true;
    }

    private static int loadHSEInstructionsLength(byte file[]){
        byte[] bLength = new byte[4];
        System.arraycopy(file, 8, bLength, 0, 4);
        Integer length = CharUtils.byte2int(bLength);
        Log.d(TAG, "total instructions length " + length);
        return length;
    }

    private static void loadHSEInstructions(byte file[]) throws IllegalInstructionException{
        byte[] bInstruction = new byte[4];
        System.arraycopy(file, mInstructionStartIndex, bInstruction, 0, 4);
        Integer instruction = CharUtils.byte2int(bInstruction);
        switch (instruction){
            case HSEDefinition.ADD_CODE: {
                int type1 = loadIntOperand(file, mInstructionStartIndex + 4);
                Object operand1;
                if (type1 == HSEDefinition.TOKEN_TYPE_INT) {
                    operand1 = loadIntOperand(file, mInstructionStartIndex + 8);
                }else{
                    operand1 = loadFloatOperand(file, mInstructionStartIndex + 8);
                }
                int type2 = loadIntOperand(file, mInstructionStartIndex + 12);
                Object operand2;
                if (type2 == HSEDefinition.TOKEN_TYPE_INT) {
                    operand2 = loadIntOperand(file, mInstructionStartIndex + 16);
                }else{
                    operand2 = loadFloatOperand(file, mInstructionStartIndex + 16);
                }
                mInstructionStartIndex += 20;
                Executor.executeAdd(type1, operand1, type2, operand2);
            }
                break;
            case HSEDefinition.SUB_CODE: {
                int type1 = loadIntOperand(file, mInstructionStartIndex + 4);
                Object operand1;
                if (type1 == HSEDefinition.TOKEN_TYPE_INT) {
                    operand1 = loadIntOperand(file, mInstructionStartIndex + 8);
                }else{
                    operand1 = loadFloatOperand(file, mInstructionStartIndex + 8);
                }
                int type2 = loadIntOperand(file, mInstructionStartIndex + 12);
                Object operand2;
                if (type2 == HSEDefinition.TOKEN_TYPE_INT) {
                    operand2 = loadIntOperand(file, mInstructionStartIndex + 16);
                }else{
                    operand2 = loadFloatOperand(file, mInstructionStartIndex + 16);
                }
                mInstructionStartIndex += 20;
                Executor.executeSub(type1, operand1, type2, operand2);
            }
                break;
            case HSEDefinition.MUL_CODE: {
                int type1 = loadIntOperand(file, mInstructionStartIndex + 4);
                Object operand1;
                if (type1 == HSEDefinition.TOKEN_TYPE_INT) {
                    operand1 = loadIntOperand(file, mInstructionStartIndex + 8);
                }else{
                    operand1 = loadFloatOperand(file, mInstructionStartIndex + 8);
                }
                int type2 = loadIntOperand(file, mInstructionStartIndex + 12);
                Object operand2;
                if (type2 == HSEDefinition.TOKEN_TYPE_INT) {
                    operand2 = loadIntOperand(file, mInstructionStartIndex + 16);
                }else{
                    operand2 = loadFloatOperand(file, mInstructionStartIndex + 16);
                }
                mInstructionStartIndex += 20;
                Executor.executeMul(type1, operand1, type2, operand2);
            }
                break;
            case HSEDefinition.DIV_CODE: {
                int type1 = loadIntOperand(file, mInstructionStartIndex + 4);
                Object operand1;
                if (type1 == HSEDefinition.TOKEN_TYPE_INT) {
                    operand1 = loadIntOperand(file, mInstructionStartIndex + 8);
                }else{
                    operand1 = loadFloatOperand(file, mInstructionStartIndex + 8);
                }
                int type2 = loadIntOperand(file, mInstructionStartIndex + 12);
                Object operand2;
                if (type2 == HSEDefinition.TOKEN_TYPE_INT) {
                    operand2 = loadIntOperand(file, mInstructionStartIndex + 16);
                }else{
                    operand2 = loadFloatOperand(file, mInstructionStartIndex + 16);
                }
                mInstructionStartIndex += 20;
                Executor.executeDiv(type1, operand1, type2, operand2);
            }
                break;
            default:
                throw new IllegalInstructionException("Invalid instruction " + instruction);
        }
    }

    private static int loadIntOperand(byte file[], int start){
        byte[] bInstruction = new byte[4];
        System.arraycopy(file, start, bInstruction, 0, 4);
        return CharUtils.byte2int(bInstruction);
    }

    private static float loadFloatOperand(byte file[], int start){
        byte[] fInstruction = new byte[4];
        System.arraycopy(file, start, fInstruction, 0, 4);
        return CharUtils.byte2float(fInstruction, 0);
    }

    private static void loadOperands(byte file[]){
        int type1 = loadIntOperand(file, mInstructionStartIndex + 4);
        if (type1 == HSEDefinition.TOKEN_TYPE_INT) {
            int operand1 = loadIntOperand(file, mInstructionStartIndex + 8);
        }else if (type1 == HSEDefinition.TOKEN_TYPE_FLOAT){
            float operand1 = loadFloatOperand(file, mInstructionStartIndex + 8);
        }
        int type2 = loadIntOperand(file, mInstructionStartIndex + 12);
        if (type2 == HSEDefinition.TOKEN_TYPE_INT) {
            int operand2 = loadIntOperand(file, mInstructionStartIndex + 16);
        }else if (type1 == HSEDefinition.TOKEN_TYPE_FLOAT){
            float operand2 = loadFloatOperand(file, mInstructionStartIndex + 16);
        }
        mInstructionStartIndex += 16;
    }
}
