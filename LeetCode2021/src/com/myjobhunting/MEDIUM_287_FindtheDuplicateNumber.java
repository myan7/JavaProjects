package com.myjobhunting;
// https://leetcode.com/problems/find-the-duplicate-number/
/*
Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
There is only one repeated number in nums, return this repeated number.
You must solve the problem without modifying the array nums and uses only constant extra space.

Example 1:
Input: nums = [1,3,4,2,2]
Output: 2

Example 2:
Input: nums = [3,1,3,4,2]
Output: 3

Constraints:
1 <= n <= 105
nums.length == n + 1
1 <= nums[i] <= n
All the integers in nums appear only once except for precisely one integer which appears two or more times.

Follow up:
How can we prove that at least one duplicate number must exist in nums?
Can you solve the problem in linear runtime complexity?
 */
public class MEDIUM_287_FindtheDuplicateNumber {

    // O(n) space 2 ms, faster than 99.94%
    public int findDuplicate(int[] nums) {

        int[] map = new int[nums.length];
        int ans = nums[0];
        for (int num : nums) {
            if (map[num] == 1) {
                ans = num;
                return ans;
            } else {
                map[num]++;
            }
        }
        return ans;
    }


    // Negative Marking  also refer to LC041
    /*
    Note: This approach temporarily modifies individual elements and thus does not satisfy the problem constraints.
    However, this approach is intuitive and utilizes a technique that is useful to know.
    Furthermore, the underlying concept lends itself to solving similar problems.
    As such, you can further practice this technique on other problems such as 41. First Missing Positive.

    Intuition

There are n + 1 positive numbers in the array (nums) (all in the range [1, n][1,n]).
Since the array only contains positive integers,
we can track each number (num) that has been seen before
by flipping the sign of the number located at index |num|, where || denotes absolute value.

For example, if the input array is [1,3,3,2],
then for 1, flip the number at index 1,
making the array [1,−3,3,2].
Next, for -3 flip the number at index 3,
making the array [1,-3,3,-2].
Finally, when we reach the second 3, we'll notice that nums[3] is already negative,
indicating that 33 has been seen before and hence is the duplicate number.

Algorithm

Iterate over the array, evaluating each element (let's call the current element cur).
Since we use negative marking, we must ensure that the current element (cur) is positive
(i.e. if cur is negative, then use its absolute value).

Check if nums[cur] is negative.
If it is, then we have already performed this operation for the same number,
and hence cur is the duplicate number. Store cur as the duplicate and exit the loop.

Otherwise, flip the sign of nums[cur] (i.e. make it negative).
Move to the next element and repeat step 3.

Once we've identified the duplicate,
we could just return the duplicate number.
However, even though we were not able to meet the problem constraints,
we can show that we are mindful of the constraints by restoring the array.
This is done by changing all negative numbers to positive.
     */
    public int findDuplicate3(int[] nums) {
        int duplicate = 0;
        for(int i = 0; i < nums.length; i++)
        {
            int index = Math.abs(nums[i]);
            if(nums[index] < 0)
            {
                duplicate = index;
                break;
            }
            nums[index] *= -1;
        }
        return duplicate;
    }

    // Floyd's Tortoise and Hare (Cycle Detection) T: O(n) S: O(1)
    public int findDuplicate2(int[] nums) {

        // Find the intersection point of the two runners.
        int tortoise = nums[0];
        int hare = nums[0];

        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while (tortoise != hare);

        // Find the "entrance" to the cycle.
        tortoise = nums[0];

        while (tortoise != hare) {
            tortoise = nums[tortoise];
            hare = nums[hare];
        }

        return hare;
    }

    // 4.1 Array as HashMap (Recursion) T:O(n) S:O(n)
    public int findDuplicate0(int[] nums) {
        return store(nums, 0);
    }
    private int store(int[] nums, int cur) {
        if (cur == nums[cur])
            return cur;
        int nxt = nums[cur];
        nums[cur] = cur;
        return store(nums, nxt);
    }

    // 4.2 array as hashMap T: O(n) S: O(1)
    /*
    Intuition
The core intuition behind this approach is similar to that of Approach 4.1.
Here as well, we start with index 0. Since all numbers are in the range [1,n],
they will be mapped to indices 11 through nn inclusive, and hence no number will be mapped to index 00.

The key idea is to always map the number at index 0 to its equivalent index.
While in the recursive approach, we directly jump to the next index,
in this approach,
we will bring the number from the next index to index 0 and continue from there (effectively performing a swap).
     */
    public int findDuplicate1(int[] nums) {
        while (nums[0] != nums[nums[0]]) {
            int nxt = nums[nums[0]];
            nums[nums[0]] = nums[0];
            nums[0] = nxt;
        }
        return nums[0];
    }


}
