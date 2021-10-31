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

   /*  The first idea that comes to mind is to convert the number into string,
   and check if the string is a palindrome,
   but this would require extra non-constant space for creating the string
   which is not allowed by the problem description.
    */
    public boolean isPalindrome(int intVal){
        String str = String.valueOf(intVal);
        int start = 0;
        int end = str.length() - 1;
        while(start < end){
            if(str.charAt(start++) != str.charAt(end--)) return false;
        }
        return true;
    }

    /*
    Second idea would be reverting the number itself,
    and then compare the number with original number,
    if they are the same, then the number is a palindrome.
    However, if the reversed number is larger than \text{int.MAX}int.MAX,
    we will hit integer overflow problem.
     */
    public boolean isPalindrome2(int intVal){
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
        try // for scenario 1234567899, which reverse will exceed integer.
        {
            reversedVal = Integer.parseInt(new String(intArr)) ;
        }catch (Exception e)
        {
            return false;
        }

        return reversedVal == intVal;
    } // isPalindrome2 ends

    /*
    Following the thoughts based on the second idea,
    to avoid the overflow issue of the reverted number,
    what if we only revert half of the \text{int}int number?
    After all, the reverse of the last half of the palindrome
    should be the same as the first half of the number, if the number is a palindrome.

    For example,
    if the input is 1221,
    if we can revert the last part of the number "1221" from "21" to "12",
    and compare it with the first half of the number "12",
    since 12 is the same as 12, we know that the number is a palindrome.

    Time complexity : O(\log_{10}(n))
    We divided the input by 10 for every iteration, so the time complexity is O(log10(n))
    Space complexity : O(1).
    * */
    public boolean isPalindrome3( int x ){
        // Special cases:
        // As discussed above, when x < 0, x is not a palindrome.
        // Also if the last digit of the number is 0, in order to be a palindrome,
        // the first digit of the number also needs to be 0.
        // Only 0 satisfy this property.
        if (x < 0 || ( x != 0 && x % 10 == 0))
            return false;
        int rev = 0;
        while (rev < x )
        {
            rev = rev*10 + x%10;
            x = x/10;
        }
        return x == rev || x == rev/10;
    }

    public boolean isPalindrome3_v1( int x ){
        if (x < 0 || ( x != 0 && x % 10 == 0))
            return false;
        int rev = 0;
        while (rev <= x ) // including x == 0
        {
            rev = rev*10 + x%10;
            if( rev == x ) // for length is odd
                return true;
            x = x/10;
            if( rev == x ) // for length is even
                return true;
        }
        return false;
    }

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

    public boolean isPalindrome5( int x ){
        String str = String.valueOf(x);
        for (int i = 0; i < str.length();i++ )
        {
            if(str.charAt(i) != str.charAt(str.length()-1-i))
                return false;
        }
        return true;
    }



} // class ends
