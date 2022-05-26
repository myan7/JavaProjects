package com.myjobhunting;
// https://leetcode.com/problems/largest-number-after-digit-swaps-by-parity/

import java.util.*;

/*
You are given a positive integer num.
You may swap any two digits of num that have the same parity (i.e. both odd digits or both even digits).
Return the largest possible value of num after any number of swaps.

Example 1:
Input: num = 1234
Output: 3412
Explanation: Swap the digit 3 with the digit 1, this results in the number 3214.
Swap the digit 2 with the digit 4, this results in the number 3412.
Note that there may be other sequences of swaps but it can be shown that 3412 is the largest possible number.
Also note that we may not swap the digit 4 with the digit 1 since they are of different parities.

Example 2:
Input: num = 65875
Output: 87655
Explanation: Swap the digit 8 with the digit 6, this results in the number 85675.
Swap the first digit 5 with the digit 7, this results in the number 87655.
Note that there may be other sequences of swaps, but it can be shown that 87655 is the largest possible number.

Constraints:
1 <= num <= 10^9

 */
public class EASY_2231_LargestNumberAfterDigitSwapsbyParity {

    /*
    Runtime: 1 ms, faster than 98.71% of Java online submissions for Largest Number After Digit Swaps by Parity.
    Memory Usage: 41.3 MB, less than 58.66% of Java online submissions for Largest Number After Digit Swaps by Parity.
     */
    public int largestInteger(int num) {
        char[] a = String.valueOf(num).toCharArray();
        for(int i = 0; i < a.length; i++)
            for(int j = i + 1; j < a.length; j++)
                if(a[j] > a[i] && (a[j] - a[i]) % 2 == 0){
                    char t = a[i];
                    a[i] = a[j];
                    a[j] = t;
                }
        return Integer.parseInt(new String(a));
    }

    /* Counting sort
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Largest Number After Digit Swaps by Parity.
    Memory Usage: 39.1 MB, less than 97.62% of Java online submissions for Largest Number After Digit Swaps by Parity.
     */
    public int largestInteger2(int num) {
        char[] nums = Integer.toString(num).toCharArray();

        //Calculate the frequency of each digit from 0 - 9
        int[] frequency = new int[10];
        for (int index = 0; index < nums.length; index++) {
            frequency[nums[index] - '0']++;
        }

        int newNumber = 0;
        int evenIndex = 8; // corresponds to the number 8
        int oddIndex = 9; // corresponds to the number 9

        // construct the number
        for(int index = 0; index < nums.length; index++) {
            // If the parity of number in current index is even
            if(nums[index] % 2 == 0) {
                // Get first even digit of non-zero frequency
                while(frequency[evenIndex]==0) {
                    evenIndex -= 2;
                }
                frequency[evenIndex]--;
                newNumber = newNumber*10 + evenIndex;
            } else {
                // If the parity of number in current index is odd
                // Get first odd digit of non-zero frequency
                while(frequency[oddIndex]==0) {
                    oddIndex -= 2;
                }
                frequency[oddIndex]--;
                newNumber = newNumber*10 + oddIndex;
            }
        }
        return newNumber;
    }

    /*
    Runtime: 2 ms, faster than 83.83% of Java online submissions for Largest Number After Digit Swaps by Parity.
    Memory Usage: 39.4 MB, less than 88.65% of Java online submissions for Largest Number After Digit Swaps by Parity.
     */
    public int largestInteger1(int num) {
        PriorityQueue<Integer> opq = new PriorityQueue<>();
        PriorityQueue<Integer> epq = new PriorityQueue<>();
        int bnum = num;
        while(num>0){
            int cur = num%10;
            if(cur%2==1){
                opq.offer(cur);
            }else{
                epq.offer(cur);
            }
            num /= 10;
        }
        StringBuilder sb = new StringBuilder();
        num = bnum;
        while(num>0){
            int cur = num%10;
            if(cur%2==1)
                sb.insert(0, opq.poll());
            else
                sb.insert(0, epq.poll());
            num /= 10;
        }
        return Integer.parseInt(sb.toString());
    }

    /*
    Runtime: 4 ms, faster than 45.02% of Java online submissions for Largest Number After Digit Swaps by Parity.
    Memory Usage: 41.3 MB, less than 49.40% of Java online submissions for Largest Number After Digit Swaps by Parity.
     */
    public int largestInteger0(int num) {
        List<Integer> odd = new ArrayList<>();
        List<Integer> even = new ArrayList<>();
        List<Integer> digits = new ArrayList<>();
        while(num > 0)
        {
            digits.add(0,num%10);
            num /= 10;
        }
        for(int i = 0; i < digits.size(); i++)
        {
            if(digits.get(i)%2 == 0)
                even.add(digits.get(i));
            else
                odd.add(digits.get(i));
        }
        Collections.sort(even, Comparator.reverseOrder());
        Collections.sort(odd, Comparator.reverseOrder());

        StringBuilder sb = new StringBuilder();
        int evenInd = 0, oddInd = 0;
        for(int i = 0; i < digits.size(); i++)
        {
            if(digits.get(i) % 2 == 0)
                sb.append(even.get(evenInd++));
            else
                sb.append(odd.get(oddInd++));
        }

        int ans = Integer.parseInt(sb.toString());
        return ans;
    }
}
