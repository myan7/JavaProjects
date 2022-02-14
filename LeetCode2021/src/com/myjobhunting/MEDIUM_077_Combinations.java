package com.myjobhunting;

// https://leetcode.com/problems/combinations/

import java.util.ArrayList;
import java.util.List;
        /*
        n = 4, k = 2
        output
        [
        [1,2],
        [1,3],
        [1,4], // first run, backtracking to the next starting number, 2
        [2,3],
        [2,4], // second run, backtracking to the next starting number, 3
        [3,4], // third run
        ]
        */
public class MEDIUM_077_Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> results = new ArrayList<>();
        if( n <= 0 || k <= 0 )
            return results;
        combineHelper(n, k, 1, results, new ArrayList<>());
        return results;
    }
    private void combineHelper(int n, int k, int start, List<List<Integer>> results, List<Integer> curSeq)
    {
        if(k == 0) // base case, if there is no more number to be added, add the curSeq to results
            results.add(new ArrayList<>(curSeq));
        else
        {
            for(int i = start; i <= n-k+1; i++) // n-k+1 is key with it 2ms, without it 27ms
            {
                curSeq.add(i);
                combineHelper(n,k-1,i+1,results,curSeq);
                curSeq.remove(curSeq.size()-1);
            }
        }
    }

    //65 ms
    public List<List<Integer>> combine1(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ls = new ArrayList();
        function(ans, ls, k, n, 1);
        return ans;
    }

    public void function(List<List<Integer>> ans, List<Integer> ls, int k, int n, int start) {
        if (k == 0) {
            ans.add(new ArrayList(ls));
            return;
        }
        for (int i = start; i<=n; i++) {
            if (ls.contains(i)) continue;
            ls.add(i);
            function(ans, ls, k-1, n, i+1);
            ls.remove(ls.size()-1);
        }
    }
}
