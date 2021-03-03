package com.example.demo.NIO.test;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @Author chuke
 * @create 2020/11/3 20:56
 */
public class TestUtil {
    public static void sendMsg(SocketChannel channel,String msg) throws IOException {
        //定义大小
        ByteBuffer byteBuffer = ByteBuffer.allocate(50);
        //向byteBuffer中塞入数据
        byteBuffer.put(msg.getBytes());
        //重置position
        byteBuffer.flip();
        //写入管道
        channel.write(byteBuffer);
    }


    public static String  recsMsg(SocketChannel channel) throws IOException {
        ByteBuffer byteBuffer = ByteBuffer.allocate(50);
        channel.read(byteBuffer);
        byteBuffer.flip();
        byte[] bytes = new byte[byteBuffer.limit()];
        byteBuffer.get(bytes);
        return new String(bytes);
    }
}
