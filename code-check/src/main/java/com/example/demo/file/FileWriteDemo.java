package com.example.demo.file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @Author chuke
 * @create 2020/8/22 16:58
 */
public class FileWriteDemo {
    /**
     void write(int c) 写入单个字符。
     void write(char[] cbuf) 写入字符数组。
     abstract void write(char[] cbuf, int off, int len) 写入字符数组的某一部分,off数组的开始索引,len
     写的字符个数。
     void write(String str) 写入字符串。
     void write(String str, int off, int len) 写入字符串的某一部分,off字符串的开始索引,len写的字符个
     数。
     void flush() 刷新该流的缓冲。
     void close() 关闭此流，但要先刷新它。
     */
    public static void main(String[] args) throws IOException {
        //创建流对象
        String path = "C:/Users/17382/Desktop/somthing.txt";
        File file = new File(path);
        //append :ture 表示在后面续写
        FileWriter fw = new FileWriter(file,true);
//        fw.write("成");
//        fw.flush();
//        fw.write("功");
        char[] str = "小丑的末日就是小丑末日".toCharArray();
        fw.write(str);
        //换行
        fw.write("\r\n");
        //关闭前必须先刷新缓冲区
        fw.write(str,1,3);
        fw.flush();
        fw.close();
    }
}
