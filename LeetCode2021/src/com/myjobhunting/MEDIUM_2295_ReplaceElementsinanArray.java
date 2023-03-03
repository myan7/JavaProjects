package com.myjobhunting;

import java.util.HashMap;
import java.util.Map;

public class MEDIUM_2295_ReplaceElementsinanArray {

    public int[] arrayChange(int[] nums, int[][] operations) {
        HashMap<Integer,Integer> map =new HashMap<>();
        for(int i = 0;i < nums.length;i++){
            map.put(nums[i],i); // map the value with ther index

        }
        for(int[] arr : operations){
            nums[map.get(arr[0])] = arr[1];
            map.put(arr[1],map.get(arr[0])); // add the new value in the map
            map.remove(arr[0]); // remove the value that has been replaced
        }
        return nums;
    }

    /*
    Runtime: 123 ms, faster than 16.67% of Java online submissions for Replace Elements in an Array.
    Memory Usage: 168.5 MB, less than 16.67% of Java online submissions for Replace Elements in an Array.
     */
    public int[] arrayChange0(int[] nums, int[][] operations) {
        Map<Integer, Integer> valueIndex = new HashMap<>();

        for(int i = 0; i< nums.length;i++)
            valueIndex.put(nums[i],i);

        for(int[] op: operations)
        {
            nums[valueIndex.get(op[0])] = op[1];
            valueIndex.put(op[1],valueIndex.get(op[0]));
        }

        return nums;
    }
}
