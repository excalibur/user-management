package org.faith.management.core.util; 

import org.junit.Test;

/** 
* MD5Helper Tester. 
* 
* @author faith
* @since 0.0.1
*/ 
public class MD5HelperTest { 



    @Test
    public void testGetMD5ByString() throws Exception {
        System.out.println(MD5Helper.getMD5ByString("123456"));
    }


} 
