package com.myjobhunting;
// https://leetcode.com/problems/delete-and-earn/
/*
You are given an integer array nums.
You want to maximize the number of points you get by performing the following operation any number of times:
Pick any nums[i] and delete it to earn nums[i] points.
Afterwards, you must delete every element equal to nums[i] - 1 and every element equal to nums[i] + 1.
Return the maximum number of points you can earn by applying the above operation some number of times.

Example 1:
Input: nums = [3,4,2]
Output: 6
Explanation: You can perform the following operations:
- Delete 4 to earn 4 points.
Consequently, 3 is also deleted. nums = [2].
- Delete 2 to earn 2 points. nums = [].
You earn a total of 6 points.

Example 2:
Input: nums = [2,2,3,3,3,4]
Output: 9
Explanation: You can perform the following operations:
- Delete a 3 to earn 3 points. All 2's and 4's are also deleted. nums = [3,3].
- Delete a 3 again to earn 3 points. nums = [3].
- Delete a 3 once more to earn 3 points. nums = [].
You earn a total of 9 points.

Constraints:
1 <= nums.length <= 2 * 104
1 <= nums[i] <= 104
 */
public class MEDIUM_740_DeleteandEarn {

    /*
    Runtime: 3 ms, faster than 84.49% of Java online submissions for Delete and Earn.
    Memory Usage: 44.5 MB, less than 34.52% of Java online submissions for Delete and Earn.
     */
    public int deleteAndEarn(int[] nums) {
        int n = 10001;
        int[] values = new int[n];
        for (int num : nums)
            values[num] += num;

        int take = 0, skip = 0;
        for (int i = 0; i < n; i++) {
            int takei = skip + values[i];
            int skipi = Math.max(skip, take);
            take = takei;
            skip = skipi;
        }
        return Math.max(take, skip);
    }

    /* initial solution similar to house robber LC 198
    Runtime: 7 ms, faster than 39.03% of Java online submissions for Delete and Earn.
    Memory Usage: 46.9 MB, less than 9.59% of Java online submissions for Delete and Earn.
     */
    public int deleteAndEarn0(int[] nums) {
        int[] map = new int[10001];
        for(int i : nums)
            map[i]++;
        int[] dp = new int[10001];
        for(int i = 1; i < 10001 ; i++)
        {
            if(i <= 1)
                dp[i] = i * map[i];
            else
                dp[i] = Math.max(dp[i-1], i*map[i]+ dp[i-2]);
        }
        return dp[10000];
    }
}
