package com.practice;

/*
write a function solution that,
given an array A of N integers, between(-100 and 100),
return the sign(-1,0,1) of the product of all the numbers in the array multiplied together.
Assume that N is between 1 and 1000.
For example,
given A = [1,-2,-3,5], the function should return 1
given A = [1,2,3,-5], expected output is -1;
given A = [1,2,0,-5], expected output is 0;
 */
public class MS_OA_008_GetSign {
    public int getSign(final int[] A)
    {
        int sign = 1;
        for(int i : A)
        {
            if(i == 0)
                return 0;
            else if(i < 0)
                sign = sign*(-1);
        }
        return sign;
    }
}
