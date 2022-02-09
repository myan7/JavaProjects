package com.myjobhunting;
//https://leetcode.com/problems/triangle/

import java.nio.file.StandardOpenOption;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MEDIUM_120_Triangle {

    /*top -> down
    get the min for each position.
    return min from the bottom level.*/
    // 7ms
    public int minimumTotal0(List<List<Integer>> triangle) {
        for(int i = 1 ; i < triangle.size();i++)
        {
            for(int j = 0; j < triangle.get(i).size(); j++)
            {
                int sum = 0;
                if(j == 0)
                {
                    sum = triangle.get(i-1).get(j) + triangle.get(i).get(j);
                }
                else if(j == triangle.get(i).size()-1)
                {
                    sum = triangle.get(i-1).get(triangle.get(i-1).size()-1) + triangle.get(i).get(j);
                }
                else
                {
                    sum = Math.min(triangle.get(i-1).get(j), triangle.get(i-1).get(j-1)) +triangle.get(i).get(j);
                }
                triangle.get(i).set(j,sum);
            }
        }
        return Collections.min(triangle.get(triangle.size()-1));
    }

    /*bottom to top*/
    // 7ms
    public int minimumTotal1(List<List<Integer>> triangle) {
        for(int i = triangle.size()-2; i >= 0; i--)
        {
            for(int j = 0; j < triangle.get(i).size(); j++)
            {
                int sum = Math.min(triangle.get(i+1).get(j), triangle.get(i+1).get(j+1)) + triangle.get(i).get(j);
                triangle.get(i).set(j,sum);
            }
        }
        return triangle.get(0).get(0);
    }

    // Follow up: Could you do this using only O(n) extra space, where n is the total number of rows in the triangle?
    // 3 ms
    public int minimumTotal(List<List<Integer>> triangle) {
        // if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.
        int[] dp = new int[triangle.size()+1];
        for( int i = triangle.size()-1; i>= 0; i--) // from bottom to top
        {
            for(int j = 0; j < triangle.get(i).size() ; j++ )
            {
                // update dp array when traverse every level.
                dp[j] = Math.min(dp[j], dp[j+1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}
