package com.practice;
//https://www.youtube.com/watch?v=oBt53YbR9Kk&t=6s

import java.util.HashMap;
import java.util.Map;

public class Learning_DP {
    // Fibonacci problem
    public long fibonacciRecur(int n )
    {
        if(n <= 2) return 1;
        return fibonacciRecur(n-1) + fibonacciRecur( n-2);
    }

    public long fibnacciDP(int n)
    {
        long[] fibArr = new long[n];
        fibArr[0] = 1;
        fibArr[1] = 1;
        for(int i = 2; i < n; i++)
        {
            fibArr[i] = fibArr[i-1] + fibArr[i-2];
        }
        return fibArr[n-1];
    }

    // matrix traversal problem
    public long gridTravellerRecur(int[][] matrix)
    {
        int m = matrix.length;
        int n = matrix[0].length;
        return gridTravellerRecurHelper(m,n);
    }

    public long gridTravellerRecurHelper(int m, int n)
    {
        if(m == 0 || n == 0)
            return 0;
        if(m == 1 || n == 1)
            return 1;
        return gridTravellerRecurHelper(m-1,n) + gridTravellerRecurHelper(m,n-1);
    }

    public long gridTravellerDP(int[][] matrix)
    {
        int m = matrix.length, n = matrix[0].length;
        long[][] ways = new long[m][n];

        // corner case
        if(m == 0 || n == 0) return 0;

        // base case
        for(int i = 0; i < m; i++)
        {
            ways[i][0] = 1;
        }
        for(int i = 0 ; i < n; i++)
        {
            ways[0][i] = 1;
        }
        // general case
        for(int i = 1; i < m ; i++)
        {
            int j = 1;
            while(j < n) {
                ways[i][j] = ways[i - 1][j] + ways[i][j - 1];
                j++;
            }
        }
        return ways[m-1][n-1];
    }

    // canSum problem
    // write a function that takes a target number as sum and an array of numbers as arguments
    // this function returns a boolean to indicate if it is possible to add some/all elements in the array
    // to generate the target number.
    // you can use any number as many times as you want, and all the numbers are non-negative.
    // for example canSum(7, [5,3,4,7]) should return true, 3+4 or 7

    public boolean canSumRec(int target, int[] numbers)
    {
        if(target == 0) return true;
        if(target < 0 ) return false;
        for( int i : numbers)
        {
            int remainder = target - i;
            if(canSumRec(remainder,numbers) == true)
                return true;
        }
        return false;
    }
    // similar to Medium 39 combination sum
    public boolean canSumDP(int target, int[] numbers)
    {
        return false;
    }

}
