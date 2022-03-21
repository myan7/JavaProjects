package com.myjobhunting;
// https://leetcode.com/problems/repeated-substring-pattern/

/*
Given a string s,
check if it can be constructed by taking a substring of it and appending multiple copies of the substring together.

Example 1:
Input: s = "abab"
Output: true
Explanation: It is the substring "ab" twice.

Example 2:
Input: s = "aba"
Output: false
Example 3:

Input: s = "abcabcabcabc"
Output: true
Explanation: It is the substring "abc" four times or the substring "abcabc" twice.

Constraints:
1 <= s.length <= 10^4
s consists of lowercase English letters.

 */
public class EASY_459_RepeatedSubstringPattern {

    /* KMP Knuth-Morris-Pratt algorithm.
    check LC 28 strStr
    for KMP https://www.youtube.com/watch?v=V5-7GzOfADQ&ab_channel=AbdulBari
    Runtime: 8 ms, faster than 92.06% of Java online submissions for Repeated Substring Pattern.
    Memory Usage: 50.6 MB, less than 47.38% of Java online submissions for Repeated Substring Pattern.
     */
    public boolean repeatedSubstringPattern(String s) {
        //This is the kmp issue
        int[] prefix = kmp(s);
        int len = prefix[s.length()-1];
        int n = s.length();
        return (len > 0 && n%(n-len) == 0);
    }
    private int[] kmp(String s){
        int len = s.length();
        int[] res = new int[len];
        char[] ch = s.toCharArray();
        int i = 0, j = 1;
        res[0] = 0;
        while(i < ch.length && j < ch.length){
            if(ch[j] == ch[i]){
                res[j] = i+1;
                i++;
                j++;
            }else{
                if(i == 0){
                    res[j] = 0;
                    j++;
                }else{
                    i = res[i-1];
                }
            }
        }
        return res;
    }
}
