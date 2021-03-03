package com.example;


import java.util.Scanner;

public class MyDateTest{

    public static void main(String[] args){
        int sum=0;
        Scanner mas = new Scanner(System.in);
        System.out.print("请输入学生人数："+"\t");
        int students=mas.nextInt();
        int[]score=new int[students];

        int temp=0;
        for(int i=0;i<score.length;i++){
//Scanner in=new Scanner (System.in);
            System.out.print("请输入学生成绩的值："+"\t");
            score[i]=mas.nextInt();
            sum+=score[i];
            if(i==score.length-1){
                temp=i+1;
            }
        }
        System.out.println(temp+"个学生的平均成绩为："+sum/temp);

    }

}
