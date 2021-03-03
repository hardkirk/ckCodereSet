package com.example.demo.NIO.randAccessFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

/**
 * @Author chuke
 * @create 2020/10/31 13:54
 */
public class RAFTtestFactory {
    private static final String url = "C:\\Users\\17382\\Desktop\\1.txt";
    private static final String[] model = {"r","rw","rws","rwd"};

    public static RandomAccessFile getRAFWithModelR() throws FileNotFoundException {
        RandomAccessFile raf = new RandomAccessFile(new File(url),model[0]);
        return raf;
    }
    public static RandomAccessFile getRAFWithModelRW() throws FileNotFoundException {
        RandomAccessFile raf = new RandomAccessFile(new File(url),model[1]);
        return raf;
    }
    public static RandomAccessFile getRAFWithModelRWS() throws FileNotFoundException {
        RandomAccessFile raf = new RandomAccessFile(new File(url),model[2]);
        return raf;
    }
    public static RandomAccessFile getRAFWithModelRWD() throws FileNotFoundException {
        RandomAccessFile raf = new RandomAccessFile(new File(url),model[3]);
        return raf;
    }
}
