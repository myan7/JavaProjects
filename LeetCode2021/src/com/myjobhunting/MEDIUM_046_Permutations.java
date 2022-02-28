package com.myjobhunting;

// https://leetcode.com/problems/permutations/
// check MEDIUM_077_Combinations
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class MEDIUM_046_Permutations {


    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> item = new ArrayList<>();
        backTrackingHelper(list, item, nums);
        return list;
    }
    // top down method, return type is void
    private void backTrackingHelper(List<List<Integer>> list, List<Integer> item, int[] nums)
    {
        // base case:
        if(item.size() == nums.length)
            list.add(new ArrayList<>(item));
        else
        {
            for(int num : nums)
            {
                if(item.contains(num))
                    continue;
                item.add(num);
                backTrackingHelper(list,item,nums);
                item.remove(item.size()-1);
            }
        }
    }

    // solution from LC
    public void backtrack(int n,
                          ArrayList<Integer> nums,
                          List<List<Integer>> output,
                          int first) {
        // if all integers are used up
        if (first == n)
            output.add(new ArrayList<>(nums));
        for (int i = first; i < n; i++) {
            // place i-th integer first
            // in the current permutation
            Collections.swap(nums, first, i);
            // use next integers to complete the permutations
            backtrack(n, nums, output, first + 1);
            // backtrack
            Collections.swap(nums, first, i);
        }
    }

    public List<List<Integer>> permute1(int[] nums) {
        // init output list
        List<List<Integer>> output = new LinkedList<>();

        // convert nums into list since the output is a list of lists
        ArrayList<Integer> nums_lst = new ArrayList<>();
        for (int num : nums)
            nums_lst.add(num);

        int n = nums.length;
        backtrack(n, nums_lst, output, 0);
        return output;
    }

    // https://youtu.be/xqidNhvwKzI?t=726
    // top down, helper function returns void, which is this case
    // bottom up, helper function returns a data structure.
    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, nums, 0);
        return res;
    }

    private void dfs(List<List<Integer>> res, int[] nums, int index)
    {
        // this is the base case, as long as the index reaches the length
        // that means the permutation or the swap, is completed.
        // then make a copy of what is in the nums, and feed it into res.
        if(index == nums.length)
        {
            List<Integer> ans = new ArrayList<>();
            for( int i : nums)
                ans.add(i);
            res.add(ans);
            return;
        }

        for(int i = index; i < nums.length; i++)
        {
            swap(nums,index, i);
            dfs(res,nums,index+1);
            swap(nums,index, i);
        }
    }

    private void swap(int[] nums, int i1, int i2)
    {
        int tmp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = tmp;
    }
}
