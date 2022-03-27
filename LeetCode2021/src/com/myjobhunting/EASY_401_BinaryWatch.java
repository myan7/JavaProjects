package com.myjobhunting;
// https://leetcode.com/problems/binary-watch/

import java.util.ArrayList;
import java.util.List;

/*
A binary watch has 4 LEDs on the top which represent the hours (0-11),
and the 6 LEDs on the bottom represent the minutes (0-59).
Each LED represents a zero or one, with the least significant bit on the right.

For example, the below binary watch reads "4:51".
[0,1,0,0]       binary representation of 4
[1,1,0,0,1,1]   binary representation of 51
Given an integer turnedOn which represents the number of LEDs that are currently on,
return all possible times the watch could represent.
You may return the answer in any order.

The hour must not contain a leading zero.

For example, "01:00" is not valid. It should be "1:00".
The minute must be consisting of two digits and may contain a leading zero.

For example, "10:2" is not valid. It should be "10:02".

Example 1:
Input: turnedOn = 1
Output: ["0:01","0:02","0:04","0:08","0:16","0:32","1:00","2:00","4:00","8:00"]

Example 2:
Input: turnedOn = 9
Output: []

Constraints:

0 <= turnedOn <= 10
 */
public class EASY_401_BinaryWatch {

    /*
    DFS solution I think about writing, but I couldn't
    Runtime: 11 ms, faster than 66.67% of Java online submissions for Binary Watch.
    Memory Usage: 42.4 MB, less than 78.94% of Java online submissions for Binary Watch.
     */
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> list = new ArrayList<>();
        dfs(new int[10], 0, 0, list, turnedOn);
        return list;
    }

    private void dfs(int[] time, int i, int k, List<String> list, int num) {
        if(k == num) {
            String res = getTime(time);
            if(res != null)
                list.add(res);
            return;
        }
        if(i == time.length) {
            return;
        }
        time[i] = 0;
        dfs(time, i+1, k, list, num);

        time[i] = 1;
        dfs(time, i+1, k+1, list, num);

        time[i] = 0;
    }

    private String getTime(int[] time) {
        int hours = 0;
        for(int i = 0; i < 4; i++) {
            if(time[i] == 1) {
                hours = hours + (int)Math.pow(2, i);
            }
        }

        int minutes = 0;
        for(int i = 4; i < 10; i++) {
            if(time[i] == 1) {
                minutes = minutes + (int)Math.pow(2, i-4);
            }
        }
        if(hours  < 12  &&  minutes  <  60)
            return String.format("%d:%02d", hours, minutes);
        else
            return null;
        /*
        String min = "" + minutes;
        if(minutes  <  10)
            min = "0" + min;
        String res = hours + ":" + min;
        if(hours  >= 12  ||  minutes  >=  60)
            return null;
        return res;
        */
    }

    /* DFS
    Runtime: 8 ms, faster than 78.28% of Java online submissions for Binary Watch.
    Memory Usage: 40.8 MB, less than 92.04% of Java online submissions for Binary Watch.
     */
    public List<String> readBinaryWatch2(int turnedOn) {
        List<String> res = new ArrayList<>();
        int[] nums1 = new int[]{8, 4, 2, 1}, nums2 = new int[]{32, 16, 8, 4, 2, 1};
        for(int i = 0; i <= turnedOn; i++) {
            List<Integer> list1 = generateDigit(nums1, i);
            List<Integer> list2 = generateDigit(nums2, turnedOn - i);
            for(int num1: list1) {
                if(num1 >= 12) continue;
                for(int num2: list2) {
                    if(num2 >= 60) continue;
                    res.add(num1 + ":" + (num2 < 10 ? "0" + num2 : num2));
                }
            }
        }
        return res;
    }

    private List<Integer> generateDigit(int[] nums, int count) {
        List<Integer> res = new ArrayList<>();
        generateDigitHelper(nums, count, 0, 0, res);
        return res;
    }

    private void generateDigitHelper(int[] nums, int count, int pos, int sum, List<Integer> res) {
        if(count == 0) {
            res.add(sum);
            return;
        }

        for(int i = pos; i < nums.length; i++) {
            generateDigitHelper(nums, count - 1, i + 1, sum + nums[i], res);
        }
    }

    /*
    Runtime: 12 ms, faster than 59.54% of Java online submissions for Binary Watch.
    Memory Usage: 42 MB, less than 85.07% of Java online submissions for Binary Watch.
    if (Integer.bitCount(h * 64 + m) == turnedOn)
    is equivalent to
    if (Integer.bitCount(h) + Integer.bitCount(m) == turnedOn)
    only one bitCount will be pushed into the call stack, which could be a little more efficient.
     */
    public List<String> readBinaryWatch0(int turnedOn) {
        List<String> times = new ArrayList<>();
        for (int h=0; h<12; h++)
            for (int m=0; m<60; m++)
                if (Integer.bitCount(h * 64 + m) == turnedOn)
                    times.add(String.format("%d:%02d", h, m));
        return times;
    }

    /*
    Just for fun
    Runtime: 6 ms, faster than 82.42% of Java online submissions for Binary Watch.
    Memory Usage: 40.9 MB, less than 91.21% of Java online submissions for Binary Watch.
     */
    String[][] hour = {{"0"},  // hours contains 0 1's
            {"1", "2", "4", "8"},   // hours contains 1 1's
            {"3", "5", "6", "9", "10"},  // hours contains 2 1's
            {"7", "11"}};  // hours contains 3 1's
    String[][] minute = {{"00"},  // mins contains 0 1's
            {"01", "02", "04", "08", "16", "32"},  // mins contains 1 1's
            {"03", "05", "06", "09", "10", "12", "17", "18", "20", "24", "33", "34", "36", "40", "48"},  // mins contains 2 1's
            {"07", "11", "13", "14", "19", "21", "22", "25", "26", "28", "35", "37", "38", "41", "42", "44", "49", "50", "52", "56"},  // mins contains 3 1's
            {"15", "23", "27", "29", "30", "39", "43", "45", "46", "51", "53", "54", "57", "58"},  // mins contains 4 1's
            {"31", "47", "55", "59"}};  // mins contains 5 1's
    public List<String> readBinaryWatch1(int num) {
        List<String> ret = new ArrayList();
        // loop from 0 to 3 which is the max number of bits can be set in hours (4 bits)
        for (int i = 0; i <= 3 && i <= num; i++) {
            // this if condition is to make sure the index from minutes array would be valid
            if (num - i <= 5) {
                // if we have i 1's in hours, then we need n - i 1's in minutes, that's why the arrays were created by grouping the number of 1's bits
                for (String str1 : hour[i]) {
                    for (String str2 : minute[num - i]) {
                        ret.add(str1 + ":" + str2);
                    }
                }
            }
        }
        return ret;
    }
}
