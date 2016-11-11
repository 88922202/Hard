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

            switch (currentToken.getTokenType()){
                case Token.TOKEN_TYPE_IDENT:
                    switch (currentValue){
                        case Instruction.ADD:
                            int code = Instruction.getInstructionCode(Instruction.ADD);
                            Log.d(TAG, "instruction code is " + code);
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


}
