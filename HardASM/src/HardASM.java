
import java.util.ArrayList;
import java.util.List;

/**
 * <h3></h3>
 * Created by root on 2016/11/9.
 */
public class HardASM {

    public static void main(String args[]){

        String path = PathUtils.getProgramPath();

        List<String> lines = HASMLoader.loadHASMSourceFile("D:\\me\\8892\\Hard\\HardScript\\HardASM\\out\\production\\HardASM\\test_0.xasm");
        for (String eachLine : lines){
            System.out.println(eachLine);
        }
    }
}
