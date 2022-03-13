package com.myjobhunting;

// https://leetcode.com/problems/average-salary-excluding-the-minimum-and-maximum-salary/

/*
You are given an array of unique integers, salary, where salary[i] is the salary of the ith employee.
Return the average salary of employees excluding the minimum and maximum salary.
Answers within 10^5 of the actual answer will be accepted.


Example 1:
Input: salary = [4000,3000,1000,2000]
Output: 2500.00000
Explanation: Minimum salary and maximum salary are 1000 and 4000 respectively.
Average salary excluding minimum and maximum salary is (2000+3000) / 2 = 2500

Example 2:
Input: salary = [1000,2000,3000]
Output: 2000.00000
Explanation: Minimum salary and maximum salary are 1000 and 3000 respectively.
Average salary excluding minimum and maximum salary is (2000) / 1 = 2000

Constraints:
3 <= salary.length <= 100
1000 <= salary[i] <= 106
All the integers of salary are unique.
 */

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.stream.Collectors;

public class EASY_1491_AverageSalaryExcludingtheMinimumandMaximumSalary {



    /*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Average Salary Excluding the Minimum and Maximum Salary.
    Memory Usage: 41.6 MB, less than 55.63% of Java online submissions for Average Salary Excluding the Minimum and Maximum Salary.
     */
    public double average(int[] salary) {
        int min = salary[0], max = salary[0], sum = 0;
        for(int s: salary)
        {
            min = Math.min(min,s);
            max = Math.max(max,s);
            sum += s;
        }
        return (double)(sum - min - max)/(salary.length-2);
    }

    /*
    Runtime: 3 ms, faster than 6.75% of Java online submissions for Average Salary Excluding the Minimum and Maximum Salary.
    Memory Usage: 40.2 MB, less than 72.55% of Java online submissions for Average Salary Excluding the Minimum and Maximum Salary.
     */
    public double average1(int[] salary) {
        IntSummaryStatistics stat = Arrays.stream(salary).boxed().collect(Collectors.summarizingInt(i -> i));
        return (double)(stat.getSum() - stat.getMax() - stat.getMin()) / (stat.getCount() - 2);
    }
}
