package com.my_porfolio.myportfolio.service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.internal.time.Timeout;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class RedisService {
    private static  Long defaultExpiry=30L;

    @Autowired
    RedisTemplate redisTemplate;

    public <T> T getValue(String key,Class<T> className){

        try {
            Object o = redisTemplate.opsForValue().get(key);
            if(o==null){
                return null;
            }
            ObjectMapper objectMapper=new ObjectMapper();
            T v=  objectMapper.readValue(o.toString(),className);
            log.debug("Value fetched from redis");
            return v;
        } catch (Exception e) {
            log.error("Error while getting data in redis :{}",e.toString());
            return null;
        }
    }
    public <T> void setValue(String key,Object o, Long expiry){
        try {
            ObjectMapper objectMapper=new ObjectMapper();
            String jsonString=objectMapper.writeValueAsString(o);
        redisTemplate.opsForValue().set(key,jsonString,defaultExpiry, TimeUnit.DAYS);

        log.debug("Value added to redis");

        } catch (Exception e) {
            log.error("Error while setting data in redis: {}",e);
        }
    }
}
