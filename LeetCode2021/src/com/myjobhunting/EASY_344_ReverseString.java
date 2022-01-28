package com.myjobhunting;

public class EASY_344_ReverseString {
    public void reverseString(char[] s) {
        int left = 0, right = s.length-1;
        while(left < right)
        {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
            left++;
            right--;
        }
    }
}
