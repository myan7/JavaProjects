package com.myjobhunting;

import java.util.ArrayList;
import java.util.List;

public class EASY_1431_KidsWiththeGreatestNumberofCandies {
    public List<Boolean> kidsWithCandies0(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        int[] updated = new int[candies.length];
        for(int i = 0; i < candies.length; i++)
        {
            max = Math.max(max, candies[i]);
            updated[i] = candies[i] + extraCandies;
        }
        for(int i : updated)
        {
            result.add(i >= max);
        }
        return result;
    }

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();
        int max = Integer.MIN_VALUE;

        for(int i : candies)
        {
            max = Math.max(max, i);
        }
        for(int i : candies)
        {
            result.add( i + extraCandies >= max);
        }

        return result;
    }
}
