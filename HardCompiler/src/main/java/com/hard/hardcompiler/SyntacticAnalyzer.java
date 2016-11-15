package com.hard.hardcompiler;

import com.hard.hardbase.exception.IllegalTokenException;
import com.hard.hardbase.utils.HSEDefinition;

import java.util.ArrayList;
import java.util.List;

/**
 * <h3></h3>
 * Created by root on 2016/11/15.
 */
public class SyntacticAnalyzer {

    private static final String TAG = "SyntacticAnalyzer";

    public static List<Object> analysis(List<Token> tokens) throws IllegalTokenException {

        List<Object> codes = new ArrayList<Object>();
        for (int i = 0; i < tokens.size(); i++){
            Token currentToken = tokens.get(i);
            String currentValue = currentToken.getValue() == null ? "" : currentToken.getValue().toUpperCase();
            int nextTokenType = getNextTokenType(tokens, i + 1);

            switch (currentToken.getType()){
                case Token.INT:
                    break;
                case Token.FLOAT:
                    break;
                case Token.ADD:
                    break;
                case Token.SUB:
                    break;
                case Token.MUL:
                    break;
                case Token.DIV:
                    break;
                case Token.LEFT_BRACKET:
                    break;
                case Token.RIGHT_BRACKET:
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

        return tokens.get(index).getType();
    }
}
