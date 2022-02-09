package com.myjobhunting;
//https://leetcode.com/problems/power-of-four/

public class EASY_342_PowerofFour {
    public boolean isPowerOfFour(int n) {
        while(n > 0 && n %4 == 0)
            n /=4;
        return n == 1;
    }

    public boolean isPowerOfFour1(int num) {
        return Math.log10(num)/Math.log10(4)%1==0;
    }
}
