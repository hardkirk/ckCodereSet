package com.example.demo.NIO.randAccessFile;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @Author chuke
 * @create 2020/10/31 13:59
 */
@Slf4j
public class RAFtest {
    public static void main(String[] args) throws IOException {
        //只读模式
        /*RandomAccessFile raft = RAFTtestFactory.getRAFWithModelR();
        System.out.println("文本头指针" + raft.getFilePointer());
        System.out.println("获取文本长度" + raft.length());
        raft.seek(4);//改变文本头指针
        System.out.println("文本头指针" + raft.getFilePointer());*/

        //读写模式
        RandomAccessFile raf = RAFTtestFactory.getRAFWithModelRW();
        raf.seek(2);
        String word = "56565656";
        raf.write(word.getBytes());
        raf.writeByte(3);
        raf.writeChar('a');
        raf.writeShort(5);
        raf.writeInt(6);
        raf.writeLong(792929347162343l);
        raf.writeFloat(8.5f);
        raf.writeDouble(9.44d);
        raf.writeBoolean(true);
        log.info("channel信息"+String.valueOf(raf.getChannel()));
    }
}
