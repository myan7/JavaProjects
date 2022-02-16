package com.practice;

import com.myjobhunting.EASY_387_FirstUniqueCharacterInAString;

/*
給兩個字串 組成為英文或數字 若遇到數字n則表示會有n個字元可能為任何英文字母
判斷兩個字串有沒有可能是相同的
(A2le, 1P2e) return true;
[A,X,X,l,e]
[X,P,X,X,e]
(a10‍‌‌‍,a9a) return true;
[a,X,X,X,X,X,X,X,X,X,X]
[a,X,X,X,X,X,X,X,X,X,a]

 */
public class MS_OA_010_CheckifTwoStringsoftheSamePattern {
    public boolean istheSamePattern(String s1, String s2)
    {
        char[] s1Arr = reconstruct(s1);
        char[] s2Arr = reconstruct(s2);
        if(s1Arr.length != s2Arr.length)
            return false;
        for(int i = 0 ; i < s1Arr.length; i++)
        {
            if(s1Arr[i] != '*' && s2Arr[i] != '*' && s1Arr[i] != s2Arr[i] )
                return false;
        }
        return true;
    }
    private char[] reconstruct(String s)
    {
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        int index = 0;
        while(index < len)
        {
            if(Character.isLetter(s.charAt(index)))
            {
                sb.append(s.charAt(index++));
            }
            else
            {
                int num = 0;
                while(index < len && Character.isDigit(s.charAt(index)))
                {
                    num = num*10 + s.charAt(index++)-'0';
                }
                for(int i = 0; i < num; i++)
                {
                    sb.append('*');
                }
                // the last for loop can be replace with sb.append("*".repeat(Math.max(0, num)));
            }
        }
        return sb.toString().toCharArray();
    }
}
