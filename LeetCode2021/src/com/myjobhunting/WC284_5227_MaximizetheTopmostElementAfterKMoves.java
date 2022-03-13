package com.myjobhunting;
// https://leetcode.com/contest/weekly-contest-284/problems/maximize-the-topmost-element-after-k-moves/

/*
You are given a 0-indexed integer array, nums, representing the contents of a pile,
where nums[0] is the topmost element of the pile.

In one move, you can perform either of the following:
If the pile is not empty, remove the topmost element of the pile.
If there are one or more removed elements, add any one of them back onto the pile.
This element becomes the new topmost element.
You are also given an integer k, which denotes the total number of moves to be made.

Return the maximum value of the topmost element of the pile possible after exactly k moves.
In case it is not possible to obtain a non-empty pile after k moves, return -1.

Example 1:
Input: nums = [5,2,2,4,0,6], k = 4
Output: 5
Explanation:
One of the ways we can end with 5 at the top of the pile after 4 moves is as follows:
- Step 1: Remove the topmost element = 5. The pile becomes [2,2,4,0,6].
- Step 2: Remove the topmost element = 2. The pile becomes [2,4,0,6].
- Step 3: Remove the topmost element = 2. The pile becomes [4,0,6].
- Step 4: Add 5 back onto the pile. The pile becomes [5,4,0,6].
Note that this is not the only way to end with 5 at the top of the pile. It can be shown that 5 is the largest answer possible after 4 moves.
Example 2:

Input: nums = [2], k = 1
Output: -1
Explanation:
In the first move, our only option is to pop the topmost element of the pile.
Since it is not possible to obtain a non-empty pile after one move, we return -1.


Constraints:

1 <= nums.length <= 105
0 <= nums[i], k <= 109
 */

/*
[5,2,2,4,0,6]
4
[2]
1
[35,43,23,86,23,45,84,2,18,83,79,28,54,81,12,94,14,0,0,29,94,12,13,1,48,85,22,95,24,5,73,10,96,97,72,41,52,1,91,3,20,22,41,98,70,20,52,48,91,84,16,30,27,35,69,33,67,18,4,53,86,78,26,83,13,96,29,15,34,80,16,49]
15
ans =
[91,98,17,79,15,55,47,86,4,5,17,79,68,60,60,31,72,85,25,77,8,78,40,96,76,69,95,2,42,87,48,72,45,25,40,60,21,91,32,79,2,87,80,97,82,94,69,43,18,19,21,36,44,81,99]
2
ans = 91
[1,2,1000000000]
2
ans = 1000000000
[2,5,6,2,10,18,14,7,3,0,18,15,10,9,11,19,3,19,4,8,10,14,11,5,2,17,0,2,0,11,12,11,2,9,2,6,0,14,7,19,17,13,4,4,11,19,9,1,10]
6
ans = 14
 */
public class WC284_5227_MaximizetheTopmostElementAfterKMoves {
    public int maximumTop(int[] nums, int k) {
        int len = nums.length;
        if (len == 1) return -1;

        int max = Integer.MIN_VALUE;
        int index = 0;
        if (len <= k)
            index = len - 1;
        else {
            if (k >= 2)
                index = k - 2;
            else if (k == 1)
                return nums[1];
            else if (k == 0)
                return nums[0];
        }

        for (int i = index; i >= 0; i--) {
            max = Math.max(max, nums[i]);
        }
        return max;
    }
}
