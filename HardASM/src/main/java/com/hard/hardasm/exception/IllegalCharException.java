package com.hard.hardasm.exception;

/**
 * <h3></h3>
 * Created by root on 2016/11/9.
 */
public class IllegalCharException extends Exception{

    public static final int TYPE = ExceptionType.ILLEGAL_CHAR;

    private String mMessage;

    public IllegalCharException(){
        super();
    }

    public IllegalCharException(String message) {
        super(message);
        mMessage = message;
    }

    public String getMessage() {
        return mMessage;
    }

    public void setMessage(String message) {
        mMessage = message;
    }
}
