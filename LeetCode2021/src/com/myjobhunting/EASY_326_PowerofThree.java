package com.myjobhunting;

// https://leetcode.com/problems/power-of-three/
// https://leetcode.com/problems/power-of-three/solution/

public class EASY_326_PowerofThree {
// Could you solve it without loops/recursion?



    // mathematical
    public boolean isPowerOfThree(int n) {
        if(n <= 0)
            return false;
        else if(n == 1)
            return true;
        else if( n%3 != 0)
            return false;
        else
            return isPowerOfThree(n/3);
    }
    // fastest
    public boolean isPowerOfThree0(int n) {
        return n>0 && (int)Math.pow(3, 19)%n ==0 ;
    }

    // regex
    public boolean isPowerOfThree1(int n) {
        return Integer.toString(n, 3).matches("^10*$");
    }

    public boolean isPowerOfThree2(int n) {

        if(n <= 0) return false;
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }
}
