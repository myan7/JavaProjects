package com.myjobhunting;
// https://leetcode.com/problems/perform-string-shifts/

/*
You are given a string, s, containing lowercase English letters,
and a matrix, shift, where shift[i] = [directioni, amounti]:

directioni can be 0 (for left shift) or 1 (for right shift).
amounti is the amount by which string, s, is to be shifted.
A left shift by 1 means remove the first character of s and append it to the end.
Similarly, a right shift by 1 means remove the last character of s and add it to the beginning.
Return the final string after all operations.

Example 1:
Input: s = "abc", shift = [[0,1],[1,2]]
Output: "cab"
Explanation:
[0,1] means shift to left by 1. "abc" -> "bca"
[1,2] means shift to right by 2. "bca" -> "cab"

Example 2:
Input: s = "abcdefg", shift = [[1,1],[1,1],[0,2],[1,3]]
Output: "efgabcd"
Explanation:
[1,1] means shift to right by 1. "abcdefg" -> "gabcdef"
[1,1] means shift to right by 1. "gabcdef" -> "fgabcde"
[0,2] means shift to left by 2. "fgabcde" -> "abcdefg"
[1,3] means shift to right by 3. "abcdefg" -> "efgabcd"

Constraints:
1 <= s.length <= 100
s only contains lower case English letters.
1 <= shift.length <= 100
shift[i].length == 2
directioni is either 0 or 1.
0 <= amounti <= 100
 */
public class EASY_1427_PerformStringShifts {

    /*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Perform String Shifts.
    Memory Usage: 42.6 MB, less than 18.10% of Java online submissions for Perform String Shifts.
     */
    public String stringShift0(String s, int[][] shift) {
        int  amount = 0, len = s.length();
        for(int [] move : shift)
        {
            if(move[0] == 0)
                move[1] *= -1;
            amount += move[1];
        }
        amount %= len;
        amount = amount > 0? len - amount: Math.abs(amount);
        if(amount == 0)
            return s;
        return s.substring(amount)+s.substring(0,amount);
    }

    public String stringShift(String s, int[][] shift) {
        // Add up the left shifts and right shifts.
        int[] overallShifts = new int[2];
        for (int[] move : shift) {
            overallShifts[move[0]] += move[1];
        }
        int leftShifts = overallShifts[0];
        int rightShifts = overallShifts[1];

        // Determine which shift (if any) to perform.
        int len = s.length();
        if (leftShifts > rightShifts) {
            leftShifts = (leftShifts - rightShifts) % len;
            s = s.substring(leftShifts) + s.substring(0, leftShifts);
        }
        else if (rightShifts > leftShifts) {
            rightShifts = (rightShifts - leftShifts) % len;
            s = s.substring(len - rightShifts) + s.substring(0, len - rightShifts);
        }
        return s;
    }
}
