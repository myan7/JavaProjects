package com.myjobhunting;
// https://leetcode.com/problems/decompress-run-length-encoded-list/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
We are given a list, nums, of integers representing a list compressed with run-length encoding.
Consider each adjacent pair of elements [freq, val] = [nums[2*i], nums[2*i+1]] (with i >= 0).
For each such pair, there are freq elements with value val concatenated in a sublist.
Concatenate all the sublists from left to right to generate the decompressed list.
Return the decompressed list.

Example 1:
    Input: nums = [1,2,3,4]
    Output: [2,4,4,4]
Explanation:    The first pair [1,2] means we have freq = 1 and val = 2 so we generate the array [2].
                The second pair [3,4] means we have freq = 3 and val = 4 so we generate [4,4,4].
                At the end the concatenation [2] + [4,4,4] is [2,4,4,4].

Example 2:
Input: nums = [1,1,2,3]
Output: [1,3,3]

Constraints:
2 <= nums.length <= 100
nums.length % 2 == 0
1 <= nums[i] <= 100
 */
public class EASY_1313_DecompressRunLengthEncodedList {

    // 1ms
    public int[] decompressRLElist(int[] nums) {
        int len = 0;
        for(int i = 0; i< nums.length; i = i+2)
            len += nums[i];
        int[] ans = new int[len];
        int index = 0;
        for(int i = 1; i < nums.length; i+=2)
        {
            int rep = nums[i-1];
            while(rep-- > 0)
                ans[index++] = nums[i];
        }
        return ans;
    }

    public int[] decompressRLElist1(int[] nums) {
        int arrSize = 0;
        for (int i = 0; i < nums.length; i += 2) {
            arrSize += nums[i];
        }

        int[] result = new int[arrSize];

        int startIdx = 0;
        for (int i = 0; i < nums.length; i += 2) {
            Arrays.fill(result, startIdx, startIdx + nums[i], nums[i + 1]);
            startIdx += nums[i];
        }
        return result;
    }

    //3ms
    public int[] decompressRLElist0(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < nums.length-1; i = i+2)
        {
            for(int j = 0; j < nums[i]; j++)
                result.add(nums[i+1]);
        }
        int[] ans = new int[result.size()];
        for(int i = 0; i < result.size(); i++)
            ans[i] = result.get(i);
        return ans;
    }

    // java8 stream feature
    public int[] decompressRLElist2(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for(int i = 1; i < nums.length; i+=2)
        {
            while(nums[i-1]-- > 0)
                ans.add(nums[i]);
        }
        int[] res = ans.stream().mapToInt(i->i).toArray();
        //or int[] res = ans.stream().mapToInt(Integer::intValue).toArray();
        return res;
    }


}
