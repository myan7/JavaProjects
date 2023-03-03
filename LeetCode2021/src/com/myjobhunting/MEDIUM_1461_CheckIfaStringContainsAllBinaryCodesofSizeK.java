package com.myjobhunting;

// https://leetcode.com/problems/check-if-a-string-contains-all-binary-codes-of-size-k/

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
Given a binary string s and an integer k, return true if every binary code of length k is a substring of s. Otherwise, return false.

Example 1:
Input: s = "00110110", k = 2
Output: true
Explanation: The binary codes of length 2 are "00", "01", "10" and "11". They can be all found as substrings at indices 0, 1, 3 and 2 respectively.

Example 2:
Input: s = "0110", k = 1
Output: true
Explanation: The binary codes of length 1 are "0" and "1", it is clear that both exist as a substring.

Example 3:
Input: s = "0110", k = 2
Output: false
Explanation: The binary code "00" is of length 2 and does not exist in the array.

Constraints:
1 <= s.length <= 5 * 10^5
s[i] is either '0' or '1'.
1 <= k <= 20
 */
public class MEDIUM_1461_CheckIfaStringContainsAllBinaryCodesofSizeK {

    /*
    Runtime: 208 ms, faster than 42.71% of Java online submissions for Check If a String Contains All Binary Codes of Size K.
    Memory Usage: 96.5 MB, less than 39.58% of Java online submissions for Check If a String Contains All Binary Codes of Size K.

     */
    public boolean hasAllCodes0(String s, int k) {
        Set<String> seen = new HashSet<>();
        for (int i = k; i <= s.length() && seen.size() < 1 << k; ++i) {
            seen.add(s.substring(i - k, i));
        }
        return seen.size() == 1 << k;
    }

    /*
    Runtime: 248 ms, faster than 27.61% of Java online submissions for Check If a String Contains All Binary Codes of Size K.
    Memory Usage: 98.5 MB, less than 35.94% of Java online submissions for Check If a String Contains All Binary Codes of Size K.
     */
    public boolean hasAllCodes1(String s, int k) {
        int need = 1 << k;
        Set<String> got = new HashSet<String>();

        for (int i = k; i <= s.length(); i++) {
            String a = s.substring(i - k, i);
            if (!got.contains(a)) {
                got.add(a);
                need--;
                // return true when found all occurrences
                if (need == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    // TLE
    public boolean hasAllCodes_original(String s, int k) {
        Map<Integer, String> map = new HashMap<>();
        StringBuilder format = new StringBuilder("%"+(int)Math.pow(2,k)+"d");
        for(int i = 0; i < (int)Math.pow(2,k); i++)
        {
            map.put(i,String.format("%1$"+k+"s", Integer.toBinaryString(i)).replace(' ','0'));
        }

        for(Integer key : map.keySet())
        {
            if(s.indexOf(map.get(key)) == -1)
                return false;
        }
        return true;
    }

}
