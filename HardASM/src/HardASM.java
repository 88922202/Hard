
import java.util.ArrayList;
import java.util.List;

/**
 * <h3></h3>
 * Created by root on 2016/11/9.
 */
public class HardASM {

    private static final String TAG = "HardASM";

    public static void main(String args[]){

 //       String path = PathUtils.getProgramPath();

        List<String> lines = HASMLoader.loadHASMSourceFile("D:\\me\\8892\\Hard\\HardScript\\HardASM\\out\\production\\HardASM\\test_0.xasm");
        for (int i = 0; i < lines.size(); i++){
            Log.d(TAG, "line " + i + ": " + lines.get(i));
            try {
                List<Token> tokens = Lexer.getLineTokens(lines.get(i));
                for (int j = 0; j < tokens.size(); j++){
                    Log.d(TAG, "token is " + tokens.get(i).getValue());
                }
            }catch (IllegalTokenException e){
                e.printStackTrace();
                Log.e(TAG, e.getMessage());
            }

        }


    }
}
