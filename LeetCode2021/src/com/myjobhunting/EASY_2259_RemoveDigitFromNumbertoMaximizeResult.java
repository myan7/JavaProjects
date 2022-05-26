package com.myjobhunting;

import java.util.ArrayList;
import java.util.List;

/*
You are given a string number representing a positive integer and a character digit.

Return the resulting string after removing exactly one occurrence of digit from number
such that the value of the resulting string in decimal form is maximized.
The test cases are generated such that digit occurs at least once in number.


Example 1:
Input: number = "123", digit = "3"
Output: "12"
Explanation: There is only one '3' in "123". After removing '3', the result is "12".

Example 2:
Input: number = "1231", digit = "1"
Output: "231"
Explanation: We can remove the first '1' to get "231" or remove the second '1' to get "123".
Since 231 > 123, we return "231".

Example 3:
Input: number = "551", digit = "5"
Output: "51"
Explanation: We can remove either the first or second '5' from "551".
Both result in the string "51".

Constraints:

2 <= number.length <= 100
number consists of digits from '1' to '9'.
digit is a digit from '1' to '9'.
digit occurs at least once in number.
 */
public class EASY_2259_RemoveDigitFromNumbertoMaximizeResult {

    /*
    Runtime: 1 ms, faster than 100.00% of Java online submissions for Remove Digit From Number to Maximize Result.
    Memory Usage: 42.3 MB, less than 100.00% of Java online submissions for Remove Digit From Number to Maximize Result.
     */
    public String removeDigit(String number, char digit) {

        int index = -1;
        int end = number.length();
        List<Integer> list = new ArrayList<>();

        // if there is only one occurrence of the digit.
        if(number.lastIndexOf(digit) == number.indexOf(digit))
            return number.substring(0,number.indexOf(digit))+number.substring(number.indexOf(digit)+1,end);
        else
        {
            for(int i = 0; i < number.length(); i++)
            {
                char curr = number.charAt(i);
                if(curr == digit)
                    list.add(i);
            }
            for(int i = list.size()-1; i >=0; i--)
            {
                int currIndex = list.get(i);
                if(currIndex < end-1 && number.charAt(currIndex) < number.charAt(currIndex+1)) {
                    index = currIndex;
                }
            }
            if(index == -1)
                return number.substring(0,number.lastIndexOf(digit))+number.substring(number.lastIndexOf(digit)+1,end);
            else
                return number.substring(0,index)+number.substring(index+1,end);
        }
    }
}
