package com.myjobhunting;

// https://leetcode.com/problems/power-of-two/

public class EASY_231_PowerofTwo {
    public boolean isPowerOfTwo(int n) {
        while(n > 1 && n%2 == 0)
            n >>= 1;
        return n == 1;
    }

    public boolean isPowerOfTwo1(int n) {
        if(n <= 0) return false;
        while (n % 2 == 0) {
            n /= 2;
        }
        return n == 1;
    }

    public boolean isPowerOfTwo2(int n) {
        return n>0 && (n&(n-1))==0;
        // or
        /*
        if(n == Integer.MIN_VALUE || n == 0)
            return false;
        return (n&(n-1)) == 0;
        */
    }



    public boolean isPowerOfTwo3(int n) {
        return n > 0 && Math.log10(n) / Math.log10(2) == (int) (Math.log10(n) / Math.log10(2));
    }
}
