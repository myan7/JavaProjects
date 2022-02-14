package com.myjobhunting;
// https://leetcode.com/problems/number-of-1-bits/

/*
https://stackoverflow.com/questions/2811319/difference-between-and
>> is arithmetic shift right, >>> is logical shift right.

In an arithmetic shift, the sign bit is extended to preserve the signedness of the number.

For example:
-2 represented in 8 bits would be 11111110
(because the most significant bit has negative weight).
Shifting it right one bit using arithmetic shift would give you 11111111, or -1.
if I use n >>= 1; instead of n >>>= 1; n will never get out of that condition (n != 0)

Logical right shift, however, does not care that the value could possibly represent a signed number;
it simply moves everything to the right and fills in from the left with 0s.
Shifting our -2 right one bit using logical shift would give 01111111.
 */
public class EASY_191_Numberof1Bits {
    public int hammingWeight(int n) {
        int count = 0;
        while(n != 0)
        {
            count+=(n&1);
            n >>>= 1;
        }
        return count;
    }

    public int hammingWeight0(int n) {
        int count = 0;
        while(n != 0)
        {
            if( (n&1) == 1)
                count++;
            n >>>= 1;
        }
        return count;
    }
}
