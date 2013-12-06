package org.faith.management.core.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Properties属性读取
 *
 * 为了方便配置
 *
 * @author faith
 * @since 0.0.1
 */
public class PropertiesHelper {
    private Properties properties = new Properties();
    public PropertiesHelper(String name) {
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(name+".properties");
        try {
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getString(String name){
        Object o = properties.get(name);
        return (String)o;
    }

    public boolean getBoolean(String name){
        Object o = properties.get(name);
        return Boolean.parseBoolean(o.toString());
    }

    public int getInt(String name){
        Object o = properties.get(name);
        return Integer.parseInt((String)o);
    }
}
