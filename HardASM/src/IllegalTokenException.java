/**
 * <h3></h3>
 * Created by root on 2016/11/9.
 */
public class IllegalTokenException extends Exception{

    private int mExceptionType;

    private String mMessage;

    public IllegalTokenException(){
        super();
    }

    public IllegalTokenException(String message) {
        super(message);
        mMessage = message;
    }

    public int getExceptionType() {
        return mExceptionType;
    }

    public String getMessage() {
        return mMessage;
    }

    public void setMessage(String message) {
        mMessage = message;
    }
}
