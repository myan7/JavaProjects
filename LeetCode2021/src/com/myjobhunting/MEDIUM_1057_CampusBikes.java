package com.myjobhunting;
// https://leetcode.com/problems/campus-bikes/

import java.util.*;

/*
On a campus represented on the X-Y plane, there are n workers and m bikes, with n <= m.

You are given an array workers of length n where workers[i] = [xi, yi] is the position of the ith worker.
You are also given an array bikes of length m where bikes[j] = [xj, yj] is the position of the jth bike.
All the given positions are unique.

Assign a bike to each worker.
Among the available bikes and workers,
we choose the (workeri, bikej) pair with the shortest Manhattan distance between each other and assign the bike to that worker.

If there are multiple (workeri, bikej) pairs with the same shortest Manhattan distance,
we choose the pair with the smallest worker index.
If there are multiple ways to do that, we choose the pair with the smallest bike index.
Repeat this process until there are no available workers.

Return an array answer of length n, where answer[i] is the index (0-indexed) of the bike that the ith worker is assigned to.

The Manhattan distance between two points p1 and p2 is Manhattan(p1, p2) = |p1.x - p2.x| + |p1.y - p2.y|.

Example 1:
Input: workers = [[0,0],[2,1]], bikes = [[1,2],[3,3]]
Output: [1,0]
Explanation: Worker 1 grabs Bike 0 as they are closest (without ties), and Worker 0 is assigned Bike 1.
So the output is [1, 0].

Example 2:
Input: workers = [[0,0],[1,1],[2,0]], bikes = [[1,0],[2,2],[2,1]]
Output: [0,2,1]
Explanation: Worker 0 grabs Bike 0 at first.
Worker 1 and Worker 2 share the same distance to Bike 2,
thus Worker 1 is assigned to Bike 2, and Worker 2 will take Bike 1.
So the output is [0,2,1].


Constraints:

n == workers.length
m == bikes.length
1 <= n <= m <= 1000
workers[i].length == bikes[j].length == 2
0 <= xi, yi < 1000
0 <= xj, yj < 1000
All worker and bike locations are unique.
 */
public class MEDIUM_1057_CampusBikes {

    /*
    Runtime: 576 ms, faster than 24.29% of Java online submissions for Campus Bikes.
    Memory Usage: 116.9 MB, less than 15.34% of Java online submissions for Campus Bikes.
     */
    class Triplet{
        int distance;
        int worker;
        int bike;
        Triplet(int distance, int worker, int bike){
            this.distance = distance;
            this.worker = worker;
            this.bike = bike;
        }
    }

    public int[] assignBikes1(int[][] workers, int[][] bikes) {
        List<Triplet> ls = new ArrayList<>();
        for(int i = 0;i<workers.length;i++){
            for(int j = 0;j<bikes.length;j++){
                int[] currWorker = workers[i];
                int[] currBike = bikes[j];
                ls.add(new Triplet(Math.abs(currWorker[0]-currBike[0]) + Math.abs(currWorker[1]-currBike[1]), i , j));
            }
        }
        Collections.sort(ls, (a,b)->{
            if(a.distance==b.distance)
            {
                if(a.worker==b.worker)
                {
                    return a.bike-b.bike;
                }
                return a.worker-b.worker;
            }
            return a.distance-b.distance;
        });
        int[] res = new int[workers.length];
        Set<Integer> seenWorker = new HashSet<>();
        Set<Integer> seenBike = new HashSet<>();
        for(Triplet t : ls){
            // you need to check both worker and bike, if they are visited, skip.
            // because the first one will be the one that meets the condition.
            if(!seenWorker.contains(t.worker)&&!seenBike.contains(t.bike)){
                res[t.worker] = t.bike;
                seenWorker.add(t.worker);
                seenBike.add(t.bike);
            }
        }
        return res;
    }



    /*Runtime: 73 ms, faster than 89.58% of Java online submissions for Campus Bikes.
    Memory Usage: 90.4 MB, less than 65.09% of Java online submissions for Campus Bikes.*/
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        // Notice that the Manhattan distance is between 0 and 2000,
        // which means we can sort easily without even using priority queue
        int w = workers.length, b = bikes.length;
        int[] wo = new int[w], bi = new int[b];
        List<int[]>[] dists = new List[2001];

        Arrays.fill(wo, -1);
        Arrays.fill(bi, -1);
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < b; j++) {
                int[] worker = workers[i];
                int[] bike = bikes[j];
                int dist = Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
                if (dists[dist] == null) {
                    dists[dist] = new ArrayList<int[]>();
                }
                dists[dist].add(new int[]{i, j});
            }
        }
        int assigned = 0;
        for (int i = 0; i <= 2000 && assigned < w; i++) {
            if (dists[i] == null) continue;
            for (int[] pair : dists[i]) {
                if (wo[pair[0]] == -1 && bi[pair[1]] == -1) {
                    wo[pair[0]] = pair[1];
                    bi[pair[1]] = pair[0];
                    assigned++;
                }
            }
        }
        return wo;
    }
}
