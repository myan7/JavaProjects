package com.myjobhunting;

import java.util.Locale;
// https://leetcode.com/problems/string-to-integer-atoi/

/*
ask the interviewer, what is the input look like
is there any size limitation?
is there any sign included?
is there any constraints,
like leading blanks, what to be converted and what not to be converted.
any special character, like ',', '_'
 */
public class MEDIUM_008_StringtoInteger_atoi_ {

    // 4ms
    public int myAtoi(String s) {
        long ans = 0;
        int sign = 1;
        String s1 = s.trim();
        char[] chArr = s1.toCharArray();
        if(chArr.length == 0)
            return 0;
        if(chArr[0] == '+') // this is for test case like +1
            sign = 1;
        else if(chArr[0] == '-')
            sign = -1;
        else if(chArr[0] >= '0' && chArr[0] <= '9')
            ans = ans*10 + chArr[0] - '0';
        else
            return 0;

        for(int i = 1; i<chArr.length; i++)
        {
            char currChar = chArr[i];
            if(currChar < '0' || currChar > '9')
                return (int)ans * sign;
            ans = ans*10 + currChar - '0';
            if(sign == 1 && ans > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            else if (sign == -1 && sign * ans < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
        }
        return (int)ans * sign;
    }

    // 2ms
    public int myAtoi0(String s) {
        s = s.trim();
        if (s == null || s.length() == 0)
            return 0;
        char firstChar = s.charAt(0);
        int sign = 1, start = 0, len = s.length();
        long sum = 0;

        if (firstChar == '+')
        {
            sign = 1;
            start++;
        }
        else if (firstChar == '-')
        {
            sign = -1;
            start++;
        }

        for (int i = start; i < len; i++)
        {
            if (!Character.isDigit(s.charAt(i)))
                return (int) sum * sign;
            sum = sum * 10 + s.charAt(i) - '0';
            if (sign == 1 && sum > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            if (sign == -1 && (-1) * sum < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
        }
        return (int) sum * sign;
    }
}
