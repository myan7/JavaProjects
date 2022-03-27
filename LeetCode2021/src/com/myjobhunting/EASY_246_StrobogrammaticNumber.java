package com.myjobhunting;

// https://leetcode.com/problems/strobogrammatic-number/

import java.util.HashMap;
import java.util.Map;

/*
Given a string num which represents an integer, return true if num is a strobogrammatic number.

A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

Example 1:
Input: num = "69"
Output: true

Example 2:
Input: num = "88"
Output: true

Example 3:
Input: num = "962"
Output: false

Constraints:
1 <= num.length <= 50
num consists of only digits.
num does not contain any leading zeros except for zero itself.
 */
public class EASY_246_StrobogrammaticNumber {

    /*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Strobogrammatic Number.
    Memory Usage: 40 MB, less than 83.36% of Java online submissions for Strobogrammatic Number.
     */
    public boolean isStrobogrammatic(String num) {
        // In Java, we need to put '\0' to represent an empty character
        char[] rotatedDigits = new char[]{'0', '1', '\0', '\0', '\0', '\0', '9', '\0', '8', '6'};

        StringBuilder rotatedStringBuilder = new StringBuilder();

        // Remember that we want to loop backwards through the string
        for (int i = num.length() - 1; i >= 0; i--) {
            char c = num.charAt(i);
            int charIndex = Character.getNumericValue(c);
            rotatedStringBuilder.append(rotatedDigits[charIndex]);
        }

        String rotatedString = rotatedStringBuilder.toString();
        return num.equals(rotatedString);
    }

    /*
    Runtime: 1 ms, faster than 40.74% of Java online submissions for Strobogrammatic Number.
    Memory Usage: 42 MB, less than 31.00% of Java online submissions for Strobogrammatic Number.
     */
    public boolean isStrobogrammatic0(String num) {
        /*
        Map<Character, Character> map = new HashMap<>();
        map.put('6','9');
        map.put('9','6');
        map.put('1','1');
        map.put('8','8');
        map.put('0','0');
        */
        Map<Character, Character> map = new HashMap<> (
                Map.of('0', '0', '1', '1', '6', '9', '8', '8', '9', '6'));
        StringBuilder sb = new StringBuilder();
        for(char c : num.toCharArray())
        {
            if(map.containsKey(c))
                sb.insert(0,map.get(c));
            else
                return false;
        }
        return sb.toString().equals(num);
    }

}
