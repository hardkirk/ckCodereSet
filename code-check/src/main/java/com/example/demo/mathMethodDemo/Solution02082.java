package com.example.demo.mathMethodDemo;

/**
 * @description:
 * @author: Chuk
 * @time: 2021/2/8 16:25
 * @Params Solution02082
 */
public class Solution02082 {
    //开始时间
    public String longestCommonPrefix(String[] strs) {
        boolean flag = false;
        int setnum = 0;
        int flagnum = 0;
        int length = strs.length;
        int num = 0;
        int changeI = 0;
        //先找出长度最短的字符串
        for (int i = 1; i < length; i++) {
            if (strs[i].length() < strs[i-1].length()){
                num = i;
            }
        }
        String[] sts = resetStringResult(strs[num]);
        int size = sts.length;
        for (int i = 0; i <length; i++) {
            changeI = i;
            for (int j = size-1; j >=0; j--) {
//                String kkj = sts[j];
                if (strs[changeI].contains(sts[j]) && i !=num){
//                if ("cnaslbclsdn".contains("bsaocbsaob") && i !=num){
                    flagnum = flagnum + 1;
                    break;
                }else {
                    flagnum = 0;
                }
                if (flagnum == length-1){
                    setnum = j-1;
                    return sts[setnum];
                }
            }

        }

        return "111";
    }
    //获取字符串所有的子集
    public String[] resetStringResult(String bigStr){
        int n = bigStr.length();
        String [] resultStr = new String[n/2+n*n/2];
        int length = bigStr.length();//字符串长度
        int size = length;
        int index = 0;
        //最大长度的  非顺序派排法
        /*for (int j = 0; j < length; j++) {
            for (int i = 1; i < length+1; i++) {
                if (j+i <length+1) {
                    resultStr[i+j*length-1] = bigStr.substring(j, j+i);
                }
            }
        }*/
        int cutSize = length;//截取长度
        //获取字符串子集顺序排法
        for (int i = 1; i < cutSize; i++) {
            for (int j = 0; j < length; j++) {
                if (j+i <= length) {
                    resultStr[index] = bigStr.substring(j, i+j);

                    index++;
                }
            }
        }
    return resultStr;
    }


    //获取字符串所有的子集
    public String[] resetStringResult2(String bigStr){
        int resultStrL = bigStr.length();
        String [] resultStr = new String[(int) Math.pow(2,resultStrL)];
        int length = bigStr.length();//字符串长度
        int size = length;

        //最大长度的  非顺序派排法
        /*for (int j = 0; j < length; j++) {
            for (int i = 1; i < length+1; i++) {
                if (j+i <length+1) {
                    resultStr[i+j*length-1] = bigStr.substring(j, j+i);
                }
            }
        }*/
        int cutSize = length;//截取长度
        //获取字符串子集顺序排法
        for (int i = 1; i < cutSize+1; i++) {
            for (int j = 0; j < length; j++) {
                if (j+i <= length) {
                    resultStr[(i - 1) * length + j] = bigStr.substring(j, i+j);
                }
            }
        }
        return resultStr;
    }
    public static void main(String[] args) {
        Solution02082 solution02082 = new Solution02082();
        String[] strs2 = new String[3];
        strs2[0] = "dog";
        strs2[1] = "racecar";
        strs2[2] = "car";
//        strs2[2].contains("ds");
        String strs2s = solution02082.longestCommonPrefix(strs2);
        System.out.println(strs2s);
//        String[] dsads = solution02082.resetStringResult("dsad");
//        System.out.println(dsads);



    }
}
