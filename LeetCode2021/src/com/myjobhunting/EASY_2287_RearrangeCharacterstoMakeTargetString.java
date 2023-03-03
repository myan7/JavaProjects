package com.myjobhunting;
// https://leetcode.com/problems/rearrange-characters-to-make-target-string/

/*
You are given two 0-indexed strings s and target. You can take some letters from s and rearrange them to form new strings.

Return the maximum number of copies of target that can be formed by taking letters from s and rearranging them.



Example 1:
Input: s = "ilovecodingonleetcode", target = "code"
Output: 2
Explanation:
For the first copy of "code", take the letters at indices 4, 5, 6, and 7.
For the second copy of "code", take the letters at indices 17, 18, 19, and 20.
The strings that are formed are "ecod" and "code" which can both be rearranged into "code".
We can make at most two copies of "code", so we return 2.

Example 2:
Input: s = "abcba", target = "abc"
Output: 1
Explanation:
We can make one copy of "abc" by taking the letters at indices 0, 1, and 2.
We can make at most one copy of "abc", so we return 1.
Note that while there is an extra 'a' and 'b' at indices 3 and 4, we cannot reuse the letter 'c' at index 2, so we cannot make a second copy of "abc".

Example 3:
Input: s = "abbaccaddaeea", target = "aaaaa"
Output: 1
Explanation:
We can make one copy of "aaaaa" by taking the letters at indices 0, 3, 6, 9, and 12.
We can make at most one copy of "aaaaa", so we return 1.

Constraints:
1 <= s.length <= 100
1 <= target.length <= 10
s and target consist of lowercase English letters.
 */
public class EASY_2287_RearrangeCharacterstoMakeTargetString {

    /*
    Runtime: 1 ms, faster than 100.00% of Java online submissions for Rearrange Characters to Make Target String.
    Memory Usage: 42.4 MB, less than 50.00% of Java online submissions for Rearrange Characters to Make Target String.
     */
    public int rearrangeCharacters(String s, String target) {
        int[] letters = new int[26];
        for(char c: s.toCharArray())
            letters[c-'a']++;
        int times = 0;
        while(true)
        {
            for(char c : target.toCharArray())
            {
                if(letters[c-'a'] > 0)
                    letters[c-'a']--;
                else
                    return times;
            }
            times++;
        }
    }

    /*
    Runtime: 1 ms, faster than 100.00% of Java online submissions for Rearrange Characters to Make Target String.
    Memory Usage: 42.1 MB, less than 50.00% of Java online submissions for Rearrange Characters to Make Target String.
     */
    public int rearrangeCharacters2(String s, String target) {
        int[] freq = new int[26];
        int[] freq2 = new int[26];
        for(char ch : s.toCharArray())
            freq[ch-'a']++;
        for(char ch : target.toCharArray())
            freq2[ch-'a']++;

        int min = Integer.MAX_VALUE;
        for(char ch : target.toCharArray())
            min = Math.min(min,freq[ch-'a']/freq2[ch-'a']);

        return min;
    }
}
