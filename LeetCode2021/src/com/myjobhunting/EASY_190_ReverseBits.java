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

    public int reverseBits1(int n) {
//https://leetcode.com/submissions/detail/110053926/
        if (n == 0) return 0;

        int result = 0;
        for (int i = 0; i < 32; i++) {
            //System.out.println("result in binary is "+ Integer.toBinaryString(result));
            result <<= 1;
            //System.out.println("after <<= 1, result in binary is "+ Integer.toBinaryString(result));
            //System.out.println("n in binary is "+ Integer.toBinaryString(n));
            if ((n & 1) == 1)
            {
                //.out.println(" (n & 1) == 1 is because "+ Integer.toBinaryString(n));
                result++;
            }
            n >>= 1;
            //System.out.println("after >>= 1, n in binary is "+ Integer.toBinaryString(n));
        }
        return result;
    }

    public int reverseBits2(int n) {

        n = n>>>16 | n << 16; //2byte swap
        n = (n&0xff00ff00)>>>8 | (n&0x00ff00ff) <<8; //1byte swap
        n = (n&0xf0f0f0f0)>>>4 | (n&0x0f0f0f0f) <<4; //4bit swap
        n = (n&0xcccccccc)>>>2 | (n&0x33333333) <<2;//2bit swap
        n = (n&0xaaaaaaaa)>>>1 | (n&0x55555555) <<1;//1bit swap

        return n;
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

    public int reverseBits3(int n) {
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


}
