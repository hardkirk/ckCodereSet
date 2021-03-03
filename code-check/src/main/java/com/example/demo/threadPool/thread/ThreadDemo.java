package com.example.demo.threadPool.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author chuke
 * @create 2020/11/18 19:54
 */
public class ThreadDemo extends Thread{
    @Override
    public void run() {
        super.run();
    }

    public static void main(String[] args) {
        List<String> sca = new ArrayList<>();
        sca.add("11111") ;
        sca.add( "22222");
        sca.add("33333");
        sca.forEach(o-> System.out.println(o));
    }
}
