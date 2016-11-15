package com.hard.hardcompiler;

/**
 * <h3></h3>
 * Created by root on 2016/11/15.
 */
public class Token {

    public static final int INT = 0;
    public static final int FLOAT = 1;
    public static final int ADD = 2;
    public static final int SUB = 3;
    public static final int MUL = 4;
    public static final int DIV = 5;
    public static final int LEFT_BRACKET = 6;
    public static final int RIGHT_BRACKET = 7;

    private int mType;

    private String mValue;

    public Token(int type, String value) {
        mType = type;
        mValue = value;
    }

    public int getType() {
        return mType;
    }

    public void setType(int type) {
        mType = type;
    }

    public String getValue() {
        return mValue;
    }

    public void setValue(String value) {
        mValue = value;
    }
}
