package com.myjobhunting;
// https://leetcode.com/problems/determine-whether-matrix-can-be-obtained-by-rotation/

/*
Given two n x n binary matrices mat and target,
return true if it is possible to make mat equal to target by rotating mat in 90-degree increments, or false otherwise.

Example 1:
Input: mat = [[0,1],[1,0]], target = [[1,0],[0,1]]
Output: true
Explanation: We can rotate mat 90 degrees clockwise to make mat equal target.

Example 2:
Input: mat = [[0,1],[1,1]], target = [[1,0],[0,1]]
Output: false
Explanation: It is impossible to make mat equal to target by rotating mat.

Example 3:
Input: mat = [[0,0,0],[0,1,0],[1,1,1]], target = [[1,1,1],[0,1,0],[0,0,0]]
Output: true
Explanation: We can rotate mat 90 degrees clockwise two times to make mat equal target.

Constraints:
n == mat.length == target.length
n == mat[i].length == target[i].length
1 <= n <= 10
mat[i][j] and target[i][j] are either 0 or 1.
 */
public class EASY_1886_DetermineWhetherMatrixCanBeObtainedByRotation {
    public boolean findRotation(int[][] mat, int[][] target) {
        int mRow = mat.length,tRow = target.length;
        int[][] tmp = rotate(mat);
        for(int i = 0; i < 4; i++)
        {
            tmp = rotate(tmp);
            if(equalMatrix(tmp,target))
                return true;
        }
        return false;
    }
    private int[][] rotate(int[][] matrix)
    {
        int len = matrix.length;
        int[][] nmatrix = new int[len][len];
        for(int i = 0; i < len; i++)
        {
            for(int j = 0 ; j < len; j++)
                nmatrix[i][j] = matrix[len-j-1][i];
        }
        return nmatrix;
    }
    private boolean equalMatrix(int[][] m1, int[][] m2)
    {
        int len1 = m1.length, len2 = m2.length;
        if(len1 != len2)
            return false;
        for(int i = 0; i <len1; i++)
        {
            for(int j = 0; j < len2; j++)
            {
                if(m1[i][j] != m2[i][j])
                    return false;
            }
        }
        return true;
    }

}
