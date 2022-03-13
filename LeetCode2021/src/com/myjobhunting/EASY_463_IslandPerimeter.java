package com.myjobhunting;

// https://leetcode.com/problems/island-perimeter/

/*
You are given row x col grid representing a map where grid[i][j] = 1 represents land and grid[i][j] = 0 represents water.
Grid cells are connected horizontally/vertically (not diagonally).
The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).

The island doesn't have "lakes", meaning the water inside isn't connected to the water around the island.
One cell is a square with side length 1.
The grid is rectangular, width and height don't exceed 100.
Determine the perimeter of the island.


Example 1:
Input: grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
Output: 16
Explanation: The perimeter is the 16 yellow stripes in the image above.

Example 2:
Input: grid = [[1]]
Output: 4

Example 3:
Input: grid = [[1,0]]
Output: 4


Constraints:
row == grid.length
col == grid[i].length
1 <= row, col <= 100
grid[i][j] is 0 or 1.
There is exactly one island in grid.
 */
public class EASY_463_IslandPerimeter {

    /*
    Runtime: 5 ms, faster than 96.29% of Java online submissions for Island Perimeter.
    Memory Usage: 43.2 MB, less than 79.75% of Java online submissions for Island Perimeter.

    As you go through each cell on the grid, treat all the land cells as having a perimeter of 4 and add that up to the accumulated result.
    If that land cell has a neighboring land cell, remove 2 sides (one from each land cell) which will be touching between these two cells.
    If your current land cell has a UP land cell, subtract 2 from your accumulated result.
    If your current land cell has a LEFT land cell, subtract 2 from your accumulated result.
     */
    public int islandPerimeter_updated(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int result = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    result += 4;

                    if (r > 0 && grid[r-1][c] == 1) {
                        result -= 2;
                    }

                    if (c > 0 && grid[r][c-1] == 1) {
                        result -= 2;
                    }
                }
            }
        }
        return result;
    }

    /*
    Runtime: 10 ms, faster than 64.47% of Java online submissions for Island Perimeter.
    Memory Usage: 62.2 MB, less than 37.92% of Java online submissions for Island Perimeter.
     */
    public int islandPerimeter(int[][] grid) {
        int ans = 0,up = 0, down = 0, right = 0, left = 0;
        int row = grid.length, col = grid[0].length;
        for(int i = 0 ; i < row ; i++ )
        {
            for(int j = 0; j < col; j++)
            {
               if(grid[i][j] == 1)
               {
                   if(i == 0)   up = 0;
                   else         up = grid[i-1][j];

                   if(i == row-1)   down = 0;
                   else             down = grid[i+1][j];

                   if(j == 0)   left = 0;
                   else         left = grid[i][j-1];

                   if(j == col-1)   right = 0;
                   else             right = grid[i][j+1];

                   ans += 4- (up + left + right + down);
               }
            }
        }
        return ans;
    }
}
