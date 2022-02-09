package com.myjobhunting;

import java.util.Arrays;

public class MEDIUM_869_ReorderedPowerof2 {

    // basic idea is to check the frequency of the digits of the given number
    // and compare the frequency of the power of 2
    // if match, return true;
    public boolean reorderedPowerOf2(int n) {
        int[] digitFreq = digitFreq(n);

        for(int i = 0; i < 31; i++)
        {
            int[] powerof2Freq = digitFreq((int)Math.pow(2,i));
            if(Arrays.equals(digitFreq, powerof2Freq))
                return true;
        }
        return false;
    }

    private int[] digitFreq(int n )
    {
        int[] digitFreq = new int[10];
        while(n > 0){
            digitFreq[n%10]++;
            n /= 10;
        }
        return digitFreq;
    }

    // idea is to make them sorted the same way
    // sort the given number, sort the power of 2
    // if match, return true;
    public boolean reorderedPowerOf2_1(int n) {
        char [] chrs = String.valueOf(n).toCharArray();
        Arrays.sort(chrs);
        for(int i = 0; i < 31; i++){
            char[] a = String.valueOf(1<<i).toCharArray();
            Arrays.sort(a);
            if(Arrays.equals(chrs, a))
                return true;
        }
        return false;
    }
}
