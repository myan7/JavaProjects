package com.myjobhunting;
// https://leetcode.com/problems/longest-palindromic-substring/

/*
Given a string s, return the longest palindromic substring in s.

Example 1:
Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.

Example 2:
Input: s = "cbbd"
Output: "bb"

Constraints:
1 <= s.length <= 1000
s consist of only digits and English letters.
 */

public class MEDIUM_005_LongestPalindromicSubstring {

    // Runtime: 24 ms, faster than 91.00% of Java online submissions
    public String longestPalindrome1(String s) {
        if(s.length() == 0 || s == null)
            return "";
        String ans = "";
        for(int i = 0; i < s.length(); i++)
        {
            String even = helper1(s,i,i+1); // this is for even number of length
            String odd = helper1(s,i,i);         // this is for odd number of length
            ans = even.length()> ans.length()? even:odd.length()>ans.length()? odd:ans;
        }
        return ans;
    }

    private String helper1(String s, int left, int right)
    {
        int len = s.length();
        while(left >= 0 && right < len && s.charAt(left) == s.charAt(right))
        {
            left--;
            right++;
        }
        return s.substring(left+1, right);
    }

    // Runtime: 31 ms, faster than 82.02% of Java online submissions
    public String longestPalindrome_solution(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }



    // stupid solution Runtime: 614 ms, faster than 14.03% of Java online submissions
    public String longestPalindrome0(String s) {
        if(s.length() == 0 || s == null)
            return "";
        String ans = "";
        for(int i = 0; i < s.length(); i++)
        {
            String even = helper0(s,i,i+1);
            String odd = helper0(s,i,i);
            ans = even.length()> ans.length()? even:odd.length()>ans.length()? odd:ans;
        }
        return ans;
    }

    private String helper0(String s, int left, int right)
    {
        int len = s.length();
        while(left >= 0 && right < len && s.charAt(left) == s.charAt(right))
        {
            left--;
            right++;
        }
        return s.substring(left, right+1);
    }
}
