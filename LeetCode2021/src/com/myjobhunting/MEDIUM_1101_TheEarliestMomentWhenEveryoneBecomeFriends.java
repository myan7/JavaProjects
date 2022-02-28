package com.myjobhunting;
// https://leetcode.com/problems/the-earliest-moment-when-everyone-become-friends/

/*
There are n people in a social group labeled from 0 to n - 1.
You are given an array logs where
logs[i] = [timestampi, xi, yi] indicates that xi and yi will be friends at the time timestampi.

Friendship is symmetric.
That means if a is friends with b, then b is friends with a.
Also, person a is acquainted with a person b if a is friends with b, or a is a friend of someone acquainted with b.

Return the earliest time for which every person became acquainted with every other person.
If there is no such earliest time, return -1.

Example 1:
Input: logs = [[20190101,0,1],[20190104,3,4],[20190107,2,3],[20190211,1,5],[20190224,2,4],[20190301,0,3],[20190312,1,2],[20190322,4,5]], n = 6
Output: 20190301
Explanation:
The first event occurs at timestamp = 20190101 and after 0 and 1 become friends we have the following friendship groups [0,1], [2], [3], [4], [5].
The second event occurs at timestamp = 20190104 and after 3 and 4 become friends we have the following friendship groups [0,1], [2], [3,4], [5].
The third event occurs at timestamp = 20190107 and after 2 and 3 become friends we have the following friendship groups [0,1], [2,3,4], [5].
The fourth event occurs at timestamp = 20190211 and after 1 and 5 become friends we have the following friendship groups [0,1,5], [2,3,4].
The fifth event occurs at timestamp = 20190224 and as 2 and 4 are already friends anything happens.
The sixth event occurs at timestamp = 20190301 and after 0 and 3 become friends we have that all become friends.

Example 2:
Input: logs = [[0,2,0],[1,0,1],[3,0,3],[4,1,2],[7,3,1]], n = 4
Output: 3

Constraints:
2 <= n <= 100
1 <= logs.length <= 104
logs[i].length == 3
0 <= timestampi <= 109
0 <= xi, yi <= n - 1
xi != yi
All the values timestampi are unique.
All the pairs (xi, yi) occur at most one time in the input.
 */


import java.util.*;

public class MEDIUM_1101_TheEarliestMomentWhenEveryoneBecomeFriends {

    // my initial solution  Runtime: 9 ms, faster than 54.66% of Java online submissions
    public int earliestAcq0(int[][] logs, int n) {

        // First, we need to sort the events in chronological order.
        /*
        Arrays.sort(logs, new Comparator<int[]>() {
            @Override
            public int compare(int[] log1, int[] log2) {
                Integer tsp1 = new Integer(log1[0]);
                Integer tsp2 = new Integer(log2[0]);
                return tsp1.compareTo(tsp2);
            }
        }); */

        // even the examples are in oder,
        // but not all the test cases are.
        // we need to sort the events in chronological order.
        Arrays.sort(logs, Comparator.comparingInt(a -> a[0]));
        // or equivalent expression Arrays.sort(logs, (a, b) -> a[0] - b[0]);

        // the idea is to have an "answer" array every time looping thru logs, called friends
        // if everyone in the acquaintance array has the same value as the "answer"
        // then till that day, everyone becomes friends.

        // initialize all acquaintances to -1 and update the value using index
        // same index indicates they are acquainted on the same day
        int[] acq = new int[n];
        Arrays.fill(acq,-1);

        // friends will be updated every time with curr index of logs
        int[] friends = new int[n];

        for(int t = 0; t < logs.length; t++)
        {
            Arrays.fill(friends, t);  //this is the "answer"
            int p1 = logs[t][1];
            int p2 = logs[t][2];
            // if the person has never been added yet
            if(acq[p1] == -1)
            {
                acq[p1] = t;
            }
            if(acq[p2] == -1)
            {
                acq[p2] = t;
            }
            // update all their acquaintances
            int tmp1 = acq[p1];
            int tmp2 = acq[p2];
            for(int i = 0; i < n ; i++)
            {
                if(acq[i] == tmp1 || acq[i] == tmp2)
                    acq[i] = t;
            }

            if(Arrays.equals(acq, friends))
                return logs[t][0];
        }
        // check if the last day is the day
        if(Arrays.equals(acq, friends))
            return logs[logs.length-1][0];
        else
            return -1;
    }

    // LeetCode solution Runtime: 10 ms, faster than 43.94% of Java online submissions
    class UnionFind {
        private int[] group;
        private int[] rank;

        public UnionFind(int size) {
            this.group = new int[size];
            this.rank = new int[size];
            for (int person = 0; person < size; ++person) {
                this.group[person] = person;
                this.rank[person] = 0;
            }
        }

        /** Return the id of group that the person belongs to. */
        public int find(int person) {
            if (this.group[person] != person)
                this.group[person] = this.find(this.group[person]);
            return this.group[person];
        }

        /**
         * If it is necessary to merge the two groups that x, y belong to.
         * @return true: if the groups are merged.
         */
        public boolean union(int a, int b) {
            int groupA = this.find(a);
            int groupB = this.find(b);
            boolean isMerged = false;

            // The two people share the same group.
            if (groupA == groupB)
                return isMerged;

            // Otherwise, merge the two groups.
            isMerged = true;
            // Merge the lower-rank group into the higher-rank group.
            if (this.rank[groupA] > this.rank[groupB]) {
                this.group[groupB] = groupA;
            } else if (this.rank[groupA] < this.rank[groupB]) {
                this.group[groupA] = groupB;
            } else {
                this.group[groupA] = groupB;
                this.rank[groupB] += 1;
            }

            return isMerged;
        }
    }

    public int earliestAcq(int[][] logs, int n) {

        // First, we need to sort the events in chronological order.
        Arrays.sort(logs, new Comparator<int[]>() {
            @Override
            public int compare(int[] log1, int[] log2) {
                Integer tsp1 = log1[0];
                Integer tsp2 = log2[0];
                return tsp1.compareTo(tsp2);
            }
        });

        // Initially, we treat each individual as a separate group.
        int groupCount = n;
        UnionFind uf = new UnionFind(n);

        for (int[] log : logs) {
            int timestamp = log[0], friendA = log[1], friendB = log[2];

            // We merge the groups along the way.
            if (uf.union(friendA, friendB)) {
                groupCount -= 1;
            }

            // The moment when all individuals are connected to each other.
            if (groupCount == 1) {
                return timestamp;
            }
        }

        // There are still more than one groups left,
        //  i.e. not everyone is connected.
        return -1;
    }


    // DFS Runtime: 40 ms, faster than 5.11%
    public int earliestAcq2(int[][] logs, int n) {

        //Sort logs array based on time
        Arrays.sort(logs, (int[] a,int[] b) -> {
            return a[0] - b[0];
        });

        //Initilize Adjacency List
        List<List<Integer>> aList = new ArrayList<>();
        for(int i = 0; i < n; i++){
            aList.add(new ArrayList<>());
        }

        //Populate Adjacency List
        for(int i = 0; i < logs.length; i++){
            int x = logs[i][1];
            int y = logs[i][2];
            aList.get(x).add(y);
            aList.get(y).add(x);

            /*
            As Adjacency List is being populated
            check if all 'n' friends are visited/connected
            */
            Set<Integer> visited = new HashSet<>();
            dfs(aList,visited,0); //dfs(aList,visited,logs[i][1]);

            //Checks if all 'n' friends found
            if(visited.size() == n){
                return logs[i][0];
            }
        }
        //If logs doesn't connect all friends then no such earliest time
        return -1;
    }
    private void dfs(List<List<Integer>> aList,Set<Integer> visited, int index){
        if(visited.contains(index)){
            return;
        }
        visited.add(index);
        int listSize = aList.get(index).size();
        for(int i = 0; i < listSize; i++){
            dfs(aList,visited, aList.get(index).get(i));
        }
    }

    //BFS solution Runtime: 54 ms, faster than 5.11% of Java online submissions
    public int earliestAcq1(int[][] logs, int n) {

        //Sort logs array based on time
        Arrays.sort(logs, (int[] a,int[] b) -> {
            return a[0] - b[0];
        });

        //Initilize Adjacency List
        List<List<Integer>> aList = new ArrayList<>();
        for(int i = 0; i < n; i++){
            aList.add(new ArrayList<>());
        }

        //Populate Adjacency List
        for(int i = 0; i < logs.length; i++){
            int x = logs[i][1];
            int y = logs[i][2];
            aList.get(x).add(y);
            aList.get(y).add(x);

            /*
            As Adjacency List is being populated
            check if all 'n' friends are visited/connected
            */
            Set<Integer> visited = new HashSet<>();
            Queue<Integer> nextIndex = new LinkedList<>();
            nextIndex.offer(logs[i][1]); //nextIndex.offer(0);
            visited.add(logs[i][1]); //visited.add(0);
            while(!nextIndex.isEmpty()){
                int index = nextIndex.poll();
                int listSize = aList.get(index).size();
                for(int k = 0; k < listSize; k++){
                    if(!visited.contains(aList.get(index).get(k))){
                        nextIndex.offer(aList.get(index).get(k));
                        visited.add(aList.get(index).get(k));
                    }
                }
            }

            //Checks if all 'n' friends found
            if(visited.size() == n){
                return logs[i][0];
            }
        }
        //If logs doesn't connect all friends then no such earliest time
        return -1;
    }
}
