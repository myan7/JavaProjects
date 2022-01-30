package com.myjobhunting;

//https://leetcode.com/problems/valid-anagram/

import java.util.Arrays;

public class EASY_242_ValidAnagram {

    // the idea is to check the frequencies of each char in both strings
    public boolean isAnagram(String s, String t) {
        int lenS = s.length(), lenT = t.length();
        if(lenS != lenT)
            return false;
        // s and t consist of lowercase English letters.
        int[] alphabet = new int[26];
        for(int i = 0; i< lenS; i++)
        {
            alphabet[s.charAt(i)-'a']++;
            alphabet[t.charAt(i)-'a']--;
        }
        for(int i : alphabet)
        {
            if(i != 0)
                return false;
        }
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

    // looks like it works, but what if s = "aa", t = "bb"
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
