package com.myjobhunting;

/*
According to Wikipedia's article: "The Game of Life, also known simply as Life,
is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

The board is made up of an m x n grid of cells,
where each cell has an initial state: live (represented by a 1) or dead (represented by a 0).
Each cell interacts with its eight neighbors (horizontal, vertical, diagonal)
using the following four rules (taken from the above Wikipedia article):

Any live cell with fewer than two live neighbors dies as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population.
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
The next state is created by applying the above rules simultaneously to every cell in the current state,
where births and deaths occur simultaneously. Given the current state of the m x n grid board, return the next state.

Example 1:
Input: board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
Output: [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]

Example 2:
Input: board = [[1,1],[1,0]]
Output: [[1,1],[1,1]]

Constraints:
m == board.length
n == board[i].length
1 <= m, n <= 25
board[i][j] is 0 or 1.

Follow up:

Could you solve it in-place? Remember that the board needs to be updated simultaneously:
You cannot update some cells first and then use their updated values to update other cells.

In this question, we represent the board using a 2D array. In principle, the board is infinite,
which would cause problems
when the active area encroaches upon the border of the array (i.e., live cells reach the border).
How would you address these problems?
 */
public class MEDIUM_289_GameofLife {
    /*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Game of Life.
    Memory Usage: 40.3 MB, less than 92.80% of Java online submissions for Game of Life.
     */
    public void gameOfLife(int[][] board) {

        if (board == null || board.length == 0) return;
        int m = board.length, n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int lives = liveNeighbors(board, m, n, i, j);

                // In the beginning, every 2nd bit is 0;
                // So we only need to care about when will the 2nd bit become 1.
                if (board[i][j] == 1 && lives >= 2 && lives <= 3) {
                    board[i][j] = 3; // Make the 2nd bit 1: 01 ---> 11
                }
                if (board[i][j] == 0 && lives == 3) {
                    board[i][j] = 2; // Make the 2nd bit 1: 00 ---> 10
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] >>= 1;  // Get the 2nd state.
            }
        }
    }

    private int liveNeighbors(int[][] board, int m, int n, int i, int j) {
        int lives = 0;
        for (int x = Math.max(i - 1, 0); x <= Math.min(i + 1, m - 1); x++) {
            for (int y = Math.max(j - 1, 0); y <= Math.min(j + 1, n - 1); y++) {
                lives += board[x][y] & 1;
            }
        }
        //or return lives - board[i][j];
        lives -= board[i][j] & 1;
        return lives;
    }

    /*
    Runtime: 1 ms, faster than 55.24% of Java online submissions for Game of Life.
    Memory Usage: 41.5 MB, less than 80.63% of Java online submissions for Game of Life.
    Time O(1) Space O(mn)
     */
    public void gameOfLife1(int[][] board) {
        int[][] dir ={{1,-1},{1,0},{1,1},{0,-1},{0,1},{-1,-1},{-1,0},{-1,1}};
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                int live=0;
                for(int[] d:dir){
                    if(d[0]+i<0 || d[0]+i>=board.length || d[1]+j<0 || d[1]+j>=board[0].length) continue;
                    if(board[d[0]+i][d[1]+j]==1 || board[d[0]+i][d[1]+j]==2) live++;
                }
                if(board[i][j]==0 && live==3) board[i][j]=3;
                if(board[i][j]==1 && (live<2 || live>3)) board[i][j]=2;
            }
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                board[i][j] %=2;
            }
        }
    }

    /*
    Time Complexity: O(M×N), where MM is the number of rows and NN is the number of columns of the Board.
    Space Complexity: O(1)
     */
    public void gameOfLife_LC2(int[][] board) {

        // Neighbors array to find 8 neighboring cells for a given cell
        int[] neighbors = {0, 1, -1};

        int rows = board.length;
        int cols = board[0].length;

        // Iterate through board cell by cell.
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

                // For each cell count the number of live neighbors.
                int liveNeighbors = 0;

                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {

                        if (!(neighbors[i] == 0 && neighbors[j] == 0)) {
                            int r = (row + neighbors[i]);
                            int c = (col + neighbors[j]);

                            // Check the validity of the neighboring cell.
                            // and whether it was originally a live cell.
                            if ((r < rows && r >= 0) && (c < cols && c >= 0) && (Math.abs(board[r][c]) == 1)) {
                                liveNeighbors += 1;
                            }
                        }
                    }
                }

                // Rule 1 or Rule 3
                if ((board[row][col] == 1) && (liveNeighbors < 2 || liveNeighbors > 3)) {
                    // -1 signifies the cell is now dead but originally was live.
                    board[row][col] = -1;
                }
                // Rule 4
                if (board[row][col] == 0 && liveNeighbors == 3) {
                    // 2 signifies the cell is now live but was originally dead.
                    board[row][col] = 2;
                }
            }
        }

        // Get the final representation for the newly updated board.
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (board[row][col] > 0) {
                    board[row][col] = 1;
                } else {
                    board[row][col] = 0;
                }
            }
        }
    }


    // followup-1 in-place, and simultaneously.
    /*
    Here simultaneously isn't about parallelism
    but using the original values of the neighbors
    instead of the updated values while applying rules to any cell.
    Hence, the first approach could be as easy as having a copy of the board.
    The copy is never mutated.
    So, you never lose the original value for a cell.

    Time Complexity: O(M×N), where MM is the number of rows and NN is the number of columns of the Board.
    Space Complexity: O(M×N), where MM is the number of rows and NN is the number of columns of the Board.
    This is the space occupied by the copy board we created initially.
     */
    public void gameOfLife_LC1(int[][] board) {
        // Neighbors array to find 8 neighboring cells for a given cell
        int[] neighbors = {0, 1, -1};

        int rows = board.length;
        int cols = board[0].length;

        // Create a copy of the original board
        int[][] copyBoard = new int[rows][cols];

        // Create a copy of the original board
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                copyBoard[row][col] = board[row][col];
            }
        }

        // Iterate through board cell by cell.
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

                // For each cell count the number of live neighbors.
                int liveNeighbors = 0;

                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {

                        if (!(neighbors[i] == 0 && neighbors[j] == 0)) {
                            int r = (row + neighbors[i]);
                            int c = (col + neighbors[j]);

                            // Check the validity of the neighboring cell.
                            // and whether it was originally a live cell.
                            // The evaluation is done against the copy, since that is never updated.
                            if ((r < rows && r >= 0) && (c < cols && c >= 0) && (copyBoard[r][c] == 1)) {
                                liveNeighbors += 1;
                            }
                        }
                    }
                }

                // Rule 1 or Rule 3
                if ((copyBoard[row][col] == 1) && (liveNeighbors < 2 || liveNeighbors > 3)) {
                    board[row][col] = 0;
                }
                // Rule 4
                if (copyBoard[row][col] == 0 && liveNeighbors == 3) {
                    board[row][col] = 1;
                }
            }
        }
    }


    /* Simulation
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Game of Life.
    Memory Usage: 42.3 MB, less than 49.68% of Java online submissions for Game of Life.
     */
    public void gameOfLife0(int[][] board) {
        int nRow = board.length, nCol = board[0].length;
        int[][] tmp = new int[nRow][nCol];

        for(int i = 0; i < nRow; i++)
        {
            for(int j = 0; j < nCol; j++)
            {
                update(board,i,j,tmp);
            }
        }
        for(int i = 0; i < nRow; i++)
        {
            for(int j = 0; j < nCol; j++)
            {
                board[i][j] = tmp[i][j];
            }
        }
    }

    private void update(int[][] board, int row, int col,int[][] tmp)
    {
        int up = 0, down = board.length, left = 0, right = board[0].length;
        int count = 0;
        if(row - 1 >= up && col+1 < right && board[row-1][col+1] == 1)
            count++;
        if(row - 1 >= up && board[row-1][col] == 1)
            count++;
        if(row - 1 >= up && col-1 >= left && board[row-1][col-1] == 1)
            count++;
        if(col-1 >= left && board[row][col-1] ==1)
            count++;
        if(col+1 < right && board[row][col+1] ==1)
            count++;
        if(row+1 < down && col - 1 >= left && board[row+1][col-1] == 1)
            count++;
        if(row+1 < down && board[row+1][col] == 1)
            count++;
        if(row+1 < down && col +1 < right && board[row+1][col+1] == 1)
            count++;
        if(board[row][col] == 1 && count < 2)
            tmp[row][col] = 0;
        if(board[row][col] == 1 && count >=2 && count <=3)
            tmp[row][col] = 1;
        if(board[row][col] == 1 && count > 3)
            tmp[row][col] = 0;
        if(board[row][col] == 0 && count == 3)
            tmp[row][col] = 1;
    }

    // this function is equivalent to update(), just a better way to implement
    private void update2(int[][] board, int row, int col,int[][] tmp)
    {
        int up = 0, down = board.length, left = 0, right = board[0].length;
        int count = 0;

        for (int x = Math.max(row-1, 0); x <= Math.min(row+1, down-1); x++)
        {
            for (int y = Math.max(col-1, 0); y <= Math.min(col+1, right-1); y++)
            {
                count += board[x][y] & 1;
            }
        }
        // remove the target cell count.
        count -= board[row][col]&1;

        if(board[row][col] == 1 && count < 2)
            tmp[row][col] = 0;
        if(board[row][col] == 1 && count >=2 && count <=3)
            tmp[row][col] = 1;
        if(board[row][col] == 1 && count > 3)
            tmp[row][col] = 0;
        if(board[row][col] == 0 && count == 3)
            tmp[row][col] = 1;
    }


}
