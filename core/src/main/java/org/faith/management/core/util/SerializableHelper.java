package org.faith.management.core.util;

import java.io.*;

/**
 * 序列化工具类
 *
 * 主要是为了redis使用
 *
 * @author faith
 * @since 0.0.1
 */
public class SerializableHelper<T> {

    /**
     * 序列化到二进制流
     * @param t
     * @return 二进制数组
     */
    public byte[] serialize(T t){
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(t);
            return bos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 反序列化
     * @param bytes 二进制数组
     * @return
     */
    public T deserialization(byte[] bytes){
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
            ObjectInputStream ois = new ObjectInputStream(bis);
            Object o = ois.readObject();
            return (T)o;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
