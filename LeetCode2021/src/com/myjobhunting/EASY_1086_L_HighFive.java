package com.myjobhunting;
// https://leetcode.com/problems/high-five/

import java.util.*;

/*
Given a list of the scores of different students, items,
where items[i] = [IDi, scorei] represents one score from a student with IDi, calculate each student's top five average.

Return the answer as an array of pairs result,
where result[j] = [IDj, topFiveAveragej] represents the student with IDj and their top five average.
Sort result by IDj in increasing order.

A student's top five average is calculated by taking the sum of their top five scores and dividing it by 5 using integer division.

Example 1:
Input: items = [[1,91],[1,92],[2,93],[2,97],[1,60],[2,77],[1,65],[1,87],[1,100],[2,100],[2,76]]
Output: [[1,87],[2,88]]
Explanation:
The student with ID = 1 got scores 91, 92, 60, 65, 87, and 100. Their top five average is (100 + 92 + 91 + 87 + 65) / 5 = 87.
The student with ID = 2 got scores 93, 97, 77, 100, and 76. Their top five average is (100 + 97 + 93 + 77 + 76) / 5 = 88.6, but with integer division their average converts to 88.

Example 2:
Input: items = [[1,100],[7,100],[1,100],[7,100],[1,100],[7,100],[1,100],[7,100],[1,100],[7,100]]
Output: [[1,100],[7,100]]

Constraints:
1 <= items.length <= 1000
items[i].length == 2
1 <= IDi <= 1000
0 <= scorei <= 100
For each IDi, there will be at least five scores.

 */
public class EASY_1086_L_HighFive {

    // Runtime: 6 ms, faster than 76.86% of Java online submissions
    public int[][] highFive1(int[][] items) {

        Arrays.sort(
                items,
                (a, b) -> {
                    if (a[0] != b[0])
                        // item with lower id goes first
                        return a[0] - b[0];
                    // in case of tie for ids, item with higher score goes first
                    return b[1] - a[1];
                });
        /* or use new Comparator(int[])
        Arrays.sort(
                items,
                new Comparator<int[]>() {
                    @Override
                    public int compare(int[] a, int[] b) {
                        if (a[0] != b[0])
                            // item with lower id goes first
                            return a[0] - b[0];
                        // in case of tie for ids, item with higher score goes first
                        return b[1] - a[1];
                    }
                });
         */
        List<int[]> solution = new ArrayList<>();
        int n = items.length;
        int i = 0;
        while (i < n) {
            int id = items[i][0];
            int sum = 0;
            // obtain total using the top 5 scores
            for (int k = i; k < i + 5; ++k)
                sum += items[k][1];
            // ignore all the other scores for the same id
            while (i < n && items[i][0] == id)
                i++;
            solution.add(new int[] {id, sum / 5});
        }
        int[][] solutionArray = new int[solution.size()][];
        return solution.toArray(solutionArray);
    }

    // Runtime: 6 ms, faster than 76.86% of Java online submissions using lambda expression
    private int K;
    public int[][] highFive2(int[][] items) {
        this.K = 5;
        Arrays.sort(items, (a,b) -> {
            if(a[0] != b[0])
                return (a[0]-b[0]);
            return (b[1]-a[1]);});
        List<int[]> solution = new ArrayList<>();
        int n = items.length;
        int i = 0;
        while (i < n) {
            int id = items[i][0];
            int sum = 0;
            // obtain total using the top 5 scores
            for (int k = i; k < i + this.K; ++k)
                sum += items[k][1];
            // ignore all the other scores for the same id
            while (i < n && items[i][0] == id)
                i++;
            solution.add(new int[] {id, sum / this.K});
        }
        int[][] solutionArray = new int[solution.size()][];
        return solution.toArray(solutionArray);
    }

    // Initial solution
    // Runtime: 3 ms, faster than 99.42% of Java online submissions
    public int[][] highFive0(int[][] items) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int nRow = items.length, nCol = items[0].length;
        for(int[] i : items)
        {
            if(map.containsKey(i[0]))
            {
                map.get(i[0]).add(i[1]);
            }
            else
            {
                List<Integer> scores = new ArrayList<>();
                scores.add(i[1]);
                map.put(i[0],scores);
            }
        }

        int[][] ans = new int[map.size()][2];
        int index = 0;
        for(Map.Entry<Integer,List<Integer>> e: map.entrySet())
        {
            ans[index][0] = e.getKey();
            // Collections.sort sorts increasingly by default
            // to sort an Integer list, you need to provide the following lambda expression
            e.getValue().sort((a, b) -> b - a);
            // up above is a list sort, or you can use Collections.sort
            // Collections.sort(e.getValue(), (a, b) -> b - a);
            int count = 0;
            int sum = 0;
            while(count < 5)
            {
                sum += e.getValue().get(count);
                count++;
            }
            ans[index][1] = sum/5;
            index++;
        }
        return ans;
    }
}
