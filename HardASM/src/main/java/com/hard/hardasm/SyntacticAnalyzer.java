package com.hard.hardasm;

import com.hard.hardasm.exception.IllegalTokenException;
import com.hard.hardbase.utils.HSEDefinition;
import com.hard.hardbase.utils.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * <h3></h3>
 * Created by root on 2016/11/11.
 */
public class SyntacticAnalyzer {

    private static final String TAG = "SyntacticAnalyzer";

    public static List<Object> analysis(List<Token> tokens) throws IllegalTokenException {
        List<Object> codes = new ArrayList<>();
        for (int i = 0; i < tokens.size(); i++){
            Token currentToken = tokens.get(i);
            String currentValue = currentToken.getValue() == null ? "" : currentToken.getValue().toUpperCase();
            int nextTokenType = getNextTokenType(tokens, i + 1);

            switch (currentToken.getTokenType()){
                case HSEDefinition.TOKEN_TYPE_IDENT:
                    switch (currentValue){
                        case HSEDefinition.ADD:
                            if (nextTokenType == HSEDefinition.TOKEN_TYPE_INT || nextTokenType == HSEDefinition.TOKEN_TYPE_FLOAT){
                                int next2TokenType = getNextTokenType(tokens, i + 2);
                                if (next2TokenType == HSEDefinition.TOKEN_TYPE_INT || next2TokenType == HSEDefinition.TOKEN_TYPE_FLOAT){
                                    int code = HSEDefinition.getInstructionCode(HSEDefinition.ADD);
                                    codes.add(code);
                                    Log.d(TAG, "instruction code is " + code);
                                }else {
                                    throw new IllegalTokenException("error token " + next2TokenType);
                                }
                            }else {
                                throw new IllegalTokenException("error token " + nextTokenType);
                            }
                            break;
                        case HSEDefinition.SUB:
                            if (nextTokenType == HSEDefinition.TOKEN_TYPE_INT || nextTokenType == HSEDefinition.TOKEN_TYPE_FLOAT){
                                int next2TokenType = getNextTokenType(tokens, i + 2);
                                if (next2TokenType == HSEDefinition.TOKEN_TYPE_INT || next2TokenType == HSEDefinition.TOKEN_TYPE_FLOAT){
                                    int code = HSEDefinition.getInstructionCode(HSEDefinition.SUB);
                                    codes.add(code);
                                    Log.d(TAG, "instruction code is " + code);
                                }else {
                                    throw new IllegalTokenException("error token " + next2TokenType);
                                }
                            }
                            break;
                        case HSEDefinition.MUL:
                            if (nextTokenType == HSEDefinition.TOKEN_TYPE_INT || nextTokenType == HSEDefinition.TOKEN_TYPE_FLOAT){
                                int next2TokenType = getNextTokenType(tokens, i + 2);
                                if (next2TokenType == HSEDefinition.TOKEN_TYPE_INT || next2TokenType == HSEDefinition.TOKEN_TYPE_FLOAT){
                                    int code = HSEDefinition.getInstructionCode(HSEDefinition.MUL);
                                    codes.add(code);
                                    Log.d(TAG, "instruction code is " + code);
                                }else {
                                    throw new IllegalTokenException("error token " + next2TokenType);
                                }
                            }
                            break;
                        case HSEDefinition.DIV:
                            if (nextTokenType == HSEDefinition.TOKEN_TYPE_INT || nextTokenType == HSEDefinition.TOKEN_TYPE_FLOAT){
                                int next2TokenType = getNextTokenType(tokens, i + 2);
                                if (next2TokenType == HSEDefinition.TOKEN_TYPE_INT || next2TokenType == HSEDefinition.TOKEN_TYPE_FLOAT){
                                    int code = HSEDefinition.getInstructionCode(HSEDefinition.DIV);
                                    codes.add(code);
                                    Log.d(TAG, "instruction code is " + code);
                                }else {
                                    throw new IllegalTokenException("error token " + next2TokenType);
                                }
                            }
                            break;
                        default:
                            break;
                    }
                    break;
                case HSEDefinition.TOKEN_TYPE_INT:
                    try {
                        int type = HSEDefinition.TOKEN_TYPE_INT;
                        codes.add(type);
                        int number = Integer.parseInt(currentValue);
                        codes.add(number);
                        Log.d(TAG, "int number " + number);
                    }catch (Exception e){
                        throw new IllegalTokenException("error token " + currentToken.getValue());
                    }

                    break;
                case HSEDefinition.TOKEN_TYPE_FLOAT:
                    try {
                        int type = HSEDefinition.TOKEN_TYPE_FLOAT;
                        codes.add(type);
                        float number = Float.parseFloat(currentValue);
                        codes.add(number);
                        Log.d(TAG, "float number " + number);
                    }catch (Exception e){
                        throw new IllegalTokenException("error token " + currentToken.getValue());
                    }

                    break;
                default:
                    break;
            }
        }

        return codes;
    }

    private static int getNextTokenType(List<Token> tokens, int index){
        if (index > tokens.size() - 1){
            return HSEDefinition.END_OF_TOKEN_STREAM;
        }

        return tokens.get(index).getTokenType();
    }

    private static int skipParsedTokens(int startIndex, int skipCount){
        startIndex += skipCount;
        return startIndex;
    }

}
