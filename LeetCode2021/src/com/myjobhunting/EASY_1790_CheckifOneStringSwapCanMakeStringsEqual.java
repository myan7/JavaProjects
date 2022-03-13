package com.myjobhunting;
// https://leetcode.com/problems/check-if-one-string-swap-can-make-strings-equal/

/*
You are given two strings s1 and s2 of equal length.
A string swap is an operation where you choose two indices in a string (not necessarily different) and swap the characters at these indices.

Return true if it is possible to make both strings equal by performing at most one string swap on exactly one of the strings.
Otherwise, return false.

Example 1:
Input: s1 = "bank", s2 = "kanb"
Output: true
Explanation: For example, swap the first character with the last character of s2 to make "bank".

Example 2:
Input: s1 = "attack", s2 = "defend"
Output: false
Explanation: It is impossible to make them equal with one string swap.

Example 3:
Input: s1 = "kelb", s2 = "kelb"
Output: true
Explanation: The two strings are already equal, so no string swap operation is required.

Constraints:
1 <= s1.length, s2.length <= 100
s1.length == s2.length
s1 and s2 consist of only lowercase English letters.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EASY_1790_CheckifOneStringSwapCanMakeStringsEqual {

    public boolean areAlmostEqual(String s1, String s2) {
        int[] s1Array = new int[26];
        int[] s2Array = new int[26];
        int counter = 0;
        for(int i = 0;i<s1.length();i++){
            char s = s1.charAt(i);
            char ss = s2.charAt(i);
            if(s != ss)
                counter++;
            if(counter > 2)
                return false;
            s1Array[s -'a']++;
            s2Array[ss -'a']++;
        }
        return Arrays.equals(s1Array, s2Array);
    }

    /* initial solution upgraded version
    Runtime: 1 ms, faster than 80.55% of Java online submissions for Check if One String Swap Can Make Strings Equal.
    Memory Usage: 42.2 MB, less than 39.21% of Java online submissions for Check if One String Swap Can Make
     */
    public boolean areAlmostEqual1(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        if(len1 != len2) return false;
        if(s1.equals(s2)) return true;

        int[] letters = new int[26];
        for(char c : s1.toCharArray())
            letters[c-'a']++;
        for(char c : s2.toCharArray())
        {
            letters[c-'a']--;
            if(letters[c-'a'] < 0)
                return false;
        }
        int left = 0, right = len1-1, count = 0;
        while(left <= right)
        {
            if(s1.charAt(left) != s2.charAt(left))
                count++;
            left++;
            if(count > 2)
                return false;
        }

        return true;
    }



    /* initial solution
    Runtime: 1 ms, faster than 80.55% of Java online submissions for Check if One String Swap Can Make Strings Equal.
    Memory Usage: 42.2 MB, less than 39.21% of Java online submissions for Check if One String Swap Can Make
     */
    public boolean areAlmostEqual0(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        if(len1 != len2) return false;
        if(s1.equals(s2)) return true;

        int[] letters1 = new int[26];
        int[] letters2 = new int[26];
        for(char c : s1.toCharArray())
            letters1[c-'a']++;
        for(char c : s2.toCharArray())
            letters2[c-'a']++;
        if(!Arrays.equals(letters1,letters2))
            return false;
        else
        {
            int left = 0, right = len1-1, count = 0;
            while(left <= right)
            {
                if(s1.charAt(left) != s2.charAt(left))
                    count++;
                left++;
                if(count > 2)
                    return false;
            }
        }
        return true;
    }

    public boolean areAlmostEqual2(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();

        int left = 0, right = len1-1;
        List<Integer> diffs = new ArrayList<>();
        while(left <= right)
        {
            if(s1.charAt(left) != s2.charAt(left))
            {
                diffs.add(left);
            }
            left++;
            if(diffs.size() > 2)
                return false;
        }
        return diffs.size() == 0 || (diffs.size() == 2 &&
                (s1.charAt(diffs.get(0)) == s2.charAt(diffs.get(1))) &&
                (s1.charAt(diffs.get(1)) == s2.charAt(diffs.get(0))));
    }
}
