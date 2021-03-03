package com.example.demo.file;

import java.io.*;

/**
 * @Author chuke
 * @create 2020/8/24 11:45
 */
public class BufferedInputStreamDemo {

    void searchBuffer() throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("C:/Users/17382/Desktop/somthing.txt"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("C:/Users/17382/Desktop/nothing.txt"));
        int b;
        while ((b=bis.read()) !=-1 ){
            bos.write(b);
        }
        bos.close();
        bis.close();
    }
    void testBuffer() throws IOException{
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("C:/Users/17382/Desktop/somthing.txt"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("C:/Users/17382/Desktop/nothing.txt"));
        //使用数组来进行读写
        int len;
        byte[] filebyte = new byte[1024];
        while ((len = bis.read(filebyte))!=-1){
            bos.write(filebyte,0,len);
        }

    }

    public static void main(String[] args) {
        BufferedInputStreamDemo bis = new BufferedInputStreamDemo();
        try {
            bis.searchBuffer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
