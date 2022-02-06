package com.myjobhunting;

// https://leetcode.com/problems/power-of-two/

public class EASY_231_PowerofTwo {
    public boolean isPowerOfTwo(int n) {
        while(n > 1 && n%2 == 0)
            n >>= 1;
        return n == 1;
    }

    public boolean isPowerOfTwo1(int n) {
        return n > 0 && Math.log10(n) / Math.log10(2) == (int) (Math.log10(n) / Math.log10(2));
    }
}
