package com.myjobhunting;

public class EASY_2185_CountingWordsWithaGivenPrefix {

    // Runtime: 0 ms, faster than 100.00% of Java online submissions
    public int prefixCount(String[] words, String pref) {
        int result = 0;
        for (String word: words){
            if (word.startsWith(pref))
                result++;
        }
        return result;
    }

    // 1 ms
    public int prefixCount0(String[] words, String pref) {
        int len = pref.length();
        int count = 0;

        for(String word: words)
        {
            if(word.length() < len)
                continue;
            if(word.substring(0,len).equals(pref))
                count++;
        }
        return count;
    }
}
