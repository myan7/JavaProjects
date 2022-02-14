package com.practice;
//https://algo.monster/problems/lexicographically_smallest_string
/*
Given a string str,
the task is to find the lexicographically smallest string
that can be formed by removing at most one character from the given string.

Example 1:
Input: abczd
Output: abcd

Example 2:
Input: abcda
Output: abca
Explanation:
One can remove d to get abca which is the lexicographically smallest string possible.

 */
public class MS_OA_004_LexcicographicallySmallestString {
    public String smallestString(String s) {
        int pos = 0;
        for(int i = 0; i < s.length(); i++)
        {
            if(s.charAt(pos) < s.charAt(i))
                pos = i;
        }
        return s.substring(0,pos)+s.substring(pos+1);
    }
}
