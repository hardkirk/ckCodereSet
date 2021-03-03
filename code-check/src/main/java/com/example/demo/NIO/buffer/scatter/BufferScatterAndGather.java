package com.example.demo.NIO.buffer.scatter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Author chuke
 * @create 2020/10/31 20:00
 */
public class BufferScatterAndGather {
    /**
     * Scattering Reads是指数据从一个channel读取到多个buffer中
     */
    public void scatterDemo() throws IOException {
        RandomAccessFile accessFile = new RandomAccessFile("C:\\Users\\17382\\Desktop\\0000.txt","rw");
        FileChannel channel = accessFile.getChannel();
        ByteBuffer header = ByteBuffer.allocate(128);
        ByteBuffer body   = ByteBuffer.allocate(1024);
        ByteBuffer[] bufferArray = { header, body };
        channel.read(bufferArray);
    }
    /**
     * Gathering Writes是指数据从多个buffer写入到同一个channel。
     */
    public void gatherDemo() throws IOException {
        RandomAccessFile accessFile = new RandomAccessFile("C:\\Users\\17382\\Desktop\\0000.txt","rw");
        FileChannel channel = accessFile.getChannel();
        ByteBuffer header = ByteBuffer.allocate(128);
        ByteBuffer body   = ByteBuffer.allocate(1024);
//write data into buffers
        ByteBuffer[] bufferArray = { header, body };
        channel.write(bufferArray);
    }
}
