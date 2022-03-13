package com.myjobhunting;

// https://leetcode.com/problems/counting-bits/
/*
Given an integer n,
return an array ans of length n + 1 such that for each i (0 <= i <= n),
ans[i] is the number of 1's in the binary representation of i.

Example 1:
Input: n = 2
Output: [0,1,1]
Explanation:
0 --> 0
1 --> 1
2 --> 10

Example 2:
Input: n = 5
Output: [0,1,1,2,1,2]
Explanation:
0 --> 0
1 --> 1
2 --> 10
3 --> 11
4 --> 100
5 --> 101

Constraints:
0 <= n <= 10^5
 */
public class EASY_338_CountingBits {

    // dp check if the last bit is one, and plus the previously calculated number by shifting to the right by 1 bit.
    // if n == 0, nofB = 0; 0000
    // if n == 1, nofB = 1; 0001  0+1    shift to the right by one, n >> 1 --> 0,who has 0 bits of 1  1&1 = 1
    // if n == 2, nofB = 1; 0010  1+0    shift to the right by one, n >> 1 --> 1,who has 1 bits of 1  2&1 = 0
    // if n == 3, nofB = 2; 0011  1+1    shift to the right by one, n >> 1 --> 1,who has 1 bits of 1  3&1 = 1
    // if n == 4, nofB = 1; 0100  1+0    shift to the right by one, n >> 1 --> 2,who has 1 bits of 1  4&1 = 0
    // if n == 5, nofB = 2; 0101  1+1    shift to the right by one, n >> 1 --> 2,who has 1 bits of 1  5&1 = 1
    // if n == 6, nofB = 2; 0110  2+0    shift to the right by one, n >> 1 --> 3,who has 2 bits of 1  6&1 = 0
    // if n == 7, nofB = 3; 0111  2+1    shift to the right by one, n >> 1 --> 3,who has 2 bits of 1  7&1 = 1
    // so number of bits of 1 in 1, is the number of bits 0 + 1&1

    /*
    idea comes from reverse bits
    Runtime: 1 ms, faster than 99.98% of Java online submissions for Counting Bits.
    Memory Usage: 48.3 MB, less than 31.20% of Java online submissions for Counting Bits.
     */
    public int[] countBits(int n) {
        int[] res = new int[n+1];
        for(int i = 0; i<=n; i++)
        {
            res[i] = res[i>>1]+ (i&1);
        }
        return res;
    }

    /*
    Runtime: 2 ms, faster than 81.25% of Java online submissions for Counting Bits.
    Memory Usage: 48.5 MB, less than 18.87% of Java online submissions for Counting Bits.
     */
    public int[] countBits1(int n) {
        int[] ans = new int[n + 1];
        for (int x = 1; x <= n; x++) {
            ans[x] = ans[x & (x - 1)] + 1;
        }
        return ans;
    }

    // initial solution, count for every item.
    // Runtime: 8 ms, faster than 21.25% of Java online submissions
    public int[] countBits0(int n) {
        int[] ans = new int[n+1];
        for(int i = 1; i < n+1 ; i++)
        {
            ans[i] = helper(i);
        }
        return ans;
    }

    private int helper(int n)
    {
        int count = 0;
        while(n != 0)
        {
            if( (n & 1) == 1 )
                count++;
            n >>= 1;
        }
        return count;
    }


}
