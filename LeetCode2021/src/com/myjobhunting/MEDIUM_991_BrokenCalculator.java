package com.myjobhunting;
// https://leetcode.com/problems/broken-calculator/
/*
There is a broken calculator that has the integer startValue on its display initially. In one operation, you can:
    1.  multiply the number on display by 2, or
    2.  subtract 1 from the number on display.
Given two integers startValue and target, return the minimum number of operations needed to display target on the calculator.

Example 1:
Input: startValue = 2, target = 3
Output: 2
Explanation: Use double operation and then decrement operation {2 -> 4 -> 3}.

Example 2:
Input: startValue = 5, target = 8
Output: 2
Explanation: Use decrement and then double {5 -> 4 -> 8}.

Example 3:
Input: startValue = 3, target = 10
Output: 3
Explanation: Use double, decrement and double {3 -> 6 -> 5 -> 10}.

Constraints:

1 <= x, y <= 10^9
 */
public class MEDIUM_991_BrokenCalculator {

    /* recursive
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Broken Calculator.
    Memory Usage: 41 MB, less than 30.28% of Java online submissions for Broken Calculator.
     */
    public int brokenCalc(int startValue, int target) {
        // since we can only double or decrease,
        // it is important to check which one is larger first, especially when target is smaller
        // we can only decrease to get to the target.
        if(target <= startValue)
            return startValue - target;
        else
        {
            // if target is greater than startValue and it is an even number
            // then the last operation is double.
            if(target % 2 == 0)
                return brokenCalc(startValue, target/2)+1;
            // else, the target is an odd number, and the last operation is decrement.
            else
                return brokenCalc(startValue,target+1)+1;
        }
    }

    /* iterative way.
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Broken Calculator.
    Memory Usage: 41.4 MB, less than 10.76% of Java online submissions for Broken Calculator.
     */
    public int brokenCalc0(int startValue, int target) {
        int count = 0;
        while(target > startValue)
        {
            count++;
            if(target %2 == 0)
                target /=2;
            else
                target +=1;
        }
        return count + startValue - target;
    }

}
