package com.myjobhunting;

// https://leetcode.com/problems/boats-to-save-people/

import java.util.Arrays;
import java.util.Stack;

/*
You are given an array, people, where people[i] is the weight of the ith person,
and an infinite number of boats where each boat can carry a maximum weight, limit.
Each boat carries at most two people at the same time,
provided the sum of the weight of those people is at most limit.

Return the minimum number of boats to carry every given person.

Example 1:
Input: people = [1,2], limit = 3
Output: 1
Explanation: 1 boat (1, 2)

Example 2:
Input: people = [3,2,2,1], limit = 3
Output: 3
Explanation: 3 boats (1, 2), (2) and (3)

Example 3:
Input: people = [3,5,3,4], limit = 5
Output: 4
Explanation: 4 boats (3), (3), (4), (5)

Constraints:

1 <= people.length <= 5 * 104
1 <= people[i] <= limit <= 3 * 104
 */
public class MEDIUM_881_BoatstoSavePeople {

    /* updated version
    Runtime: 14 ms, faster than 97.12% of Java online submissions for Boats to Save People.
    Memory Usage: 50.4 MB, less than 89.96% of Java online submissions for Boats to Save People.
     */
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int count = 0;
        int left = 0, right = people.length-1;
        while(left <= right)
        {
            if(people[left] + people[right] > limit)
            {
                count++;
                right--;
            }
            else if(people[left] + people[right] <= limit)
            {
                count++;
                right--;
                left++;
            }
        }
        return count;
    }

    /*
    Runtime: 33 ms, faster than 5.83% of Java online submissions for Boats to Save People.
    Memory Usage: 70 MB, less than 5.39% of Java online submissions for Boats to Save People.
     */
    public int numRescueBoats0(int[] people, int limit) {
        Arrays.sort(people);
        Stack<Integer> stack = new Stack<>();
        int left = 0, right = people.length-1;
        while(left <= right)
        {
            if(people[left] + people[right] > limit)
            {
                stack.push(people[right--]);
            }
            else if(people[left] + people[right] <= limit)
            {
                stack.push(people[left++] + people[right--]);
            }

        }
        return stack.size();
    }

}
