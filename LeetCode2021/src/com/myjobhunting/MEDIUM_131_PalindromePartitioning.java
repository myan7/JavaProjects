package com.myjobhunting;

// https://leetcode.com/problems/palindrome-partitioning/

import java.util.ArrayList;
import java.util.List;

/*
Given a string, s, partition s such that every substring of the partition is a palindrome.
Return all possible palindrome partitioning of s.

A palindrome string is a string that reads the same backward as forward.

Example 1:
Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]

Example 2:
Input: s = "a"
Output: [["a"]]

Constraints:
1 <= s.length <= 16
s contains only lowercase English letters.
 */
public class MEDIUM_131_PalindromePartitioning {

    /*
    Runtime: 31 ms, faster than 13.43% of Java online submissions for Palindrome Partitioning.
    Memory Usage: 190.4 MB, less than 55.70% of Java online submissions for Palindrome Partitioning.
     */
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        dfsHelper(s,0 ,ans,new ArrayList<String>());
        return ans;
    }

    private void dfsHelper(String s, int start, List<List<String>> ans, List<String> valid){
        if(start >= s.length())
            ans.add(new ArrayList<>(valid));
        for(int end = start; end < s.length(); end++)
        {
            if(isPalindrome(s,start,end))
            {
                valid.add(s.substring(start,end+1));
                dfsHelper(s, end+1, ans,valid);
                valid.remove(valid.size()-1);
            }
        }
    }

    private boolean isPalindrome(String str, int left, int right)
    {
        while(left < right)
        {
            if(str.charAt(left++) != str.charAt(right--))
                return false;
        }
        return true;
    }

    /*
    Wrong answer,
    "aab" should return [["a","a","b"],["aa","b"]]
    while I returned [["a","aa"],["a"],["b"]]
     */
    public List<List<String>> partitionWrong(String s) {
        List<List<String>> ans = new ArrayList<>();

        for(int i = 0; i < s.length(); i++)
        {
            List<String> valid = new ArrayList<>();
            for(int j = i+1; j <= s.length(); j++)
            {
                if(isPalindrome(s.substring(i,j)))
                {
                    valid.add(s.substring(i,j));
                }
            }
            ans.add(valid);
        }
        return ans;
    }

    private boolean isPalindrome(String str)
    {
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString().equals(str);
    }
}
