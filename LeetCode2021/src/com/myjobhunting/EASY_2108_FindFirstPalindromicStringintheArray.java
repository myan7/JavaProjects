package com.myjobhunting;
//https://leetcode.com/problems/find-first-palindromic-string-in-the-array/


public class EASY_2108_FindFirstPalindromicStringintheArray {

    // 3ms
    public String firstPalindrome(String[] words) {
        for(String word: words)
        {
            if(isPalindrome(word))
                return word;
        }
        return "";
    }

    private boolean isPalindrome(String s)
    {
        int start = 0, end = s.length()-1;
        while(start < end)
        {
            if(s.charAt(start) == s.charAt(end))
            {
                start++;
                end--;
            }
            else
                return false;
        }
        return (end-start) <= 1 ;
    }


    //13 ms
    public String firstPalindrome0(String[] words) {
        for(String word: words)
        {
            if(isPalindrome(word))
                return word;
        }
        return "";
    }

    private boolean isPalindrome0(String s)
    {
        StringBuffer sb = new StringBuffer(s);
        sb.reverse();
        return s.equals(sb.toString());
    }
}
