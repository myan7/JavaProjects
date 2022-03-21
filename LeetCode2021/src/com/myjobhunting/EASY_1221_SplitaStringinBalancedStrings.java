package com.myjobhunting;

public class EASY_1221_SplitaStringinBalancedStrings {
    /*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Split a String in Balanced Strings.
    Memory Usage: 39.8 MB, less than 76.36% of Java online submissions for Split a String in Balanced Strings.
     */
    public int balancedStringSplit(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int count = 0;
        int r = 0, l = 0;
        for(char c : s.toCharArray())
        {
            if(c=='R')
                r++;
            else if(c=='L')
                l++;
            if(r==l)
                count++;
        }
        return count;
    }
}
