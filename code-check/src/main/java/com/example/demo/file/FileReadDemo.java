package com.example.demo.file;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @Author chuke
 * @create 2020/8/22 16:42
 */
public class FileReadDemo {
    /**
     public void close() ：关闭此流并释放与此流相关联的任何系统资源。
     public int read() ： 从输入流读取一个字符。
     public int read(char[] cbuf) ： 从输入流中读取一些字符，并将它们存储到字符数组 cbuf中 。
     */
    public static void main(String[] args) throws IOException {
        File file = new File("C:/Users/17382/Desktop/somthing.txt");
        FileReader fr = new FileReader(file);
        int b;
        char[] filebyet = new char[3];
        while ((b = fr.read(filebyet))!= -1){
            System.out.println(new String(filebyet,0,b));
//            System.out.println((char)b);
        }
    }


}
