package com.myjobhunting;
// https://leetcode.com/problems/sorting-the-sentence/

/*
A sentence is a list of words that are separated by a single space with no leading or trailing spaces.
Each word consists of lowercase and uppercase English letters.

A sentence can be shuffled by appending the 1-indexed word position to each word then rearranging the words in the sentence.
For example, the sentence "This is a sentence" can be shuffled as "sentence4 a3 is2 This1" or "is2 sentence4 This1 a3".
Given a shuffled sentence s containing no more than 9 words, reconstruct and return the original sentence.

Example 1:
Input: s = "is2 sentence4 This1 a3"
Output: "This is a sentence"
Explanation: Sort the words in s to their original positions "This1 is2 a3 sentence4", then remove the numbers.

Example 2:
Input: s = "Myself2 Me1 I4 and3"
Output: "Me Myself and I"
Explanation: Sort the words in s to their original positions "Me1 Myself2 and3 I4", then remove the numbers.

Constraints:
2 <= s.length <= 200
s consists of lowercase and uppercase English letters, spaces, and digits from 1 to 9.
The number of words in s is between 1 and 9.
The words in s are separated by a single space.
s contains no leading or trailing spaces.

 */
public class EASY_1859_SortingtheSentence {

    public String sortSentence(String s) {
        String[] words = s.split(" "), ans = new String[words.length];
        for (String word : words) {
            int i = word.length() - 1;
            ans[word.charAt(i) - '1'] = word.substring(0, i);
        }
        return String.join(" ", ans);
    }

    // initial solution
    /*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Sorting the Sentence.
    Memory Usage: 41.9 MB, less than 32.04% of Java online submissions for Sorting the Sentence.
     */
    public String sortSentence0(String s) {
        String[] sentences = s.split(" ");
        String[] ans = new String[sentences.length];
        for(String sen : sentences)
        {
            ans[sen.charAt(sen.length()-1)-'0'-1] = sen.substring(0,sen.length()-1);
            // ans[sen.charAt(sen.length()-1)-'1'] = sen.substring(0,sen.length()-1);
        }
        StringBuilder sb = new StringBuilder();
        for(String sen : ans)
        {
            sb.append(sen).append(" ");
        }
        return sb.substring(0,sb.length()-1);
    }
}
