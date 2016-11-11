package main.java.com.hard.hardasm;

import main.java.com.hard.hardasm.exception.IllegalTokenException;

import java.util.List;

/**
 * <h3></h3>
 * Created by root on 2016/11/11.
 */
public class SyntacticAnalyzer {

    private static final String TAG = "SyntacticAnalyzer";

    public static void analysis(List<Token> tokens) throws IllegalTokenException {
        for (int i = 0; i < tokens.size(); i++){
            Token currentToken = tokens.get(i);
            String currentValue = currentToken.getValue() == null ? "" : currentToken.getValue().toUpperCase();
            int nextTokenType = getNextTokenType(tokens, i + 1);

            switch (currentToken.getTokenType()){
                case Token.TOKEN_TYPE_IDENT:
                    switch (currentValue){
                        case Instruction.ADD:
                            if (nextTokenType == Token.TOKEN_TYPE_INT){
                                int next2TokenType = getNextTokenType(tokens, i + 2);
                                if (next2TokenType == Token.TOKEN_TYPE_INT){
                                    int code = Instruction.getInstructionCode(Instruction.ADD);
                                    //i = skipParsedTokens(i, 2);
                                    Log.d(TAG, "instruction code is " + code);
                                }else {
                                    throw new IllegalTokenException("error token " + next2TokenType);
                                }
                            }else {
                                throw new IllegalTokenException("error token " + nextTokenType);
                            }
                            break;
                        default:
                            break;
                    }
                    break;
                case Token.TOKEN_TYPE_INT:
                    try {
                        int number = Integer.parseInt(currentValue);
                        Log.d(TAG, "int number " + number);
                    }catch (Exception e){
                        throw new IllegalTokenException("error token " + currentToken.getValue());
                    }

                    break;
                default:
                    break;
            }
        }
    }

    private static int getNextTokenType(List<Token> tokens, int index){
        if (index > tokens.size() - 1){
            return Token.END_OF_TOKEN_STREAM;
        }

        return tokens.get(index).getTokenType();
    }

    private static int skipParsedTokens(int startIndex, int skipCount){
        startIndex += skipCount;
        return startIndex;
    }

}
