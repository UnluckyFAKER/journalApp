package com.moulik.journalApp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
public class redis {
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    void test() {
        redisTemplate.opsForValue().set("email", "moulik@gmail.com");
        Object nuw = redisTemplate.opsForValue().get("email");
        int a = 1;

    }
}

//}
