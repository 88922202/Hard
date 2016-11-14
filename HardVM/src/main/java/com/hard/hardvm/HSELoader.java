package com.hard.hardvm;

import com.hard.hardbase.utils.CharUtils;
import com.hard.hardbase.utils.FileUtils;
import com.hard.hardbase.utils.HSEDefinition;
import com.hard.hardbase.utils.Log;

import static com.hard.hardbase.utils.HSEDefinition.ADD;

/**
 * <h3></h3>
 * Created by root on 2016/11/14.
 */
public class HSELoader {

    private static final String TAG = "HSELoader";

    private static final int HARDVM_VERSION = 1;

    public static void loadHSEFile(String fileName){
        byte file[] = FileUtils.readFileByByte(fileName, 1024);
        if (!loadHSEHeader(file)){
            return;
        }

        loadHSEVersion(file);
        loadHSEInstructions(file);
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

    private static void loadHSEInstructions(byte file[]){
        byte[] bInstruction = new byte[4];
        System.arraycopy(file, 8, bInstruction, 0, 4);
        Integer instruction = CharUtils.byte2int(bInstruction);
        switch (instruction){
            case ADD:
                int operand1 = loadIntOperand(file, 12);
                int operand2 = loadIntOperand(file, 16);
                Executor.executeAdd(operand1, operand2);
                break;
            default:
                break;
        }
    }

    private static int loadIntOperand(byte file[], int start){
        byte[] bInstruction = new byte[4];
        System.arraycopy(file, start, bInstruction, 0, 4);
        return CharUtils.byte2int(bInstruction);
    }
}
