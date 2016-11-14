package com.hard.hardbase.utils;

/**
 * <h3></h3>
 * Created by root on 2016/11/14.
 */
public class CharUtils {

    /**
     * 把byte数组转换成为int
     * @param res 待转换的byte数组
     * @return int 转换后的int数字
     */
    public static int byte2int(byte[] res) {
        // 一个byte数据左移24位变成0x??000000，再右移8位变成0x00??0000
        return  (res[0] & 0xff) | ((res[1] << 8) & 0xff00) // | 表示按位或
                | ((res[2] << 24) >>> 8) | (res[3] << 24);
    }

    /**
     * 把int转换成byte[]
     * @param res 待转换的数字
     * @return byte[] 转换后的数组
     */
    public static byte[] int2byte(int res) {
        byte[] targets = new byte[4];

        targets[0] = (byte) (res & 0xff);// 最低位
        targets[1] = (byte) ((res >> 8) & 0xff);// 次低位
        targets[2] = (byte) ((res >> 16) & 0xff);// 次高位
        targets[3] = (byte) (res >>> 24);// 最高位,无符号右移。
        return targets;
    }
}
