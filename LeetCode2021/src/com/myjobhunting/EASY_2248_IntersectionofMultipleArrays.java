package com.myjobhunting;

import java.util.*;

public class EASY_2248_IntersectionofMultipleArrays {


    /*
    Runtime: 4 ms, faster than 100.00% of Java online submissions for Intersection of Multiple Arrays.
    Memory Usage: 42.8 MB, less than 100.00% of Java online submissions for Intersection of Multiple Arrays.
     */
    public List<Integer> intersection(int[][] nums) {
        HashMap<Integer,Integer> hm=new HashMap(); //To store the count of number
        List<Integer> li = new ArrayList(); // To store the result
        for(int i = 0; i < nums.length; i++)
        {
            for(int j = 0; j < nums[i].length; j++){
                int val=hm.getOrDefault(nums[i][j],0);
                hm.put(nums[i][j],val+1);
                if(val+1==nums.length) li.add(nums[i][j]);
                //whenever we get the count of number equal to row length that mean it is present in every rows.
            }
        }
        Collections.sort(li); //Sort the number in result list.
        return li;
    }

    /*
    Runtime: 7 ms, faster than 50.00% of Java online submissions for Intersection of Multiple Arrays.
    Memory Usage: 46 MB, less than 100.00% of Java online submissions for Intersection of Multiple Arrays.
     */
    public List<Integer> intersection0(int[][] nums) {
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(nums[0]);
        for(int i = 0; i < nums[0].length; i++)
        {

            int target = nums[0][i];
            boolean res = true;
            for(int j = 1; j < nums.length;j++)
            {
                Arrays.sort(nums[j]);
                int index = binarySearch(nums[j],target);
                if(index == -1)
                    res = false;
            }
            if(res)
                ans.add(target);
        }
        return ans;
    }
    private int binarySearch(int[] curr, int target)
    {
        int left = 0, right = curr.length-1;
        while(left <= right)
        {
            int mid = left + (right - left)/2;
            if(curr[mid] == target)
                return mid;
            else if(curr[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }
}
