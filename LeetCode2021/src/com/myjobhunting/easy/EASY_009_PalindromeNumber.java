package com.myjobhunting.easy;

/*
Given an integer x, return true if x is palindrome integer.
An integer is a palindrome when it reads the same backward as forward. For example, 121 is palindrome while 123 is not.
Example 1:
Input: x = 121
Output: true
Example 2:
Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
Example 3:
Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
Example 4:

Input: x = -101
Output: false
*/

import java.rmi.server.ExportException;
import java.util.Stack;

public class EASY_009_PalindromeNumber {
    public boolean isPalindrome(int intVal){
        String str = String.valueOf(intVal);
        int start = 0;
        int end = str.length() - 1;
        while(start < end){
            if(str.charAt(start++) != str.charAt(end--)) return false;
        }
        return true;
    }

    public boolean isPalindrome2(int intVal){
        int revertedNumber = 0;
        if(intVal < 0 || intVal% 10 == 0 && intVal  != 0 )
        {
            return false;
        }
        else
        {
            while(intVal > revertedNumber) {
                revertedNumber = revertedNumber * 10 + intVal % 10;
                intVal /= 10;
            }
        }
        return intVal == revertedNumber || intVal == revertedNumber/10;
    }

    public boolean isPalindrome3(int intVal){
        if(intVal <0 ) return false;

        String str = String.valueOf(intVal);
        char[] intArr = str.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (char c : intArr) stack.push(c);

        int i = 0, reversedVal;
        while(!stack.isEmpty())
        {
            intArr[i++] = stack.pop();
        }
        try
        {
            reversedVal = Integer.parseInt(new String(intArr)) ;
        }catch (Exception e)
        {
            return false;
        }

        return reversedVal == intVal;
    } // isPalindrome3 ends

    public boolean isPalindrome4(int x) {
        int n,sum=0,y,i;
        if(x>0)
        {
            y=x;
            for(i = 0; y>0; i++)
            {
                n = y%10;
                sum =10 *sum + n;
                y =y/10;
            }
            return x == sum;
        }
        else return x == 0;

    }

} // class ends
