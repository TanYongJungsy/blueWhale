package com.mingx.utils;

import com.alibaba.fastjson.JSON;
import com.mingx.config.RedisConnection;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

@Component
public class RedisOps {

    Jedis jedis = RedisConnection.getJedis();
    public  void setJsonString(String key, Object object,int time) {

        jedis.set(key, JSON.toJSONString(object),"NX","EX",time);
        jedis.close();
    }
    public  Object getJsonObject(String key, Class clazz) {
        String value = jedis.get(key);
        jedis.close();
        return JSON.parseObject(value, clazz);
    }
    public  Object get(String key) {
        String value = jedis.get(key);
        return JSON.parseObject(value);
    }



//        public  void hSet(String key,Object value){
//            Jedis jedis = RedisConnection.getJedis();
//            jedis.hset("login",key,JSON.toJSONString(value));
//            jedis.close();
//        }
//
//        public  String hGet(String key){
//            Jedis jedis = RedisConnection.getJedis();
//            String value = jedis.hget("login",key,);
//            jedis.close();
//            return value;
//        }


    }



