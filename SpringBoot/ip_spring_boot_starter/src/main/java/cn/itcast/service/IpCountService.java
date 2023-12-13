package cn.itcast.service;

import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class IpCountService {

    private Map<String, Integer> ipMap = new HashMap<>();

    @Autowired
    // 当前的request对象的注入工作由使用但钱starter的工程自动装配
    private HttpServletRequest httpServletRequest;

    // 每次调用当前操作，就记录当前访问的IP，然后累加访问次数
    public void count() {
        // 1. 获取当前操作的IP地址
        String ip = httpServletRequest.getRemoteAddr();
        System.out.println("--------------------------------" + ip);
        // 2. 根据IP地址从Map取值，并递增
        Integer count = ipMap.get(ip);
        if (count == null) {
            ipMap.put(ip, 1);
        } else {
            ipMap.put(ip, ipMap.get(ip) + 1);
        }
    }

    public void print() {
        System.out.println("IP访问监控");
        System.out.println("+---------+--+");
        for (Map.Entry<String, Integer> entry : ipMap.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();

        }
    }
}
