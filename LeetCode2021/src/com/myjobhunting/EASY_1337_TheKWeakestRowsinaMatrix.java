package com.myjobhunting;

// https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/

import java.util.*;

/*
You are given an m x n binary matrix mat of 1's (representing soldiers) and 0's (representing civilians). The soldiers are positioned in front of the civilians. That is, all the 1's will appear to the left of all the 0's in each row.

A row i is weaker than a row j if one of the following is true:

The number of soldiers in row i is less than the number of soldiers in row j.
Both rows have the same number of soldiers and i < j.
Return the indices of the k weakest rows in the matrix ordered from weakest to strongest.



Example 1:

Input: mat =
[[1,1,0,0,0],
 [1,1,1,1,0],
 [1,0,0,0,0],
 [1,1,0,0,0],
 [1,1,1,1,1]],
k = 3
Output: [2,0,3]
Explanation:
The number of soldiers in each row is:
- Row 0: 2
- Row 1: 4
- Row 2: 1
- Row 3: 2
- Row 4: 5
The rows ordered from weakest to strongest are [2,0,3,1,4].
Example 2:

Input: mat =
[[1,0,0,0],
 [1,1,1,1],
 [1,0,0,0],
 [1,0,0,0]],
k = 2
Output: [0,2]
Explanation:
The number of soldiers in each row is:
- Row 0: 1
- Row 1: 4
- Row 2: 1
- Row 3: 1
The rows ordered from weakest to strongest are [0,2,3,1].

Constraints:
m == mat.length
n == mat[i].length
2 <= n, m <= 100
1 <= k <= m
matrix[i][j] is either 0 or 1.
 */
public class EASY_1337_TheKWeakestRowsinaMatrix {


    /*
    Runtime: 1 ms, faster than 99.77% of Java online submissions for The K Weakest Rows in a Matrix.
    Memory Usage: 43.7 MB, less than 82.15% of Java online submissions for The K Weakest Rows in a Matrix.
     */
    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;

        int [] indexes = new int[k];
        int nextInsertIndex = 0;

        // This code does the same as the animation above.
        for (int c = 0; c < n && nextInsertIndex < k; c++) {
            for (int r = 0; r < m && nextInsertIndex < k; r++) {
                // If this is the first 0 in the current row.
                if (mat[r][c] == 0 && (c == 0 || mat[r][c - 1] == 1)) {
                    indexes[nextInsertIndex] = r;
                    nextInsertIndex++;
                }
            }
        }

        /* If there aren't enough, it's because some of the first k weakest rows
         * are entirely 1's. We need to include the ones with the lowest indexes
         * until we have at least k. */
        for (int r = 0; nextInsertIndex < k ; r++) {
            /* If index i in the last column is 1, this was a full row and therefore
             * couldn't have been included in the output yet. */
            if (mat[r][n - 1] == 1) {
                indexes[nextInsertIndex] = r;
                nextInsertIndex++;
            }
        }
        return indexes;
    }

    /*
    Runtime: 2 ms, faster than 88.13% of Java online submissions for The K Weakest Rows in a Matrix.
    Memory Usage: 48.9 MB, less than 31.65% of Java online submissions for The K Weakest Rows in a Matrix.
     */
    public int[] kWeakestRows2(int[][] mat, int k) {
        int row = mat.length, col = mat[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] == b[1]? a[0]-b[0]: a[1]-b[1]);
        for(int i = 0; i < row; i++)
        {
            int sum = binarySearch(mat[i]);
            pq.offer(new int[]{i,sum});
        }
        int[] ans = new int[k];
        for(int i = 0; i < k; i++)
        {
            ans[i] = pq.poll()[0];
        }
        return ans;
    }

    private int binarySearch(int[] row)
    {
        int left = 0, right = row.length-1;
        while(left <= right)
        {
            int mid = left + (right-left)/2;
            if(row[mid] == 1)
                left = mid+1;
            else
                right = mid-1;
        }
        return left;
    }

    /*
    Runtime: 4 ms, faster than 37.99% of Java online submissions for The K Weakest Rows in a Matrix.
    Memory Usage: 48.8 MB, less than 49.95% of Java online submissions for The K Weakest Rows in a Matrix.
     */
    public int[] kWeakestRows1(int[][] mat, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < mat.length; i++)
        {
            int sum = 0;
            for(int j = 0; j < mat[0].length; j++)
            {
                if(mat[i][j] == 0)
                    break;
                sum += mat[i][j];
            }
            map.put(sum, map.getOrDefault(sum, new ArrayList<>()));
            map.get(sum).add(i);
        }
        List<Integer> score = new ArrayList<>(map.keySet());
        Collections.sort(score);
        int[] ans = new int[k];
        int i = 0;
        for(Integer sc : score)
        {

            for(Integer ind : map.get(sc))
            {
                if(i == k)
                    break;
                ans[i++] = ind;
            }
        }
        return ans;
    }

    /*
    Runtime: 2 ms, faster than 88.13% of Java online submissions for The K Weakest Rows in a Matrix.
    Memory Usage: 43.4 MB, less than 89.60% of Java online submissions for The K Weakest Rows in a Matrix.
     */
    public int[] kWeakestRows0(int[][] mat, int k) {
        int[][] score = new int[mat.length][2];
        for(int i = 0; i < mat.length; i++)
        {
            int sum = 0;
            score[i][0] = i;
            for(int j = 0; j < mat[0].length;j++)
            {
                if(mat[i][j] == 0) // all the soldiers are in front of civilians.
                    break;
                sum += mat[i][j];
            }
            score[i][1] = sum;
        }
        Arrays.sort(score, (a, b) -> a[1] == b[1]? a[0]-b[0]: a[1]-b[1]);
        int[] ans = new int[k];
        for(int i = 0; i < k; i++)
        {
            ans[i] = score[i][0];
        }
        return ans;
    }
}
