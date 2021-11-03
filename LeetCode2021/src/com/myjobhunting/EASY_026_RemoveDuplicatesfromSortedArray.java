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


}
