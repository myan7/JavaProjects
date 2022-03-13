package com.myjobhunting;
// https://leetcode.com/problems/container-with-most-water/

/*
You are given an integer array height of length n.
There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
Find two lines that together with the x-axis form a container,
such that the container contains the most water.
Return the maximum amount of water a container can store.
Notice that you may not slant the container.

Example 1:
Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation:
The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7].
In this case, the max area of water (blue section) the container can contain is 49.

Example 2:
Input: height = [1,1]
Output: 1

Constraints:
n == height.length
2 <= n <= 105
0 <= height[i] <= 104
 */
public class MEDIUM_011_ContainerWithMostWater {

    /*public int maxArea(int[] height)
    {
        int currMin=height[0], currMax = height[0], len = height.length;
        int ans = 0;
        for(int i = 1; i < len; i++)
        {
            int tmpMin = currMin, tmpMax = currMax;
            currMin = Math.min(currMin,height[i]) * i;
            currMax = //Notice that I still need both indices to calculate the area
                    // then I know this could be solved by 2 pointers.
            ans = Math.max(currMax,ans);
        }
    }*/

    /* two pointers
    Runtime: 3 ms, faster than 93.97% of Java online submissions for Container With Most Water.
    Memory Usage: 74.4 MB, less than 61.23% of Java online submissions for Container With Most Water.
     */
    public int maxArea_2pointers(int[] height)
    {
        int maxarea = 0, left = 0, right = height.length - 1;
        while (left < right) {
            maxarea = Math.max(maxarea, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right])
                left++;
            else
                right--;
        }
        return maxarea;
    }

    /*
    Naive solution
    55 / 60 test cases passed.
    Time Limit Exceeded
     */
    public int maxArea_TLE(int[] height) {
        //this should be a dp problem.
        int len = height.length;
        //int[] dp = new int[len];
        int ans = 0;
        for(int i = 0; i< len-1; i++)
        {
            int area = 0;
            for(int j = i+1; j < len; j++)
            {
                area = (j-i)*(Math.min(height[i], height[j]));
                ans = Math.max(area,ans);
            }
        }
        return ans;
    }
}
