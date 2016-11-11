package main.java.com.hard.hardasm;

import main.java.com.hard.hardasm.utils.TextUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * <h3></h3>
 * Created by root on 2016/11/9.
 */
public class HASMLoader {

    private static final String TAG = "HASMLoader";

    public static List<String> loadHASMSourceFile(String fileName){

        if (TextUtils.isEmpty(fileName)){
            Log.w(TAG, "fileName is empty.");
            return null;
        }

        Log.d(TAG, "load file " + fileName);

        if (!fileName.endsWith(".xasm")){
            Log.d(TAG, "fileName is not end with .xasm, auto fix this.");
            fileName += ".xasm";
        }

        ArrayList<String> lines = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            while (line != null){
                line = line.trim() + '\n';
                if (!line.equals("")) {
                    lines.add(line);
                }
                line = bufferedReader.readLine();
            }

            bufferedReader.close();
            fileReader.close();
            Log.d(TAG, fileName + " loaded.");
        }catch (IOException e){
            e.printStackTrace();
            Log.e(TAG, "read file " + fileName + " failed.");
        }

        return lines;
    }
}
