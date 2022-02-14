package com.practice;

import java.util.HashSet;
import java.util.Set;

public class MS_OA_006_MissingNumber {
    /*
    Given an array A of N integers, returns the smallest positive integer(greater than 0)
    that does not occur in A;
     */
    public int solution(int[] A)
    {
        int len = A.length;
        Set<Integer> set = new HashSet<>();
        for(int i : A)
        {
            if(i > 0)
                set.add(i);
        }
        for(int i = 1; i <= len ; i++)
        {
            if(!set.contains(i))
                return i;
        }
        if(set.size() == 0)
            return 1;
        return len+1;
    }
}
