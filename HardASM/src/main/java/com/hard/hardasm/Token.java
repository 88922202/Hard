package com.hard.hardasm;

/**
 * <h3></h3>
 * Created by root on 2016/11/9.
 */
public class Token {

    private int mTokenType;

    private String mValue;

    public Token(int tokenType, String value) {
        mTokenType = tokenType;
        mValue = value;
    }

    public int getTokenType() {
        return mTokenType;
    }

    public void setTokenType(int mTokenType) {
        this.mTokenType = mTokenType;
    }

    public String getValue() {
        return mValue;
    }

    public void setValue(String mValue) {
        this.mValue = mValue;
    }
}
