package com.mingx.utils;



import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

    public class CacheUtity {
        //将对象序列化
        static public byte[] toByteArray(Object obj) {
            byte[] bytes = null;
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            try {
                ObjectOutputStream oos = new ObjectOutputStream(bos);
                oos.writeObject(obj);
                oos.flush();
                bytes = bos.toByteArray();
                oos.close();
                bos.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            return bytes;
        }
        //反序列化
        static public  Object toObject(byte[] bytes) {
            Object obj = null;
            try {
                ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
                ObjectInputStream ois = new ObjectInputStream(bis);
                obj = ois.readObject();
                ois.close();
                bis.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
            return obj;
        }
    }

