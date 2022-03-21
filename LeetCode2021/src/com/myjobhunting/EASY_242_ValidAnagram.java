package com.myjobhunting;

//https://leetcode.com/problems/valid-anagram/

/*
Given two strings s and t, return true if t is an anagram of s, and false otherwise.
An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

Example 1:
Input: s = "anagram", t = "nagaram"
Output: true

Example 2:
Input: s = "rat", t = "car"
Output: false

Constraints:
1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters.

Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?
 */
import java.util.Arrays;

public class EASY_242_ValidAnagram {

    /*
    Runtime: 1 ms, faster than 100.00% of Java online submissions for Valid Anagram.
    Memory Usage: 42.1 MB, less than 80.06% of Java online submissions for Valid Anagram.
     */
    public boolean isAnagram20220316(String s, String t) {
        int[] letters = new int[26]; // for follow up question // int[] letters = new int[256];
        for(char c : s.toCharArray())
            letters[c-'a']++;
        for(char c : t.toCharArray())
            letters[c-'a']--;
        for(int i : letters)
            if(i != 0)
                return false;
        return true;
    }

    public boolean isAnagram1(String s, String t) {
        if(s.length()!= t.length())
        {
            return false;
        }
        char[] sCh = s.toCharArray();
        char[] tCh = t.toCharArray();
        Arrays.sort(sCh);
        Arrays.sort(tCh);
        for(int i = 0;i<s.length();i++)
        {
            if(sCh[i]!=tCh[i])
                return false;
        }
        return true;
    }

    public boolean isAnagram12(String s, String t) {
        int lenS = s.length(), lenT = t.length();
        if(lenS != lenT)
            return false;
        // s and t consist of lowercase English letters.
        int[] arrS = new int[26];
        int[] arrT = new int[26];

        for(int i = 0; i< lenS; i++)
        {
            arrS[s.charAt(i)-'a']++;
            arrT[t.charAt(i)-'a']++;
        }
        return Arrays.equals(arrS,arrT);
    }

    // if you need to use a Map for a more complicated problem, you can use String as a pattern see 49. Group Anagrams
    public boolean isAnagram2(String s, String t) {
        if(s.length() != t.length())
            return false;
        char[] sa = s.toCharArray();
        char[] ta = t.toCharArray();
        Arrays.sort(sa);
        Arrays.sort(ta);
        String ss = String.valueOf(sa);
        String ts = String.valueOf(ta);

        return ss.equals(ts);
    }

    // looks like it works, but what if s = "aa", t = "bb"
    // or "ac" and "bb"
    public boolean isAnagram_fail(String s, String t) {
        int lenS = s.length(), lenT = t.length();
        if(lenS != lenT)
            return false;
        int a = 0;
        for(char c: s.toCharArray())
            a=a^c;
        for(char c: t.toCharArray())
            a=a^c;
        return a ==0;
    }


}
