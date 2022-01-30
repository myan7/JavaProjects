package com.myjobhunting;

import java.util.Arrays;

public class MEDIUM_567_PermutationinString {
    public boolean checkInclusion(String s1, String s2) {
        // return true if s2 contains a permutation of s1, or false otherwise.
        int len1 = s1.length();
        int len2 = s2.length();
        if(len1 > len2) return false;

        if(len1 == 0) return true; // this is useless in this LC question, but good to have

        // s1 and s2 consist of lowercase English letters.
        char[] arrS1 = new char[26];
        char[] arrS2 = new char[26];

        for (int i = 0; i < len1; i++)
        {
            arrS1[s1.charAt(i) - 'a']++;
            arrS2[s2.charAt(i) - 'a']++;
        }

        for(int i = len1; i < len2 ; i++)
        {
            if(Arrays.equals(arrS1,arrS2))
                return true;
            char curr = s2.charAt(i);
            char existing = s2.charAt(i-len1);
            arrS2[curr - 'a']++;
            arrS2[existing-'a']--;
        }

        return Arrays.equals(arrS1,arrS2);
    }
}
