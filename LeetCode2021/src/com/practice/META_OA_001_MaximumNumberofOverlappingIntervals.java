package com.practice;

import java.util.*;

public class META_OA_001_MaximumNumberofOverlappingIntervals {
    public static int maxOverlappingIntervals(int[][] intervals)
    {
        int count = 0;
        Arrays.sort(intervals,(a, b) -> a[0]-b[0]);
        for(int i = 0 ; i < intervals.length; i++)
        {
            int tmp  = 0;
            for(int j = 1; j < intervals.length ; j++)
            {
                if(intervals[i][1] >= intervals[j][0])
                    tmp++;
            }
            count = Math.max(count, tmp);
        }
        return count;
    }

    private static class Pair
    {
        int first;
        char second;
        Pair(int first, char second)
        {
            this.first = first;
            this.second = second;
        }
    }
    public static int maxOverlappingIntervals1(int[][] intervals)
    {
        int count = 0;
        int ans = 0;
        List<Pair> data = new ArrayList<>();

        for(int[] interval : intervals)
        {
            data.add(new Pair(interval[0],'x'));
            data.add(new Pair(interval[1],'y'));
        }
        Collections.sort(data, (a, b) -> a.first - b.first);

        for(Pair p : data)
        {
            if(p.second == 'x')
                count++;
            if(p.second=='y')
                count--;
            ans = Math.max(ans,count);
        }
        return ans;
    }

    public static void main(String[] args)
    {
        int[][] v1 = { { 1, 2 }, { 2, 4 }, { 3, 6 }, {1,8}};
        int[][] v2 =  {{0,2},{1,7},{0,5},{-1,0}};
        int[][] v3 = {{1,2},{3,4},{5,6},{6,3},{8,1}};
        System.out.println(maxOverlappingIntervals1(v1));
        System.out.println(maxOverlappingIntervals1(v2));
        System.out.println(maxOverlappingIntervals1(v3));

        System.out.println(maxOverlappingIntervals(v1));
        System.out.println(maxOverlappingIntervals(v2));
        System.out.println(maxOverlappingIntervals(v3));
    }
}
