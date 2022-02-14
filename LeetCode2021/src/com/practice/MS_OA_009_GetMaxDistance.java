package com.practice;

import javax.print.attribute.HashPrintJobAttributeSet;
import java.util.HashMap;
import java.util.Map;

public class MS_OA_009_GetMaxDistance {
    public int getMaxDist(final int[] A)
    {
        // this question is given a O(n^2) solution and ask me to refine it.

        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < A.length; i++)
        {
            int curr = A[i];
            if(map.containsKey(curr))
                max = Math.max(max,i-map.get(curr));
            else
                map.put(curr, i);
        }
        return max;
    }
}
