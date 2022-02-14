package com.myjobhunting;

// https://leetcode.com/problems/01-matrix/

public class MEDIUM_542_01Matrix {

    public int[][] updateMatrix(int[][] mat) {
        //maximum distance between 2 cells is always the max of row + max of length
        int MAX = mat.length-1 + mat[0].length-1;

        //iterate thru all the cells, check the top & left cells for the closest 0
        //populate the cells value to be the minimums distance to reach 0 (only taking top & left cells into account)
        //we will look into the bottom & right cells seperately and then compare both values in the end
        for (int row=0; row<mat.length; row++) {
            for(int col=0; col<mat[0].length; col++){
                if(mat[row][col] != 0){
                    int top = row-1>=0 ? mat[row-1][col] : MAX;
                    int left = col-1>=0 ? mat[row][col-1] : MAX;
                    mat[row][col] = Math.min(top, left)+1;
                }
            }
        }

        //Iterate thru all cells again, now we check the bottom & right cells for the closest 0
        for(int row = mat.length-1; row >= 0; row--){
            for(int col = mat[0].length-1; col >=0; col--){
                if(mat[row][col] !=0 ){
                    int bottom = row+1 < mat.length ? mat[row+1][col] : MAX;
                    int right = col+1 < mat[0].length ? mat[row][col+1] : MAX;
                    //grab the lowest value from the top/left && bottom/right approach to get the nearest distance to 0
                    mat[row][col] = Math.min(mat[row][col], Math.min(bottom, right)+1);
                }
            }
        }
        return mat;
    }
}
