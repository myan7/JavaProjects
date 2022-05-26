package com.myjobhunting;

public class EASY_026_RemoveDuplicatesfromSortedArray {

    public int removeDuplicates(int[] nums) {
        int index = 1;
        if(nums.length<2)
            return nums.length;
        else
        {
            for(int i =1;i<nums.length;i++)
            {
                if(nums[i]!=nums[i-1])
                    nums[index++] = nums[i];
            }
        }
        return index;
    }

    public int removeDuplicates2(int[] nums) {
        if(nums.length < 2)
            return nums.length;
        else
        {
            int ans = nums.length;
            int dupcnt = 0;
            int temp = nums[0];
            int cnt = 0;
            for(int i = 0; i < nums.length-1;i++)
            {
                if(nums[i] == nums[i+1])
                {
                    dupcnt++;
                }
                if(nums[i] < nums[i+1] && dupcnt > 0)
                {
                    temp = nums[i+1];
                    nums[i-dupcnt+1] = temp;
                    cnt++;
                }
            }
            return ans-dupcnt;
        }

    }

    /*
    Runtime: 1 ms, faster than 94.81% of Java online submissions for Remove Duplicates from Sorted Array.
    Memory Usage: 48.2 MB, less than 15.03% of Java online submissions for Remove Duplicates from Sorted Array.
     */
    public int removeDuplicates_05252022(int[] nums) {
        // sorted in non-decreasing order
        // Do not allocate extra space for another array.
        // You must do this by modifying the input array in-place with O(1) extra memory.
        if(nums.length <= 1)
            return nums.length;
        int left = 0, right = 1;
        while(right < nums.length)
        {
            if(nums[left] != nums[right])
            {
                left++;
            }
            nums[left] = nums[right];
            right++;
        }
        return left+1;
    }

}
