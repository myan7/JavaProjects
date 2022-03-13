package com.myjobhunting;
// https://leetcode.com/problems/check-if-it-is-a-straight-line/

/*
You are given an array coordinates,
coordinates[i] = [x, y], where [x, y] represents the coordinate of a point.
Check if these points make a straight line in the XY plane.

Example 1:
Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
Output: true

Example 2:
Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
Output: false

Constraints:
2 <= coordinates.length <= 1000
coordinates[i].length == 2
-10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
coordinates contains no duplicate point.

 */
public class EASY_1232_CheckIfItIsaStraightLine {

    public boolean checkStraightLine(int[][] coordinates) {

        for(int i = 1; i < coordinates.length; i++)
        {
            double y2 = coordinates[i][1];
            double x2 = coordinates[i][0];
            double y1 = coordinates[i-1][1];
            double x1 = coordinates[i-1][0];
            double y0 = coordinates[0][1];
            double x0 = coordinates[0][0];

            if((y2-y1)*(x2-x0) != (y2-y0)*(x2-x1))
            {
                return false;
            }
        }
        return true;
    }

    /* naive solution
    Runtime: 1 ms, faster than 35.98% of Java online submissions for Check If It Is a Straight Line.
    Memory Usage: 43.9 MB, less than 36.27% of Java online submissions for Check If It Is a Straight Line.
     */
    public boolean checkStraightLine0(int[][] coordinates) {
        for(int i = 1; i < coordinates.length; i++)
        {
            double y2 = coordinates[i][1];
            double x2 = coordinates[i][0];
            double y1 = coordinates[i-1][1];
            double x1 = coordinates[i-1][0];
            double y0 = coordinates[0][1];
            double x0 = coordinates[0][0];
            if(x1 == x2  && x2 == x0)
                continue;
            else if(y1 == y2 && y2 == y0 )
                continue;
            else if((y2-y1)/(x2-x1) == (y2-y0)/(x2-x0) )
            {
                continue;
            }
            else
                return false;
        }
        return true;
    }
}
