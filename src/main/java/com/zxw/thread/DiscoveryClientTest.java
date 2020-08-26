package com.zxw.thread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.TimerTask;
import java.util.concurrent.*;

/**
 * @author zxw
 * @date 2020/8/25 22:36
 */
public class DiscoveryClientTest {
    public static void main(String[] args) {
        DiscoveryClient d1 = new DiscoveryClient("d1");
        DiscoveryClient d2 = new DiscoveryClient("d2");
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                try {
//                    Thread.sleep(1000);
                    System.out.println(i);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.setDaemon(true);
        thread.run();
        System.out.println("主线程结束");
//        while (true){
//
//        }
    }
}
