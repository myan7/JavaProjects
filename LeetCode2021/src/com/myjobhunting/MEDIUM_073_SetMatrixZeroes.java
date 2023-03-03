package com.myjobhunting;
// https://leetcode.com/problems/set-matrix-zeroes/

import java.util.HashSet;
import java.util.Set;

/*
Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.

You must do it in place.

Example 1:
Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[1,0,1],[0,0,0],[1,0,1]]

Example 2:
Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]

Constraints:
m == matrix.length
n == matrix[0].length
1 <= m, n <= 200
-2^31 <= matrix[i][j] <= 2^31 - 1


Follow up:

A straightforward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?
 */
public class MEDIUM_073_SetMatrixZeroes {

    /*
    Runtime: 4 ms, faster than 18.93% of Java online submissions for Set Matrix Zeroes.
    Memory Usage: 54 MB, less than 63.05% of Java online submissions for Set Matrix Zeroes.
     */
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();

        // find the target rows and cols
        for(int i = 0; i < row ; i++)
        {
            for(int j = 0; j < col; j++)
            {
                if(matrix[i][j] == 0)
                {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        for(int i = 0 ; i < row; i++)
        {
            for(int j = 0; j < col; j++)
            {
                if(rows.contains(i) || cols.contains(j))
                {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
