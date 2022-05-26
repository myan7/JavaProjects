package com.myjobhunting;

import java.util.*;

public class WC291_6049_KDivisibleElementsSubarrays {

    public static void main(String[] args)
    {
        // 11
        //int[] nums = {2,3,3,2,2};
        //int k = 2, p = 2;

        int[] nums = {1,2,3,4};
        int k = 4, p = 1;
        System.out.println(countDistinct(nums,k,p));

    }
    public static int countDistinct(int[] nums, int k, int p) {
        Set<String> potential = new HashSet<>();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++)
        {
            int count = 0;
            StringBuilder sb = new StringBuilder();

            for(int j = i; j <nums.length;j++)
            {
                if(count == 2 && list.contains(j))
                    continue;
                if(nums[j]%p == 0)
                    count++;
                sb.append(nums[j]).append('$');
                potential.add(sb.toString());
                System.out.println(sb.toString());
            }
        }
        return  potential.size();
    }
}
