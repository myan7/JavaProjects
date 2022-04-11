package com.myjobhunting;

// https://leetcode.com/problems/baseball-game/

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
You are keeping score for a baseball game with strange rules.
The game consists of several rounds, where the scores of past rounds may affect future rounds' scores.

At the beginning of the game, you start with an empty record.
You are given a list of strings ops,
where ops[i] is the ith operation you must apply to the record and is one of the following:

An integer x - Record a new score of x.

"+" - Record a new score that is the sum of the previous two scores.
    It is guaranteed there will always be two previous scores.

"D" - Record a new score that is double the previous score.
    It is guaranteed there will always be a previous score.

"C" - Invalidate the previous score, removing it from the record.
    It is guaranteed there will always be a previous score.
Return the sum of all the scores on the record.

Example 1:
Input: ops = ["5","2","C","D","+"]
Output: 30
Explanation:
"5" - Add 5 to the record, record is now [5].
"2" - Add 2 to the record, record is now [5, 2].
"C" - Invalidate and remove the previous score, record is now [5].
"D" - Add 2 * 5 = 10 to the record, record is now [5, 10].
"+" - Add 5 + 10 = 15 to the record, record is now [5, 10, 15].
The total sum is 5 + 10 + 15 = 30.

Example 2:
Input: ops = ["5","-2","4","C","D","9","+","+"]
Output: 27
Explanation:
"5" - Add 5 to the record, record is now [5].
"-2" - Add -2 to the record, record is now [5, -2].
"4" - Add 4 to the record, record is now [5, -2, 4].
"C" - Invalidate and remove the previous score, record is now [5, -2].
"D" - Add 2 * -2 = -4 to the record, record is now [5, -2, -4].
"9" - Add 9 to the record, record is now [5, -2, -4, 9].
"+" - Add -4 + 9 = 5 to the record, record is now [5, -2, -4, 9, 5].
"+" - Add 9 + 5 = 14 to the record, record is now [5, -2, -4, 9, 5, 14].
The total sum is 5 + -2 + -4 + 9 + 5 + 14 = 27.

Example 3:
Input: ops = ["1"]
Output: 1

Constraints:
1 <= ops.length <= 1000
ops[i] is "C", "D", "+", or a string representing an integer in the range [-3 * 10^4, 3 * 10^4].
For operation "+", there will always be at least two previous scores on the record.
For operations "C" and "D", there will always be at least one previous score on the record.
 */
public class EASY_682_BaseballGame {

    /*
    Runtime: 10 ms, faster than 5.89% of Java online submissions for Baseball Game.
    Memory Usage: 44.4 MB, less than 5.24% of Java online submissions for Baseball Game.
     */
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        for(String op : ops)
        {
            try {
                int d = Integer.parseInt(op);
                stack.push(d);
            } catch (NumberFormatException nfe){
                if(op.equals("D"))
                    stack.push(stack.peek()*2);
                else if(op.equals("C"))
                    stack.pop();
                else if(op.equals("+"))
                {
                    int temp = stack.pop();
                    int up = temp + stack.peek();
                    stack.push(temp);
                    stack.push(up);
                }
            }
        }
        int sum = 0;
        for(Integer val : stack)
            sum += val;
        return sum;
    }

    /*
    Runtime: 3 ms, faster than 78.45% of Java online submissions for Baseball Game.
    Memory Usage: 43.4 MB, less than 5.24% of Java online submissions for Baseball Game.
     */
    public int calPoints1(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        for(String op : ops)
        {
            if(op.equals("D"))
                stack.push(stack.peek()*2);
            else if(op.equals("C"))
                stack.pop();
            else if(op.equals("+"))
            {
                int temp = stack.pop();
                int up = temp + stack.peek();
                stack.push(temp);
                stack.push(up);
            }
            else
                stack.push(Integer.parseInt(op));
        }

        int sum = 0;
        for(Integer val : stack)
            sum += val;
        return sum;
    }

    /*
    Runtime: 3 ms, faster than 78.45% of Java online submissions for Baseball Game.
    Memory Usage: 42.3 MB, less than 56.47% of Java online submissions for Baseball Game.
     */

    public int calPoints0(String[] ops) {
        int sum = 0;

        List<Integer> score = new ArrayList<Integer>();

        for(int i=0;i<ops.length;i++){
            String c = ops[i];
            if(c.equals("+")){
                score.add(score.get(score.size()-1)+score.get(score.size()-2));
            }else if(c.equals("D")){
                score.add(score.get(score.size()-1)*2);
            }else if(c.equals("C")){
                score.remove(score.size()-1);
            }else{
                score.add(Integer.valueOf(c));
            }
        }
        for(Integer s : score){
            sum += s;
        }
        return sum;
    }
}
