import org.omg.CORBA.NO_IMPLEMENT;

import java.util.ArrayList;
import java.util.List;

/**
 * <h3></h3>
 * Created by root on 2016/11/9.
 */
public class Lexer {

    private static final String TAG = "Lexer";

    private static final int LEX_STATE_END = -1;
    private static final int LEX_STATE_NOMAL = 0;
    private static final int LEX_STATE_IN_STRING = 1;
    private static final int LEX_STATE_IN_REVERT = 2;
    private static final int LEX_STATE_IN_INT = 3;
    private static final int LEX_STATE_IN_FLOAT = 4;
    private static final int LEX_STATE_IN_INDENTFIER = 5;
    private static final int LEX_STATE_IN_ARRAY = 6;
    private static final int LEX_STATE_IN_FUNCTION = 7;


    private static int CURRENT_LEX_STATE;

    public static List<Token> getLineTokens(String line) throws IllegalTokenException{
        CURRENT_LEX_STATE = 0;
        List<Token> tokens = new ArrayList<>();
        int parseStartIndex = 0;

        for (int i = 0; i < line.length(); i++){
            char currentChar = line.charAt(i);
            Log.d(TAG, "char is " + currentChar + " at " + i + ", lexer state is " + CURRENT_LEX_STATE);
            if (currentChar >= 48 && currentChar <= 57){
                if (CURRENT_LEX_STATE == LEX_STATE_NOMAL){
                    CURRENT_LEX_STATE = LEX_STATE_IN_INT;
                }else if (CURRENT_LEX_STATE == LEX_STATE_IN_STRING){

                }else if (CURRENT_LEX_STATE == LEX_STATE_IN_REVERT){
                    CURRENT_LEX_STATE = LEX_STATE_IN_STRING;
                }else if (CURRENT_LEX_STATE == LEX_STATE_IN_INT){

                }else if (CURRENT_LEX_STATE == LEX_STATE_IN_FLOAT){

                }else if (CURRENT_LEX_STATE == LEX_STATE_IN_INDENTFIER){

                }
                else {
                    throw new IllegalTokenException("error char " + currentChar);
                }
            }else if (currentChar >= 65 && currentChar <= 122){
                if (CURRENT_LEX_STATE == LEX_STATE_NOMAL){
                    CURRENT_LEX_STATE = LEX_STATE_IN_INDENTFIER;
                }else if (CURRENT_LEX_STATE == LEX_STATE_IN_STRING){

                }else if (CURRENT_LEX_STATE == LEX_STATE_IN_REVERT){
                    CURRENT_LEX_STATE = LEX_STATE_IN_STRING;
                }else if (CURRENT_LEX_STATE == LEX_STATE_IN_INDENTFIER){

                }
                else {
                    throw new IllegalTokenException("error char " + currentChar);
                }
            }else {

                switch (currentChar) {
                    case '"': {
                        if (CURRENT_LEX_STATE == LEX_STATE_NOMAL) {
                            parseStartIndex = i;
                            CURRENT_LEX_STATE = LEX_STATE_IN_STRING;
                        } else if (CURRENT_LEX_STATE == LEX_STATE_IN_STRING) {
                            String sub = line.substring(parseStartIndex, i);
                            Token token = new Token(Token.TOKEN_TYPE_STRING, sub);
                            tokens.add(token);
                            parseStartIndex = i;
                            CURRENT_LEX_STATE = LEX_STATE_NOMAL;
                        } else if (CURRENT_LEX_STATE == LEX_STATE_IN_REVERT) {
                            CURRENT_LEX_STATE = LEX_STATE_IN_STRING;
                        } else {
                            throw new IllegalTokenException();
                        }
                    }
                    break;
                    case '\\': {
                        if (CURRENT_LEX_STATE == LEX_STATE_IN_STRING) {
                            CURRENT_LEX_STATE = LEX_STATE_IN_REVERT;
                        } else if (CURRENT_LEX_STATE == LEX_STATE_IN_REVERT) {
                            CURRENT_LEX_STATE = LEX_STATE_IN_STRING;
                        } else {
                            throw new IllegalTokenException();
                        }
                    }
                    break;
                    case ';': {
                        if (CURRENT_LEX_STATE == LEX_STATE_IN_INT) {
                            String sub = line.substring(parseStartIndex, i);
//                        Token token = new Token(Token.TOKEN_TYPE_STRING, sub);
//                        tokens.add(token);
                            CURRENT_LEX_STATE = LEX_STATE_END;
                            return tokens;
                        } else if (CURRENT_LEX_STATE == LEX_STATE_IN_FLOAT) {
                            CURRENT_LEX_STATE = LEX_STATE_END;
                            return tokens;
                        } else if (CURRENT_LEX_STATE == LEX_STATE_NOMAL) {
                            CURRENT_LEX_STATE = LEX_STATE_END;
                            return tokens;
                        } else if (CURRENT_LEX_STATE == LEX_STATE_IN_INDENTFIER) {
                            CURRENT_LEX_STATE = LEX_STATE_END;
                            return tokens;
                        } else if (CURRENT_LEX_STATE == LEX_STATE_IN_STRING) {

                        } else if (CURRENT_LEX_STATE == LEX_STATE_IN_REVERT) {
                            CURRENT_LEX_STATE = LEX_STATE_IN_STRING;
                        } else {
                            throw new IllegalTokenException();
                        }
                    }
                    break;
                    case '\n': {
                        if (CURRENT_LEX_STATE == LEX_STATE_NOMAL) {
                            return tokens;
                        } else {
                            throw new IllegalTokenException();
                        }
                    }
                    case '\t':{
                        if (CURRENT_LEX_STATE == LEX_STATE_NOMAL){

                        }else if (CURRENT_LEX_STATE == LEX_STATE_IN_STRING){

                        }else if (CURRENT_LEX_STATE == LEX_STATE_IN_INT){

                        }else if (CURRENT_LEX_STATE == LEX_STATE_IN_FLOAT){

                        }
                        else if (CURRENT_LEX_STATE == LEX_STATE_IN_INDENTFIER){
                            CURRENT_LEX_STATE = LEX_STATE_NOMAL;
                        }else {
                            throw new IllegalTokenException("error char " + currentChar);
                        }
                    }
                    break;
                    case ',': {
                        if (CURRENT_LEX_STATE == LEX_STATE_NOMAL) {
                            Token token = new Token(Token.TOKEN_TYPE_COMMA, ",");
                            tokens.add(token);
                        }else if (CURRENT_LEX_STATE == LEX_STATE_IN_STRING){

                        }else if (CURRENT_LEX_STATE == LEX_STATE_IN_REVERT){
                            CURRENT_LEX_STATE = LEX_STATE_IN_STRING;
                        }else if (CURRENT_LEX_STATE == LEX_STATE_IN_INT){
                            CURRENT_LEX_STATE = LEX_STATE_NOMAL;
                        }else if (CURRENT_LEX_STATE == LEX_STATE_IN_FLOAT){
                            CURRENT_LEX_STATE = LEX_STATE_NOMAL;
                        }
                        else if (CURRENT_LEX_STATE == LEX_STATE_IN_INDENTFIER){
                            CURRENT_LEX_STATE = LEX_STATE_NOMAL;
                        }
                        else {
                            throw new IllegalTokenException("error char " + currentChar);
                        }
                    }
                    break;
                    case '[': {
                        if (CURRENT_LEX_STATE == LEX_STATE_IN_INDENTFIER) {
                            CURRENT_LEX_STATE = LEX_STATE_IN_ARRAY;
                        } else if (CURRENT_LEX_STATE == LEX_STATE_IN_STRING) {

                        } else if (CURRENT_LEX_STATE == LEX_STATE_IN_REVERT) {
                            CURRENT_LEX_STATE = LEX_STATE_IN_STRING;
                        } else {
                            throw new IllegalTokenException();
                        }
                    }
                    break;
                    case ']': {
                        if (CURRENT_LEX_STATE == LEX_STATE_IN_ARRAY) {
                            CURRENT_LEX_STATE = LEX_STATE_NOMAL;
                        } else if (CURRENT_LEX_STATE == LEX_STATE_IN_STRING) {

                        } else if (CURRENT_LEX_STATE == LEX_STATE_IN_REVERT) {
                            CURRENT_LEX_STATE = LEX_STATE_IN_STRING;
                        } else {
                            throw new IllegalTokenException();
                        }
                    }
                    break;
                    case '{': {
                        if (CURRENT_LEX_STATE == LEX_STATE_NOMAL) {

                        } else if (CURRENT_LEX_STATE == LEX_STATE_IN_STRING) {

                        } else if (CURRENT_LEX_STATE == LEX_STATE_IN_REVERT) {
                            CURRENT_LEX_STATE = LEX_STATE_IN_STRING;
                        } else {
                            throw new IllegalTokenException();
                        }
                    }
                    break;
                    case '}': {
                        if (CURRENT_LEX_STATE == LEX_STATE_NOMAL){

                        } else if (CURRENT_LEX_STATE == LEX_STATE_IN_STRING) {

                        } else if (CURRENT_LEX_STATE == LEX_STATE_IN_REVERT) {
                            CURRENT_LEX_STATE = LEX_STATE_IN_STRING;
                        } else if (CURRENT_LEX_STATE == LEX_STATE_IN_FUNCTION) {

                        } else {
                            throw new IllegalTokenException();
                        }
                    }

                    break;
                    case ' ': {
                        if (CURRENT_LEX_STATE == LEX_STATE_NOMAL){

                        } else if (CURRENT_LEX_STATE == LEX_STATE_IN_INDENTFIER) {
                            CURRENT_LEX_STATE = LEX_STATE_NOMAL;
                        } else if (CURRENT_LEX_STATE == LEX_STATE_IN_INT) {
                            CURRENT_LEX_STATE = LEX_STATE_NOMAL;
                        } else if (CURRENT_LEX_STATE == LEX_STATE_IN_FLOAT) {
                            CURRENT_LEX_STATE = LEX_STATE_NOMAL;
                        } else if (CURRENT_LEX_STATE == LEX_STATE_IN_STRING) {

                        } else if (CURRENT_LEX_STATE == LEX_STATE_IN_REVERT) {
                            CURRENT_LEX_STATE = LEX_STATE_IN_STRING;
                        } else {
                            throw new IllegalTokenException("error char " + currentChar);
                        }
                    }
                    break;
                    case ':':
                        break;
                    default:
                        throw new IllegalTokenException("error char " + currentChar);

                }
            }
        }
        return tokens;
    }


}
