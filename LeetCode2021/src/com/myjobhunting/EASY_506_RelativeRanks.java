package com.myjobhunting;
// https://leetcode.com/problems/relative-ranks/

import java.util.Arrays;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

/*
You are given an integer array, score, of size n,
where score[i] is the score of the ith athlete in a competition.
All the scores are guaranteed to be unique.

The athletes are placed based on their scores, where the 1st place athlete has the highest score, the 2nd place athlete has the 2nd highest score, and so on. The placement of each athlete determines their rank:

The 1st place athlete's rank is "Gold Medal".
The 2nd place athlete's rank is "Silver Medal".
The 3rd place athlete's rank is "Bronze Medal".
For the 4th place to the nth place athlete, their rank is their placement number (i.e., the xth place athlete's rank is "x").
Return an array answer of size n where answer[i] is the rank of the ith athlete.



Example 1:

Input: score = [5,4,3,2,1]
Output: ["Gold Medal","Silver Medal","Bronze Medal","4","5"]
Explanation: The placements are [1st, 2nd, 3rd, 4th, 5th].
Example 2:

Input: score = [10,3,8,9,4]
Output: ["Gold Medal","5","Bronze Medal","Silver Medal","4"]
Explanation: The placements are [1st, 5th, 3rd, 2nd, 4th].

Constraints:

n == score.length
1 <= n <= 10^4
0 <= score[i] <= 106
All the values in score are unique.
 */
public class EASY_506_RelativeRanks {

    /*
    Runtime: 5 ms, faster than 98.72% of Java online submissions for Relative Ranks.
    Memory Usage: 54.8 MB, less than 19.84% of Java online submissions for Relative Ranks.
     */
    public String[] findRelativeRanks(int[] score) {
        int max = 0;
        for(int sc : score)
            max = Math.max(max,sc);

        int[] hash = new int[max+1];
        for(int i = 0; i< score.length; i++)
            hash[score[i]] = i+1;
        String[] ans = new String[score.length];
        int place = 1;
        for(int i = hash.length-1; i >= 0 ; i--)
        {
            if(hash[i] != 0)
            {
                ans[hash[i]-1] = place == 1?"Gold Medal": place == 2?"Silver Medal": place == 3? "Bronze Medal": place+"";
                place++;
            }
        }
        return ans;
    }
    /*
    Runtime: 16 ms, faster than 35.26% of Java online submissions for Relative Ranks.
    Memory Usage: 53.9 MB, less than 65.60% of Java online submissions for Relative Ranks.
     */
    public String[] findRelativeRanks2(int[] score) {
        int[][] ranks = new int[score.length][2];
        for(int i = 0; i < score.length; i++)
        {
            ranks[i][0] = score[i];
            ranks[i][1] = i;
        }
        Arrays.sort(ranks, (a, b) -> b[0] - a[0]);
        String[] ans = new String[score.length];
        String[] top = new String[]{"Gold Medal", "Silver Medal","Bronze Medal"};
        int count = 0;
        for(int[] rank : ranks)
        {
            if(count < 3)
                ans[rank[1]] = top[count++];
            else
                ans[rank[1]] = ++count + "";
        }
        return ans;
    }

    /*
    Runtime: 9 ms, faster than 82.23% of Java online submissions for Relative Ranks.
    Memory Usage: 54.1 MB, less than 59.53% of Java online submissions for Relative Ranks.
     */
    public String[] findRelativeRanks1(int[] score) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> score[b] - score[a]);

        for(int i=0;i<score.length;i++)
            queue.offer(i);

        String[] result = new String[score.length];
        String[] topThree = new String[] { "Gold Medal", "Silver Medal","Bronze Medal" };

        for(int rank = 1;!queue.isEmpty();rank++)
            if(rank<=3)
                result[queue.poll()] = topThree[rank-1];
            else
                result[queue.poll()] = String.valueOf(rank);
        return result;
    }
    /*
    Runtime: 15 ms, faster than 39.83% of Java online submissions for Relative Ranks.
    Memory Usage: 54.2 MB, less than 55.03% of Java online submissions for Relative Ranks.
     */
    public String[] findRelativeRanks0(int[] score) {
        Map<Integer, Integer> map = new TreeMap<>();
        for(int i = 0; i < score.length; i++)
        {
            map.put(score[i], i);
        }
        String[] ans = new String[score.length];
        int count = map.size();

        for(Integer key: map.keySet())
        {
            ans[map.get(key)] = count == 1? "Gold Medal":count == 2?"Silver Medal":count==3?"Bronze Medal": count+"";
            count--;
        }
        return ans;
    }
}
