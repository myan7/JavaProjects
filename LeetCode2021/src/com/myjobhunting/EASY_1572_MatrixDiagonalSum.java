package com.myjobhunting;
// https://leetcode.com/problems/matrix-diagonal-sum/

/*
Given a square matrix mat, return the sum of the matrix diagonals.
Only include the sum of all the elements on the primary diagonal and
all the elements on the secondary diagonal that are not part of the primary diagonal.
 */

public class EASY_1572_MatrixDiagonalSum {

    /*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Matrix Diagonal Sum.
    Memory Usage: 48.1 MB, less than 21.47% of Java online submissions for Matrix Diagonal Sum.
     */
    public int diagonalSum20220312(int[][] mat) {
        int sum = 0, col = mat[0].length;
        int left = 0, right = col-1;
        for(int[] curr: mat)
        {
            if(left != right)
                sum += curr[left] + curr[right];
            else
                sum += curr[left];
            left++;
            right--;
        }
        return sum;
    }
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
