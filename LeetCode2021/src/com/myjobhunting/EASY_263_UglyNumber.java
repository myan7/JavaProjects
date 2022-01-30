package com.myjobhunting;

// https://leetcode.com/problems/ugly-number/

public class EASY_263_UglyNumber {
    public boolean isUgly(int n) {
        if(n == 1)
            return true;
        while(n > 1)
        {
            if(n % 5 == 0)
                n /= 5;
            else if(n % 3 == 0)
                n /= 3;
            else if(n%2 == 0)
                n /= 2;
            else
                return false;
        }
        return n == 1;
    }
    private boolean isPrime(int n)
    {
        for(int i = 2; i < n; i++)
        {
            if((double)n/i == n/i) {
                return false;
            }
        }
        return true;
    }

    public boolean isUgly2(int num)
    {
        for (int i=2; i<6 && num>0; i++)
            while (num % i == 0)
                num /= i;
        return num == 1;
    }
}
