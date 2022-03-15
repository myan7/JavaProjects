package com.myjobhunting;

// https://leetcode.com/problems/merge-strings-alternately/
/*
You are given two strings word1 and word2.
Merge the strings by adding letters in alternating order, starting with word1.
If a string is longer than the other, append the additional letters onto the end of the merged string.
Return the merged string.

Example 1:
Input: word1 = "abc", word2 = "pqr"
Output: "apbqcr"
Explanation: The merged string will be merged as so:
word1:  a   b   c
word2:    p   q   r
merged: a p b q c r

Example 2:
Input: word1 = "ab", word2 = "pqrs"
Output: "apbqrs"
Explanation: Notice that as word2 is longer, "rs" is appended to the end.
word1:  a   b
word2:    p   q   r   s
merged: a p b q   r   s

Example 3:
Input: word1 = "abcd", word2 = "pq"
Output: "apbqcd"
Explanation: Notice that as word1 is longer, "cd" is appended to the end.
word1:  a   b   c   d
word2:    p   q
merged: a p b q c   d

Constraints:
1 <= word1.length, word2.length <= 100
word1 and word2 consist of lowercase English letters.
 */

public class EASY_1768_MergeStringsAlternately {

    /*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Merge Strings Alternately.
    Memory Usage: 42.5 MB, less than 32.57% of Java online submissions for Merge Strings Alternately.
     */
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int len1 = word1.length();
        int len2 = word2.length();
        int len = len1 > len2 ? len2 : len1;
        int i = 0;
        for(; i < len; i++)
        {
            sb.append(word1.charAt(i)).append(word2.charAt(i));
        }
        if( i == len1)
            sb.append(word2.substring(i,len2));
        else
            sb.append(word1.substring(i,len1));
        return sb.toString();
    }

    public String mergeAlternately0(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int len1 = word1.length();
        int len2 = word2.length();

        int index1 = 0, index2 = 0;
        while(index1 < len1 || index2 < len2)
        {
            char w1 = index1 >= len1? ' ': word1.charAt(index1);
            char w2 = index2 >= len2? ' ': word2.charAt(index2);
            if( w1 == ' ')
                sb.append(w2);
            else if( w2 == ' ')
                sb.append(w1);
            else
                sb.append(w1).append(w2);
            index1++;
            index2++;
        }
        return sb.toString();
    }
}
