package test;

import main.java.com.hard.hardasm.exception.IllegalCharException;
import main.java.com.hard.hardasm.Lexer;
import main.java.com.hard.hardasm.Token;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

/**
 * <h3></h3>
 * Created by root on 2016/11/10.
 */
public class TestLexer {

    @Test
    public void shouldReadAsInt() throws IllegalCharException {
        String line = "200 ";
        List<Token> tokens = Lexer.getLineTokens(line);
        assertThat(tokens.size() == 1).isTrue();
    }
}
