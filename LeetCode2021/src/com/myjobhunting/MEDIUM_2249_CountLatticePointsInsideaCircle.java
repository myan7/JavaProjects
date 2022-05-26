package com.myjobhunting;

// https://leetcode.com/problems/count-lattice-points-inside-a-circle/
/*
Given a 2D integer array, circles, where circles[i] = [xi, yi, ri] represents the center (xi, yi),
and radius ri of the ith circle drawn on a grid,
return the number of lattice points that are present inside at least one circle.

Note:
A lattice point is a point with integer coordinates.
Points that lie on the circumference of a circle are also considered to be inside it.

Example 1:
Input: circles = [[2,2,1]]
Output: 5
Explanation:
The figure above shows the given circle.
The lattice points present inside the circle are (1, 2), (2, 1), (2, 2), (2, 3), and (3, 2) and are shown in green.
Other points such as (1, 1) and (1, 3), which are shown in red, are not considered inside the circle.
Hence, the number of lattice points present inside at least one circle is 5.


Example 2:
Input: circles = [[2,2,2],[3,4,1]]
Output: 16
Explanation:
The figure above shows the given circles.
There are exactly 16 lattice points which are present inside at least one circle.
Some of them are (0, 2), (2, 0), (2, 4), (3, 2), and (4, 4).

Constraints:

1 <= circles.length <= 200
circles[i].length == 3
1 <= xi, yi <= 100
1 <= ri <= min(xi, yi)
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class MEDIUM_2249_CountLatticePointsInsideaCircle {


    public int countLatticePoints(int[][] circles) {
        int x,y,r;

        int result = 0;

        for (int i = 0; i <= 200; ++i)
        {
            for (int j = 0; j <= 200; ++j)
            {
                for (int [] circle : circles)
                {
                    x = circle[0];
                    y = circle[1];
                    r = circle[2];

                    if (isInCircle(i , j, x, y, r)){
                        ++result;
                        break;
                    }
                }
            }
        }
        return result;
    }

    private boolean isInCircle(int x1, int y1, int x2, int y2, int r){
        int xDist = Math.abs(x2 - x1);
        int yDist = Math.abs(y2 - y1);

        return (xDist*xDist + yDist*yDist) <= r*r;
    }

    /*
    Runtime: 34 ms, faster than 100.00% of Java online submissions for Count Lattice Points Inside a Circle.
    Memory Usage: 41.5 MB, less than 100.00% of Java online submissions for Count Lattice Points Inside a Circle.
     */
    public int countLatticePoints2(int[][] circles) {
        int i,j,ans=0;
        int[] px={500,-1},py={500,-1};
        for(int[] x:circles)    //find the range for checking lattice points
        {
            px[0]=Math.min(px[0],x[0]-x[2]);
            px[1]=Math.max(px[1],x[0]+x[2]);

            py[0]=Math.min(py[0],x[1]-x[2]);
            py[1]=Math.max(py[1],x[1]+x[2]);
        }

        for(i=px[0];i<=px[1];i++)
            for(j=py[0];j<=py[1];j++)
                for(int[] x:circles)    //for each lattice point, perform brute force
                    if(distance(x,i,j)<=x[2]*x[2])  //inside a circle
                    {
                        ans++;
                        break;
                    }
        return ans;
    }

    int distance(int[] a,int x,int y)
    {
        return (a[0]-x)*(a[0]-x)+(a[1]-y)*(a[1]-y);
    }

    public int countLatticePoints1(int[][] circles) {
        HashSet<String> res = new HashSet<String>(); // avoid duplicate points
        for(int[] arr : circles){
            int x = arr[0], y = arr[1], r = arr[2];  // center: (x,y) radius: r
            for(int i=x-r; i<=x+r; i++)     // generate integers for x-values in range [x-r, x+r]
                for(int j=y-r; j<=y+r; j++){   // generate integers for y-values in range [y-r, y+r]
                    if((x-i)*(x-i) + (y-j)*(y-j) <= r*r)   // distance formula (x2-x1)^2 + (y2-y1)^2 = r^2
                        res.add(i+","+j);  // add current co-ordinate to hashset
                }
        }
        return res.size();  // number of values in res is the answer
    }

    /*
    Runtime: 382 ms, faster than 50.00% of Java online submissions for Count Lattice Points Inside a Circle.
    Memory Usage: 50.1 MB, less than 50.00% of Java online submissions for Count Lattice Points Inside a Circle.
     */
    public int countLatticePoints0(int[][] circles) {
        int left,right,up,down;
        Map<Integer, HashSet<Integer>> map = new HashMap<>();
        for(int[] circle : circles)
        {
            int centerX = circle[0];
            int centerY = circle[1];
            int radius  = circle[2];
            left = centerX - radius;
            right = centerX + radius;
            down = centerY - radius;
            up = centerY + radius;
            for(int i = left; i <= right; i++)
            {
                for(int j = down; j <= up; j++)
                {
                    if(inside(circle, i,j))
                    {
                        HashSet<Integer> tmp = map.getOrDefault(i, new HashSet<Integer>());
                        tmp.add(j);
                        map.put(i, tmp);
                    }
                }
            }
        }
        int count = 0;
        for(Integer key: map.keySet())
        {
            count += map.get(key).size();
        }
        return count;
    }

    private boolean inside(int[] circle, int x, int y)
    {
        int dist = (x - circle[0])*(x - circle[0]) + (y - circle[1])*(y - circle[1]);
        return dist <= circle[2] * circle[2];
    }
}
