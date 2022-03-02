package com.myjobhunting;

// https://leetcode.com/problems/hamming-distance/
/*
The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
Given two integers x and y, return the Hamming distance between them.

Example 1:

Input: x = 1, y = 4
Output: 2
Explanation:
1   (0 0 0 1)
4   (0 1 0 0)
       ↑   ↑
The above arrows point to positions where the corresponding bits are different.
Example 2:

Input: x = 3, y = 1
Output: 1

Constraints:
0 <= x, y <= 2^31 - 1
 */

public class EASY_461_HammingDistance {

    // Leet code solution
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

    // updated solution:
    /*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Hamming Distance.
    Memory Usage: 40.4 MB, less than 41.01% of Java online submissions for Hamming Distance.
    */
    public int hammingDistance1(int x, int y) {
        int ans = 0;
        x = x^y;
        for(int i = 0 ; i < 32 ;i++)
        {
            if((x & 1) == 1)
                ans++;
            x >>= 1;
        }
        return ans;
    }

    /* initial solution:
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Hamming Distance.
    Memory Usage: 41.7 MB, less than 5.28% of Java online submissions for Hamming Distance.
     */
    public int hammingDistance0(int x, int y) {
        int ans = 0;
        for(int i = 0 ; i < 32 ;i++)
        {
            if((x & 1) != (y & 1))
                ans++;
            x >>= 1;
            y >>= 1;
        }
        return ans;
    }
}
