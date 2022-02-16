package com.practice;

import java.util.HashSet;
import java.util.Set;

/*
第一題 debug
一個size N的不遞減數列 內含數字1-K 每個數字至少要出現過一次
題目給的function有錯 最多改兩行的情況下如何讓該function執行出正常結果
https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=830999&ctid=232515
 */
public class MS_OA_011_CheckOccurence {
    public boolean isValid(int[] nums, int k)
    {
        int len = nums.length;
        if(len < k)
            return false;
        Set<Integer> set = new HashSet<>();
        for(int i = 1; i <= k ; i++ )
        {
            set.add(i);
        }
        for(int i = 0; i < len; i ++)
        {
            set.remove(nums[i]);
        }
        return set.isEmpty();
    }
}
