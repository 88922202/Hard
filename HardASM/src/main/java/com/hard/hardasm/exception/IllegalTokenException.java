package com.hard.hardasm.exception;

/**
 * <h3></h3>
 * Created by root on 2016/11/11.
 */
public class IllegalTokenException extends Exception{

    public static final int TYPE = ExceptionType.ILLEGAL_TOKEN;

    private String mMessage;

    public IllegalTokenException(String message) {
        mMessage = message;
    }

    public String getMessage() {
        return mMessage;
    }

    public void setMessage(String message) {
        mMessage = message;
    }
}
