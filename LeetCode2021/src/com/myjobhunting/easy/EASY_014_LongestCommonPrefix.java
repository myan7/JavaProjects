package com.myjobhunting.easy;

import java.util.HashMap;

//https://leetcode.com/problems/longest-common-prefix/
public class EASY_014_LongestCommonPrefix {
        public String longestCommonPrefix(String[] strs) {
            int len = strs.length;
            if (len == 0)
                return "";
            for ( int i = 0; i < strs[0].length() ; i++ )
            {
                for (String str : strs) {
                    if (str.length() <= i || strs[0].charAt(i) != str.charAt(i))
                        return strs[0].substring(0, i);
                }
            }
            return strs[0];
    }

    public String longestCommonPrefix2(String[] strs) {
        HashMap<String, Integer> kvMap = new HashMap<>();
        int min = 200;
        String commonStr = "";
        /* find the shortest string */
        for (String s: strs)
        {
            kvMap.put(s,s.length());
            if(s.length() < min ) {
                min = s.length();
                commonStr = s;
            }
        }
        for (int i = 0; i < commonStr.length(); i++)
        {
            for (String str : strs) {
                if (str.length() < i || str.charAt(i) != commonStr.charAt(i))
                    return commonStr.substring(0, i);
            }
        }
        return commonStr;
    }
}
