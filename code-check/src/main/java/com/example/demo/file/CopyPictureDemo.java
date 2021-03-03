package com.example.demo.file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author chuke
 * @create 2020/8/22 16:24
 */
public class CopyPictureDemo {
    public static void main(String[] args) throws IOException {
        //读取文件
        String inputpath = "C:/Users/17382/Desktop/银行模板/银行卡与身份证照/站.jpg";
        FileInputStream fis = new FileInputStream(inputpath);
        //输出文件
        String outputpath = "C:/Users/17382/Desktop/待分解/坐.jpg";
        FileOutputStream fos = new FileOutputStream(outputpath);
        byte[] b = new byte[1024];
        int len;
        while ((len = fis.read()) != -1){
            fos.write(b,0,len);
        }
        fos.close();
        fis.close();
    }

}
