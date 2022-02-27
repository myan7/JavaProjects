package com.myjobhunting;
// https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/

/*
Given an integer n,
return any array containing n unique integers such that they add up to 0.

Example 1:
Input: n = 5
Output: [-7,-1,1,3,4]
Explanation: These arrays also are accepted [-5,-1,1,2,3] , [-3,-1,2,-2,4].

Example 2:
Input: n = 3
Output: [-1,0,1]

Example 3:
Input: n = 1
Output: [0]

Constraints:
1 <= n <= 1000
 */
public class EASY_1304_FindNUniqueIntegersSumuptoZero {

    /*
     n = 5
     will output [-4,-2,0,2,4]
     n = 6
     will output [-5,-3,-1,1,3,5]
     */
    public int[] sumZero1(int n) {
        int[] ans = new int[n];
        for(int i=0; i<n; i++) {
            ans[i]  = (i*2)-n+1;
        }
        return ans;
    }
    /*
    as long as every 2 elements come in pair, one +, one -
    if n is an odd number, assign the last one with 0.
    n = 5
    output [5,-5,4,-4,0]
    n = 6
    output [6,-6,5,-5,4,-4]
     */
    public int[] sumZero0(int n) {
        int[] ans = new int[n];
        ans[0] = n;
        for(int i = 1; i< n; i++)
        {
            if(i%2 != 0)
                ans[i] = -1 * ans[i-1];
            else
                ans[i] = -1* ans[i-1] -1;
        }
        if(n%2 != 0)
            ans[n-1] = 0;
        return ans;
    }
}
