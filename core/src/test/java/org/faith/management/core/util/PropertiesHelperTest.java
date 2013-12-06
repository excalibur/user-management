package org.faith.management.core.util; 

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/** 
* PropertiesHelper Tester. 
* 
* @author faith
* @version 0.0.1
*/ 
public class PropertiesHelperTest { 
    private  PropertiesHelper p;

    @Before
    public void setUp(){
        p = new PropertiesHelper("appConfig");
    }

    @Test
    public void testGetString() throws Exception {
        String a = p.getString("a");
        Assert.assertEquals(a,"a");
    }


    @Test
    public void testGetBoolean() throws Exception {
        boolean b = p.getBoolean("b");
        Assert.assertEquals(b,true);
    }


    @Test
    public void testGetInt() throws Exception {
          int c = p.getInt("c");
        Assert.assertEquals(c,1);
    }

    @Test
    public void testGetStringNull() throws Exception {
        String d = p.getString("d");
        Assert.assertEquals(d,null);
    }
} 
