package com.example.demo.file;

import java.io.*;

/**
 * @Author chuke
 * @create 2020/8/22 14:57
 */
public class FileOutputStreamDemo {
    /**
     public void close() ：关闭此输出流并释放与此流相关联的任何系统资源。
     public void flush() ：刷新此输出流并强制任何缓冲的输出字节被写出。
     public void write(byte[] b) ：将 b.length字节从指定的字节数组写入此输出流。
     public void write(byte[] b, int off, int len) ：从指定的字节数组写入 len字节，从偏移量 off开始输
     出到此输出流。
     public abstract void write(int b) ：将指定的字节输出流。
     */

    public static void main(String[] args) throws IOException {
        //使用file对象创建流对象
        /*String path  = "C:/Users/17382/Desktop/nothing.txt";
        File file = new File(path);
        try {
            FileOutputStream fos = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }*/
        //使用文件名称创建流对象
        FileOutputStream fos = new FileOutputStream("C:/Users/17382/Desktop/nothing.txt");
        //写入文档
//        fos.write(97);
//        fos.write(98);
//        fos.write(99);
        byte [] a = "justdoit".getBytes();
        //从索引2开始，读取三个字节，std
        fos.write(a,2,3);
        fos.write(a);
        fos.close();
    }
    /**
     public FileOutputStream(File file, boolean append) ： 创建文件输出流以写入由指定的 File对象表示的
     文件。
     public FileOutputStream(String name, boolean append) ： 创建文件输出流以指定的名称写入文件
     续写*/
    void rewrite() throws IOException{
        //这两个构造方法，参数中都需要传入一个boolean类型的值， true 表示追加数据， false 表示清空原有数据。
        FileOutputStream fos = new FileOutputStream("C:/Users/17382/Desktop/nothing.txt",true);
        byte[] words = "abcde".getBytes();

        for (int i = 0; i < words.length; i++) {
            // 写出一个字节
            fos.write(words[i]);
            // 写出一个换行, 换行符号转成数组写出
            fos.write("\r\n".getBytes());
        }
        fos.close();
    }

}
