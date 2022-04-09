package com.myjobhunting;
// https://leetcode.com/problems/kth-largest-element-in-a-stream/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/*
Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order, not the kth distinct element.

Implement KthLargest class:

KthLargest(int k, int[] nums) Initializes the object with the integer k and the stream of integers nums.
int add(int val) Appends the integer val to the stream and returns the element representing the kth largest element in the stream.


Example 1:

Input
["KthLargest", "add", "add", "add", "add", "add"]
[[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
Output
[null, 4, 5, 5, 8, 8]

Explanation
KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
kthLargest.add(3);   // return 4
kthLargest.add(5);   // return 5
kthLargest.add(10);  // return 5
kthLargest.add(9);   // return 8
kthLargest.add(4);   // return 8


Constraints:

1 <= k <= 104
0 <= nums.length <= 104
-104 <= nums[i] <= 104
-104 <= val <= 104
At most 104 calls will be made to add.
It is guaranteed that there will be at least k elements in the array when you search for the kth element.
 */
public class EASY_703_KthLargestElementinaStream {

    /*
    Runtime: 752 ms, faster than 5.02% of Java online submissions for Kth Largest Element in a Stream.
    Memory Usage: 50 MB, less than 80.22% of Java online submissions for Kth Largest Element in a Stream.
     */
    class KthLargest {
        List<Integer> list = new ArrayList<>();
        int key;
        public KthLargest(int k, int[] nums) {
            for(int num : nums)
                list.add(num);
            key = k-1;
        }

        public int add(int val) {
            list.add(val);
            Collections.sort(list, (a, b) -> b-a);
            return list.get(key);
        }
    }

    /*
    Runtime: 18 ms, faster than 75.33% of Java online submissions for Kth Largest Element in a Stream.
    Memory Usage: 53.3 MB, less than 14.37% of Java online submissions for Kth Largest Element in a Stream.
     */
    class KthLargest_LC {
        private static int k;
        private PriorityQueue<Integer> heap;
        public KthLargest_LC(int k, int[] nums) {
            this.k = k;
            heap = new PriorityQueue<>();

            for (int num: nums) {
                heap.offer(num);
            }

            while (heap.size() > k) {
                heap.poll();
            }
        }

        public int add(int val) {
            heap.offer(val);
            if (heap.size() > k) {
                heap.poll();
            }

            return heap.peek();
        }
    }
}
