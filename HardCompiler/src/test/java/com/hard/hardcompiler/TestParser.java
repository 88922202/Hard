package com.hard.hardcompiler;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * <h3></h3>
 * Created by root on 2016/11/16.
 */
public class TestParser {

    @Test
    public void testParseHighExpress() throws Exception{
        List<Token> tokens = new ArrayList<Token>();

        tokens.add(new Token(Token.INT, "1"));
        tokens.add(new Token(Token.MUL, "*"));
        tokens.add(new Token(Token.INT, "2"));
        tokens.add(new Token(Token.END, " "));

        Parser.parse(tokens);
        List<String> codes = Parser.getCodes();
        for (String eachString : codes){
            System.out.print(eachString);
        }

    }
}
