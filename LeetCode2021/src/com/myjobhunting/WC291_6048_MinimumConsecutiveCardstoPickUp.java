package com.myjobhunting;

import java.util.HashMap;
import java.util.Map;

public class WC291_6048_MinimumConsecutiveCardstoPickUp {
    public int minimumCardPickup(int[] cards) {
        int min = Integer.MAX_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < cards.length;i++)
        {
            if(map.containsKey(cards[i]))
            {
                min = Math.min(min,i - map.get(cards[i]));
            }
            map.put(cards[i], i);
        }
        return min;
    }
}
