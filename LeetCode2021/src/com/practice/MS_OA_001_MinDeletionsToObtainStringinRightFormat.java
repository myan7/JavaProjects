package com.practice;
/*
Given a string with only characters X and Y.
Find the minimum number of characters to remove
from the string such that
there is no interleaving of character X and Y and all the Xs appear before any Y.

Example 1:
Input:YXXXYXY
Output: 2
Explanation:
We can obtain XXXYY by:

Delete first Y -> XXXYXY
Delete last occurrence pf X -> XXXYY
Example 2:
Input:YYXYXX
Output: 3
Explanation:
We can remove all occurrence of X or Y:

Example 3:
Input:XXYYYY
Output: 0
Explanation:
String matches the format required.
 */
public class MS_OA_001_MinDeletionsToObtainStringinRightFormat {

    public int minStep(String str) {
        // X has to be before Y
        int numY = 0;
        int numDel = 0;
        for(int i = 0; i < str.length();i++)
        {
            if(str.charAt(i) == 'X')
                numDel = Math.min(numY,numDel+1); //for each character, compare how many Y is in the past.
            else
                numY++;
        }
        return numDel;
    }
}
