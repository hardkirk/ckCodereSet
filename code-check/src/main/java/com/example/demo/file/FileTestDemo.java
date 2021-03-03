package com.example.demo.file;

import java.io.File;

/**
 * @Author chuke
 * @create 2020/8/22 14:41
 */
public class FileTestDemo {
    /**
     * 构造方法
     * public File(String pathname) ：通过将给定的路径名字符串转换为抽象路径名来创建新的 File实例。
     * public File(String parent, String child) ：从父路径名字符串和子路径名字符串创建新的 File实例。
     * public File(File parent, String child) ：从父抽象路径名和子路径名字符串创建新的 File实例。
     *
     * 1. 一个File对象代表硬盘中实际存在的一个文件或者目录。
     * 2. 无论该路径下是否存在文件或者目录，都不影响File对象的创建。
     */
    public static void main(String[] args) {

        String path = "D:/uploadfile";
        File file = new File(path);

        String path1 = "D:/uploadfile";
        String path2 = "D:/uploadfile/null";
        File file1 = new File(path1, path2);

        /**public String[] list() ：返回一个String数组，表示该File目录中的所有子文件或目录。
         public File[] listFiles() ：返回一个File数组，表示该File目录中的所有的子文件或目录。
         */
        file1.exists();
        file.mkdir();//创建File表示的目录
        file.mkdirs();//创建File表示的目录，包括任何必须但不存在的父目录
    }

}
