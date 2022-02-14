package com.myjobhunting;
// https://leetcode.com/problems/maximal-network-rank/

import java.util.*;

/*
There is an infrastructure of n cities with some number of roads connecting these cities.
Each roads[i] = [ai, bi] indicates that there is a bidirectional road between cities ai and bi.

The network rank of two different cities is defined as
the total number of directly connected roads to either city.
If a road is directly connected to both cities, it is only counted once.

The maximal network rank of the infrastructure is the maximum network rank of all pairs of different cities.

Given the integer n and the array roads, return the maximal network rank of the entire infrastructure.
 */
public class MEDIUM_1615_MaximalNetworkRank {

    public int maximalNetworkRank(int n, int[][] roads) {
        int[][] adjMatrix = new int[n][n];
        int[] degrees = new int[n];
        for (int[] road : roads){
            adjMatrix[road[0]][road[1]] = 1;
            adjMatrix[road[1]][road[0]] = 1;
            degrees[road[0]]++;
            degrees[road[1]]++;
        }
        int max = 0;
        for (int i = 0; i < degrees.length; i++){
            for (int j = i + 1; j < degrees.length; j++){
                int contains = adjMatrix[i][j] == 1 ? 1 : 0;
                max = Math.max(max, degrees[i] + degrees[j] - contains);
            }
        }
        return max;
    }

    public int maximalNetworkRank1(int n, int[][] roads) {

        //number of roads connected to city, or edges
        int[] count = new int[n];
        // adjacency, check if 2 cities are connected
        int[][] connection = new int[n][n];

        // count the edges, and the continuity of those 2 cities
        for(int[] i : roads){
            count[i[0]]++;
            count[i[1]]++;
            // if adjacent, 1, if non directly connected, 0
            connection[i[0]][i[1]] = 1;
            connection[i[1]][i[0]] = 1;
        }
        int result = 0;
        // loop thru the cities. remove the duplicate one, like [1,2], and [2,1]
        for(int i = 0;i<n;i++){
            for(int j = i+1;j<n;j++){
                result = Math.max(count[i] + count[j] - connection[i][j],result);
            }
        }
        return result;
    }

    public int maximalNetworkRank2(int n, int[][] roads)
    {
        //number of road connected to city
        int[] numRoadsConnectedCity = new int[n];
        //road exist between two two cities
        boolean[][] raadExist = new boolean[n][n];
        for (int[] cities : roads) {
            //increment the count of numbers of connected city
            numRoadsConnectedCity[cities[0]]++;
            numRoadsConnectedCity[cities[1]]++;
            // mark road exist, between two cities
            raadExist[cities[0]][cities[1]] = true;
            raadExist[cities[1]][cities[0]] = true;
        }

        int maxRank = 0;
        for (int city1 = 0; city1 < n - 1; city1++) {
            for (int city2 = city1 + 1; city2 < n; city2++) {
                //count total number of road connected to both city
                int rank = numRoadsConnectedCity[city1] + numRoadsConnectedCity[city2];
                //just decrement the rank, if both city connected
                if (raadExist[city1][city2]) rank--;
                maxRank = Math.max(maxRank, rank);
            }
        }
        return maxRank;
    }



    public int maximalNetworkRank0(int n, int[][] roads) {
        /*
        n=8  [[0,1],[1,2],[2,3],[2,4],[5,6],[5,7]]
        output max rank is 5
        Explanation:
            Let's make an array of HashSets that would store all the cities connected to each of the cities
            Then we find a pair in that such that
            The pair has the highest sum of cities
            however if they have a road between them
            We decrease the count of sum by 1 (because we want to avoid counting the
            road joining them twice)
            0 to n-1 cities
            ...
         */
        Set<Integer>[] cityConnection=new HashSet[n];

        for(int i=0;i<n;i++)
            cityConnection[i]=new HashSet<Integer>();

        for(int[] road : roads)
        {
            int srcCity=road[0];
            int desCity=road[1];

            //Undirected so we add the cities both ways
            cityConnection[srcCity].add(desCity);
            cityConnection[desCity].add(srcCity);
        }

        //All connections successfully established
        //n^2 approach

        int max=0;

        for(int i=0;i<cityConnection.length-1;i++)
        {
            for(int j=i+1;j<cityConnection.length;j++)
            {
                int totalRoads=cityConnection[i].size()+cityConnection[j].size();
                if(cityConnection[i].contains(j)){
                    //ith City is connected with j
                    //So decrease the total road count by 1
                    totalRoads--;
                }
                max=Math.max(totalRoads,max);
            }
        }
        return max;
    }


    public int maximalNetworkRank3(int n, int[][] roads) {
        int[][] v=new int[n][2];
        for(int i=0;i<n;i++){
            v[i][0]=i;
        }
        boolean[][] conn =new boolean[n][n];
        for(int[] r:roads){
            conn[r[0]][r[1]]=true;
            conn[r[1]][r[0]]=true;
            v[r[0]][1]++;
            v[r[1]][1]++;
        }
        Arrays.sort(v,(a, b)->b[1]-a[1]);
        List<int[]> list=new ArrayList();
        list.add(v[0]);
        int lastNum=v[0][1];
        for(int i=1;i<v.length;i++){
            if(lastNum==v[i][1]){
                list.add(v[i]);
            }else if(list.size()==1){
                list.add(v[i]);
                lastNum=v[i][1];
            }else{
                break;
            }
        }
        int res=0;
        for(int i=0;i<list.size();i++){
            for(int j=i+1;j<list.size();j++){
                int t=list.get(i)[1]+list.get(j)[1];
                if(conn[list.get(i)[0]][list.get(j)[0]]){
                    t-=1;
                }
                res=Math.max(res,t);
            }
        }
        return res;
    }

}
