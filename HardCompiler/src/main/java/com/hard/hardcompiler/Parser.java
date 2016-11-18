package com.hard.hardcompiler;

import com.hard.hardbase.exception.IllegalTokenException;
import com.hard.hardbase.utils.HSEDefinition;
import com.hard.hardbase.utils.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * <h3></h3>
 * Created by root on 2016/11/15.
 */
public class Parser {

    private static final String TAG = "Parser";

    private static List<String> codes = new ArrayList<String>();

    public static void parse(List<Token> tokens) throws IllegalTokenException {
        parseExpression(tokens, 0);
    }

    private static int getNextTokenType(List<Token> tokens, int index){
        if (index > tokens.size() - 1){
            return HSEDefinition.END_OF_TOKEN_STREAM;
        }

        return tokens.get(index).getType();
    }


    public static void parseExpression(List<Token> tokens, int start) throws IllegalTokenException{
        parseTerm(tokens, start);

        parseSubExpression(tokens, start + 1);
    }

    public static void parseSubExpression(List<Token> tokens, int start) throws IllegalTokenException{
        Token currentToken = tokens.get(start);
        switch (currentToken.getType()){
            case Token.ADD:
                codes.add("Add");
                codes.add(" ");
                Log.d(TAG, "subExpression add ");
                parseTerm(tokens, start + 1);
                parseSubExpression(tokens, start + 2);
                break;
            case Token.SUB:
                codes.add("Sub");
                codes.add(" ");
                Log.d(TAG, "subExpression sub ");
                parseTerm(tokens, start + 1);
                parseSubExpression(tokens, start + 2);
                break;
            case Token.END:
                codes.add("\n");
                Log.d(TAG, "subExpression null ");
                break;
            default:
                break;
        }
    }

    public static void parseTerm(List<Token> tokens, int start) throws IllegalTokenException{
        parsePrimary(tokens, start);

        parseSubTerm(tokens, start + 1);
    }

    public static void parseSubTerm(List<Token> tokens, int start) throws IllegalTokenException{
        Token currentToken = tokens.get(start);
        switch (currentToken.getType()){
            case Token.MUL:
                codes.add("Mul");
                codes.add(" ");
                Log.d(TAG, "subTerm mul ");
                parsePrimary(tokens, start + 1);
                parseSubTerm(tokens, start + 2);
                break;
            case Token.DIV:
                codes.add("Div");
                codes.add(" ");
                Log.d(TAG, "subTerm div ");
                parsePrimary(tokens, start + 1);
                parseSubTerm(tokens, start + 2);
                break;
            case Token.END:
                codes.add("\n");
                Log.d(TAG, "subTerm null");
                break;
            default:
                break;
        }
    }

    public static void parsePrimary(List<Token> tokens, int start) throws IllegalTokenException{
        Token currentToken = tokens.get(start);
        switch (currentToken.getType()){
            case Token.INT:
                codes.add(currentToken.getValue());
                codes.add(" ");
                Log.d(TAG, "primary int");
                break;
            case Token.FLOAT:
                codes.add(currentToken.getValue());
                codes.add(" ");
                Log.d(TAG, "primary float");
                break;
            case Token.END:
                codes.add("\n");
                Log.d(TAG, "primary null");
                break;
            default:
                break;
        }
    }

    public static List<String> getCodes(){
        return codes;
    }

}
