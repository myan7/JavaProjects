package com.myjobhunting;

// https://leetcode.com/problems/sort-integers-by-the-number-of-1-bits/

import java.util.Arrays;

/*
You are given an integer array arr.
Sort the integers in the array in ascending order
by the number of 1's in their binary representation and
in case of two or more integers have the same number of 1's you have to sort them in ascending order.

Return the array after sorting it.

Example 1:
Input: arr = [0,1,2,3,4,5,6,7,8]
Output: [0,1,2,4,8,3,5,6,7]
Explanation: [0] is the only integer with 0 bits.
[1,2,4,8] all have 1 bit.
[3,5,6] have 2 bits.
[7] has 3 bits.
The sorted array by bits is [0,1,2,4,8,3,5,6,7]

Example 2:
Input: arr = [1024,512,256,128,64,32,16,8,4,2,1]
Output: [1,2,4,8,16,32,64,128,256,512,1024]
Explanation: All integers have 1 bit in the binary representation, you should just sort them in ascending order.

Constraints:
1 <= arr.length <= 500
0 <= arr[i] <= 10^4
 */
public class EASY_1356_SortIntegersbyTheNumberof1Bits {

    /*
    Runtime: 6 ms, faster than 83.69% of Java online submissions for Sort Integers by The Number of 1 Bits.
    Memory Usage: 42.2 MB, less than 93.69% of Java online submissions for Sort Integers by The Number of 1 Bits.
     */
    public int[] sortByBits(int[] arr) {
        int[][] cur = new int[arr.length][2]; //[[0,0],[1,1],[2,1],[3,2],[4,1],[5,2]]
        for (int i = 0; i < arr.length; i++) {
            cur[i][0] = arr[i];
            cur[i][1] = Integer.bitCount(arr[i]);
        }
        Arrays.sort(cur, (a, b) -> (a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]));
        for (int i = 0; i < arr.length; i++) {
            arr[i] = cur[i][0];
        }
        return arr;
    }

    /*
    Runtime: 29 ms, faster than 16.48% of Java online submissions for Sort Integers by The Number of 1 Bits.
    Memory Usage: 46 MB, less than 47.05% of Java online submissions for Sort Integers by The Number of 1 Bits.
     */
    public Integer[] sortByBits0(Integer[] arr) {
        Integer[] tmp = new Integer[arr.length];
        for(int i = 0; i < arr.length; i++)
            tmp[i] = arr[i];

        Arrays.sort(tmp,(a,b) ->{
            if( count1bits(a) == count1bits(b))
                return a-b;
            return count1bits(a) - count1bits(b);
        });

        for(int i = 0; i < arr.length; i++)
            arr[i] = tmp[i];

        return arr;
    }
    private int count1bits(int a)
    {
        int ans = 0;
        while(a != 0)
        {
            if((a&1)==1)
                ans++;
            a >>>= 1;
        }
        return ans;
    }
}
