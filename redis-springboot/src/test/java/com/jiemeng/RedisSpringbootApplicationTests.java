package com.jiemeng;

import com.jiemeng.config.RedisConfig;
import com.jiemeng.utils.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class RedisSpringbootApplicationTests {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Autowired
    RedisUtil redisUtil;

    @Test
    void contextLoads() {
        redisTemplate.opsForValue().set("myKey","myValue");
        System.out.println(redisTemplate.opsForValue().get("myKey"));
    }
    @Test
    void expire() {
        redisUtil.expire("myKey",60);
        System.out.println(redisTemplate.opsForValue().get("myKey"));
    }
    @Test
    void getExpire() {
        long myKey = redisUtil.getExpire("myKey");
        System.out.println(myKey);
        System.out.println(redisTemplate.opsForValue().get("myKey"));
    }

}
