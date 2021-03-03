package com.example.demo.mathMethodDemo;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: Chuk
 * @time: 2021/2/4 14:53
 * @Params Solution0204
 */
public class Solution0204 {
    /**
     * 给你一个整数 x ，如果 x 是一个回文整数，返回 ture ；否则，返回 false 。
     *
     * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/palindrome-number
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        Boolean flag = false;
        int b =x;
        int a =0;
        List numList = new ArrayList();
        if (x <0) return false;
        while (x>0 || x%10 != 0){
             a = x%10 +a*10;
             x = x/10;
        }
        if (a == b){
            System.out.println("哈哈哈哈哈哈哈");
            return true;
        }
        System.out.println("呜呜呜呜");
        return flag;
    }

    public static void main(String[] args) {
        Solution0204 solution0204 = new Solution0204();
        solution0204.isPalindrome(1001);
    }
}
