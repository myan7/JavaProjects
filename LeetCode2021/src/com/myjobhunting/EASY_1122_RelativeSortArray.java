package com.myjobhunting;

import java.util.*;

// https://leetcode.com/problems/relative-sort-array/
/*
Given two arrays arr1 and arr2, the elements of arr2 are distinct,
and all elements in arr2 are also in arr1.

Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2.
Elements that do not appear in arr2 should be placed at the end of arr1 in ascending order.

Example 1:
Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
Output: [2,2,2,1,4,3,3,9,6,7,19]
Example 2:
Input: arr1 = [28,6,22,8,44,17], arr2 = [22,28,8,6]
Output: [22,28,8,6,17,44]

Constraints:
1 <= arr1.length, arr2.length <= 1000
0 <= arr1[i], arr2[i] <= 1000
All the elements of arr2 are distinct.
Each arr2[i] is in arr1.
 */
public class EASY_1122_RelativeSortArray {

    /*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Relative Sort Array.
    Memory Usage: 40.7 MB, less than 64.72% of Java online submissions for Relative Sort Array.
    */
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int [] map = new int[1001];
        for(int a:arr1){
            map[a]++;
        }
        int i=0;
        for(int b:arr2){
            while(map[b]!=0){
                map[b]--;
                arr1[i] = b;
                i++;
            }
        }
        for(int j=0;j<map.length;j++){
            while(map[j]!=0){
                arr1[i] = j;
                map[j]--;
                i++;
            }
        }
        return arr1;
    }
    /*
    Runtime: 1 ms, faster than 86.78% of Java online submissions for Relative Sort Array.
    Memory Usage: 42.1 MB, less than 55.32% of Java online submissions for Relative Sort Array.
     */
    public int[] relativeSortArray1(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap();
        List<Integer> list = new ArrayList();
        for(int num : arr2){
            map.put(num,0);
        }
        for(int num : arr1){
            if(map.containsKey(num)){
                map.put(num,map.get(num)+1);
            }else{
                list.add(num);
            }
        }
        int index = 0;
        for(int num : arr2){
            while(map.get(num) > 0){
                arr1[index++] = num;
                map.put(num,map.get(num)-1);
            }
        }
        Integer[] arr = list.toArray(new Integer[list.size()]);
        Arrays.sort(arr);
        for(int num : arr){
            arr1[index++] = num;
        }
        return arr1;
    }

    /*
    Runtime: 3 ms, faster than 55.32% of Java online submissions for Relative Sort Array.
    Memory Usage: 43.4 MB, less than 7.79% of Java online submissions for Relative Sort Array.
     */
    public int[] relativeSortArray0_updated(int[] arr1, int[] arr2) {
        int[] ans = new int[arr1.length];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : arr1)
            map.put(i,map.getOrDefault(i,0)+1);
        int index = 0;
        for(int i : arr2)
        {
            while(map.get(i) > 0)
            {
                ans[index++] = i;
                map.put(i,map.get(i)-1);
            }
            map.remove(i);
        }
        int[] tmp = new int[map.size()];
        int j = 0;
        for(Map.Entry<Integer, Integer> en : map.entrySet())
        {
            tmp[j++] = en.getKey();
        }
        Arrays.sort(tmp);
        j = 0;
        for(int i = index ; i < arr1.length ;)
        {
            while(map.get(tmp[j]) > 0)
            {
                ans[i++] = tmp[j];
                map.put(tmp[j],map.get(tmp[j])-1);
            }
            j++;
        }
        return ans;
    }

    /* initial solution, could be better. I lost focus when resolving it.
    Runtime: 4 ms, faster than 45.23% of Java online submissions for Relative Sort Array.
    Memory Usage: 42.8 MB, less than 34.45% of Java online submissions for Relative Sort Array.
     */
    public int[] relativeSortArray0(int[] arr1, int[] arr2) {
        int[] ans = new int[arr1.length];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : arr1)
            map.put(i,map.getOrDefault(i,0)+1);
        int index = 0;
        for(int i : arr2)
        {
            if(map.containsKey(i))
            {
                int count = map.get(i);
                while(count > 0)
                {
                    ans[index++] = i;
                    count--;
                }
                map.remove(i);
            }
        }
        int[] tmp = new int[map.size()];
        int j = 0;
        for(Map.Entry<Integer, Integer> en : map.entrySet())
        {
            tmp[j++] = en.getKey();
        }
        Arrays.sort(tmp);
        j = 0;
        for(int i = index ; i < arr1.length ;)
        {
            int count = map.get(tmp[j]);
            while(count > 0)
            {
                ans[i++] = tmp[j];
                count--;
            }
            map.remove(tmp[j]);
            j++;
        }
        return ans;
    }
}
