package com.myjobhunting;

// https://leetcode.com/problems/reshape-the-matrix/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
In MATLAB, there is a handy function called reshape which can reshape an m x n matrix into a new one with a different size r x c keeping its original data.
You are given an m x n matrix mat and two integers r and c representing the number of rows and the number of columns of the wanted reshaped matrix.
The reshaped matrix should be filled with all the elements of the original matrix in the same row-traversing order as they were.
If the reshape operation with given parameters is possible and legal, output the new reshaped matrix; Otherwise, output the original matrix.

Example 1:
Input: mat = [[1,2],[3,4]], r = 1, c = 4
Output: [[1,2,3,4]]

Example 2:
Input: mat = [[1,2],[3,4]], r = 2, c = 4
Output: [[1,2],[3,4]]

Constraints:
m == mat.length
n == mat[i].length
1 <= m, n <= 100
-1000 <= mat[i][j] <= 1000
1 <= r, c <= 300
 */
public class EASY_566_ReshapetheMatrix {

    /*
    Runtime: 1 ms, faster than 83.77% of Java online submissions for Reshape the Matrix.
    Memory Usage: 51.1 MB, less than 17.71% of Java online submissions for Reshape the Matrix.
     */
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int[][] res = new int[r][c];
        if (mat.length == 0 || r * c != mat.length * mat[0].length)
            return mat;
        int count = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                res[count / c][count % c] = mat[i][j];
                count++;
            }
        }
        return res;
    }


    /*
    Runtime: 3 ms, faster than 10.35% of Java online submissions for Reshape the Matrix.
    Memory Usage: 51 MB, less than 17.71% of Java online submissions for Reshape the Matrix.
     */
    public int[][] matrixReshape1(int[][] mat, int r, int c) {

        int m = mat.length, n = mat[0].length;
        if(m == 0 || m*n != r*c)
            return mat;
        List<Integer> elements = new ArrayList<>();
        int[][] ans = new int[r][c];
        for(int[] row : mat)
        {
            for(int item: row)
                elements.add(item);
        }
        int index = 0;
        for(int i = 0; i < r; i++)
        {
            for(int j = 0; j< c; j++)
                ans[i][j] = elements.get(index++);
        }
        return ans;
    }

    // Initial solution
    /*
    Runtime: 1 ms, faster than 83.77% of Java online submissions for Reshape the Matrix.
    Memory Usage: 50.8 MB, less than 32.92% of Java online submissions for Reshape the Matrix.
     */
    public int[][] matrixReshape0(int[][] mat, int r, int c) {
        int nRow = mat.length, nCol = mat[0].length;
        if(nRow == 0 || nRow * nCol != r*c)
            return mat;
        int[][] ans = new int[r][c];
        int rind = 0, cind = 0;

        for(int i = 0; i < nRow; i++)
        {
            for(int j = 0; j < nCol; j++)
            {
                ans[rind][cind] = mat[i][j];
                cind++;
                if(cind == c)
                {
                    cind = 0;
                    rind++;
                }
            }
        }
        return ans;
    }
}
