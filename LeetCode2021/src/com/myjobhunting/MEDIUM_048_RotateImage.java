package com.myjobhunting;
// https://leetcode.com/problems/rotate-image/

/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Rotate Image.
Memory Usage: 43.3 MB, less than 8.51% of Java online submissions for Rotate Image.
 */
public class MEDIUM_048_RotateImage {



    public void rotate(int[][] matrix) {
        /*
        (n-1, 0) -> (0,0) [len-j-1][i] -> [i][j]
        (0,0) -> (0,n-1)  [len-j-1][i] -> [i][j]
        (0,1) -> (1,n-1)  [len-j-1][i] -> [i][j]
        (0,2) -> (2,n-1)
        (0,n-1) -> (n-1,n-1)
        (1,0) -> (0,1)
        (2,0) -> (0,2)*/
        int nRow = matrix.length, nCol = matrix[0].length;
        int left = 0, right = nCol-1;
        while(left < right)
        {
            int top = left, bottom = right;
            for(int i = 0; i < right-left; i++)
            {
                int temp = matrix[top][left+i];
                matrix[top][left+i] = matrix[bottom-i][left];
                matrix[bottom-i][left] = matrix[bottom][right-i];
                matrix[bottom][right-i] = matrix[top + i][right];
                matrix[top+i][right] = temp;
            }
            left++;
            right--;
        }
    }

    public void rotate1(int[][] matrix) {
        int[][] tmp = helper(matrix);
        for(int i = 0; i < matrix.length; i++)
        {
            for(int j = 0; j < matrix.length; j++)
            {
                matrix[i][j] = tmp[i][j];
            }
        }
    }

    private int[][] helper(int[][] matrix)
    {
        int n = matrix.length;
        int[][] tmp = new int[n][n];
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                tmp[i][j] = matrix[n-j-1][i];
            }
        }
        return tmp;
    }


    public void rotate0(int[][] matrix) {
        transpose(matrix);
        reflect(matrix);
    }

    public void transpose(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }
    }

    public void reflect(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = tmp;
            }
        }
    }
}
