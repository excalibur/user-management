package org.faith.management.core.exception.database;

import org.junit.Test;

/**
* NotFoundException Tester. 
* 
* @author faith
* @version 0.0.1
*/ 
public class NotFoundExceptionTest { 

    @Test(expected = NotFoundException.class)
    public void test01() throws NotFoundException {
        throw new NotFoundException("11122","bbb");
    }

} 
