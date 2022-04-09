package com.myjobhunting;

public class MEDIUM_034_FindFirstandLastPositionofElementinSortedArray {

    /*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Find First and Last Position of Element in Sorted Array.
    Memory Usage: 45.8 MB, less than 81.73% of Java online submissions for Find First and Last Position of Element in Sorted Array.
     */
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        ans[0] = binSearch(nums,target, true);
        ans[1] = binSearch(nums,target,false);

        return ans;
    }

    private int binSearch(int[] nums, int target,boolean leftBias)
    {
        int index = -1;
        int left = 0, right = nums.length-1;
        while(left <= right)
        {
            int mid = left + (right - left)/2;
            if(nums[mid] > target)
                right = mid-1;
            else if(nums[mid] < target)
                left = mid +1;
            else
            {
                index = mid;
                if(leftBias)
                    right = mid - 1;
                else
                    left = mid + 1;
            }
        }
        return index;
    }

    /*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Find First and Last Position of Element in Sorted Array.
    Memory Usage: 45.8 MB, less than 81.73% of Java online submissions for Find First and Last Position of Element in Sorted Array.
     */
    public int[] searchRange0(int[] nums, int target) {
        int[] ans = new int[2];
        ans[0] = findFirstOccurrence(nums,target);
        ans[1] = findLastOccurrence(nums,target);

        return ans[0] > ans[1]? new int[]{-1,-1} : ans;
    }

    private int findFirstOccurrence(int[] nums, int target)
    {
        int left = 0, right = nums.length-1;
        while(left <= right)
        {
            int mid = left + (right - left)/2;
            if(nums[mid] >= target)
                right = mid-1;
            else
                left = mid +1;
        }
        return left;
    }

    private int findLastOccurrence(int[] nums, int target)
    {
        int left = 0, right = nums.length-1;
        while(left <= right)
        {
            int mid = left + (right - left)/2;
            if(nums[mid] <= target)
                left = mid+1;
            else
                right = mid-1;
        }
        return right;
    }
}
