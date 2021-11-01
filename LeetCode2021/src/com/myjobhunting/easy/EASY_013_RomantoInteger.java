package com.myjobhunting.easy;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
// https://leetcode.com/problems/roman-to-integer/
public class EASY_013_RomantoInteger {
    public int romanToInt(String s) {
        int ans = 0;
        int len = s.length();
        for( int i = 0; i < len-1; i++ )
        {
            int currVal = getValue(s.charAt(i));
            int nextVal = getValue(s.charAt(i+1));
            if( currVal < nextVal )
                ans -= currVal;
            else
                ans += currVal;
        }
        return ans + getValue(s.charAt(len-1));
    }

    public int getValue(char c){
        return switch (c) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> 0;
        };
    }

    public int romanToInt2(@NotNull String s) {
        char[] charArr = s.toCharArray();
        int ans;
        HashMap<Character,Integer> kvMap = new HashMap<>();
        kvMap.put('I',1);
        kvMap.put('V',5);
        kvMap.put('X',10);
        kvMap.put('L',50);
        kvMap.put('C',100);
        kvMap.put('D',500);
        kvMap.put('M',1000);

        ans = kvMap.get(charArr[0]);

        for (int i = 1; i < charArr.length;i++) {
            int j = i - 1;
            if (kvMap.get(charArr[j]) < kvMap.get(charArr[i]) ) {
                ans = ans - kvMap.get(charArr[j])*2 + kvMap.get(charArr[i]);
            } else {
                ans = ans + kvMap.get(charArr[i]);
            }
        }
        return ans;
    }

}
