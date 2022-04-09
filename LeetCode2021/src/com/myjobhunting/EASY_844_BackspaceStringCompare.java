package com.myjobhunting;
// https://leetcode.com/problems/backspace-string-compare/

import java.util.Stack;

/*
Given two strings s and t, return true if they are equal when both are typed into empty text editors.
'#' means a backspace character.

Note that after backspacing an empty text, the text will continue empty.

Example 1:
Input: s = "ab#c", t = "ad#c"
Output: true
Explanation: Both s and t become "ac".

Example 2:
Input: s = "ab##", t = "c#d#"
Output: true
Explanation: Both s and t become "".

Example 3:
Input: s = "a#c", t = "b"
Output: false
Explanation: s becomes "c" while t becomes "b".

Constraints:
1 <= s.length, t.length <= 200
s and t only contain lowercase letters and '#' characters.

Follow up: Can you solve it in O(n) time and O(1) space?
 */
public class EASY_844_BackspaceStringCompare {

    /*
    Runtime: 1 ms, faster than 89.56% of Java online submissions for Backspace String Compare.
    Memory Usage: 42.6 MB, less than 26.06% of Java online submissions for Backspace String Compare.
     */
    public boolean backspaceCompare(String s, String t) {
        int indexS = s.length()-1, indexT = t.length()-1;
        int delS = 0, delT = 0;
        while(indexS >= 0 || indexT >= 0)
        {
            while(indexS >= 0){  // skip all removable char in s
                if(s.charAt(indexS) == '#') {   delS++; indexS--;   }
                else if(delS > 0)           {   delS--; indexS--;   }
                else                        break;
            }
            while(indexT >= 0){ // skip all removable char in t
                if(t.charAt(indexT) == '#') {  delT++;  indexT--;   }
                else if(delT > 0)           {  delT--;  indexT--;   }
                else                        break;
            }
            // if 2 chars from s and t are different
            if(indexS >= 0 && indexT >= 0 &&s.charAt(indexS) != t.charAt(indexT))
                return false;
            // if one reaches to the head, but the other one doesn't
            if( (indexS >= 0) != (indexT >= 0) )
                return false;
            indexS--;
            indexT--;
        }
        return true;
    }

    /*
    Runtime: 2 ms, faster than 57.94% of Java online submissions for Backspace String Compare.
    Memory Usage: 40.7 MB, less than 84.25% of Java online submissions for Backspace String Compare.
    T - O(M+N) S - O(M+N)
     */
    public boolean backspaceCompare1(String s, String t) {
        return build(s).equals(build(t));
    }
    private String build(String s)   {
        Stack<Character> ans = new Stack();
        for(char c: s.toCharArray())
        {
            if(c != '#')
                ans.push(c);
            else if(!ans.empty())
                ans.pop();
        }
        return String.valueOf(ans);
    }

    /*
    Runtime: 1 ms, faster than 89.60% of Java online submissions for Backspace String Compare.
    Memory Usage: 39.9 MB, less than 98.53% of Java online submissions for Backspace String Compare.
    T - O(M+N) S - O(M+N)
     */
    public boolean backspaceCompare0(String s, String t) {
        Stack<Character> ss = new Stack<>();
        Stack<Character> st = new Stack<>();
        for(char c: s.toCharArray())
        {
            if(c!='#')
                ss.push(c);
            else if(!ss.isEmpty())
                ss.pop();
        }
        for(char c: t.toCharArray())
        {
            if(c!='#')
                st.push(c);
            else if(!st.isEmpty())
                st.pop();
        }
        if(ss.size() != st.size())
            return false;
        while(!ss.isEmpty() && !st.isEmpty())
        {
            if(ss.pop() != st.pop())
                return false;
        }
        return true;
    }
}
