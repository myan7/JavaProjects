package com.myjobhunting;

// https://leetcode.com/problems/find-the-student-that-will-replace-the-chalk/

/*
There are n students in a class numbered from 0 to n - 1.
The teacher will give each student a problem starting with the student number 0,
then the student number 1,
and so on until the teacher reaches the student number n - 1.
After that, the teacher will restart the process, starting with the student number 0 again.

You are given a 0-indexed integer array chalk and an integer k.
There are initially k pieces of chalk.
When the student number i is given a problem to solve, they will use chalk[i] pieces of chalk to solve that problem.
However, if the current number of chalk pieces is strictly less than chalk[i],
then the student number i will be asked to replace the chalk.

Return the index of the student that will replace the chalk.

Example 1:

Input: chalk = [5,1,5], k = 22
Output: 0
Explanation: The students go in turns as follows:
- Student number 0 uses 5 chalk, so k = 17.
- Student number 1 uses 1 chalk, so k = 16.
- Student number 2 uses 5 chalk, so k = 11.
- Student number 0 uses 5 chalk, so k = 6.
- Student number 1 uses 1 chalk, so k = 5.
- Student number 2 uses 5 chalk, so k = 0.
Student number 0 does not have enough chalk, so they will have to replace it.
Example 2:

Input: chalk = [3,4,1,2], k = 25
Output: 1
Explanation: The students go in turns as follows:
- Student number 0 uses 3 chalk so k = 22.
- Student number 1 uses 4 chalk so k = 18.
- Student number 2 uses 1 chalk so k = 17.
- Student number 3 uses 2 chalk so k = 15.
- Student number 0 uses 3 chalk so k = 12.
- Student number 1 uses 4 chalk so k = 8.
- Student number 2 uses 1 chalk so k = 7.
- Student number 3 uses 2 chalk so k = 5.
- Student number 0 uses 3 chalk so k = 2.
Student number 1 does not have enough chalk, so they will have to replace it.


Constraints:

chalk.length == n
1 <= n <= 105
1 <= chalk[i] <= 105
1 <= k <= 109
 */
public class MEDIUM_1894_FindtheStudentthatWillReplacetheChalk {

    /*
    Runtime: 1 ms, faster than 100.00% of Java online submissions for Find the Student that Will Replace the Chalk.
    Memory Usage: 55.2 MB, less than 85.57% of Java online submissions for Find the Student that Will Replace the Chalk.
    Time Complexity O(N)
    Space Complexity O(1)
     */
    public int chalkReplacer(int[] chalk, int k) {
        int sum = 0;
        for(int i = 0 ; i<chalk.length; i++)
        {
            sum += chalk[i];
            if(sum > k)
                return i;
        }
        k = k%sum;
        if(k == 0)
            return 0;
        sum = 0;
        for(int i = 0 ; i<chalk.length; i++)
        {
            sum += chalk[i];
            if(sum > k)
                return i;
        }
        return -1;
    }

    public int chalkReplacer_BS(int[] chalk, int k) {
        int sum = 0;
        int[] sums = new int[chalk.length];
        for(int i = 0 ; i<chalk.length; i++)
        {
            sum += chalk[i];
            sums[i] = sum;
            if(sum > k)
                return i;
        }
        k = k%sum;
        if(k == 0)
            return 0;
        int left = 0, right = chalk.length-1;
        while(left <= right)
        {
            int mid = left + (right - left)/2;
            if(sums[mid] == k)
                return mid+1; // you need to output the next i in chalk.
            else if(sums[mid] < k)
                left = mid+1;
            else
                right = mid-1;
        }
        return left;
    }

    // Memory Limit Exceeded
    /*
    chalk = [30,76,46,74,34,12,1,82,25,28,63,29,60,76,98,20,40,32,76,26,71]
    k = 346237330
     */
    public int chalkReplacer_MLE(int[] chalk, int k) {
        if(k <= 1)
            return 0;
        int[] dp = new int[k];
        dp[0] = chalk[0];
        for(int i = 1; i < k; i++)
        {
            dp[i] = dp[i-1] + chalk[i%chalk.length];
            if(dp[i] > k)
                return i%chalk.length;
        }
        return -1;
    }

    // Time Limit Exceeded
    public int chalkReplacer_TLE(int[] chalk, int k) {
        int ans = 0;
        for(int i = 0; i < chalk.length; i++)
        {
            k -= chalk[i];
            if(k < 0)
                return i;
            if( i == chalk.length-1)
                i = -1;
        }
        return -1;
    }
}
