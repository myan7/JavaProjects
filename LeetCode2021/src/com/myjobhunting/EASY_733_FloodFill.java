package com.myjobhunting;

//https://leetcode.com/problems/flood-fill/

public class EASY_733_FloodFill {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image[sr][sc] == newColor) return image;
        fill(image,sr,sc,image[sr][sc],newColor);
        return image;
    }
    private void fill(int[][] image, int sr, int sc, int color, int newColor)
    {
        int nRow = image.length;
        int nCol = image[0].length;
        if(  sr < 0 || sc < 0 || sr >= nRow || sc >= nCol || image[sr][sc] != color )
        {
            return;
        }
        // to avoid update it again.
        image[sr][sc] = newColor;
        fill(image, sr+1, sc,color, newColor);
        fill(image, sr-1, sc,color, newColor);
        fill(image, sr, sc+1,color, newColor);
        fill(image, sr, sc-1,color, newColor);
    }

    public int[][] floodFill2(int[][] image, int sr, int sc, int newColor) {
        if(image[sr][sc] == newColor) return image;
        dfsUpdate(image,sr,sc,newColor, image[sr][sc]);
        return image;
    }

    private void dfsUpdate(int[][] image, int sr, int sc, int newColor, int color)
    {
        if(sr < 0  || sc < 0 || sr >= image.length || sc >= image[0].length || image[sr][sc] != color)
        {
            return;
        }
        image[sr][sc] = newColor;
        dfsUpdate(image, sr+1, sc, newColor, color);
        dfsUpdate(image, sr-1, sc, newColor, color);
        dfsUpdate(image, sr, sc+1, newColor, color);
        dfsUpdate(image, sr, sc-1, newColor, color);
    }
}
