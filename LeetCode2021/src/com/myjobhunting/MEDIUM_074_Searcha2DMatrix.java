package com.myjobhunting;

// https://leetcode.com/problems/search-a-2d-matrix/

/*
Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix.
This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.

Example 1:
Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true

Example 2:
Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false

Constraints:
m == matrix.length
n == matrix[i].length
1 <= m, n <= 100
-104 <= matrix[i][j], target <= 10^4
 */
public class MEDIUM_074_Searcha2DMatrix {
    /*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Search a 2D Matrix.
    Memory Usage: 43.5 MB, less than 6.06% of Java online submissions for Search a 2D Matrix.
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int topRow = 0, topCol = 0, bottomRow = matrix.length-1, bottomCol = matrix[0].length-1;
        while(topRow <= bottomRow && topCol <= bottomCol)
        {
            int midRow = topRow + (bottomRow - topRow)/2;
            int midCol = topCol + (bottomCol - topCol)/2;
            int mid = matrix[midRow][midCol];
            {
                if(mid == target )
                    return true;
                else if(mid > target)
                {
                    if(matrix[midRow][0] > target)
                        bottomRow = midRow -1;
                    else if(matrix[midRow][matrix[0].length-1] > target)
                        bottomCol = midCol -1;
                }
                else
                {
                    if(matrix[midRow][matrix[0].length-1] < target)
                        topRow = midRow + 1;
                    else if(matrix[midRow][0] < target)
                        topCol = midCol + 1;
                }
            }
        }
        return false;
    }
}
