package com.myjobhunting;
// https://leetcode.com/problems/rearrange-spaces-between-words/

import java.util.ArrayList;
import java.util.List;

/*
You are given a string text of words that are placed among some number of spaces.
Each word consists of one or more lowercase English letters and are separated by at least one space.
It's guaranteed that text contains at least one word.

Rearrange the spaces so that there is an equal number of spaces between every pair of adjacent words and that number is maximized.
If you cannot redistribute all the spaces equally, place the extra spaces at the end, meaning the returned string should be the same length as text.

Return the string after rearranging the spaces.

Example 1:

Input: text =   "  this   is  a sentence "
Output:         "this   is   a   sentence"
Explanation: There are a total of 9 spaces and 4 words. We can evenly divide the 9 spaces between the words: 9 / (4-1) = 3 spaces.

Example 2:
Input: text =   " practice   makes   perfect"
Output:         "practice   makes   perfect "
Explanation: There are a total of 7 spaces and 3 words. 7 / (3-1) = 3 spaces plus 1 extra space. We place this extra space at the end of the string.

Constraints:
1 <= text.length <= 100
text consists of lowercase English letters and ' '.
text contains at least one word.
 */
public class EASY_1592_RearrangeSpacesBetweenWords {

    /*
    Runtime: 2 ms, faster than 75.93% of Java online submissions for Rearrange Spaces Between Words.
    Memory Usage: 42.3 MB, less than 44.28% of Java online submissions for Rearrange Spaces Between Words.
     */
    public String reorderSpaces(String text) {
        if(text.length() == 1)
            return text;

        int spaces = 0;
        char[] textArray = text.toCharArray();
        for(char c : textArray)
        {
            if(c == ' ')
                spaces++;
        }
        List<StringBuilder> words = new ArrayList<>();
        for(int i = 0; i < text.length(); )
        {
            int index = i;
            StringBuilder sb = new StringBuilder();
            if(i < text.length() && text.charAt(index) == ' ')
            {
                i++;
                continue;
            }
            while(index < text.length() && text.charAt(index) != ' ')
            {
                sb.append(text.charAt(index));
                index++;
            }
            i = index;
            words.add(sb);
        }
        StringBuilder ans = new StringBuilder();

        if(words.size() == 1)
        {
            ans.append(words.get(0));
            int len = text.length() - words.get(0).length();
            while(len > 0)
            {
                ans.append(" ");
                len--;
            }
        }
        else
        {
            int separate = spaces/(words.size()-1);
            int leftover = spaces%(words.size()-1);
            StringBuilder leftoverStr = new StringBuilder();

            StringBuilder space = new StringBuilder();

            while(separate > 0)
            {
                space.append(" ");
                separate--;
            }
            while(leftover > 0)
            {
                leftoverStr.append(" ");
                leftover--;
            }

            for(StringBuilder word : words)
            {
                ans.append(word).append(space);
            }
            ans.append(leftoverStr);
        }

        return ans.substring(0,text.length());

    }
}
