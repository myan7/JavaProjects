package com.myjobhunting;
// https://leetcode.com/problems/replace-the-substring-for-balanced-string/

/*
You are given a string s of length n containing only four kinds of characters: 'Q', 'W', 'E', and 'R'.
A string is said to be balanced if each of its characters appears n / 4 times, where n is the length of the string.
Return the minimum length of the substring that can be replaced with any other string of the same length to make s balanced.
If s is already balanced, return 0.



Example 1:
Input: s = "QWER"
Output: 0
Explanation: s is already balanced.

Example 2:
Input: s = "QQWE"
Output: 1
Explanation: We need to replace a 'Q' to 'R', so that "RQWE" (or "QRWE") is balanced.

Example 3:
Input: s = "QQQW"
Output: 2
Explanation: We can replace the first "QQ" to "ER".

Constraints:

n == s.length
4 <= n <= 105
n is a multiple of 4.
s contains only 'Q', 'W', 'E', and 'R'.
 */
public class MEDIUM_1234_ReplacetheSubstringforBalancedString {

    /*
    Runtime: 4 ms, faster than 100.00% of Java online submissions for Replace the Substring for Balanced String.
    Memory Usage: 42.1 MB, less than 77.91% of Java online submissions for Replace the Substring for Balanced String.
    charArray is faster than s.charAt()
     */
    public int balancedString(String s) {
        if(s.length() % 4 != 0) return 0;
        int len = s.length();
        int need = len/ 4;
        char[] input = s.toCharArray();
        int[] freq = new int[26];
        for(int i = 0; i < len; i++)
            freq[input[i] - 'A']++;
        if(freq[0]==need && freq[1]==need && freq[2]==need && freq[3]==need )
            return 0;

        int left = 0, right = 0, minWindowSize = s.length();
        while(right < len){
            freq[input[right] - 'A']--;
            while(freq['Q'-'A'] <= need && freq['W'-'A'] <= need && freq['E'-'A'] <= need && freq['R'-'A'] <= need && left < len){
                int currentWindowSize = right - left + 1;
                minWindowSize = Math.min(minWindowSize, currentWindowSize);
                freq[input[left++] - 'A']++;
            }
            right++;
        }
        return minWindowSize;
    }
    /*
    Runtime: 17 ms, faster than 40.70% of Java online submissions for Replace the Substring for Balanced String.
    Memory Usage: 44.7 MB, less than 23.64% of Java online submissions for Replace the Substring for Balanced String.
     */
    public int balancedString0(String s) {
        int len = s.length();
        int need = len/4;
        int[] freq = new int[4];
        for(char c : s.toCharArray())
            freq[getIndex(c)]++;
        if(freq[0] == need && freq[1] == need && freq[2] == need && freq[3] == need)
            return 0;

        int left = 0, right = 0, min = len;
        while(right < len)
        {
            char r = s.charAt(right);
            freq[getIndex(r)]--;
            while(left < len && freq[0] <= need && freq[1] <= need && freq[2] <= need && freq[3] <= need)
            {
                char l = s.charAt(left);
                int currWindow = right - left + 1;
                min = Math.min(currWindow, min);
                freq[getIndex(l)]++;
                left++;
            }
            right++;
        }
        return min;
    }

    private int getIndex(char c)
    {
        switch(c){
            case 'Q':return 0;
            case 'W':return 1;
            case 'E':return 2;
        }
        return 3;
    }
}
