package test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

/**
 * <h3></h3>
 * Created by root on 2016/11/10.
 */
public class TestLexer {

    @Test
    public void shouldReadAsInt(){
        String line = "200";
//        List<Token> tokens = Lexer.getLineTokens(line);
        List<String> tokens = new ArrayList<>();
        assertThat(tokens.size() == 1).isTrue();
    }
}
