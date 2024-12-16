package com.atguigu.lease.common.utils;

import java.util.Random;

public class CodeUtil {

    public static String getRandomString(int length) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int num = random.nextInt(10);
            sb.append(num);
        }
        return sb.toString();
    }
}
