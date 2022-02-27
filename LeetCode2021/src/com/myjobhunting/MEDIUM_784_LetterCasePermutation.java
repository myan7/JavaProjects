package com.myjobhunting;

// https://leetcode.com/problems/letter-case-permutation/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Given a string s, you can transform every letter individually to be lowercase or uppercase to create another string.
Return a list of all possible strings we could create. Return the output in any order.

Example 1:
Input: s = "a1b2"
Output: ["a1b2","a1B2","A1b2","A1B2"]

Example 2:
Input: s = "3z4"
Output: ["3z4","3Z4"]

Constraints:
1 <= s.length <= 12
s consists of lowercase English letters, uppercase English letters, and digits.

 */
public class MEDIUM_784_LetterCasePermutation {

    /*
    Approach 3 : DFS
    Runtime: 3 ms, faster than 86.12% of Java online submissions
     */
    public List<String> letterCasePermutation(String s)
    {
        if(s == null)
            return new LinkedList<>();

        List<String> res = new LinkedList<>();
        helper(s.toCharArray(), res, 0);
        return res;
    }
    private void helper(char[] chs, List<String> res, int pos)
    {
        if(pos == chs.length)
        {
            res.add(new String(chs));
            return;
        }
        if(Character.isDigit(chs[pos]))
        {
            helper(chs,res,pos+1);
            return;
        }
        chs[pos] = Character.toLowerCase(chs[pos]);
        helper(chs,res,pos+1);
        chs[pos] = Character.toUpperCase(chs[pos]);
        helper(chs,res,pos+1);
    }


    /*
    Approach 2: BFS
    13 ms
    like permutation
    for example
    abc
    abc Abc                     - 0
    abc aBc Abc ABc             - 1
    abc aBc aBC Abc ABc ABC     - 2
     */
    public List<String> letterCasePermutation1(String s) {
        if(s == null)
            return new LinkedList<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(s);

        for(int i = 0; i < s.length(); i++)
        {
            if(!Character.isLetter(s.charAt(i)))
                continue;
            int size = queue.size();
            for(int j = 0; j < size; j++)
            {
                String curr = queue.poll();
                char[] chs = curr.toCharArray();

                chs[i] = Character.toUpperCase(chs[i]);
                queue.offer(String.valueOf(chs));

                chs[i] = Character.toLowerCase(chs[i]);
                queue.offer(String.valueOf(chs));
            }
        }
        return new LinkedList<>(queue);
    }


    /*
    Approach 1 recursion
    12 ms
    the algorithm is everytime I saw a character, I am going to double the size of the answer by adding a new existing string to the list
    // and add the lower case character to the first string, then upper case to the second string
    Maintain the correct answer as we increase the size of the prefix of S we are considering.

    For example, when S = "abc",
    maintain ans = [""],
    and update it to
    ans = ["a", "A"],
    ans = ["ab", "Ab", "aB", "AB"],
    ans = ["abc", "Abc", "aBc", "ABc", "abC", "AbC", "aBC", "ABC"] as we consider the letters "a", "b", "c".

    For example: a1b2
    [a,A]
    [a1,A1]
    [a1b, A1b, a1B, A1B]
    [a1b2, A1b2, a1B2,A1B2]
     */

    /*
    Time Complexity: O(2^{N} * N). where N is the length of S. This reflects the cost of writing the answer.
    Space Complexity: O(2^{N} * N).
     */
    public List<String> letterCasePermutation0(String s) {
        List<StringBuilder> ans = new ArrayList<>();
        ans.add(new StringBuilder()); // initialize the ans, or it will be 0.
        for(char c : s.toCharArray())
        {
            int n = ans.size();
            if(Character.isLetter(c)) // if the current character is a letter
            {
                for(int i = 0; i < n ; i++)
                {
                    ans.add(new StringBuilder(ans.get(i))); // looping through ans, duplicate current item
                    ans.get(i).append(Character.toLowerCase(c)); // add lower case to the first occurrence.
                    ans.get(i+n).append(Character.toUpperCase(c)); // add upper case to the second occurrence.
                }
            }
            else // else, if the current character is not a letter
            {
                for(int i = 0; i < n; i++)
                {
                    ans.get(i).append(c);
                }
            }
        }

        List<String> finalans = new ArrayList<>();
        for(StringBuilder sb : ans)
        {
            finalans.add(sb.toString());
        }

        return finalans;
    }
}
