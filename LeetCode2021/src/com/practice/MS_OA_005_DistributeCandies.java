package com.practice;

public class MS_OA_005_DistributeCandies {
    public int candy(int[] A)
    {
        int n = A.length;
        int[] candies = new int[n];
        for(int i = 0; i< n ; i++)
        {
            candies[i]= 1;
        }
        for(int i = 0; i<n-1; i++)
        {
            if(A[i+1] > A[i])
                candies[i+1] = candies[i] +1;
        }
        for(int i = n-1; i >0 ; i--)
        {
            if(A[i-1] > A[i] && candies[i-1] <= candies[i])
                candies[i-1] = candies[i]+1;
        }
        int sum = 0;
        for(int i = 0; i<n; i++)
        {
            sum+=candies[i];
        }
        return sum;
    }
}
