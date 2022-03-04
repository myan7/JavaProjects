package com.myjobhunting;
// https://leetcode.com/problems/remove-k-digits/

/*
Given string num representing a non-negative integer num, and an integer k,
return the smallest possible integer after removing k digits from num.

Example 1:
Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.

Example 2:
Input: num = "10200", k = 1
Output: "200"
Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.

Example 3:
Input: num = "10", k = 2
Output: "0"
Explanation: Remove all the digits from the number and it is left with nothing which is 0.

Constraints:
1 <= k <= num.length <= 105
num consists of only digits.
num does not have any leading zeros except for the zero itself.
 */


import java.util.LinkedList;
import java.util.Stack;

public class MEDIUM_402_RemoveKDigits {

    /*
    LeetCode Solution:
    Runtime: 18 ms, faster than 48.08% of Java online submissions for Remove K Digits.
    Memory Usage: 51.5 MB, less than 12.67% of Java online submissions for Remove K Digits.
     */
    public String removeKdigits1(String num, int k) {
        LinkedList<Character> stack = new LinkedList<>();

        for(char digit : num.toCharArray()) {
            while(stack.size() > 0 && k > 0 && stack.peekLast() > digit) {
                stack.removeLast();
                k -= 1;
            }
            stack.addLast(digit);
        }

        /* remove the remaining digits from the tail. */
        for(int i=0; i<k; ++i) {
            stack.removeLast();
        }

        // build the final string, while removing the leading zeros.
        StringBuilder ret = new StringBuilder();
        boolean leadingZero = true;
        for(char digit: stack) {
            if(leadingZero && digit == '0') continue;
            leadingZero = false;
            ret.append(digit);
        }

        /* return the final string  */
        if (ret.length() == 0) return "0";
        return ret.toString();
    }

    /* https://www.youtube.com/watch?v=vbM41Zql228&ab_channel=NickWhite
    Greedy with Stack
    Runtime: 20 ms, faster than 41.34% of Java online submissions for Remove K Digits.
    Memory Usage: 47.7 MB, less than 15.28% of Java online submissions for Remove K Digits.
    Greedy algorithm
    Time complexity : O(N)
    Space complexity : O(N)
     */
    /*
    12345 1, remove 5
    54321 1, remove 5
    to keep the number as small as possible, we want to keep the digits as increasing as possible.
     num = "1432219" k = 3
     stack [1]
     stack [1,4]
     stack [1,3]
     stack [1,2]
     */
    public static String removeKdigits(String num, int k) {
        int len = num.length();
        if( k == 0) return num;
        if(k == len) return "0";
        Stack<Character> stack = new Stack<>();
        int index = 0;
        while(index < len)
        {
            // this is where to keep the num increasing, while loop is to keep the first digit to be the smallest
            while( k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(index))
            {
                stack.pop();
                k--;
            }
            stack.push(num.charAt(index));
            index++;
        }
        while(k>0)
        {
            stack.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty())
        {
            char c = stack.pop();
            sb.append(c);
        }
        sb.reverse();
        while(sb.length()>1 && sb.toString().charAt(0) == '0')
            sb.deleteCharAt(0);
        return sb.toString();
    }

    /*public static void main(String[] args)
    {
        MEDIUM_402_RemoveKDigits so = new MEDIUM_402_RemoveKDigits();
        System.out.println(so.removeKdigits("1432219", 3));
    }*/
}
