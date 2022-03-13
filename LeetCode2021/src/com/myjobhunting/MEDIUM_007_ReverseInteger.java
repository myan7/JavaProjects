package com.myjobhunting;

import java.util.ArrayList;
import java.util.List;

public class MEDIUM_007_ReverseInteger {


    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }

    /*
    Runtime: 2 ms, faster than 70.85% of Java online submissions for Reverse Integer.
    Memory Usage: 41 MB, less than 48.60% of Java online submissions for Reverse Integer.
     */
    public int reverse1(int x) {
        int sign = 1;
        if(x < 0)
            sign = -1;
        int ans = 0;
        int tmp = Math.abs(x);
        while(tmp > 0)
        {
            if(ans > Integer.MAX_VALUE/10)
                return 0;
            ans = ans*10 + tmp%10;
            tmp /=10;
        }
        return ans* sign;
    }

    /*
    Runtime: 4 ms, faster than 18.37% of Java online submissions for Reverse Integer.
    Memory Usage: 41.7 MB, less than 22.99% of Java online submissions for Reverse Integer.
     */
    public int reverse0(int x) {
        int sign = 1;
        if(x < 0)
            sign = -1;

        long ans = 0;
        List<Integer> digits = new ArrayList<Integer>();

        int tmp = Math.abs(x);
        while(tmp > 0)
        {
            digits.add(tmp%10);
            tmp /=10;
        }
        for(int i = 0; i< digits.size(); i++ )
        {
            ans = ans*10 + digits.get(i);
            if(ans > Integer.MAX_VALUE)
                return 0;
        }
        return (int)ans* sign;
    }
}
