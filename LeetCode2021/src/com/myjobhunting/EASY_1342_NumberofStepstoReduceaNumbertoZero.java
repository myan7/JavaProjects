package com.myjobhunting;
// https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/
/*
Given an integer num, return the number of steps to reduce it to zero.
In one step, if the current number is even, you have to divide it by 2, otherwise, you have to subtract 1 from it.

Example 1:
Input: num = 14
Output: 6
Explanation:
Step 1) 14 is even; divide by 2 and obtain 7.
Step 2) 7 is odd; subtract 1 and obtain 6.
Step 3) 6 is even; divide by 2 and obtain 3.
Step 4) 3 is odd; subtract 1 and obtain 2.
Step 5) 2 is even; divide by 2 and obtain 1.
Step 6) 1 is odd; subtract 1 and obtain 0.

Example 2:
Input: num = 8
Output: 4
Explanation:
Step 1) 8 is even; divide by 2 and obtain 4.
Step 2) 4 is even; divide by 2 and obtain 2.
Step 3) 2 is even; divide by 2 and obtain 1.
Step 4) 1 is odd; subtract 1 and obtain 0.

Example 3:
Input: num = 123
Output: 12


Constraints:

0 <= num <= 106
 */
public class EASY_1342_NumberofStepstoReduceaNumbertoZero {



    /*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Number of Steps to Reduce a Number to Zero.
    Memory Usage: 41.8 MB, less than 5.47% of Java online submissions for Number of Steps to Reduce a Number to Zero.
    T: O(logN)
    S: O(1)
     */
    public int numberOfSteps0(int num) {
        int steps = 0;
        while(num > 0)
        {
            if((num & 1) == 1)
                num -= 1;
            else
                num >>= 1;
            steps++;
        }
        return steps;
    }

    // counting bits
    // Time Complexity O(logN)
    // space complexity O(logN) because this method requires to convert the number into a binary representation
    public int numberOfSteps(int num) {
        // Get the binary for num, as a String.
        String binaryString = Integer.toBinaryString(num);

        int steps = 0;
        // Iterate over all the bits in the binary string.
        for (char bit : binaryString.toCharArray()) {
            if (bit == '1') { // If the bit is a 1
                steps = steps + 2; // Then it'll take 2 to remove.
            } else { // bit == '0'
                steps = steps + 1; // Then it'll take 1 to remove.
            }
        }
        // We need to subtract 1, because the last bit was over-counted.
        return steps - 1;
    }
}
