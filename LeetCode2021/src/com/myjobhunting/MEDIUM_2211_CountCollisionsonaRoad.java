package com.myjobhunting;

/*
There are n cars on an infinitely long road.
The cars are numbered from 0 to n - 1 from left to right and each car is present at a unique point.

You are given a 0-indexed string directions of length n.
directions[i] can be either 'L', 'R', or 'S'
denoting whether the ith car is moving towards the left, towards the right, or staying at its current point respectively.
Each moving car has the same speed.

The number of collisions can be calculated as follows:

When two cars moving in opposite directions collide with each other, the number of collisions increases by 2.
When a moving car collides with a stationary car, the number of collisions increases by 1.
After a collision, the cars involved can no longer move and will stay at the point where they collided.
Other than that, cars cannot change their state or direction of motion.

Return the total number of collisions that will happen on the road.

Example 1:
Input: directions = "RLRSLL"
Output: 5
Explanation:
The collisions that will happen on the road are:
- Cars 0 and 1 will collide with each other. Since they are moving in opposite directions, the number of collisions becomes 0 + 2 = 2.
- Cars 2 and 3 will collide with each other. Since car 3 is stationary, the number of collisions becomes 2 + 1 = 3.
- Cars 3 and 4 will collide with each other. Since car 3 is stationary, the number of collisions becomes 3 + 1 = 4.
- Cars 4 and 5 will collide with each other. After car 4 collides with car 3, it will stay at the point of collision and get hit by car 5. The number of collisions becomes 4 + 1 = 5.
Thus, the total number of collisions that will happen on the road is 5.

Example 2:
Input: directions = "LLRR"
Output: 0
Explanation:
No cars will collide with each other. Thus, the total number of collisions that will happen on the road is 0.

Constraints:
1 <= directions.length <= 105
directions[i] is either 'L', 'R', or 'S'.
 */

import java.util.Stack;

public class MEDIUM_2211_CountCollisionsonaRoad {

    /*
    Runtime: 42 ms, faster than 33.33% of Java online submissions for Count Collisions on a Road.
    Memory Usage: 56 MB, less than 33.33% of Java online submissions for Count Collisions on a Road.
     */
    public int countCollisions(String directions) {
        int ret = 0;

        char[] arr = directions.toCharArray();
        for(int i=1; i<arr.length; i++) {
            char pre = arr[i-1];
            if(arr[i] == 'L' && pre != 'L') {
                ret++;
                arr[i-1] = 'S';
                arr[i] = 'S';
            }
        }

        arr = directions.toCharArray();
        for(int i=arr.length-2; i>=0; i--) {
            char pre = arr[i+1];
            if(arr[i] == 'R' && pre != 'R') {
                ret++;
                arr[i+1] = 'S';
                arr[i] = 'S';
            }
        }
        return ret;
    }

    /*
    Runtime: 343 ms, faster than 33.33% of Java online submissions for Count Collisions on a Road.
    Memory Usage: 66.7 MB, less than 33.33% of Java online submissions for Count Collisions on a Road.
     */
    public int countCollisions_initial(String directions) {
        int count = 0;
        Stack<Integer> stack = new Stack<>();

        for(char c : directions.toCharArray())
        {
            int val = 0;
            if(c == 'R') val = 1;
            if(c == 'L') val = -1;
            if(c == 'S') val = 0;
            if(!stack.isEmpty() && val < stack.peek())
            {
                if(val == -1 && stack.peek() == 1)
                {
                    count += 2;
                    stack.pop();
                    val = 0;
                }
                else if(val == -1 && stack.peek() == 0)
                {
                    count +=1;
                    val = 0;
                }
                while(!stack.isEmpty() && stack.peek() == 1)
                {
                    count +=1;
                    stack.pop();
                }
            }
            stack.push(val);
        }
        return count;
    }

}
