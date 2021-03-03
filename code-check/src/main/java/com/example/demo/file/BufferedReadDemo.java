package com.example.demo.file;

import java.io.*;
import java.util.HashMap;

/**
 * @Author chuke
 * @create 2020/8/24 19:08
 */
public class BufferedReadDemo {
    void testRead() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("C:/Users/17382/Desktop/somthing.txt"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("C:/Users/17382/Desktop/nomthing.txt"));

        String line = null;
        while ((line = reader.readLine())!=null){
            System.out.println(line);
            System.out.println("--------");
        }
        reader.close();
    }

    void testWrite() throws IOException{
        HashMap<String,String> lineMap = new HashMap<>();
        BufferedReader br = new BufferedReader(new FileReader("C:/Users/17382/Desktop/somthing.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("C:/Users/17382/Desktop/nothing.txt"));

        String line = null;
        while ((line = br.readLine()) != null){
            String[] split = line.split("\\.");
            lineMap.put(split[0],split[1]);
        }
        br.close();

        for (int i=1; i<=lineMap.size(); i++){
            String key = String.valueOf(i);
            String value = lineMap.get(key);
            bw.write(value);
            bw.newLine();
        }
        bw.close();
    }



    public static void main(String[] args) {
        BufferedReadDemo brd = new BufferedReadDemo();
        try {
            brd.testWrite();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
