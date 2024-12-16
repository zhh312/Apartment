package com.atguigu.lease.web.app.service.impl;


import com.atguigu.lease.common.constant.RedisConstant;
import com.atguigu.lease.common.exception.LeaseException;
import com.atguigu.lease.common.result.ResultCodeEnum;
import com.atguigu.lease.common.utils.CodeUtil;
import com.atguigu.lease.web.app.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private StringRedisTemplate redisTemplate;
    @Override
    public void getCode(String phone) {
        String code = CodeUtil.getRandomString(6);

        String key = RedisConstant.APP_LOGIN_PREFIX+phone;
        if(redisTemplate.hasKey(key)){
//            Long ttl = redisTemplate.getExpire(key, TimeUnit.SECONDS);
//            if(RedisConstant.APP_LOGIN_CODE_TTL_SEC - ttl < RedisConstant.APP_LOGIN_CODE_TTL_SEC){
                throw new LeaseException(ResultCodeEnum.APP_SEND_SMS_TOO_OFTEN);
//            }
        }
        System.out.println("--------Mock SMS sent to " + phone + " with message: " + code);
        redisTemplate.opsForValue().set(key,code, RedisConstant.APP_LOGIN_CODE_RESEND_TIME_SEC, TimeUnit.SECONDS);

    }
}
