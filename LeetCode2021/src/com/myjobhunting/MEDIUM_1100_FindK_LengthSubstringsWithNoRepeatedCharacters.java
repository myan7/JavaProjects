package com.myjobhunting;
// https://leetcode.com/problems/find-k-length-substrings-with-no-repeated-characters/
/*
Given a string s and an integer k,
return the number of substrings in s of length k with no repeated characters.

Example 1:
Input: s = "havefunonleetcode", k = 5
Output: 6
Explanation: There are 6 substrings they are: 'havef','avefu','vefun','efuno','etcod','tcode'.

Example 2:
Input: s = "home", k = 5
Output: 0
Explanation: Notice k can be larger than the length of s. In this case, it is not possible to find any substring.

Constraints:
1 <= s.length <= 104
s consists of lowercase English letters.
1 <= k <= 104
 */
public class MEDIUM_1100_FindK_LengthSubstringsWithNoRepeatedCharacters {

    // initial solution Runtime: 2 ms, faster than 99.95% of Java online submissions
    public int numKLenSubstrNoRepeats0(String s, int k) {

        int[] map = new int[26];
        if(s.length() < k )
            return 0;
        for(int i = 0; i < k ; i++)
        {
            map[s.charAt(i) - 'a']++;
        }
        int count = 0;

        for(int i = k ; i <= s.length(); i++)
        {
            int j;
            for( j = 0; j < 26; j ++)
            {
                if(map[j] > 1)
                    break;
            }
            if(j == 26)
                count++;
            if(i < s.length())
            {
                map[s.charAt(i-k)-'a']--;
                map[s.charAt(i)-'a']++;
            }
        }
        return count;
    }
}
