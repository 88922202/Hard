package com.hard.hardvm;

import com.hard.hardbase.utils.CharUtils;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * <h3></h3>
 * Created by root on 2016/11/15.
 */
public class TestCharUtils {

    @Test
    public void shouldBeRightFloat(){
        float a = .2f;
        byte result[] = CharUtils.float2byte(a);
        float b = CharUtils.byte2float(result, 0);
        assertThat(b == a).isTrue();
    }
}
