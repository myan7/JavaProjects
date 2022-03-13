package com.myjobhunting;
// https://leetcode.com/problems/decrypt-string-from-alphabet-to-integer-mapping/

import java.util.HashMap;
import java.util.Map;

/*
You are given a string s formed by digits and '#'.
We want to map s to English lowercase characters as follows:

Characters ('a' to 'i') are represented by ('1' to '9') respectively.
Characters ('j' to 'z') are represented by ('10#' to '26#') respectively.
Return the string formed after mapping.
The test cases are generated so that a unique mapping will always exist.

Example 1:
Input: s = "10#11#12"
Output: "jkab"
Explanation: "j" -> "10#" , "k" -> "11#" , "a" -> "1" , "b" -> "2".

Example 2:
Input: s = "1326#"
Output: "acz"

Constraints:
1 <= s.length <= 1000
s consists of digits and the '#' letter.
s will be a valid string such that mapping is always possible.
 */
public class EASY_1309_DecryptStringfromAlphabettoIntegerMapping {

    /*
    Runtime: 1 ms, faster than 84.72% of Java online submissions for Decrypt String from Alphabet to Integer Mapping.
    Memory Usage: 40.2 MB, less than 78.02% of Java online submissions for Decrypt String from Alphabet to Integer Mapping.
     */
    public String freqAlphabets(String s) {
        int i = 1;
        char ch = 'a';
        Map<String, String> map = new HashMap<>();
        while(i <= 26)
        {
            StringBuilder sb = new StringBuilder();
            map.put(sb.append(i).toString(), String.valueOf(ch));
            i++;
            ch++;
        }
        StringBuilder ans = new StringBuilder();
        for(int j = s.length()-1; j >= 0;j-- )
        {
            char curr = s.charAt(j);
            if(curr == '#')
            {
                ans.insert(0,map.get(s.substring(j-2,j)));
                j = j-2;
            }
            else
                ans.insert(0,map.get(String.valueOf(curr)));
        }
        return ans.toString();
    }

    public String freqAlphabets1(String s) {
        StringBuilder sb = new StringBuilder();
        int size = s.length();
        for(int i=0; i< size;i++){
            if(i+2 < size && s.charAt(i+2) == '#'){
                sb.append((char) ((Integer.parseInt(s.substring(i, i+2)) - 1)+ 'a') );
                i=i+2;
            }
            else
                sb.append( (char) ( (Integer.parseInt(String.valueOf(s.charAt(i))) - 1) + 'a') );
        }
        return sb.toString();
    }
}
