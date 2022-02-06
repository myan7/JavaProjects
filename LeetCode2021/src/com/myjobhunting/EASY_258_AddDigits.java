package com.myjobhunting;

// https://leetcode.com/problems/add-digits/


public class EASY_258_AddDigits {
    public int addDigits(int num) {
        int ans = num;
        while( ans > 9 )
        {
            int temp = ans;
            int res = 0;
            while( temp > 0 )
            {
                res += temp%10;
                temp = temp/10;
            }
            ans = res;
        }
        return ans;
    }
    public int addDigits1(int num) {

        int ans = 0;
        if(num<10)
        {
            ans = num;
        }
        else if(num%9==0)
        {
            ans = 9;
        }
        else
            ans = num%9;
        return ans;
    }

    public int addDigits2(int num) {

        int res = num % 9;
        return (res != 0 || num == 0) ? res : 9;
    }
}
