package com.myjobhunting;

public class MEDIUM_3_LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        char[] ascii = new char[256];
        int left = 0, max = 0;
        for(int curr = 0; curr < s.length(); )
        {
            char currChar = s.charAt(curr);
            char leftChar = s.charAt(left);
            if(ascii[currChar] > 0)
            {
                ascii[leftChar]--;
                left++;
            }
            else
            {
                ascii[currChar]++;
                curr++;
                max = Math.max(max, curr-left);
            }
        }
        return max;
    }

    public int lengthOfLongestSubstring1(String s) {
        if(s.length() == 1)
            return 1;
        char[] ascii = new char[256];
        int left = 0, max = 0, curr= 0;
        while(curr < s.length())
        {
            char currChar = s.charAt(curr);
            char leftChar = s.charAt(left);
            if(ascii[currChar] > 0)
            {
                ascii[leftChar]--;
                left++;
            }
            else
            {
                ascii[currChar]++;
                curr++;
                max = Math.max(max, curr-left);
            }
        }
        return max;
    }
}
