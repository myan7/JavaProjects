package com.myjobhunting;

// https://leetcode.com/problems/spiral-matrix-ii/


/*
Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.

Example 1:
Input: n = 3
Output: [[1,2,3],[8,9,4],[7,6,5]]

Example 2:
Input: n = 1
Output: [[1]]

Constraints:
1 <= n <= 20
 */
public class MEDIUM_059_SpiralMatrix_II {

    /*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Spiral Matrix II.
    Memory Usage: 40.1 MB, less than 90.73% of Java online submissions for Spiral Matrix II.
     */
    public int[][] generateMatrix_LC(int n) {
        int[][] result = new int[n][n];
        int cnt = 1;
        int dir[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int d = 0;
        int row = 0;
        int col = 0;
        while (cnt <= n * n) {
            result[row][col] = cnt++;
            int r = Math.floorMod(row + dir[d][0], n);
            int c = Math.floorMod(col + dir[d][1], n);

            // change direction if next cell is non zero
            if (result[r][c] != 0) d = (d + 1) % 4;

            row += dir[d][0];
            col += dir[d][1];
        }
        return result;
    }

    public int[][] generateMatrix_dfs(int n) {
        var m = new int[n][n];
        dfs(m, 0, 0, false, 1);
        return m;
    }
    private void dfs(int[][] m, int row, int col, boolean goup,int count) {
        if (row < 0 || col < 0 || col >= m[0].length || row >= m.length || m[row][col] != 0) return;
        m[row][col] = count;
        count++;
        if (goup) dfs(m, row-1, col, true, count);
        dfs(m, row, col+1, false, count);
        dfs(m, row + 1, col, false, count);
        dfs(m, row, col-1, false, count);
        dfs(m, row-1, col, true, count);
    }

    /*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Spiral Matrix II.
    Memory Usage: 40.5 MB, less than 83.33% of Java online submissions for Spiral Matrix II.
     */
    public int[][] generateMatrix_rec(int n) {

        int ans[][] = new int[n][n];
        fillMatrix(ans, 0 , 0, 1,'r');
        return ans;
    }

    public void fillMatrix(int [][]ans, int i, int j, int cur, char dir){
        if(i < 0 || j < 0 || i >=ans.length ||  j >= ans.length) return;

        if(ans[i][j] != 0) return;

        ans[i][j] = cur;

        if(dir == 'u'){
            fillMatrix(ans, i-1,j,cur+1, 'u');
        }

        fillMatrix(ans, i,j+1,cur+1, 'r');
        fillMatrix(ans, i+1,j,cur+1, 'd');
        fillMatrix(ans, i,j-1,cur+1, 'l');
        fillMatrix(ans, i-1,j,cur+1, 'u');
    }

    /*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Spiral Matrix II.
    Memory Usage: 40.5 MB, less than 83.33% of Java online submissions for Spiral Matrix II.
     */
    int rowDir = 0, colDir = 1;
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int num = 1;
        int row =0, col=0;

        while(num<= n*n) {
            matrix[row][col] = num++;

            int tempRow = row+rowDir;
            int tempCol = col+colDir;

            //Condition to change direction
            if(tempRow < 0 || tempCol <0 || tempRow == n || tempCol == n || matrix[tempRow][tempCol] != 0) {
                changeDirection();
            }
            row += rowDir;
            col += colDir;
        }

        return matrix;
    }

    public void changeDirection() {

        if(rowDir == 0 && colDir ==1) {
            // initial: right -> new: down
            colDir = 0;
            rowDir = 1;
        } else if (colDir == 0 && rowDir ==1) {
            // initial: down -> new: left
            rowDir = 0;
            colDir = -1;
        } else if (colDir == -1 && rowDir == 0) {
            // initial: left -> new: up
            rowDir = -1;
            colDir = 0;
        } else if (rowDir == -1 && colDir == 0) {
            // initial: up -> new: right
            colDir = 1;
            rowDir = 0;
        }
    }

    /* update my original solution
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Spiral Matrix II.
    Memory Usage: 40.2 MB, less than 87.79% of Java online submissions for Spiral Matrix II.
     */
    public int[][] generateMatrix1(int n) {
        int r = 0, c = 0, i = 1;
        int up = 0, left = 0;
        int down = n-1, right = n-1;
        int[][] ans = new int[n][n];
        int dR = 0, dC = 1;
        while(r >= up && r <= down && c >= left && c <= right )
        {
            ans[r][c] = i++;
            // going right
            if(dR == 0 && dC == 1 && c == right)
            {
                dR = 1;
                dC = 0;
                up++;
            }
            // going down
            else if(dR == 1 && dC == 0 && r == down)
            {
                dR = 0;
                dC = -1;
                right--;
            }
            // going left
            else if(dR == 0 && dC == -1 && c == left)
            {
                dR = -1;
                dC = 0;
                down--;
            }
            // going up
            else if(dR == -1 && dC == 0 && r == up)
            {
                dR = 0;
                dC = 1;
                left++;
            }
            c += dC;
            r += dR;
        }
        return ans;
    }

    /*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Spiral Matrix II.
    Memory Usage: 40.3 MB, less than 87.79% of Java online submissions for Spiral Matrix II.
     */
    public int[][] generateMatrix0(int n) {
        int r = 0, c = 0;
        int minR = 0, minC = 0;
        int maxR = n-1, maxC = n-1;
        int i = 1, max = n*n;
        int[][] ans = new int[n][n];
        int dR = 0, dC = 1;
        while(i <= max && r >= minR && r <= maxR && c >= minC && c <= maxC )
        {
            ans[r][c] = i++;
            // going right
            if(dR == 0 && dC == 1)
            {
                if(c == maxC)
                {
                    dR = 1;
                    dC = 0;
                    minR++;
                    r++;
                    continue;
                }
                c++;
            }
            // going down
            else if(dR == 1 && dC == 0)
            {
                if(r == maxR)
                {
                    dR = 0;
                    dC = -1;
                    maxC--;
                    c--;
                    continue;
                }
                r++;
            }
            // going left
            else if(dR == 0 && dC == -1)
            {
                if(c == minC)
                {
                    dR = -1;
                    dC = 0;
                    maxR--;
                    r--;
                    continue;
                }
                c--;
            }
            // going up
            else if(dR == -1 && dC == 0 )
            {
                if(r == minR)
                {
                    dR = 0;
                    dC = 1;
                    minC++;
                    c++;
                    continue;
                }
                r--;
            }
        }
        return ans;
    }
}
