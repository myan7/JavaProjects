package com.myjobhunting;

// https://leetcode.com/problems/isomorphic-strings/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class EASY_205_Isomorphic_Strings {

    public boolean isIsomorphic(String s, String t) {

        int[] alphabet = new int[512];
        for (int i = 0; i < s.length(); i++) {
            if (alphabet[s.charAt(i)] != alphabet[t.charAt(i)+256])
                return false;
            alphabet[s.charAt(i)] = alphabet[t.charAt(i)+256] = i+1;
            /*
            s = "ab" and t = "aa" makes it has to be assigned to i+1
            because the initial value of the array are all 0's
            if i == 0, and we assign 0 to alphabet[s.charAt(0)],
            that will confuse the same character in the next occurrence .
            it doesn't matter +1 or +100, as long as it is not 0 for index 0.
            * */
        }
        return true;
    }
    public boolean isIsomorphic2(String s, String t) {

        int[] mappingDictStoT = new int[256];
        Arrays.fill(mappingDictStoT, -1);

        int[] mappingDictTtoS = new int[256];
        Arrays.fill(mappingDictTtoS, -1);

        for (int i = 0; i < s.length(); ++i) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            // Case 1: No mapping exists in either of the dictionaries
            if (mappingDictStoT[c1] == -1 && mappingDictTtoS[c2] == -1) {
                mappingDictStoT[c1] = c2;
                mappingDictTtoS[c2] = c1;
            }

            // Case 2: Ether mapping doesn't exist in one of the dictionaries or Mapping exists and
            // it doesn't match in either of the dictionaries or both
            else if (!(mappingDictStoT[c1] == c2 && mappingDictTtoS[c2] == c1)) {
                return false;
            }
        }

        return true;
    }

    /*
    s = "badc"
    t = "baba"  false

    s = "paper"
    t = "title" true
    */
    public boolean isIsomorphic1(String s, String t) {
        Map<Character,Character> mapS = new HashMap<>();
        /* second map exists because of example
        * s = "badc"
        t = "baba"
        * */
        Map<Character,Character> mapT = new HashMap<>();

        if(s.length() != t.length())
            return false;
        else
        {
            for (int i = 0; i< s.length();i++)
            {
                if(mapS.containsKey(s.charAt(i)))
                {
                    if(mapS.get(s.charAt(i)) != t.charAt(i))
                        return false;
                }
                else
                    mapS.put(s.charAt(i),t.charAt(i));
            }
            for (int i = 0; i< s.length();i++)
            {
                if(mapT.containsKey(t.charAt(i)))
                {
                    if(mapT.get(t.charAt(i)) != s.charAt(i))
                        return false;
                }
                mapT.put(t.charAt(i),s.charAt(i));
            }
            return true;
        }
    }
}
