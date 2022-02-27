package com.myjobhunting;

// https://leetcode.com/problems/group-anagrams/

import java.util.*;

/*
Given an array of strings strs, group the anagrams together.
You can return the answer in any order.
An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
typically using all the original letters exactly once.

Example 1:
Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

Example 2:
Input: strs = [""]
Output: [[""]]

Example 3:
Input: strs = ["a"]
Output: [["a"]]

Constraints:
1 <= strs.length <= 104
0 <= strs[i].length <= 100
strs[i] consists of lowercase English letters.
 */
public class MEDIUM_049_GroupAnagrams {

    //Runtime: 5 ms, faster than 99.58% of Java online submissions for Group Anagrams.
    public List<List<String>> groupAnagrams1(String[] strs) {
        Map<String, List<String> > map = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();

        for(int i = 0 ; i < strs.length ; i++)
        {
            List<String> tmp = new ArrayList<>();
            char[] ca = strs[i].toCharArray();
            Arrays.sort(ca);
            String pattern = String.valueOf(ca);

            if(map.containsKey(pattern))
            {
                map.get(pattern).add(strs[i]);
            }
            else
            {
                tmp.add(strs[i]);
                map.put(pattern, tmp);
            }
        }
        for( Map.Entry<String, List<String>> entry: map.entrySet())
        {
            ans.add(entry.getValue());
        }
        return ans;
    }

    // 24 ms
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> ans = new HashMap<>();
        if (strs.length == 0)
            return new ArrayList();

        for (String s : strs)
        {
            int[] count = new int[26];
            for (char c : s.toCharArray())
                count[c - 'a']++;

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                sb.append('#');
                sb.append(count[i]);
            }
            String key = sb.toString();
            if (!ans.containsKey(key))
                ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }


    // naive solution, Runtime: 1218 ms, faster than 5.02% of Java online submissions for Group Anagrams.
    public List<List<String>> groupAnagrams0(String[] strs) {
        int[] visited = new int[strs.length];
        List<List<String>> ans = new ArrayList<>();

        for(int i = 0; i < strs.length ; i++)
        {
            if(visited[i] == 0)
            {
                List<String> anagram = new ArrayList<>();
                anagram.add(strs[i]);
                visited[i] = 1;

                for(int j = i+1 ; j < strs.length; j++)
                {
                    if(visited[j] == 0)
                    {
                        if(isAnagram(strs[i], strs[j]))
                        {
                            anagram.add(strs[j]);
                            visited[j] = 1;
                        }
                    }
                }
                ans.add(anagram);
            }
        }
        return ans;
    }

    private boolean isAnagram(String s, String t)
    {
        if(s.length() != t.length())
            return false;
        int[] alphabet = new int[26];
        for(int i = 0; i < s.length(); i++)
        {
            alphabet[s.charAt(i) - 'a']++;
            alphabet[t.charAt(i) - 'a']--;
        }
        for(int i : alphabet)
            if(i != 0)
                return false;
        return true;
    }
}
