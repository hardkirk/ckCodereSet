package com.example.iotest;

import org.junit.jupiter.api.Test;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author chuke
 * @create 2020/8/22 15:25
 */
public class FOSWrite {
    @Test
    void outputStreamWrite() throws IOException {
        // 使用文件名称创建流对象
        FileOutputStream fos = new FileOutputStream("fos.txt");
        // 字符串转换为字节数组
        byte[] b = "abcde".getBytes();
        // 写出从索引2开始，2个字节。索引2是c，两个字节，也就是cd。
        fos.write(b,2,2);
        // 关闭资源
        fos.close();
    }


    @Test
    void reWrite() throws IOException{
        //这两个构造方法，参数中都需要传入一个boolean类型的值， true 表示追加数据， false 表示清空原有数据。
        FileOutputStream fos = new FileOutputStream("C:/Users/17382/Desktop/nothing.txt",true);
        byte[] words = "abcde".getBytes();

        for (int i = 0; i < words.length; i++) {
            // 写出一个字节
            fos.write(words[i]);
            // 写出一个换行, 换行符号转成数组写出
            fos.write("\r\n".getBytes());
        }
//
        fos.close();
    }
}
