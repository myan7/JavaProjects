package com.myjobhunting;

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

    /*
    Runtime: 1 ms, faster than 82.14% of Java online submissions for Longest Common Prefix.
    Memory Usage: 42 MB, less than 54.50% of Java online submissions for Longest Common Prefix.
     */
    public String longestCommonPrefix_20220518(String[] strs) {
        StringBuilder sb = new StringBuilder();
        if(strs.length == 1)
            return strs[0];
        boolean res = true;
        for(int index = 0; index < strs[0].length();index++)
        {
            char curr = strs[0].charAt(index);
            for(int i = 1; i < strs.length; i++)
            {
                if(index >= strs[i].length() || strs[i].charAt(index) != curr)
                    res = false;
            }
            if(res == true)
                sb.append(curr);
            else
                break;
        }

        return sb.toString();
    }

    /*
    Runtime: 1 ms, faster than 82.14% of Java online submissions for Longest Common Prefix.
    Memory Usage: 40.5 MB, less than 82.65% of Java online submissions for Longest Common Prefix.
     */
    public String longestCommonPrefix_LC_DivideandConquer(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        return longestCommonPrefix(strs, 0 , strs.length - 1);
    }

    private String longestCommonPrefix(String[] strs, int l, int r) {
        if (l == r) {
            return strs[l];
        }
        else {
            int mid = (l + r)/2;
            String lcpLeft =   longestCommonPrefix(strs, l , mid);
            String lcpRight =  longestCommonPrefix(strs, mid + 1,r);
            return commonPrefix(lcpLeft, lcpRight);
        }
    }

    String commonPrefix(String left,String right) {
        int min = Math.min(left.length(), right.length());
        for (int i = 0; i < min; i++) {
            if ( left.charAt(i) != right.charAt(i) )
                return left.substring(0, i);
        }
        return left.substring(0, min);
    }
}
