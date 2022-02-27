package com.myjobhunting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MEDIUM_438_FindAllAnagramsinaString {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> ans = new ArrayList<>();
        if(p.length() > s.length())
            return ans;
        int[] mapP = new int[26];
        int[] mapS = new int[26];
        for(int i = 0; i < p.length() ; i++)
        {
            mapP[p.charAt(i)-'a']++;
            mapS[s.charAt(i)-'a']++;
        }

        for(int i = p.length() ; i < s.length() ; i++)
        {
            if(Arrays.equals(mapP,mapS))
                ans.add(i-p.length());
            mapS[s.charAt(i)-'a']++;
            mapS[s.charAt(i-p.length())-'a']--;
        }
        if(Arrays.equals(mapP,mapS))
            ans.add(s.length()-p.length());
        return ans;
    }
}
