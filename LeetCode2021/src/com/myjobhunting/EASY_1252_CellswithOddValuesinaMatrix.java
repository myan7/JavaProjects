package com.myjobhunting;
// https://leetcode.com/problems/cells-with-odd-values-in-a-matrix/

/*
There is an m x n matrix that is initialized to all 0's.
There is also a 2D array indices
where each indices[i] = [ri, ci] represents a 0-indexed location to perform some increment operations on the matrix.

For each location indices[i], do both of the following:
Increment all the cells on row ri.
Increment all the cells on column ci.
Given m, n, and indices,
return the number of odd-valued cells in the matrix after applying the increment to all locations in indices.

Example 1:

Input: m = 2, n = 3, indices = [[0,1],[1,1]]
Output: 6
Explanation: Initial matrix = [[0,0,0],[0,0,0]].
After applying first increment it becomes [[1,2,1],[0,1,0]].
The final matrix is [[1,3,1],[1,3,1]], which contains 6 odd numbers.
 */
public class EASY_1252_CellswithOddValuesinaMatrix {

    // 2 ms naive solution
    public int oddCells(int m, int n, int[][] indices) {
        int[][] mat = new int[m][n];
        for(int i = 0 ; i < indices.length ;i ++)
        {
            int row = indices[i][0];
            int col = indices[i][1];
            for(int r = 0; r < m ; r++)
            {
                mat[r][col]++;
            }
            for(int c = 0; c < n; c++)
            {
                mat[row][c]++;
            }
        }
        int count = 0;
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(mat[i][j] %2 != 0)
                    count++;
            }
        }
        return count;
    }

    // 1ms
    /*
    Steps:
    1.  Count how many times each row and column is incremented using row and column array.
    2.  Add row and col value to get corresponding array element value.
    3.  If it's odd increment counter
     */
    public int oddCells1(int n, int m, int[][] indices) {
        int count = 0;
        int row[] = new int [n];
        int col[] = new int [m];
        for(int x[] : indices)
        {
            row[x[0]]++;
            col[x[1]]++;
        }
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
            {
                if((row[i]+col[j])%2!=0)
                    count++;
            }
        return count;
    }

    // or maybe this is easier to understand
    public int oddCells1_0(int n, int m, int[][] indices) {
        int[] rows = new int[n]; //array to hold increments in rows
        int[] columns = new int[m]; //array to hold increments in columns

        for(int i = 0; i < indices.length; i++){
            rows[indices[i][0]] += 1;   //increment the indices of rows array based on "indices" array
            columns[indices[i][1]] += 1; //increment the indices of columns array based on "indices" array
        }

        int count = 0;
        for(int i = 0; i < rows.length; i++){
            for(int j = 0; j < columns.length; j++){
                if((rows[i] + columns[j]) % 2 != 0){ //adding rows[i] and columns[j] will give the value in final array. check whether it is odd or even
                    count += 1;
                }
            }
        }
        return count;
    }
}
