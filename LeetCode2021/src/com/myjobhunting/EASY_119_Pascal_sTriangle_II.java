package com.myjobhunting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EASY_119_Pascal_sTriangle_II {
    public List<Integer> getRow(int rowIndex) {
        // construct the triangle
        List<List<Integer>> triangle = new ArrayList<>();
        for(int row = 0; row <= rowIndex; row++ )
        {
            // create list for current row
            List<Integer> level = new ArrayList<>();
            level.add(1);
            if(row >= 1)
            {
                List<Integer> prev = triangle.get(row - 1);
                for (int i = 1; i < row; i++)
                {
                    level.add(prev.get(i - 1) + prev.get(i));
                }
                level.add(1);
            }
            triangle.add(level);
        }
        // retrieve the row of rowIndex
        return triangle.get(rowIndex);
    }

    public List<Integer> getRow2(int rowIndex) {
        Integer[] result = new Integer[rowIndex+1];
        Arrays.fill(result,1);
        for(int i=0;i<=rowIndex;i++)
            for(int j=i-1;j>0;j--)
                result[j] += result[j-1];
        return Arrays.asList(result);
    }
}
