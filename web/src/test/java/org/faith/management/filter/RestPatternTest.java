package org.faith.management.filter;

import org.faith.management.web.common.Router;
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

    @Test
    public void test03(){
        String path = "/home";
        System.out.println( path.indexOf(Router.login) == 0 ||
                path.indexOf(Router.register) == 0 ||
                path.indexOf("/favicon.ico") == 0 ||
                (path.length() == 1 && path.indexOf(Router.index) == 0) ||
                path.indexOf(Router.logout) == 0);
    }
}
