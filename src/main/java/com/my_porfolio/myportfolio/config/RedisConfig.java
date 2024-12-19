package com.my_porfolio.myportfolio.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {

    @Bean
    RedisTemplate getRedisTemplate(RedisConnectionFactory connectionFactory){
//        why this configuaration required ?
//        we were not able to access whatever we were setting directly to redis server
//                because internally redis serialize objects and deserialize while getting
//                due do different serialization we were not able to get values whatever
//                we were setting into redis server directly so we have to set redis serializer
//                and deserializer
        RedisTemplate redisTemplate=new RedisTemplate();
        redisTemplate.setConnectionFactory(connectionFactory);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        return redisTemplate;



    }
}
