package org.faith.management.core.util;

import com.mongodb.*;

/**
 * mongoDB连接工具类
 *
 * @author faith
 * @since 0.0.1
 */
public class DBConnectionHelper {
    private static final String host = "192.168.137.157";
    private static final int	port = 27017;
    private static final String username = "faith";
    private static final String passwd = "123456";
    private static final String dbase= "users";
    private static boolean auth = false;
    private static Mongo mg = null;

    public static DBCollection Connection(String collection){
        DB db = null;
        DBCollection col=null;

        try {
            mg = new MongoClient(host, port);
            db = mg.getDB(dbase);
            auth = db.authenticate(username, passwd.toCharArray());
            if(auth == true){
                col = db.getCollection(collection);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return col;
    }
    public static void MongoClose(Mongo mg){
        if(mg!=null){
            mg.close();
        }
    }
}
