package com.myjobhunting;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

// https://leetcode.com/problems/to-lower-case/
/*
Given a string s, return the string after replacing every uppercase letter with the same lowercase letter.

Example 1:
Input: s = "Hello"
Output: "hello"

Example 2:
Input: s = "here"
Output: "here"

Example 3:
Input: s = "LOVELY"
Output: "lovely"

Constraints:
1 <= s.length <= 100
s consists of printable ASCII characters.
 */
public class EASY_709_ToLowerCase {

    /*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for To Lower Case.
    Memory Usage: 40.5 MB, less than 64.45% of Java online submissions for To Lower Case.
     */
    public String toLowerCase20220314(String s) {
        char[] chArr = s.toCharArray();
        for(int i = 0 ; i< s.length() ;i++)
        {
            char curr = s.charAt(i);
            if(curr >= 'A' && curr <= 'Z')
                chArr[i] = (char)('a' + curr-'A');
            else
                chArr[i] = curr;
        }
        return String.valueOf(chArr);
    }
    /*
    Runtime: 1 ms, faster than 72.64% of Java online submissions for To Lower Case.
    Memory Usage: 42.2 MB, less than 36.88% of Java online submissions for To Lower Case.
     */
    public String toLowerCase(String s) {
        char[] sArr = s.toCharArray();
        for(int i = 0; i < s.length(); i++)
        {
            if(sArr[i] >= 'A' && sArr[i] <= 'Z')
                sArr[i] += Math.abs('A'-'a');
        }
        return String.valueOf(sArr);
    }

    /*
    Runtime: 2 ms, faster than 20.52% of Java online submissions for To Lower Case.
    Memory Usage: 42.3 MB, less than 30.57% of Java online submissions for To Lower Case.
     */
    public String toLowerCase2(String s)
    {
        String caps = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lows = "abcdefghijklmnopqrstuvwxyz";
        Map<Character, Character> map = new HashMap<>();
        for(int i = 0; i < 26; i++)
        {
            map.put(caps.charAt(i), lows.charAt(i));
        }
        char[] ans = s.toCharArray();
        for(int i = 0; i < s.length(); i++)
        {
            ans[i] = map.getOrDefault(ans[i],ans[i]);
        }
        return String.valueOf(ans);
    }

    public String toLowerCase1(String s)
    {
        return s.toLowerCase();
    }
}
