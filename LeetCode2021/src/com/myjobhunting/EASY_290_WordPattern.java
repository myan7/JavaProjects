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

    // Runtime: 1 ms, faster than 92.02%
    // explanation:
    /*
    map.put() will return the previous value associated with key, or null if there was no mapping for key.
    (A null return can also indicate that the map previously associated null with key,
    if the implementation supports null values.)
     */
    public boolean wordPattern2(String pattern, String s) {
        String[] words = s.split(" ");
        if (words.length != pattern.length())
            return false;
        Map index = new HashMap();
        for (Integer i=0; i<words.length; ++i)
            if (index.put(pattern.charAt(i), i) != index.put(words[i], i))
                return false;
        return true;
    }

    public boolean wordPattern3(String pattern, String s) {
        Map<Character, String> map1 = new HashMap<>();
        Map<String, Character> map2 = new HashMap<>();

        String[] sa = s.split(" ");
        char[] ca = pattern.toCharArray();

        int cn = ca.length;
        int sn = sa.length;
        if(sn != cn)
            return false;

        for(int i = 0; i < pattern.length();i++)
        {
            /*
                "abaaba"
                "dog cat fish fish cat dog"
            */
            if(!map1.containsKey(ca[i]))
            {
                if(map2.containsKey(sa[i]))
                    return false;
                else
                {
                    map1.put(ca[i],sa[i]);
                    map2.put(sa[i],ca[i]);
                }
            }
            else
            {
                if(!map1.get(ca[i]).equals(sa[i]))
                    return false;
            }
        }
        return true;
    }
}
