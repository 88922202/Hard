package com.hard.hardcompiler;

import com.hard.hardbase.exception.IllegalCharException;
import com.hard.hardbase.utils.Log;

import java.util.List;

/**
 * <h3></h3>
 * Created by root on 2016/11/15.
 */
public class Main {

    private static final String TAG = "HardCompiler";

    public static void main(String args[]){

        System.out.print("HardCompiler started.");

        List<String> lines = ScriptLoader.loadHSCScript("D:\\me\\8892\\Hard\\res\\test.hsc");
        for (int i = 0; i < lines.size(); i++){
            Log.d(TAG, lines.get(i));
            try {
                List<Token> tokens = Lexer.getLineTokens(lines.get(i));
                for (int j = 0; j < tokens.size(); j++){
                    Log.d(TAG, "token is " + tokens.get(j).getValue());
                }
            }catch (IllegalCharException e){
                e.printStackTrace();
                Log.e(TAG, e.getMessage());
            }

        }
    }
}
