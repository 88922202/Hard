/**
 * <h3></h3>
 * Created by root on 2016/11/9.
 */
public class Token {

    public static final int  TOKEN_TYPE_INT              = 0;           // An integer literal
    public static final int  TOKEN_TYPE_FLOAT            = 1;           // An floating-point literal
    public static final int  TOKEN_TYPE_STRING           = 2;           // An string literal
    public static final int  TOKEN_TYPE_QUOTE            = 3;           // A double-quote
    public static final int  TOKEN_TYPE_IDENT            = 4;           // An identifier
    public static final int  TOKEN_TYPE_COLON            = 5;           // A colon
    public static final int  TOKEN_TYPE_OPEN_BRACKET     = 6;           // An openening bracket
    public static final int  TOKEN_TYPE_CLOSE_BRACKET    = 7;           // An closing bracket
    public static final int  TOKEN_TYPE_COMMA            = 8;           // A comma
    public static final int  TOKEN_TYPE_OPEN_BRACE       = 9;           // An openening curly brace
    public static final int  TOKEN_TYPE_CLOSE_BRACE      = 10;          // An closing curly brace
    public static final int  TOKEN_TYPE_NEWLINE          = 11;          // A newline

    public static final int  TOKEN_TYPE_INSTR			= 12;			// An instruction

    public static final int  TOKEN_TYPE_SETSTACKSIZE     = 13;          // The SetStackSize directive
    public static final int  TOKEN_TYPE_VAR              = 14;          // The Var/Var [] directives
    public static final int  TOKEN_TYPE_FUNC             = 15;          // The Func directives
    public static final int  TOKEN_TYPE_PARAM            = 16;          // The Param directives
    public static final int  TOKEN_TYPE_REG_RETVAL       = 17;          // The _RetVal directives

    public static final int  TOKEN_TYPE_INVALID          = 18;          // Error code for invalid tokens
    public static final int  END_OF_TOKEN_STREAM         = 19;          // The end of the stream has been
// reached

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
