package com.myjobhunting;
// https://leetcode.com/problems/matrix-diagonal-sum/

/*
Given a square matrix mat, return the sum of the matrix diagonals.
Only include the sum of all the elements on the primary diagonal and
all the elements on the secondary diagonal that are not part of the primary diagonal.
 */

public class EASY_1572_MatrixDiagonalSum {

    // 0ms
    public int diagonalSum(int[][] mat) {
        int n = mat.length;
        int ans = 0;
        int ind = 0;
        while( ind < n-1 -ind)
        {
            ans += mat[ind][ind] + mat[ind][n-ind-1] + mat[n-ind-1][ind] + mat[n-ind-1][n-ind-1];
            ind++;
        }
        if(n % 2 != 0)
        {
            ans += mat[ind][ind];
        }
        return ans;
    }

    // 1ms
    public int diagonalSum1(int[][] mat) {
        int answer = 0;
        for(int i=0; i<mat.length; i++) {
            if (i != mat.length-1-i) {
                answer = answer + mat[i][i] + mat[i][mat.length-1-i];
            } else {
                answer += mat[i][i];
            }

        }
        return answer;
    }

    // 0ms
    public int diagonalSum2(int[][] mat) {
        int sum=0;
        for(int i=0,k=mat.length-1;i<mat.length;i++,k--)
        {
            sum=sum+mat[i][i];
            if(i!=k)
            {
                sum=sum+mat[i][k];
            }
        }
        return sum;
    }
}
