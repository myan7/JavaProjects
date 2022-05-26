package com.myjobhunting;

import java.util.HashMap;
import java.util.Map;

/*
You are given an integer array cards where cards[i] represents the value of the ith card.
A pair of cards are matching if the cards have the same value.

Return the minimum number of consecutive cards you have to pick up to have a pair of matching cards among the picked cards.
If it is impossible to have matching cards, return -1.

Example 1:
Input: cards = [3,4,2,3,4,7]
Output: 4
Explanation: We can pick up the cards [3,4,2,3] which contain a matching pair of cards with value 3. Note that picking up the cards [4,2,3,4] is also optimal.

Example 2:
Input: cards = [1,0,5,3]
Output: -1
Explanation: There is no way to pick up a set of consecutive cards that contain a pair of matching cards.

Constraints:
1 <= cards.length <= 10^5
0 <= cards[i] <= 10^6
 */
public class MEDIUM_2260_MinimumConsecutiveCardstoPickUp {
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
        return min == Integer.MAX_VALUE? -1: min+1;
    }
}
