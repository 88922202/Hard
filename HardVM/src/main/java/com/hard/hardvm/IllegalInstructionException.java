package com.hard.hardvm;

/**
 * <h3></h3>
 * Created by root on 2016/11/15.
 */
public class IllegalInstructionException extends Exception {

    private static final int TYPE = 0;

    private String mMessage;

    public IllegalInstructionException(String message) {
        super(message);
        mMessage = message;
    }

    @Override
    public String getMessage() {
        return mMessage;
    }

    public void setMessage(String message) {
        mMessage = message;
    }
}
