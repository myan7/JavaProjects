package com.myjobhunting;
// https://leetcode.com/problems/distribute-candies/

import java.util.HashSet;
import java.util.Set;

public class EASY_575_DistributeCandies {

    public int distributeCandies(int[] candyType) {
        Set<Integer> kinds = new HashSet<>();
        for (int candy : candyType) kinds.add(candy);
        return Math.min(candyType.length / 2, kinds.size());
    }

    public int distributeCandies0(int[] candyType) {
        int count = 0;
        Set<Integer> mySet = new HashSet<>();
        for(int e: candyType)
        {
            if(mySet.add(e))
            {
                count++;
            }
        }
        return  count>candyType.length/2? candyType.length/2:mySet.size();
    }
}
