package com.hard.hardasm;

import com.hard.hardasm.exception.IllegalCharException;
import com.hard.hardbase.utils.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * <h3></h3>
 * Created by root on 2016/11/11.
 */
public class Lexer2 {

    private static final String TAG = "Lexer";

    private static final int LEX_STATE_END = -1;
    private static final int LEX_STATE_NORMAL = 0;
    private static final int LEX_STATE_IDENTITIER = 1;
    private static final int LEX_STATE_INT = 2;

    public static List<Token> getLineTokens(String line) throws IllegalCharException {

        int currentLexState = LEX_STATE_NORMAL;
        int tokenStartIndex = 0;
        List<Token> tokens = new ArrayList<>();

        for (int i = 0; i < line.length(); i++){
            char currentChar = line.charAt(i);
            Log.d(TAG, "char is " + currentChar + " at " + i + ", lexer state is " + currentLexState);

            if (currentChar >= 48 && currentChar <= 57){
                //当前字符是数字
                switch (currentLexState){
                    case LEX_STATE_NORMAL:
                        tokenStartIndex = i;
                        currentLexState = LEX_STATE_INT;
                        break;
                    case LEX_STATE_IDENTITIER:
                        break;
                    case LEX_STATE_INT:
                        break;
                    default:
                        break;
                }
            }

            if (currentChar >= 65 && currentChar <= 122){
                //当前字符是英文字母
                switch (currentLexState){
                    case LEX_STATE_NORMAL:
                        tokenStartIndex = i;
                        currentLexState = LEX_STATE_IDENTITIER;
                        break;
                    case LEX_STATE_IDENTITIER:
                        break;
                    case LEX_STATE_INT:
                        throw new IllegalCharException("error char " + currentChar);
                    default:
                        break;
                }
            }

            switch (currentChar){
                case ' ':
                    if (currentLexState == LEX_STATE_NORMAL){
                        tokenStartIndex = i;
                    }
                    if (currentLexState == LEX_STATE_IDENTITIER){
                        String strToken = line.substring(tokenStartIndex, i);
                        Token token = new Token(Token.TOKEN_TYPE_IDENT, strToken);
                        tokens.add(token);
                        tokenStartIndex = i;
                        currentLexState = LEX_STATE_NORMAL;
                    }
                    if (currentLexState == LEX_STATE_INT){
                        String strToken = line.substring(tokenStartIndex, i);
                        Token token = new Token(Token.TOKEN_TYPE_INT, strToken);
                        tokens.add(token);
                        tokenStartIndex = i;
                        currentLexState = LEX_STATE_NORMAL;
                    }
                    break;
                case '\n':
                    if (currentLexState == LEX_STATE_NORMAL){
                        return tokens;
                    }
                    if (currentLexState == LEX_STATE_IDENTITIER){
                        String strToken = line.substring(tokenStartIndex, i);
                        Token token = new Token(Token.TOKEN_TYPE_IDENT, strToken);
                        tokens.add(token);
                        return tokens;
                    }
                    if (currentLexState == LEX_STATE_INT){
                        String strToken = line.substring(tokenStartIndex, i);
                        Token token = new Token(Token.TOKEN_TYPE_INT, strToken);
                        tokens.add(token);
                        return tokens;
                    }
                    break;
                default:
                    break;
            }


        }
        return tokens;
    }
}
