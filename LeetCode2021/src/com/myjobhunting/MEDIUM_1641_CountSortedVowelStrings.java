package com.myjobhunting;
// https://leetcode.com/problems/count-sorted-vowel-strings/

/*
Given an integer n, return the number of strings of length n that consist only of vowels (a, e, i, o, u) and are lexicographically sorted.
A string s is lexicographically sorted if for all valid i, s[i] is the same as or comes before s[i+1] in the alphabet.

Example 1:
Input: n = 1
Output: 5
Explanation: The 5 sorted strings that consist of vowels only are ["a","e","i","o","u"].

Example 2:
Input: n = 2
Output: 15
Explanation: The 15 sorted strings that consist of vowels only are
["aa","ae","ai","ao","au","ee","ei","eo","eu","ii","io","iu","oo","ou","uu"].
Note that "ea" is not a valid string since 'e' comes after 'a' in the alphabet.

Example 3:
Input: n = 33
Output: 66045

Constraints:
1 <= n <= 50
 */
public class MEDIUM_1641_CountSortedVowelStrings {

    /*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Count Sorted Vowel Strings.
    Memory Usage: 40.9 MB, less than 50.57% of Java online submissions for Count Sorted Vowel Strings.
    O(1)
    Now we have n characters, we are going to insert 4 l inside.
    We can add in the front, in the middle and in the end.
    How many ways do we have?
    For the 1st l, we have n+1 position to insert.
    For the 2nd l, we have n+2 position to insert.
    For the 3rd l, we have n+3 position to insert.
    For the 4th l, we have n+4 position to insert.
    Also, 4 l are the same,
    there are (n + 1) * (n + 2) * (n + 3) * (n + 4) / 4! ways.

    The character before the 1st l, we set to a.
    The character before the 2nd l, we set to e.
    The character before the 3rd l, we set to i.
    The character before the 4th l, we set to o.
    The character before the 5th l, we set to u.

    We get the one result for the original problem.
     */
    public int countVowelStrings(int n) {
        return (n + 4) * (n + 3) * (n + 2) * (n + 1) / 24;
    }

    /*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Count Sorted Vowel Strings.
    Memory Usage: 41.2 MB, less than 29.06% of Java online submissions for Count Sorted Vowel Strings.
     */
    public int countVowelStringsDP(int n) {
        int[][] dp = new int[n + 1][6];
        for (int i = 1; i <= n; ++i)
            for (int k = 1; k <= 5; ++k)
                dp[i][k] = dp[i][k - 1] + (i > 1 ? dp[i - 1][k] : 1);
        return dp[n][5];
    }

    /*
    Runtime: 8 ms, faster than 19.57% of Java online submissions for Count Sorted Vowel Strings.
    Memory Usage: 41.5 MB, less than 11.21% of Java online submissions for Count Sorted Vowel Strings.
     */
    public int countVowelStringsREC(int n) {
        return countVowelStringUtil(n, 5);
    }

    private int countVowelStringUtil(int n, int vowels) {
        if (n == 1)
            return vowels;
        if (vowels == 1)
            return 1;
        return countVowelStringUtil(n - 1, vowels) +
                countVowelStringUtil(n, vowels - 1);
    }
}
