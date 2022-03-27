package com.myjobhunting;

public class EASY_541_ReverseString_II {

    /*
    Runtime: 6 ms, faster than 16.80% of Java online submissions for Reverse String II.
    Memory Usage: 43.4 MB, less than 74.94% of Java online submissions for Reverse String II.
     */
    public String reverseStr(String s, int k) {
        char[] ans = s.toCharArray();
        for(int i = 0; i < s.length(); i += 2*k)
        {
            int right = Math.min(k-1+i, s.length()-1);
            int left = i;

            while(right > left)
            {
                char tmp = s.charAt(left);
                ans[left++] = s.charAt(right);
                ans[right--] = tmp;
            }

        }
        return String.valueOf(ans);
    }
}
