package com.myjobhunting;
// https://leetcode.com/problems/lucky-numbers-in-a-matrix/
/*
Given an m x n matrix of distinct numbers,
return all lucky numbers in the matrix in any order.
A lucky number is an element of the matrix such that it is the minimum element in its row and maximum in its column.

Example 1:
Input: matrix = [[3,7,8],[9,11,13],[15,16,17]]
Output: [15]
Explanation: 15 is the only lucky number since it is the minimum in its row and the maximum in its column.

Example 2:
Input: matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
Output: [12]
Explanation: 12 is the only lucky number since it is the minimum in its row and the maximum in its column.

Example 3:
Input: matrix = [[7,8],[1,2]]
Output: [7]
Explanation: 7 is the only lucky number since it is the minimum in its row and the maximum in its column.


Constraints:
m == mat.length
n == mat[i].length
1 <= n, m <= 50
1 <= matrix[i][j] <= 105.
All elements in the matrix are distinct.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class EASY_1380_LuckyNumbersinaMatrix {
    public List<Integer> luckyNumbers (int[][] matrix) {
        // Arrays.sort(matrix, (a, b)-> a[0]-b[0]);
        int nRow = matrix.length;
        int nCol = matrix[0].length;
        List<Integer> ans = new ArrayList<>();
        // get the smallest value of each row
        int[] minRow = new int[nRow];
        Arrays.fill(minRow, Integer.MAX_VALUE);
        // get the maximum value of each column.
        int[] maxCol = new int[nCol];
        for(int i = 0 ; i < nRow ; i ++)
        {
            for(int j = 0 ; j < nCol ; j++)
            {
                minRow[i] = Math.min(minRow[i],matrix[i][j]); // keep updating until the end of the row
                maxCol[j] = Math.max(maxCol[j], matrix[i][j]);
            }
        }

        for(int i = 0 ; i < nRow ; i ++)
        {
            for (int j = 0; j < nCol; j++)
            {
                if(minRow[i] == matrix[i][j] && maxCol[j] == matrix[i][j])
                    ans.add(matrix[i][j]);
            }
        }
        return ans;
    }
}
