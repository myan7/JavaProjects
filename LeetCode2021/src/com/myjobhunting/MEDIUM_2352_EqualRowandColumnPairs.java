package com.myjobhunting;

/*
Given a 0-indexed n x n integer matrix grid, return the number of pairs (Ri, Cj) such that row Ri and column Cj are equal.

A row and column pair is considered equal if they contain the same elements in the same order (i.e. an equal array).
Example 1:
Input: grid = [[3,2,1],[1,7,6],[2,7,7]]
Output: 1
Explanation: There is 1 equal row and column pair:
- (Row 2, Column 1): [2,7,7]

Example 2:
Input: grid = [[3,1,2,2],[1,4,4,5],[2,4,2,2],[2,4,2,2]]
Output: 3
Explanation: There are 3 equal row and column pairs:
- (Row 0, Column 0): [3,1,2,2]
- (Row 2, Column 2): [2,4,2,2]
- (Row 3, Column 2): [2,4,2,2]

Constraints:

n == grid.length == grid[i].length
1 <= n <= 200
1 <= grid[i][j] <= 105
 */

import java.util.HashMap;
import java.util.Map;

public class MEDIUM_2352_EqualRowandColumnPairs {
    /*
    Runtime: 49 ms, faster than 80.00% of Java online submissions for Equal Row and Column Pairs.
    Memory Usage: 74.1 MB, less than 20.00% of Java online submissions for Equal Row and Column Pairs.
     */
    public int equalPairs(int[][] grid) {
        int result = 0;

        StringBuilder sb = new StringBuilder();
        Map<String, Integer> map = new HashMap<>();
        String s;

        for (int i = 0; i < grid.length; ++i){
            sb.setLength(0);

            for (int j = 0; j < grid.length; ++j){
                sb.append(grid[j][i]);
                sb.append(':');
            }

            s = sb.toString();

            map.put(s , map.getOrDefault(s , 0) + 1);
        }

        for (int i = 0; i < grid.length; ++i){
            sb.setLength(0);

            for (int j = 0; j < grid.length; ++j){
                sb.append(grid[i][j]);
                sb.append(':');
            }

            s = sb.toString();

            result += map.getOrDefault(s , 0);
        }

        return result;
    }
}
