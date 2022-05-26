package com.myjobhunting;

public class EASY_027_RemoveElement {
    public int removeElement(int[] nums, int val) {
        int index = 0;
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] != val)
                nums[index++] = nums[i];
        }
        return index;
    }

    public int removeElement2(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                // reduce array size by one
                n--;
            } else {
                i++;
            }
        }
        return n;
    }

    /*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Element.
    Memory Usage: 40.9 MB, less than 81.40% of Java online submissions for Remove Element.
     */
    public int removeElement3(int[] nums, int val) {
        int index = 0;
        for(int e: nums)
        {
            if(e != val)
                nums[index++] = e;
        }
        return index;
    }

    // 2 pointers
    /*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Element.
    Memory Usage: 43 MB, less than 17.51% of Java online submissions for Remove Element.
     */
    public int removeElement_05252022(int[] nums, int val) {
        int left = 0, right = nums.length-1, count = 0;
        for(int num : nums)
            if(num == val)
                count++;

        while(left < right)
        {
            while(left < nums.length && nums[left] != val)
                left++;
            while(right >= 0 && nums[right] == val)
                right--;
            if(left < right && nums[left] == val && nums[right] != val)
            {
                nums[left] = nums[right];
                nums[right] = val;
            }
        }
        return nums.length - count;
    }
}
