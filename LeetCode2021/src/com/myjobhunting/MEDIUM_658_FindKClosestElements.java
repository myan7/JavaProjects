package com.myjobhunting;

// https://leetcode.com/problems/find-k-closest-elements/

import java.util.*;

/*
Given a sorted integer array arr, two integers k and x,
return the k closest integers to x in the array.
The result should also be sorted in ascending order.

An integer a is closer to x than an integer b if:

|a - x| < |b - x|, or |a - x| == |b - x| and a < b


Example 1:
Input: arr = [1,2,3,4,5], k = 4, x = 3
Output: [1,2,3,4]

Example 2:
Input: arr = [1,2,3,4,5], k = 4, x = -1
Output: [1,2,3,4]


Constraints:

1 <= k <= arr.length
1 <= arr.length <= 104
arr is sorted in ascending order.
-104 <= arr[i], x <= 104
 */
public class MEDIUM_658_FindKClosestElements {


    /* find the left most element that meets the criteria using Binary search
    Runtime: 3 ms, faster than 99.33% of Java online submissions for Find K Closest Elements.
    Memory Usage: 43.9 MB, less than 95.77% of Java online submissions for Find K Closest Elements.
    Time complexity: O(\log(N - k) + k)O(log(N−k)+k).\
        Although finding the bounds only takes O(log(N−k)) time from the binary search,
        it still costs us O(k) to build the final output.
        Both the Java and Python implementations require O(k) time to build the result.
        However, it is worth noting that if the input array were given as a list instead of an array of integers,
        then the Java implementation could use the ArrayList.subList() method to build the result in O(1) time.
        If this were the case, the Java solution would have an (extremely fast) overall time complexity of O(log(N−k)).

    Space complexity: O(1).
        Again, we use a constant amount of space for our pointers,
        and space used for the output does not count towards the space complexity.
     */
    public List<Integer> findClosestElements_LC(int[] arr, int k, int x) {
        // Initialize binary search bounds
        int left = 0;
        int right = arr.length - 1 - k;

        // Binary search against the criteria described
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (x - arr[mid] > arr[mid + k] - x) {
                left = mid + 1;
            } else {
                right = mid-1;
            }
        }

        // Create output in correct format
        List<Integer> result = new ArrayList<Integer>();
        for (int i = left; i < left + k; i++) {
            result.add(arr[i]);
        }

        return result;
    }

    /* find the element closest to x first using Binary Search and expand
    Runtime: 3 ms, faster than 99.35% of Java online submissions for Find K Closest Elements.
    Memory Usage: 44.4 MB, less than 83.36% of Java online submissions for Find K Closest Elements.
    Time complexity: O(log(N)+k).
        The initial binary search to find where we should start our window costs O(log(N)).
        Our sliding window initially starts with size 0, and we expand it one by one until it is of size k,
        thus it costs O(k) to expand the window.

    Space complexity: O(1)O(1)
        We only use integer variables left and right that are O(1) regardless of input size.
        Space used for the output is not counted towards the space complexity.
     */
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<Integer>();

        // best case
        if (arr.length == k) {
            for (int i = 0; i < k; i++) {
                result.add(arr[i]);
            }
            return result;
        }

        // Binary search to find the closest element
        int left = 0;
        int right = arr.length;
        int mid = 0;
        while (left < right) {
            mid = (left + right) / 2;
            if (arr[mid] >= x) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        // Initialize our sliding window's bounds
        left -= 1;
        right = left + 1;

        // While the window size is less than k
        while (right - left - 1 < k) {
            // Be careful to not go out of bounds
            if (left == -1) {
                right += 1;
                continue;
            }

            // Expand the window towards the side with the closer number
            // Be careful to not go out of bounds with the pointers
            if (right == arr.length || Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)) {
                left -= 1;
            } else {
                right += 1;
            }
        }

        // Build and return the window
        for (int i = left + 1; i < right; i++) {
            result.add(arr[i]);
        }

        return result;
    }

    /*
    Runtime: 4 ms, faster than 88.03% of Java online submissions for Find K Closest Elements.
    Memory Usage: 44.3 MB, less than 85.62% of Java online submissions for Find K Closest Elements.
     */
    public List<Integer> findClosestElements_UpdatedBS(int[] arr, int k, int x) {
        List<Integer> ans = new ArrayList<>();
        // find the closest element in arr to x.
        int left = 0, right = arr.length-1;
        while(left <= right)
        {
            int mid = left +(right - left)/2;
            if(arr[mid] <= x)
                left = mid + 1;
            else
                right = mid-1;
        }
        left--;
        right++;
        LinkedList<Integer> tmp = new LinkedList<>();

        int count = 0;
        while(left >= 0 || right < arr.length)
        {
            if(count == k)
                break;
            else
            {
                count++;
                if(left < 0)
                {
                    right++;
                    continue;
                }
                else if(right == arr.length)
                {
                    left--;
                    continue;
                }

                int l = arr[left], r = arr[right];
                if(Math.abs(l-x) <= Math.abs(r-x))
                {
                    left--;
                }
                else
                    right++;
            }
        }
        for(int i = left+1; i < right;i++)
        {
            ans.add(arr[i]);
        }
        return ans;
    }

    /*
    Runtime: 8 ms, faster than 46.20% of Java online submissions for Find K Closest Elements.
    Memory Usage: 44.2 MB, less than 85.62% of Java online submissions for Find K Closest Elements.
     */
    public List<Integer> findClosestElements_originalBS(int[] arr, int k, int x) {
        List<Integer> ans = new ArrayList<>();
        // find the closest element in arr to x.
        int left = 0, right = arr.length-1;
        while(left <= right)
        {
            int mid = left +(right - left)/2;
            if(arr[mid] <= x)
                left = mid + 1;
            else
                right = mid-1;
        }
        // get the starting point.
        left--;
        right++;
        LinkedList<Integer> tmp = new LinkedList<>();

        while(left >= 0 || right < arr.length)
        {
            // threshold of break
            if(tmp.size() == k)
                break;
            // boundary check
            if(left < 0)
            {
                tmp.addLast(arr[right++]);
                continue;
            }
            else if(right == arr.length)
            {
                tmp.addFirst(arr[left--]);
                continue;
            }
            // general case
            int l = arr[left], r = arr[right];
            if(Math.abs(l-x) <= Math.abs(r-x))
            {
                tmp.addFirst(arr[left--]);
            }
            else
                tmp.addLast(arr[right++]);

        }
        for(Integer val : tmp)
            ans.add(val);
        return ans;
    }

    /*
    Runtime: 22 ms, faster than 22.72% of Java online submissions for Find K Closest Elements.
    Memory Usage: 44.9 MB, less than 78.21% of Java online submissions for Find K Closest Elements.
     */
    public List<Integer> findClosestElements2(int[] arr, int k, int x) {
        List<Integer> ans = new ArrayList<>();
        for(int val: arr)
            ans.add(val);
        Collections.sort(ans,(a,b) -> Math.abs(a-x) - Math.abs(b-x));
        ans = ans.subList(0, k);
        Collections.sort(ans);
        return ans;
    }

    public List<Integer> findClosestElements1(int[] arr, int k, int x) {
        int[][] scores = new int[arr.length][2];
        for(int i = 0; i < arr.length; i++)
        {
            scores[i][0] = arr[i];
            scores[i][1] = Math.abs(arr[i]-x);
        }
        Arrays.sort(scores,(a, b)-> a[0] == b[0]? a[0]-b[0]: a[1]-b[1]);
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < k ; i++)
        {
            ans.add(scores[i][0]);
        }
        Collections.sort(ans);
        return ans;
    }

    /*
    Runtime: 50 ms, faster than 14.09% of Java online submissions for Find K Closest Elements.
    Memory Usage: 45.2 MB, less than 77.57% of Java online submissions for Find K Closest Elements.
     */
    public List<Integer> findClosestElements0(int[] arr, int k, int x) {
        PriorityQueue<Integer> pool = new PriorityQueue<Integer>(
                (a,b) -> Math.abs(a-x) == Math.abs(b-x)? b-a: Math.abs(b-x) - Math.abs(a-x));
        for(int val : arr)
        {
            pool.offer(val);
            if(pool.size() > k)
                pool.poll();
        }
        List<Integer> ans = new ArrayList<>();
        for(Integer val: pool)
        {
            ans.add(val);
        }
        Collections.sort(ans);
        return ans;
    }

}
