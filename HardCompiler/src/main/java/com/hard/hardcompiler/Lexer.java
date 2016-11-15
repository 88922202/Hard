package com.hard.hardcompiler;

import com.hard.hardbase.exception.IllegalCharException;
import com.hard.hardbase.utils.HSEDefinition;
import com.hard.hardbase.utils.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * <h3></h3>
 * Created by root on 2016/11/15.
 */
public class Lexer {

    private static final String TAG = "Lexer";

    private static final int STATE_END = -1;
    private static final int STATE_NORMAL = 0;
    private static final int STATE_IDENTITIER = 1;
    private static final int STATE_INT = 2;
    private static final int STATE_FLOAT = 3;
    private static final int STATE_LEFT_BRACKET = 4;


    public static List<Token> getLineTokens(String line)throws IllegalCharException{
        int currentLexState = STATE_NORMAL;
        int tokenStartIndex = 0;
        List<Token> tokens = new ArrayList<Token>();

        for (int i = 0; i < line.length(); i++){
            char currentChar = line.charAt(i);
            //Log.d(TAG, "char is " + currentChar + " at " + i + ", lexer state is " + currentLexState);

            if (currentChar >= 48 && currentChar <= 57){
                //当前字符是数字
                switch (currentLexState){
                    case STATE_NORMAL:
                        tokenStartIndex = i;
                        currentLexState = STATE_INT;
                        break;
                    case STATE_IDENTITIER:
                        break;
                    case STATE_INT:
                        break;
                    case STATE_FLOAT:
                        break;
                    default:
                        break;
                }
            }

            if (currentChar >= 65 && currentChar <= 122){
                //当前字符是英文字母
                switch (currentLexState){
                    case STATE_NORMAL:
                        tokenStartIndex = i;
                        currentLexState = STATE_IDENTITIER;
                        break;
                    case STATE_IDENTITIER:
                        break;
                    default:
                        throw new IllegalCharException("error char " + currentChar);
                }
            }

            switch (currentChar){
                case ' ':
                    if (currentLexState == STATE_NORMAL){
                        tokenStartIndex = i;
                    }
                    if (currentLexState == STATE_IDENTITIER){
                        String strToken = line.substring(tokenStartIndex, i);
                        Token token = new Token(HSEDefinition.TOKEN_TYPE_IDENT, strToken);
                        tokens.add(token);
                        tokenStartIndex = i;
                        currentLexState = STATE_NORMAL;
                    }
                    if (currentLexState == STATE_INT){
                        String strToken = line.substring(tokenStartIndex, i);
                        Token token = new Token(HSEDefinition.TOKEN_TYPE_INT, strToken);
                        tokens.add(token);
                        tokenStartIndex = i;
                        currentLexState = STATE_NORMAL;
                    }
                    if (currentLexState == STATE_FLOAT){
                        String strToken = line.substring(tokenStartIndex, i);
                        Token token = new Token(HSEDefinition.TOKEN_TYPE_FLOAT, strToken);
                        tokens.add(token);
                        tokenStartIndex = i;
                        currentLexState = STATE_NORMAL;
                    }
                    break;
                case '\n':
                    if (currentLexState == STATE_NORMAL){
                        return tokens;
                    }
                    if (currentLexState == STATE_IDENTITIER){
                        String strToken = line.substring(tokenStartIndex, i);
                        Token token = new Token(HSEDefinition.TOKEN_TYPE_IDENT, strToken);
                        tokens.add(token);
                        return tokens;
                    }
                    if (currentLexState == STATE_INT){
                        String strToken = line.substring(tokenStartIndex, i);
                        Token token = new Token(HSEDefinition.TOKEN_TYPE_INT, strToken);
                        tokens.add(token);
                        return tokens;
                    }
                    if (currentLexState == STATE_FLOAT){
                        String strToken = line.substring(tokenStartIndex, i);
                        Token token = new Token(HSEDefinition.TOKEN_TYPE_FLOAT, strToken);
                        tokens.add(token);
                        return tokens;
                    }
                    break;
                case '.':
                    switch (currentLexState){
                        case STATE_NORMAL:
                            currentLexState = STATE_FLOAT;
                            break;
                        case STATE_INT:
                            currentLexState = STATE_FLOAT;
                            break;
                        default:
                            throw new IllegalCharException("error char '.' ");
                    }

                    break;
                case '+':
                    if (currentLexState == STATE_NORMAL){
                        String strToken = line.substring(i, i + 1);
                        Token token = new Token(Token.ADD, strToken);
                        tokens.add(token);
                        tokenStartIndex = i;
                    }else {
                        throw new IllegalCharException("error char '+' ");
                    }
                    break;
                case '-':
                    if (currentLexState == STATE_NORMAL){
                        String strToken = line.substring(i, i + 1);
                        Token token = new Token(Token.SUB, strToken);
                        tokens.add(token);
                        tokenStartIndex = i;
                    }else {
                        throw new IllegalCharException("error char '-' ");
                    }
                    break;
                case '*':
                    if (currentLexState == STATE_NORMAL){
                        String strToken = line.substring(i, i + 1);
                        Token token = new Token(Token.MUL, strToken);
                        tokens.add(token);
                        tokenStartIndex = i;
                    }else {
                        throw new IllegalCharException("error char '*' ");
                    }
                    break;
                case '\\':
                    if (currentLexState == STATE_NORMAL){
                        String strToken = line.substring(i, i + 1);
                        Token token = new Token(Token.DIV, strToken);
                        tokens.add(token);
                        tokenStartIndex = i;
                    }else {
                        throw new IllegalCharException("error char '\\' ");
                    }
                    break;
                case '(':
                    if (currentLexState == STATE_NORMAL){
                        String strToken = line.substring(i, i + 1);
                        Token token = new Token(Token.LEFT_BRACKET, strToken);
                        tokens.add(token);
                        tokenStartIndex = i;
                    }else {
                        throw new IllegalCharException("error char '(' ");
                    }
                    break;
                case ')':
                    if (currentLexState == STATE_NORMAL){
                        String strToken = line.substring(i, i + 1);
                        Token token = new Token(Token.RIGHT_BRACKET, strToken);
                        tokens.add(token);
                        tokenStartIndex = i;
                    }else {
                        throw new IllegalCharException("error char ')' ");
                    }
                    break;
                default:
                    break;
            }


        }
        return tokens;
    }
}
