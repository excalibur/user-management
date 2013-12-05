package org.faith.management.filter;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 验证正则
 *
 * @author faith
 * @since 0.0.1
 */
public class RestPatternTest {
    Pattern pattern = Pattern.compile("^/[^/]*$");
    @Test
    public void test01(){
        Matcher matcher = pattern.matcher("/user");
        if(matcher.find()){
            System.out.println(true);
            System.out.println(matcher.group().substring(1));
        }
    }
    @Test
    public void test02(){
        Matcher matcher = pattern.matcher("/user/");
        if(matcher.find()){
            System.out.println(true);
        }
    }
}
