package com.qiguliuxing.dts.db.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class IdGenerator {
    private static final Random random = new Random();

    public String getStrId() {
        // 获取当前的年月日时分秒
        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        // 生成 4 位随机数
        int randomNumber = 1000 + random.nextInt(9000); // 1000 到 9999
        // 拼接时间戳和随机数
        return timestamp + randomNumber;    }
}
