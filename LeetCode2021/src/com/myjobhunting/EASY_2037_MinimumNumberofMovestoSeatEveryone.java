package com.myjobhunting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/minimum-number-of-moves-to-seat-everyone/
/*
There are n seats and n students in a room.
You are given an array seats of length n, where seats[i] is the position of the ith seat.
You are also given the array students of length n, where students[j] is the position of the jth student.

You may perform the following move any number of times:
Increase or decrease the position of the ith student by 1 (i.e., moving the ith student from position x to x + 1 or x - 1)
Return the minimum number of moves required to move each student to a seat such that no two students are in the same seat.

Note that there may be multiple seats or students in the same position at the beginning.
 */
public class EASY_2037_MinimumNumberofMovestoSeatEveryone {
    public int minMovesToSeat(int[] seats, int[] students) {
        int[] seatsMap = new int[101];
        int[] studentsMap = new int[101];
        for(int i : seats)
            seatsMap[i]++;
        for(int i : students)
            studentsMap[i]++;
        int moves= 0;
        int i = 1, j = 1;
        while( i < 101)
        {
            if(seatsMap[i] > 0)
            {
                while(j < 101 && studentsMap[j] == 0)
                    j++;
                moves += Math.abs(i-j);
                seatsMap[i]--;
                studentsMap[j]--;
            }
            else
                i++;
        }
        return moves;
    }

    public int minMovesToSeat0(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int diff = 0;
        for(int i=0; i<seats.length; i++){
            diff +=  Math.abs(students[i]-seats[i]);
        }
        return diff;
    }
}
