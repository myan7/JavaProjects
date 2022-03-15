package com.myjobhunting;

public class EASY_066_PlusOne {
    public int[] plusOne(int[] digits) {
        int[] add = new int[]{0,0};
        if (digits[digits.length-1] + 1 == 10) {
            add[0] = 1;
            digits[digits.length - 1] = add[1];
        }
        else
            digits[digits.length - 1] = digits[digits.length - 1] + 1;
        for(int i = digits.length-2 ; i >=0; i--)
        {
            if(add[0] != 0 && digits[i]+1 == 10)
                digits[i] = add[1];
            else if(add[0] != 0 && digits[i]+1 < 10)
            {
                add[0] = 0;
                digits[i] = digits[i]+1;
            }
        }
        if(add[0] != 1)
            return digits;
        else
        {
            int[] ans = new int[(digits.length+1)];
            ans[0] = 1;
            int i = 1;
            for(int val: digits)
                ans[i] = val;
            return ans;
        }
    }

    public int[] plusOne2(int[] digits) {
        int length = digits.length;
        for(int i = length-1; i>=0; i--)
        {
            if(digits[i]<9)
            {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        int[] newInt = new int[length+1];
        newInt[0] =1;
        return newInt;
    }

    public int[] plusOne20220313(int[] digits) {
        int carry = 0;
        for(int i = digits.length-1; i>= 0 ;i--)
        {
            int val = digits[i]+carry;
            if(i == digits.length -1)
                val = val+1;
            carry = val/10;
            digits[i] = val%10;
        }
        if(carry == 1)
        {
            int[] ans = new int[digits.length+1];
            /*for(int i = 1; i< ans.length; i++)
			ans[i] = digits[i-1];*/ // this is not necessary, because plus one.
            ans[0] = carry;
            return ans;
        }
        return digits;
    }
}
