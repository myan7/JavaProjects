package com.myjobhunting;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/valid-sudoku/
/*
Determine if a 9 x 9 Sudoku board is valid.
Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
Note:

A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.


Example 1:
Input: board =
[["5","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: true

Example 2:
Input: board =
[["8","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: false
Explanation: Same as Example 1,
except with the 5 in the top left corner being modified to 8.
Since there are two 8's in the top left 3x3 sub-box, it is invalid.

Constraints:
board.length == 9
board[i].length == 9
board[i][j] is a digit 1-9 or '.'.
 */
public class MEDIUM_036_ValidSudoku {

    /* Genius solution!!!!! one set only
    Runtime: 13 ms, faster than 31.58% of Java online submissions for Valid Sudoku.
    Memory Usage: 42.7 MB, less than 81.31% of Java online submissions for Valid Sudoku.
     */
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();
        for(int i = 0; i < 9; i++)
        {
            for(int j = 0; j < 9; j++)
            {
                char curr = board[i][j];
                if(curr == '.')
                    continue;
                if(!seen.add(curr + " found in row "+ i) ||
                   !seen.add(curr + " found in col " + j) ||
                   !seen.add(curr + " found in sub box "+ i/3 + j/3))
                    return false;
            }
        }
        return true;
    }

    /*
    Initial solution
    Runtime: 7 ms, faster than 48.03% of Java online submissions for Valid Sudoku.
    Memory Usage: 47.2 MB, less than 35.30% of Java online submissions for Valid Sudoku.
     */
    public boolean isValidSudoku0(char[][] board) {
        int rows = board.length, cols = board[0].length;
        // row
        for(int i = 0; i < rows; i++)
        {
            Set<Integer> digits = new HashSet<>();
            for(int j = 0; j < cols; j++)
            {
                int curr = board[i][j];
                if(Character.isDigit(curr) && !digits.add(curr))
                    return false;
            }
        }

        // col
        for(int i = 0; i < rows; i++)
        {
            Set<Integer> digits = new HashSet<>();
            for(int j = 0; j < cols; j++)
            {
                int curr = board[j][i];
                if(Character.isDigit(curr) && !digits.add(curr))
                    return false;
            }
        }

        // sub-box
        Set<Character>[] digits = new HashSet[9];
        for(int i = 0; i < 9; i++)
            digits[i] = new HashSet<>();
        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < cols; j++)
            {
                char curr = board[i][j];
                int index = (i/3)*3+j/3;
                if(Character.isDigit(curr))
                {
                    if(!digits[index].add(curr))
                        return false;
                }
            }
        }
        return true;
    }

    /*  LC solution Approach 1 Hash Set array
    Runtime: 2 ms, faster than 94.18% of Java online submissions for Valid Sudoku.
    Memory Usage: 42 MB, less than 90.11% of Java online submissions for Valid Sudoku.
     */
    public boolean isValidSudoku_LC1(char[][] board) {
        int N = 9;
        // Use hash set to record the status
        HashSet<Character>[] rows = new HashSet[N];
        HashSet<Character>[] cols = new HashSet[N];
        HashSet<Character>[] boxes = new HashSet[N];
        for (int r = 0; r < N; r++) {
            rows[r] = new HashSet<>();
            cols[r] = new HashSet<>();
            boxes[r] = new HashSet<>();
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                char val = board[r][c];
                // Check if the position is filled with number
                if (val == '.')
                    continue;
                // Check the row
                if (!rows[r].add(val))
                    return false;
                // Check the column
                if (!cols[c].add(val))
                    return false;
                // Check the box
                int idx = (r / 3) * 3 + c / 3;
                if (!boxes[idx].add(val))
                    return false;
            }
        }
        return true;
    }

    /* LC solution. Approach 2: Array of Fixed Length
    Runtime: 4 ms, faster than 71.36% of Java online submissions for Valid Sudoku.
    Memory Usage: 45.9 MB, less than 51.22% of Java online submissions for Valid Sudoku.
     */
    public boolean isValidSudoku_LC2(char[][] board) {
        int[][] rows = new int[9][9];
        int[][] cols = new int[9][9];
        int[][] boxes = new int[9][9];

        for(int i = 0; i < 9; i++)
        {
            for(int j = 0; j < 9; j++)
            {
                char curr = board[i][j];
                if(curr == '.')
                    continue;
                int val = curr - '1';
                if(rows[i][val] == 1)
                    return false;
                rows[i][val] = 1;
                if(cols[j][val] == 1)
                    return false;
                cols[j][val] = 1;
                int index = (i/3)*3 + j/3;
                if(boxes[index][val] == 1)
                    return false;
                boxes[index][val] = 1;
            }
        }
        return true;
    }

}
