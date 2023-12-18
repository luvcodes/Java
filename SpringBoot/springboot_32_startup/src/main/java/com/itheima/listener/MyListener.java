package com.itheima.listener;

import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class MyListener implements ApplicationListener<ApplicationStartingEvent> {
//    @Override
//    public void onApplicationEvent(ApplicationEvent applicationEvent) {
//        System.out.println("================================================");
//        System.out.println(applicationEvent.getTimestamp());
//        System.out.println(applicationEvent.getSource());
//        System.out.println(applicationEvent.getClass());
//    }

    @Override
    public void onApplicationEvent(ApplicationStartingEvent applicationStartingEvent) {
        System.out.println("================================================");
        System.out.println(applicationStartingEvent.getTimestamp());
        System.out.println(applicationStartingEvent.getSource());
        System.out.println(applicationStartingEvent.getClass());
    }
}
