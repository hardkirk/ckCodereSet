package com.example.demo.mathMethodDemo;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: Chuk
 * @time: 2021/2/8 14:36
 * @Params Solution0208
 */
public class Solution0208 {
    /**
     * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
     *
     * 字符          数值
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     */
    public int romanToInt(String s){
        //开始时间
        long startTime=System.nanoTime();
        int num = 0;
        int length = s.length();
        for (int i = 1; i < length; i++) {

            if (i<length-1 && changen(s.charAt(i+1)) > changen(s.charAt(i))){
            num = num -(changen(s.charAt(i)));}
            else {
                num = num + changen(s.charAt(i));
            }

        }
        long endTime=System.nanoTime();
        System.out.println(num+"运行时间为："+(endTime-startTime));
        return num;
    }
    public int changen(char str){
        switch(str){
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        Solution0208 solution0208 = new Solution0208();
        solution0208.romanToInt("IV");
    }
}
