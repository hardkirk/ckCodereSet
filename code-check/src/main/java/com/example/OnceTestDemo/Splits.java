package com.example.OnceTestDemo;

/**
 * @description:
 * @author: Chuk
 * @time: 2020/12/16 17:35
 * @Params Splits
 */
public class Splits {

    public String cdvdsda(){
        String as = "dsacs,dsadsa";
        String result = null;
        String[] split = as.split(",");
        result = split[0];
        return result;
    }

    public static void main(String[] args) {
        Splits split = new Splits();
        split.cdvdsda();
    }
}
