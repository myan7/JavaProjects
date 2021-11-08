package com.myjobhunting;

public class EASY_035_SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {

        int begin = 0;
        int end = nums.length;
        while( (end+begin)/2 != begin  || begin < end)
        {
            if(target <= nums[(end+begin)/2])
            {
                end = (end+begin)/2;
            }
            else
            {
                begin = (end+begin)/2+1;
            }
        }
        return begin;
    }
}
