package com.myjobhunting;

// https://leetcode.com/problems/find-smallest-letter-greater-than-target/

/*
Given a characters array letters that is sorted in non-decreasing order and a character target,
return the smallest character in the array that is larger than target.

Note that the letters wrap around.

For example, if target == 'z' and letters == ['a', 'b'], the answer is 'a'.

Example 1:
Input: letters = ["c","f","j"], target = "a"
Output: "c"

Example 2:
Input: letters = ["c","f","j"], target = "c"
Output: "f"

Example 3:
Input: letters = ["c","f","j"], target = "d"
Output: "f"

Constraints:
2 <= letters.length <= 10^4
letters[i] is a lowercase English letter.
letters is sorted in non-decreasing order.
letters contains at least two different characters.
target is a lowercase English letter.
 */
public class EASY_744_FindSmallestLetterGreaterThanTarget {

    /*
    Runtime: 1 ms, faster than 42.34% of Java online submissions for Find Smallest Letter Greater Than Target.
    Memory Usage: 47.9 MB, less than 56.92% of Java online submissions for Find Smallest Letter Greater Than Target.
     */
    public char nextGreatestLetter(char[] letters, char target) {
        int ans = letters[0];
        int left = 0, right = letters.length-1;
        while(left <= right)
        {
            int mid = left + (right - left)/2;
            char midChar = letters[mid];
            if(midChar > target)
                right = mid-1;
            else
                left = mid+1;
        }
        if(left == letters.length)
            return letters[0];
        return letters[left];
    }
}
