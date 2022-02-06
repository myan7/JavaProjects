package com.myjobhunting;
// https://leetcode.com/problems/word-pattern/

import java.util.HashMap;
import java.util.Map;

public class EASY_290_WordPattern {
    public boolean wordPattern(String pattern, String s) {
        int lenP = pattern.length();

        String[] arrS = s.split(" ");
        int lenS = arrS.length;

        if(lenP != lenS)
            return false;

        Map<Character,String> map1 = new HashMap<>();

        for(int i = 0; i < lenP; i++)
        {
            if(map1.containsKey(pattern.charAt(i)))
            {
                if(!map1.get(pattern.charAt(i)).equals(arrS[i]))
                    return false;
            }
            map1.put(pattern.charAt(i),arrS[i]);
        }

        Map<String,Character> map2 = new HashMap<>();

        for(int i = 0; i < lenP; i++)
        {
            if(map2.containsKey(arrS[i]))
            {
                if( map2.get(arrS[i]) != pattern.charAt(i) )
                    return false;
            }
            map2.put(arrS[i],pattern.charAt(i));
        }

        return true;
    }

    public boolean wordPattern2(String pattern, String str) {
        String[] words = str.split(" ");
        if (words.length != pattern.length())
            return false;
        Map index = new HashMap();
        for (Integer i=0; i<words.length; ++i)
            if (index.put(pattern.charAt(i), i) != index.put(words[i], i))
                return false;
        return true;
    }
}
