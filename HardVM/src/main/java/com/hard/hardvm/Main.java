package com.hard.hardvm;

import com.hard.hardbase.utils.Log;

/**
 * <h3></h3>
 * Created by root on 2016/11/11.
 */
public class Main {
    public static void main(String args[]){
        Log.d("HardVM", "HardVM started.");

        HSELoader.loadHSEFile("D:\\me\\8892\\Hard\\HardASM\\first.hse");
    }
}
