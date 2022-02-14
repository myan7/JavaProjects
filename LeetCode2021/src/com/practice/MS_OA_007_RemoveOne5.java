package com.practice;

import java.util.ArrayList;
import java.util.List;

public class MS_OA_007_RemoveOne5 {
    public int getMaxbyRemovingOne5(int N)
    {
        int sign = 1;
        if(N < 0)
            sign = -1;
        List<Integer> digits = new ArrayList<>();
        List<Integer> possible = new ArrayList<>();

        int temp = Math.abs(N);
        while(temp > 0)
        {
            digits.add(0,temp%10);
            temp /= 10;
        }

        int[] target = new int[digits.size()];

        for(int i = 0; i < digits.size(); i++)
        {
            if(digits.get(i) == 5)
                target[i] = 1;
        }
        for(int i = 0 ; i < target.length;i++)
        {
            int val = 0;
            if(target[i] == 1)
            {
                for(int j = 0; j<digits.size(); j++)
                {
                    if(i != j)
                        val = val*10 + digits.get(j);
                }
                possible.add(val*sign);
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i : possible) {
            max = Math.max(max, i);
        }
        return max;
    }
}
