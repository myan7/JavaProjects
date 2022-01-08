package com.myjobhunting;

/*
https://leetcode.com/problems/valid-palindrome/
*/
public class EASY_125_ValidPalindrome {
    public boolean isPalindrome(String s) {
        String sl = s.toLowerCase();
        StringBuffer sb = new StringBuffer();
        boolean res = false;
        for (char c : sl.toCharArray())
        {
            if ((c >= '0' && c <= '9') ||(c >= 'a' && c <= 'z') )
            {
                sb.append(c);
            }
        }
        return sb.toString().equals(sb.reverse().toString());
    }

    public boolean isPalindrome2(String s) {
        int left = 0;
        int right = s.length()-1;
        while(left < right) {
            int leftChar = s.charAt(left);
            int rightChar = s.charAt(right);
            if(!Character.isLetterOrDigit(leftChar)) {
                left++;
            } else if(!Character.isLetterOrDigit(rightChar)) {
                right--;
            } else if(Character.toLowerCase(leftChar) != Character.toLowerCase(rightChar)) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }
}
