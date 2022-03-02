package com.myjobhunting;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// https://leetcode.com/problems/jewels-and-stones/
/*
You're given strings,
jewels, representing the types of stones that are jewels,
and, stones, representing the stones you have.
Each character in stones is a type of stone you have.
You want to know how many of the stones you have are also jewels.

Letters are case-sensitive, so "a" is considered a different type of stone from "A".

Example 1:
Input: jewels = "aA", stones = "aAAbbbb"
Output: 3

Example 2:
Input: jewels = "z", stones = "ZZ"
Output: 0

Constraints:
1 <= jewels.length, stones.length <= 50
jewels and stones consist of only English letters.
All the characters of jewels are unique.

 */
public class EASY_771_JewelsandStones {

    /*
    Runtime: 1 ms, faster than 91.06% of Java online submissions for Jewels and Stones.
    Memory Usage: 42.6 MB, less than 15.42% of Java online submissions for Jewels and Stones.
     */
    public int numJewelsInStones(String jewels, String stones) {
        int ans = 0;
        for(int i = 0; i < stones.length(); i++)
        {
            ans += jewels.indexOf(stones.charAt(i)) != -1? 1:0;
        }
        return ans;
    }

    /* updated initial solution 2
    Runtime: 1 ms, faster than 91.06% of Java online submissions for Jewels and Stones.
    Memory Usage: 42.7 MB, less than 15.42% of Java online submissions for Jewels and Stones.
    ASCii A = 65, Z = 90; [ = 91, \ = 92, ] = 93, ^ = 94, _ = 95, ` = 96
          a = 97, z = 122;
     */
    public int numJewelsInStones2(String jewels, String stones) {
        int ans = 0;
        int[] check = new int[128];
        for(char c : jewels.toCharArray())
            check[c-'A']++;
        for(char c : stones.toCharArray())
        {
            if(check[c-'A'] == 1)
                ans++;
        }
        return ans;
    }

    /* updated initial solution 1
    Runtime: 2 ms, faster than 58.50% of Java online submissions for Jewels and Stones.
    Memory Usage: 42.4 MB, less than 28.80% of Java online submissions for Jewels and Stones.
    Time Complexity: O(J.length+S.length).
        The O(J.length) part comes from creating J.
        The O(S.length) part comes from searching S.
    Space Complexity: O(J.length).
     */
    public int numJewelsInStones1(String jewels, String stones) {
        Set<Character> jewelSet = new HashSet<>();
        for(char c : jewels.toCharArray())
            jewelSet.add(c);
        int ans = 0;
        for(char c : stones.toCharArray())
            if(jewelSet.contains(c))
                ans++;
        return ans;
    }

    /* initial solution
    Runtime: 4 ms, faster than 15.65% of Java online submissions for Jewels and Stones.
    Memory Usage: 42.9 MB, less than 5.58% of Java online submissions for Jewels and Stones.
     */
    public int numJewelsInStones0(String jewels, String stones) {
        Map<Character, Integer> map = new HashMap<>();
        for(char jewel : jewels.toCharArray())
            map.put(jewel,0);
        for(char stone : stones.toCharArray())
        {
            if(map.containsKey(stone))
                map.put(stone,map.get(stone)+1);
        }
        int ans = 0;
        for(Map.Entry<Character,Integer> en: map.entrySet())
        {
            ans += en.getValue();
        }
        return ans;
    }
}
