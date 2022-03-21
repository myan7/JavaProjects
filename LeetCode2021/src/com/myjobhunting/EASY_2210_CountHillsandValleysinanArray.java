package com.myjobhunting;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/contest/weekly-contest-285/problems/count-hills-and-valleys-in-an-array/
/*
You are given a 0-indexed integer array nums.
An index i is part of a hill in nums if the closest non-equal neighbors of i are smaller than nums[i].
Similarly, an index i is part of a valley in nums if the closest non-equal neighbors of i are larger than nums[i].
Adjacent indices i and j are part of the same hill or valley if nums[i] == nums[j].

Note that for an index to be part of a hill or valley,
it must have a non-equal neighbor on both the left and right of the index.

Return the number of hills and valleys in nums.


Example 1:
Input: nums = [2,4,1,1,6,5]
Output: 3
Explanation:
At index 0: There is no non-equal neighbor of 2 on the left, so index 0 is neither a hill nor a valley.
At index 1: The closest non-equal neighbors of 4 are 2 and 1. Since 4 > 2 and 4 > 1, index 1 is a hill.
At index 2: The closest non-equal neighbors of 1 are 4 and 6. Since 1 < 4 and 1 < 6, index 2 is a valley.
At index 3: The closest non-equal neighbors of 1 are 4 and 6. Since 1 < 4 and 1 < 6, index 3 is a valley, but note that it is part of the same valley as index 2.
At index 4: The closest non-equal neighbors of 6 are 1 and 5. Since 6 > 1 and 6 > 5, index 4 is a hill.
At index 5: There is no non-equal neighbor of 5 on the right, so index 5 is neither a hill nor a valley.
There are 3 hills and valleys so we return 3.

Example 2:
Input: nums = [6,6,5,5,4,1]
Output: 0
Explanation:
At index 0: There is no non-equal neighbor of 6 on the left, so index 0 is neither a hill nor a valley.
At index 1: There is no non-equal neighbor of 6 on the left, so index 1 is neither a hill nor a valley.
At index 2: The closest non-equal neighbors of 5 are 6 and 4. Since 5 < 6 and 5 > 4, index 2 is neither a hill nor a valley.
At index 3: The closest non-equal neighbors of 5 are 6 and 4. Since 5 < 6 and 5 > 4, index 3 is neither a hill nor a valley.
At index 4: The closest non-equal neighbors of 4 are 5 and 1. Since 4 < 5 and 4 > 1, index 4 is neither a hill nor a valley.
At index 5: There is no non-equal neighbor of 1 on the right, so index 5 is neither a hill nor a valley.
There are 0 hills and valleys so we return 0.

Constraints:
3 <= nums.length <= 100
1 <= nums[i] <= 100
 */
public class EASY_2210_CountHillsandValleysinanArray {

    /*
    Runtime: 3 ms, faster than 33.33% of Java online submissions for Count Hills and Valleys in an Array.
    Memory Usage: 42.7 MB, less than 33.33% of Java online submissions for Count Hills and Valleys in an Array.
     */
    public int countHillValley(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i : nums) {
            if (list.isEmpty() || i != list.get(list.size() - 1)) {
                list.add(i);
            }
        }
        int res = 0;
        for (int i = 1; i < list.size() - 1; i++) {
            if (list.get(i - 1) > list.get(i) && list.get(i) < list.get(i + 1) || list.get(i - 1) < list.get(i) && list.get(i) > list.get(i + 1)) {
                res++;
            }
        }
        return res;
    }

    /*
    Runtime: 1 ms, faster than 100.00% of Java online submissions for Count Hills and Valleys in an Array.
    Memory Usage: 42.1 MB, less than 66.67% of Java online submissions for Count Hills and Valleys in an Array.
     */
    public int countHillValley_initial(int[] nums) {

        int count = 0;
        for(int i = 1; i < nums.length-1; i++)
        {
            if(nums[i] == nums[i+1])
                continue;
            int post = i+1;
            int prev = i-1;

            while(post < nums.length-1 && nums[i] == nums[post])
                post++;

            while(prev > 0 && nums[i] == nums[prev])
                prev--;

            if(nums[i] > nums[prev] && nums[i] > nums[post])
                count++;
            if (nums[i] < nums[prev] && nums[i] < nums[post])
                count++;
        }
        return count;
    }
}
