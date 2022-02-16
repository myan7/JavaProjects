package com.myjobhunting;
// https://leetcode.com/problems/maximum-number-of-words-found-in-sentences/

public class EASY_2114_MaximumNumberofWordsFoundinSentences {
    public int mostWordsFound(String[] sentences) {
        int max = 0;
        for(String s: sentences)
        {
            max = Math.max(max, s.split(" ").length);
        }
        return max;
    }
}
