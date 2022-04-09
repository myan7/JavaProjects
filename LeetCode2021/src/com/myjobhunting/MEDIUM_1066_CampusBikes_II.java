package com.myjobhunting;
// https://leetcode.com/problems/campus-bikes-ii/

import java.util.*;

/*
On a campus represented as a 2D grid, there are n workers and m bikes,
with n <= m. Each worker and bike is a 2D coordinate on this grid.

We assign one unique bike to each worker
so that the sum of the Manhattan distances between each worker and their assigned bike is minimized.

Return the minimum possible sum of Manhattan distances between each worker and their assigned bike.
The Manhattan distance between two points p1 and p2 is Manhattan(p1, p2) = |p1.x - p2.x| + |p1.y - p2.y|.

Example 1:
Input: workers = [[0,0],[2,1]], bikes = [[1,2],[3,3]]
Output: 6
Explanation:
We assign bike 0 to worker 0, bike 1 to worker 1. The Manhattan distance of both assignments is 3, so the output is 6.

Example 2:
Input: workers = [[0,0],[1,1],[2,0]], bikes = [[1,0],[2,2],[2,1]]
Output: 4
Explanation:
We first assign bike 0 to worker 0, then assign bike 1 to worker 1 or worker 2, bike 2 to worker 2 or worker 1.
Both assignments lead to sum of the Manhattan distances as 4.

Example 3:
Input: workers = [[0,0],[1,0],[2,0],[3,0],[4,0]], bikes = [[0,999],[1,999],[2,999],[3,999],[4,999]]
Output: 4995

Constraints:
n == workers.length
m == bikes.length
1 <= n <= m <= 10
workers[i].length == 2
bikes[i].length == 2
0 <= workers[i][0], workers[i][1], bikes[i][0], bikes[i][1] < 1000
All the workers and the bikes locations are unique.
 */
public class MEDIUM_1066_CampusBikes_II {

    /*
    Runtime: 592 ms, faster than 21.07% of Java online submissions for Campus Bikes II.
    Memory Usage: 41.7 MB, less than 60.31% of Java online submissions for Campus Bikes II.
     */
    int min = Integer.MAX_VALUE;
    public int assignBikes(int[][] workers, int[][] bikes) {
        int m = bikes.length;
        boolean[] used = new boolean[m];
        dfs(0,workers, bikes, 0, used);
        return min;
    }

    private int getDist(int[] worker, int[] bike)
    {
        return Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
    }

    private void dfs(int workerIndex, int[][] workers, int[][] bikes, int sum, boolean[] used)
    {
        if(workerIndex == workers.length)
        {
            min = Math.min(min, sum);
            return;
        }

        if(sum > min) return;

        for(int i = 0; i < bikes.length; i++)
        {
            if(!used[i])
            {
                used[i] = true;
                dfs(workerIndex+1, workers, bikes, sum+getDist(workers[workerIndex], bikes[i]), used);
                used[i] = false;
            }
        }
    }

    /*
    Runtime: 50 ms, faster than 44.21% of Java online submissions for Campus Bikes II.
    Memory Usage: 47.3 MB, less than 7.22% of Java online submissions for Campus Bikes II.
     */
    public int assignBikes2(int[][] workers, int[][] bikes) {
        Queue<Node> pq = new PriorityQueue<>(1,(a, b)->(a.cost-b.cost));
        Set<String> seen = new HashSet<>();
        pq.offer(new Node(0,0,0));
        while (!pq.isEmpty()){
            Node curr = pq.poll();
            String key = "$"+curr.worker+"$"+curr.mask;
            // reason - you can skip if you have already seen this mask
            // is because this is a PQ - and lower cost has already been seen
            // with this exact mask (i.e., those bikes used in some order)
            // then there is no point to consider a higher cost one
            if (seen.contains(key))
                continue;
            seen.add(key);
            // all workers have a bike if this is true
            if (curr.worker == workers.length)
                return curr.cost;
            // scan all bikes - and create new nodes into the PQ for next worker.
            for(int j = 0; j < bikes.length; j++){
                if ( (curr.mask & (1<<j)) == 0){
                    pq.offer( new Node(curr.worker+1, curr.mask | (1 << j),
                            curr.cost + getDist2(bikes[j], workers[curr.worker]) ));
                }
            }
        }
        return -1;
    }
    private int getDist2(int[] bikepos,int[] wpos){
        return Math.abs(bikepos[0]-wpos[0]) + Math.abs(bikepos[1]-wpos[1]);
    }
    class Node {
        int worker;
        int mask;
        int cost;
        public Node(int w,int m,int cost){
            this.worker = w;
            this.mask = m;
            this.cost = cost;
        }
    }

    // this is wrong because there are more bikes than workers.
    /*
    workers :   [[239,904],[191,103],[260,117],[86,78],[747,62]]
    bikes:      [[660,8],[431,772],[78,576],[894,481],[451,730],[155,28]]
    */
    // this method only works under circumstance of there are the same amount of workers and bikes.
    public int assignBikes0(int[][] workers, int[][] bikes) {
        int nw = workers.length, nb = bikes.length;
        int[][] map = new int[nw*nb][3];
        int index = 0;
        for(int i = 0; i < nw; i++)
        {
            for(int j = 0; j < nb; j++)
            {
                map[index][0] = i;
                map[index][1] = j;
                map[index][2] = getDist0(workers[i], bikes[j]);
                index++;
            }
        }
        Arrays.sort(map,(a, b) -> a[0] == b[0]? a[2]-b[2]: a[0]-b[0]);
        Set<Integer> sw = new HashSet<>();
        Set<Integer> sb = new HashSet<>();
        int sum = 0;
        int i = 0;
        while(i< index)
        {
            int workerIndex = map[i][0];
            int bikeIndex = map[i][1];
            //int flag = 0;
            if(!sw.contains(workerIndex) && !sb.contains(bikeIndex) )
            {
                sum += map[i][2];
                sw.add(workerIndex);
                sb.add(bikeIndex);
                //flag = 1;
            }
            i++;
        }
        return sum;
    }
    private int getDist0(int[] worker, int[] bike)
    {
        return Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
    }
}
