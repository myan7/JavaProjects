package com.myjobhunting;
// https://leetcode.com/problems/maximum-product-of-word-lengths/

/*
Given a string array words, return the maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters.
If no such two words exist, return 0.


Example 1:

Input: words = ["abcw","baz","foo","bar","xtfn","abcdef"]
Output: 16
Explanation: The two words can be "abcw", "xtfn".
Example 2:

Input: words = ["a","ab","abc","d","cd","bcd","abcd"]
Output: 4
Explanation: The two words can be "ab", "cd".
Example 3:

Input: words = ["a","aa","aaa","aaaa"]
Output: 0
Explanation: No such pair of words.


Constraints:

2 <= words.length <= 1000
1 <= words[i].length <= 1000
words[i] consists only of lowercase English letters.
 */
public class MEDIUM_318_MaximumProductofWordLengths {


    /*
    Runtime: 10 ms, faster than 82.67% of Java online submissions for Maximum Product of Word Lengths.
    Memory Usage: 47 MB, less than 55.41% of Java online submissions for Maximum Product of Word Lengths.
     */
    private static int[] bits = new int[26];
    static {
        for (int i = 0; i < bits.length; i++)
            bits[i] = 1 << i;
    }
    public int maxProduct_05302022(String[] words) {
        int[] charOccurences = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray())
                charOccurences[i] |= bits[c - 'a'];
        }
        int ans = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++)
                if ((charOccurences[i] & charOccurences[j]) == 0) ans = Math.max(ans, words[i].length() * words[j].length());
        }
        return ans;
    }

    /*
    Runtime: 11 ms, faster than 71.82% of Java online submissions for Maximum Product of Word Lengths.
    Memory Usage: 47.9 MB, less than 38.49% of Java online submissions for Maximum Product of Word Lengths.
     */
    public int maxProduct(String[] words) {
        if(words == null || words.length < 2) {
            return 0;
        }
        // Idea Instead of making Character Set for checking common letters
        // we can calculate a binary value of each word as left shifting 1 by the letter
        // int value - 'a' and do OR of all these values to get bitValue of word
        // Now to check for common letters we do a simple AND of bitValues. if AND
        // Result is 0 we know for sure both don't have common letters.
        int length = words.length;
        int[] bitValues = new int[length];
        for(int i=0;i<length;i++) {
            String word = words[i];
            for(char letter: word.toCharArray()) {
                bitValues[i] |= 1 << (letter - 'a');
            }
        }
        int max = 0;
        for(int i=0;i<length-1;i++) {
            for(int j=i+1;j<length;j++) {
                if((bitValues[i] & bitValues[j]) == 0) {
                    max = Math.max(words[i].length() * words[j].length(), max);
                }
            }
        }
        return max;
    }

    /*
    Runtime: 513 ms, faster than 15.83% of Java online submissions for Maximum Product of Word Lengths.
    Memory Usage: 42.6 MB, less than 80.85% of Java online submissions for Maximum Product of Word Lengths.
     */
    public int maxProduct_05292022(String[] words) {
        int ans = 0;
        for(int i = 0; i < words.length; i++)
        {
            String s1 = words[i];
            int tmp = 0;
            for(int j = i+1; j< words.length; j++)
            {
                String s2 = words[j];
                if(!shareLetters(s1, s2))
                    ans = Math.max(ans,s1.length()*s2.length());
            }
        }
        return ans;
    }

    private boolean shareLetters(String s1, String s2)
    {
        int[] alpha = new int[26];
        for(char c : s1.toCharArray())
            alpha[c-'a']++;
        for(char c: s2.toCharArray())
        {
            if(alpha[c-'a'] > 0)
                return true;
        }
        return false;
    }
}
