package com.itheima.service.impl;

import com.itheima.service.MsgService;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class MsgServiceImpl implements MsgService {
    // 定义缓存
    private HashMap<String, String> cache = new HashMap<String, String>();

    @Override
    public String get(String tele) {
        String substring = tele.substring(tele.length() - 6);
        cache.put(tele, substring);
        return substring;
    }

    @Override
    public boolean check(String tele, String verifyCode) {
        String queryCode = cache.get(tele);
        return verifyCode.equals(queryCode);  // 不区分大小写
    }
}
