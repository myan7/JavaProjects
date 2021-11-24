package com.myjobhunting;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/pascals-triangle/
/*
Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]

Input: numRows = 1
Output: [[1]]
*/


public class EASY_118_Pascal_sTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int row = 0;row < numRows; row++)
        {
            List<Integer> level = new ArrayList<>();
            level.add(1);
            if( row >= 1 )
            {
                List<Integer> prev = ans.get(row-1);
                for(int j = 1; j< row;j++)
                {
                    level.add(prev.get(j-1)+prev.get(j));
                }
                level.add(1);
            }
            ans.add(level);
        }
        return ans;
    }
}
