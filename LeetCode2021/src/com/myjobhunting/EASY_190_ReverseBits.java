package com.myjobhunting;

//https://leetcode.com/problems/reverse-bits/
/*
Java uses two's complement for negative numbers and
the basic rule is to take the positive,
invert all bits, and then add one.
That gets you the negative.
for example:
-5
take the positive,
[00000000000000000000000000000101]
invert all bits
[11111111111111111111111111111010]
add one
[11111111111111111111111111111011]
*/
public class EASY_190_ReverseBits {
    // you need treat n as an unsigned value

    // remember this
    // 0 & 1 = 0, 1 & 1 = 1
    // what we need to do is to check if it is 1 or 0 for each bit.
    public int reverseBits1(int n) {
//https://leetcode.com/submissions/detail/110053926/
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1;
                    // shift all bits to the left by 1, 001 <<= 1 => 010
            if ((n & 1) == 1)
            {
                //check (n & 1) == 1, if 1, add 1 to result
                result++;
            }
            n >>= 1; //shift all bits to the right by 1, 010 >>= 1 => 001
        }
        return result;
    }

    public int reverseBits2(int n) {
        int result = 0;
        for( int i = 0; i <32 ; i++)
        {
            int bit = (n >> i) & 1; // check if 1 at the i-th position of n
            if( bit == 1)
            {
                result |= (bit << (31-i)); // update the (31-i)-th position of result to be 1
            }
        }
        return result;
    }

    public int reverseBits3(int n) {

        n = n>>>16 | n << 16; //2byte swap
        n = (n&0xff00ff00)>>>8 | (n&0x00ff00ff) <<8; //1byte swap
        n = (n&0xf0f0f0f0)>>>4 | (n&0x0f0f0f0f) <<4; //4bit swap
        n = (n&0xcccccccc)>>>2 | (n&0x33333333) <<2;//2bit swap
        n = (n&0xaaaaaaaa)>>>1 | (n&0x55555555) <<1;//1bit swap

        return n;
    }


    public int reverseBits4(int n) {
//https://leetcode.com/submissions/detail/110053719/
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result += n & 1;
            n >>>= 1;   // CATCH: must do unsigned shift
            if (i < 31) // CATCH: for last digit, don't shift!
                result <<= 1;
        }
        return result;
    }

    // this is wrong. because it doesn't see n as unsigned integer.
    public int reverseBits(int n) {
        int[] bits = convertBit2Reverse(n);
        int sum = 0;
        int pow = 31;
        for( int i = 1; i < 32; i++)
        {
            sum += bits[i]*Math.pow(2,pow--);
        }
        return sum;
    }

    private int[] convertBit2Reverse(int n)
    {
        int[] bits = new int[32];
        for(int i = 0; i < 32 ; i ++)
        {
            if(n != 0)
            {
                bits[i] = n%2;
                n = n/2;
            }
            else
                bits[i] = 0;
        }
        return bits;
    }

}
