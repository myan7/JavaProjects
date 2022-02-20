package com.myjobhunting;
// https://leetcode.com/problems/flipping-an-image/

/*
Given an n x n binary matrix image, flip the image horizontally, then invert it, and return the resulting image.

To flip an image horizontally means that each row of the image is reversed.
For example, flipping [1,1,0] horizontally results in [0,1,1].

To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0.
For example, inverting [0,1,1] results in [1,0,0].


Example 1:

Input: image = [[1,1,0],[1,0,1],[0,0,0]]
Output: [[1,0,0],[0,1,0],[1,1,1]]
Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]
Example 2:

Input: image = [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
Output: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
Explanation: First reverse each row: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]].
Then invert the image: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]


Constraints:

n == image.length
n == image[i].length
1 <= n <= 20
images[i][j] is either 0 or 1.
 */
public class EASY_832_FlippinganImage {
    public int[][] flipAndInvertImage(int[][] image) {
        int n = image.length;
        for(int i = 0; i < n; i++)
        {
            int start = 0, end = n-1;
            while(start <= end)
            {
                // if start and end is the same, just invert them
                if(image[i][start] == image[i][end])
                {
                    image[i][start] = 1 - image[i][start];
                    image[i][end] = image[i][start];
                }
                // if they are not the same, no need to change, they are already flipped and inverted.
                start++;
                end--;
            }
        }
        return image;
    }

    // naive solution
    public int[][] flipAndInvertImage0(int[][] image) {
        int nRow = image.length;
        int nCol = image[0].length;
        for(int i = 0; i < nRow; i++)
        {
            flip(image[i]);
            invert(image[i]);
        }
        return image;
    }

    private void flip(int[] row)
    {
        int start = 0, end = row.length - 1;
        while(start < end)
        {
            int tmp = row[start];
            row[start] = row[end];
            row[end] = tmp;
            start++;
            end--;
        }
    }

    private void invert(int[] row)
    {
        for(int i = 0 ; i < row.length ;i++)
            row[i] ^= 1;
    }
}
