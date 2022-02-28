package com.myjobhunting;
// https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/
/*
Given a m x n matrix grid which is sorted in non-increasing order both row-wise and column-wise,
return the number of negative numbers in grid.

Example 1:
Input: grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
Output: 8
Explanation: There are 8 negatives number in the matrix.

Example 2:
Input: grid = [[3,2],[1,0]]
Output: 0

Constraints:
m == grid.length
n == grid[i].length
1 <= m, n <= 100
-100 <= grid[i][j] <= 100

Follow up: Could you find an O(n + m) solution?

 */
public class EASY_1351_CountNegativeNumbersinaSortedMatrix {

    // binary search
    // Runtime: 0 ms, faster than 100.00% of Java online submissions
    public int countNegatives1(int[][] grid) {
        int count = 0;
        int nRow = grid.length, nCol = grid[0].length;
        for(int i = 0; i < nRow ; i++)
        {
            if(grid[i][0] < 0)
            {
                count += nCol* (nRow - i);
                break;
            }
            int left = 0, right = nCol-1;
            while(left <= right)
            {
                int mid = left +(right - left)/2;
                if(grid[i][mid] < 0)
                {
                    right = mid -1;
                }
                else
                {
                    left = mid+1;
                }
            }
            count += nCol - left;
        }
        return count;
    }

    // initial solution
    // Runtime: 0 ms, faster than 100.00% of Java online submissions
    public int countNegatives0(int[][] grid) {
        int count = 0;
        int nRow = grid.length, nCol = grid[0].length;
        for(int i = 0; i < nRow ; i++)
        {
            if(grid[i][0] < 0)
            {
                count += nCol* (nRow - i);
                break;
            }
            for(int j = 0; j < nCol; j++)
            {
                if(grid[i][j] < 0)
                {
                    count += nCol-j;
                    break;
                }
            }
        }
        return count;
    }
}
