package com.myjobhunting;

//https://leetcode.com/problems/missing-number/

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class EASY_268_MissingNumber {

    /*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Missing Number.
    Memory Usage: 42.8 MB, less than 88.91% of Java online submissions for Missing Number.
     */
    public int missingNumber20220311(int[] nums) {
        int len = nums.length;
        int ans = len*(len+1)/2;
        int sum = 0;
        for(int num: nums)
            sum += num;
        return ans - sum;
    }

    /*
    Both bit manipulation and Gauss' Formula is O(n) Time and O(1) space
     */
    // 0 ms time complexity O(n), O(1) space complexity
    // bit manipulation
    public int missingNumber(int[] nums) {
        int missing = nums.length;
        for(int i = 0; i < nums.length; i++)
        {
            missing = missing ^i ^ nums[i];
        }
        return missing;
    }

    // n^n = 0, and n^0 = n
    public int missingNumber2(int[] nums)
    {
        int missing = 0, i;
        for(i = 0;i < nums.length; i++)
        {
            missing = missing^i^nums[i];
        }
        missing = missing^i;
        return missing;
    }
    // Gauss' Formula
    public int missingNumber3(int[] nums) {
        int len = nums.length;
        int sum = len*(len+1)/2;
        for(int i : nums)
        {
            sum -= i;
        }
        return sum;
    }

    /* 5ms
    Time complexity : O(n)
        Because the set allows for O(1) containment queries, the main loop runs in O(n) time.
        Creating set costs O(n) time, as each set insertion runs in amortized O(1) time,
        so the overall runtime is O(n+n)=O(n).

    Space complexity : O(n)
        nums contains (n-1) distinct elements, so it costs O(n) space to store a set containing all of them.
    */
    public int missingNumber1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int n = nums.length;
        for (int num : nums) {
            set.add(num);
        }
        for(int i = 0; i <= n; i++)
        {
            if(!set.contains(i))
                return i;
        }
        return -1;
    }

    // naive solution  8ms
    // given that the array contains n distinct numbers in range of [0,n]
    // return the ONLY number missing
    // which means if we can have the elements in order, it would be easier for us to see which one is missing
    /*
    Time complexity : O(nlgn)
        The only elements of the algorithm that have asymptotically non-constant time complexity are the main for loop
        (which runs in O(n) time), and the sort invocation (which runs in O(nlgn) time).
        Therefore, the runtime is dominated by sort, and the entire runtime is O(nlgn).

    Space complexity : O(1) (or O(n))
        In the sample code, we sorted nums in place,
        allowing us to avoid allocating additional space.
        If modifying nums is forbidden, we can allocate an O(n) size copy and sort that instead.
    */
    public int missingNumber0(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++)
        {
            if(i != nums[i])
                return i;
        }
        return nums.length;
    }


}
