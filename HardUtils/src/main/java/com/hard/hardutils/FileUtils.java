package com.hard.hardutils;

import com.hard.hardutils.Log;

import java.io.*;

/**
 * <h3></h3>
 * Created by root on 2016/11/11.
 */
public class FileUtils {

    private static final String TAG = "FileUtils";

    public static void appendToFile(String fileName, int data){
        try {
            File file = new File(fileName);
            if (!file.exists()) {
                if (file.createNewFile()){
                    Log.w(TAG, "Failed to create file " + fileName);
                }
            }
            FileWriter fileWriter = new FileWriter(file.getName(), true);
            BufferedWriter bufferWriter = new BufferedWriter(fileWriter);
            bufferWriter.write(data);
            bufferWriter.close();

            Log.d(TAG, "Append to file " + fileName + " success.");
        }catch (IOException e){
            e.printStackTrace();
            Log.e(TAG, "Error read or write file " + fileName);
        }
    }

    /**
     * A方法追加文件：使用RandomAccessFile
     * @param fileName 文件名
     * @param content 追加的内容
     * note:适用于二进制文件，不支持中文字符
     */
    public static void appendBytes(String fileName,String content){
        try {
            // 打开一个随机访问文件流，按读写方式
            RandomAccessFile randomFile = new RandomAccessFile(fileName, "rw");
            // 文件长度，字节数
            long fileLength = randomFile.length();
            //将写文件指针移到文件尾。
            randomFile.seek(fileLength);
            randomFile.writeBytes(content);
            randomFile.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * A方法追加文件：使用RandomAccessFile
     * @param fileName 文件名
     * @param content 追加的内容
     * note:适用于二进制文件，不支持中文字符
     */
    public static void appendFloat(String fileName,float content){
        try {
            // 打开一个随机访问文件流，按读写方式
            RandomAccessFile randomFile = new RandomAccessFile(fileName, "rw");
            // 文件长度，字节数
            long fileLength = randomFile.length();
            //将写文件指针移到文件尾。
            randomFile.seek(fileLength);
            randomFile.writeFloat(content);
            randomFile.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * A方法追加文件：使用RandomAccessFile
     * @param fileName 文件名
     * @param content 追加的内容
     * note:适用于二进制文件，不支持中文字符
     */
    public static void appendInt(String fileName, int content){
        try {
            // 打开一个随机访问文件流，按读写方式
            RandomAccessFile randomFile = new RandomAccessFile(fileName, "rw");
            // 文件长度，字节数
            long fileLength = randomFile.length();
            //将写文件指针移到文件尾。
            randomFile.seek(fileLength);
            randomFile.writeInt(content);
            randomFile.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
