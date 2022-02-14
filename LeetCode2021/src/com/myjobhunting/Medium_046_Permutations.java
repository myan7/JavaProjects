package com.myjobhunting;

// https://leetcode.com/problems/permutations/
// check MEDIUM_077_Combinations
import java.util.ArrayList;
import java.util.List;

public class Medium_046_Permutations {
    public List<List<Integer>> permute(int[] nums)
    {
        List<List<Integer>> list = new ArrayList<>();
        helper(new ArrayList<>(),list,nums);
        return list;
    }

    private void helper(List<Integer> op,List<List<Integer>> list,int[] nums)
    {
        //if no of element in output list reaches nums length print
        if(op.size()==nums.length)
        {
            list.add(new ArrayList<>(op));
        }
        else
        {
            //for every element add it to the op list.
            for (int num : nums) {
                //if set already contains it don't add it.
                if (op.contains(num)) continue;
                //consider nums[i] element
                op.add(num);
                //call with updated data
                helper(op, list, nums);
                //backtrack
                op.remove(op.size() - 1);
            }
        }
    }
}
