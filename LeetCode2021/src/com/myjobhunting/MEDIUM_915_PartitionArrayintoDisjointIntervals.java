package com.myjobhunting;

import java.util.Stack;

//
/*

 */
public class MEDIUM_915_PartitionArrayintoDisjointIntervals {


    /*
    Runtime: 2 ms, faster than 99.82% of Java online submissions for Partition Array into Disjoint Intervals.
    Memory Usage: 51.2 MB, less than 98.55% of Java online submissions for Partition Array into Disjoint Intervals.
     */
    public int partitionDisjoint(int[] nums) {
        int currMax = nums[0];
        int maxLeftPartition = nums[0];
        int partitionInd = 0;
        for( int i = 1; i < nums.length; i++)
        {
            currMax = Math.max(currMax, nums[i]);
            if(nums[i] < maxLeftPartition)
            {
                maxLeftPartition = currMax;
                partitionInd = i;
            }
        }
        return partitionInd+1;
    }

    /*
    Runtime: 7 ms, faster than 38.41% of Java online submissions for Partition Array into Disjoint Intervals.
    Memory Usage: 99.5 MB, less than 35.87% of Java online submissions for Partition Array into Disjoint Intervals.
     */
    public int partitionDisjoint1(int[] nums) {
        int currMax = nums[0];
        int[] rightMin = new int[nums.length];
        rightMin[nums.length-1] = nums[nums.length-1];
        for(int i = 1; i< nums.length; i++)
        {
            rightMin[nums.length-i-1] = Math.min(rightMin[nums.length-i], nums[nums.length-i-1]);
        }
        for(int i = 1; i < nums.length; i++)
        {
            currMax = Math.max(currMax,nums[i-1]);
            if(currMax <= rightMin[i])
                return i;
        }
        return -1;
    }

    /*
    Runtime: 9 ms, faster than 27.36% of Java online submissions for Partition Array into Disjoint Intervals.
    Memory Usage: 103.6 MB, less than 14.49% of Java online submissions for Partition Array into Disjoint Intervals.
     */
    public int partitionDisjoint2(int[] nums) {
        int[] leftMax = new int[nums.length];
        leftMax[0] = nums[0];
        int[] rightMin = new int[nums.length];
        rightMin[nums.length-1] = nums[nums.length-1];
        for(int i = 1; i< nums.length; i++)
        {
            leftMax[i] = Math.max(nums[i],leftMax[i-1]);
            rightMin[nums.length-i-1] = Math.min(rightMin[nums.length-i], nums[nums.length-i-1]);
        }
        for(int i = 1; i < nums.length; i++)
        {
            if(leftMax[i-1] <= rightMin[i])
                return i;
        }
        return -1;
    }


// [1,1]
// [90,47,69,10,43,92,31,73,61,97]
// [29,33,6,4,42,0,10,22,62,16,46,75,100,67,70,74,87,69,73,88]
// [ 0, 1,2,3,4, 5, 6, 7, 8, 9,10,11,12, 13,14,15,16,17,18,19]
// [26,51,40,58,42,76,30,48,79,91]
    public int partitionDisjoint0(int[] nums) {
        int max = nums[0];
        Stack<Integer> stack = new Stack<>();

        for(int i = 1; i < nums.length; i++)
        {
            if(nums[i] < max )
            {
                if(stack.isEmpty())
                    continue;
                else
                {
                    while(!stack.isEmpty() && nums[i] < nums[stack.peek()])
                    {
                        max = Math.max(max, nums[stack.pop()]);
                    }
                }
            }
            else
                stack.push(i);
        }
        return nums.length - stack.size();
    }
}
