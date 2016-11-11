package main.java.com.hard.hardasm;

import main.java.com.hard.hardasm.exception.IllegalCharException;
import main.java.com.hard.hardasm.exception.IllegalTokenException;

import java.util.List;

/**
 * <h3></h3>
 * Created by root on 2016/11/9.
 */
public class Assembler {

    private static final String TAG = "Assembler";

    public static List<Integer> getInstructions(){
        List<String> lines = HASMLoader.loadHASMSourceFile("D:\\me\\8892\\Hard\\HardScript\\HardASM\\build\\production\\HardASM\\main\\java\\com\\hard\\hardasm\\test_0.xasm");
        for (int i = 0; i < lines.size(); i++){
            Log.d(TAG, "line " + i + ": " + lines.get(i));
            try {
                List<Token> tokens = Lexer2.getLineTokens(lines.get(i));
                for (int j = 0; j < tokens.size(); j++){
                    Log.d(TAG, "token is " + tokens.get(j).getValue());
                }
                return SyntacticAnalyzer.analysis(tokens);
            }catch (IllegalCharException | IllegalTokenException e){
                e.printStackTrace();
                Log.e(TAG, e.getMessage());
            }

        }

        return null;
    }
}
