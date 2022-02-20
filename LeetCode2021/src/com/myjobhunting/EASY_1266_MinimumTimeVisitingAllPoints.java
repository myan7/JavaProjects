package com.myjobhunting;
// https://leetcode.com/problems/minimum-time-visiting-all-points/

/*
On a 2D plane, there are n points with integer coordinates points[i] = [xi, yi].
Return the minimum time in seconds to visit all the points in the order given by points.

You can move according to these rules:
In 1 second, you can either:
    move vertically by one unit,
    move horizontally by one unit, or
    move diagonally sqrt(2) units (in other words, move one unit vertically then one unit horizontally in 1 second).
You have to visit the points in the same order as they appear in the array.
You are allowed to pass through points that appear later in the order, but these do not count as visits.

Example 1:
Input: points = [[1,1],[3,4],[-1,0]]
Output: 7
Explanation: One optimal path is [1,1] -> [2,2] -> [3,3] -> [3,4] -> [2,3] -> [1,2] -> [0,1] -> [-1,0]
Time from [1,1] to [3,4] = 3 seconds
Time from [3,4] to [-1,0] = 4 seconds
Total time = 7 seconds

Example 2:
Input: points = [[3,2],[-2,2]]
Output: 5


Constraints:
points.length == n
1 <= n <= 100
points[i].length == 2
-1000 <= points[i][0], points[i][1] <= 1000
 */
public class EASY_1266_MinimumTimeVisitingAllPoints {
    /*
    Proof:
    the time cost to travel between 2 neighboring points equals
    the larger value between the absolute values of the difference of respective x and y coordinates of the 2 points.

    a) Consider 2 points (x1, y1) and (x2, y2),
        let dx = |x1 - x2| and dy = |y1 - y2|;
        According to the constraints of the problem, each step at most moves 1 unit along x and/or y coordinate.
        Therefore, min time >= max(dx, dy);

    b) On the other hand,
        each step can move 1 unit along x/y coordinate to cover the distance dx/dy, whichever is greater;
        Therefore, min time <= max(dx, dy);

    Combine the above a) and b), we have max(dx, dy) <= min time <= max(dx, dy) to complete the proof.
    End of Proof
     */
    // 1ms faster than 72.59%
    public int minTimeToVisitAllPoints(int[][] points) {
        int count = 0;

        for(int i = 1; i < points.length ; i++)
        {
            int[] curr = points[i], prev = points[i - 1];
            count += Math.max(Math.abs(prev[0] - curr[0]), Math.abs(prev[1] - curr[1]));
        }
        return count;
    }

    // naive solution 34 ms faster than 5.06%
    public int minTimeToVisitAllPoints0(int[][] points) {
        int count = 0;

        for(int i = 1; i < points.length ; i++)
        {
            int prevX = points[i-1][0];
            int prevY = points[i-1][1];
            int currX = points[i][0];
            int currY = points[i][1];

            while(prevX != currX || prevY != currY )
            {
                if(currX > prevX && currY > prevY)
                {
                    prevX++;
                    prevY++;
                    count++;
                }
                else if(currX > prevX && currY < prevY)
                {
                    prevX++;
                    prevY--;
                    count++;
                }
                else if(currX < prevX && currY < prevY)
                {
                    prevX--;
                    prevY--;
                    count++;
                }
                else if(currX < prevX && currY > prevY)
                {
                    prevX--;
                    prevY++;
                    count++;
                }
                else if(currX == prevX && currY > prevY)
                {
                    prevY++;
                    count++;
                }
                else if(currX == prevX && currY < prevY) // Warning:(107, 43) Condition 'currY < prevY' is always 'true' when reached
                {
                    prevY--;
                    count++;
                }
                else if(currX > prevX && currY == prevY) // Warning:(112, 42) Condition 'currY == prevY' is always 'true' when reached
                {
                    prevX ++;
                    count++;
                }
                else if(currX < prevX && currY == prevY) // Warning:(117, 25) Condition 'currX < prevX' is always 'true'
                { // Warning:(117, 25) Condition 'currX < prevX && currY == prevY' is always 'true'
                    prevX--;
                    count++;
                }
            }

        }
        return count;
    }
}
