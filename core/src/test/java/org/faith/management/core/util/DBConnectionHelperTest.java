package org.faith.management.core.util;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import org.junit.Before;
import org.junit.Test;

/**
* DBConnectionHelper Tester. 
* 
* @author faith
* @version 0.0.1
*/ 
public class DBConnectionHelperTest { 
    private DBCollection collection = null;
    @Before
    public void setUp(){
        collection = DBConnectionHelper.Connection("test");
    }
    @Test
    public void testInert(){
        DBObject o = new BasicDBObject();
        o.put("username", "faith");
        o.put("password", "123456");
        o.put("name", "刘真源");
        collection.insert(o);
    }
    @Test
    public void testQuery(){
        DBCursor dbCursor = collection.find();
        if (dbCursor.hasNext()){
            System.out.println(dbCursor.next());
        }
    }
} 
