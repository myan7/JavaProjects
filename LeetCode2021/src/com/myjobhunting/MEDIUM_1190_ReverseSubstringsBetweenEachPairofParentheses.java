package com.myjobhunting;
// https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses/

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/*
You are given a string s that consists of lower case English letters and brackets.
Reverse the strings in each pair of matching parentheses, starting from the innermost one.
Your result should not contain any brackets.

Example 1:
Input: s = "(abcd)"
Output: "dcba"

Example 2:
Input: s = "(u(love)i)"
Output: "iloveu"
Explanation: The substring "love" is reversed first, then the whole string is reversed.

Example 3:
Input: s = "(ed(et(oc))el)"
Output: "leetcode"
Explanation: First, we reverse the substring "oc", then "etco", and finally, the whole string.

Constraints:
1 <= s.length <= 2000
s only contains lower case English characters and parentheses.
It is guaranteed that all parentheses are balanced.
 */
public class MEDIUM_1190_ReverseSubstringsBetweenEachPairofParentheses {

    /*
    Runtime: 1 ms, faster than 98.43% of Java online submissions for Reverse Substrings Between Each Pair of Parentheses.
    Memory Usage: 40.5 MB, less than 83.64% of Java online submissions for Reverse Substrings Between Each Pair of Parentheses.
     */
    public String reverseParentheses_StackMyStyle(String s) {
        Stack<StringBuilder> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                st.push(sb);
                sb = new StringBuilder();
            } else if (c == ')') {
                String str = sb.reverse().toString();
                sb = st.pop();
                sb.append(str);
            } else sb.append(c);
        }
        return sb.toString();
    }
    /*
    Runtime: 2 ms, faster than 85.01% of Java online submissions for Reverse Substrings Between Each Pair of Parentheses.
    Memory Usage: 42.7 MB, less than 39.77% of Java online submissions for Reverse Substrings Between Each Pair of Parentheses.
    Time complexity is O(N^2), space complexity is O(N) because every time reverse will also take O(N)
    "(hg(bc(de)f)a)"
    Stack/Deque : ["","hg"]
    Stack/Deque : ["", "hg", "bc"]
    Stack/Deque : ["", "hg", "bc", "de"]
    Stack/Deque : ["", "hg", "bc"]    // see a ), pop out the last "de", reverse it "ed",
    Stack/Deque : ["", "hg", "bced"]  // add it to the new last, "bced"
    Stack/Deque : ["", "hg", "bcedf"] // see a letter, f, append f to the last element, "bced" now the new last becomes "bcedf"
    Stack/Deque : ["", "hg"]          // see a ), pop out the last, "bcedf", reverse it, "fdecb",
    Stack/Deque : ["", "hgfdecb"]     // append it to the new last "hg", new last becomes "hgfdecb"
    Stack/Deque : ["", "hgfdecba"]    // see a letter a, append a to the last element
    Stack/Deque : ["", ]              // see a ), pop out the last, "hgfdecba", reverse it, "abcedfgh",
    Stack/Deque : ["abcedfgh"]        // append it to the new last, "", new last becomes "abcedfgh"
    then return the last element on the deque of stack.
    notice that I intentionally put d and e in reverse order in this example.
     */
    public String reverseParentheses20220317(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<StringBuilder> stack = new Stack();
        stack.push(new StringBuilder());
        for(char c : s.toCharArray()){
            if(c == '('){
                stack.push(new StringBuilder());
            }
            else if( c == ')'){
                StringBuilder last = stack.pop();
                stack.peek().append(last.reverse());
            }
            else{
                stack.peek().append(c);
            }
        }
        return stack.pop().toString();
    }

    /*
    Runtime: 2 ms, faster than 85.01% of Java online submissions for Reverse Substrings Between Each Pair of Parentheses.
    Memory Usage: 42.5 MB, less than 47.21% of Java online submissions for Reverse Substrings Between Each Pair of Parentheses.
    https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses/discuss/382421/JavaPython-3-Iterative-short-O(n-2)-codes-w-comment-and-analysis.
     */

    public String reverseParentheses(String s) {
        Deque<StringBuilder> dq = new ArrayDeque<>();
        dq.push(new StringBuilder()); // In case the first char is NOT '(', need an empty StringBuilder.
        for (char c : s.toCharArray()) {
            if (c == '(')
            { // need a new StringBuilder to save substring in brackets pair
                dq.offer(new StringBuilder());
            }
            else if (c == ')')
            { // found a matched brackets pair and reverse the substring between them.
                StringBuilder end = dq.pollLast();
                dq.peekLast().append(end.reverse());
            }
            else
            { // append the char to the last StringBuilder.
                dq.peekLast().append(c);
            }
        }
        return dq.pollLast().toString();
    }

    /*
    This is a O(N) solution.
     */
    public String reverseParentheses0(String s) {
        int len = s.length();
        Stack<Integer> opened = new Stack<>();
        int[] pair = new int[len];
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '(')
                opened.push(i);
            if (s.charAt(i) == ')') {
                int j = opened.pop();
                pair[i] = j;
                pair[j] = i;
            }
        }
        StringBuilder sb = new StringBuilder();
        /*
        i is the index of current position.
        d is the direction of traversing.
         */
        for (int i = 0, d = 1; i < len; i += d) {
            if (s.charAt(i) == '(' || s.charAt(i) == ')') {
                i = pair[i];
                d = -d;
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    /*
    Recursive
     */
    public String reverseParentheses_Recursive(String s) {
        return helper(s,0,s.length()-1).toString();
    }

    public StringBuilder helper(String s, int left, int right) {
        int level = 0;
        StringBuilder sb = new StringBuilder();
        int start = -1, end = -1;
        for(int i = left; i <= right ; i ++){
            if(level == 0 && Character.isLetter(s.charAt(i)) )
                sb.append(s.charAt(i));
            if(s.charAt(i) == '(' ) {
                if(level == 0) start  = i+1;
                level++;
            }
            if(s.charAt(i) == ')' ){
                level--;
                if(level == 0){
                    sb.append(helper(s,start, i-1).reverse());
                }
            }
        }
        return sb;
    }
}
