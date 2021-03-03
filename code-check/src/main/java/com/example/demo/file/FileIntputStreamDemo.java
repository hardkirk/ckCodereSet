package com.example.demo.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @Author chuke
 * @create 2020/8/22 15:47
 */
public class FileIntputStreamDemo {

    public static void main(String[] args) throws IOException {
        String path = "C:/Users/17382/Desktop/somthing.txt";
        File file = new File(path);
        //创建流对象
        FileInputStream fios = new FileInputStream(file);
        int b;
        byte[] c = new byte[2];
        while ( (b = fios.read(c)) != -1){
            System.out.println(new String(c,0,b));
        }
        fios.close();
    }
}
