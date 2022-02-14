package com.myjobhunting;
//https://leetcode.com/problems/combination-sum/

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
/*
Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]
 */
public class MEDIUM_039_CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backTracking(candidates,0,target, new ArrayList<>(), res);
        return res;
    }

    private void backTracking(int[] candidates, int start, int target, List<Integer> temp, List<List<Integer>> res)
    {
        if(target < 0 ) return;
        if(target == 0)
        {
            res.add(new ArrayList<>(temp)); // deep copy of this temp arraylist, because object is passed by references.
        }
        for(int i = start; i < candidates.length; i++)
        {
            temp.add(candidates[i]);
            backTracking(candidates,i,target - candidates[i],temp,res);
            temp.remove(temp.size()-1);
        }
    }
}
