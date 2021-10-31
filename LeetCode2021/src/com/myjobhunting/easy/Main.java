package com.myjobhunting.easy;

public class Main {

    public static void main(String[] args) {
	// write your code here
        /* 001 two sum */
        int[] arr = new int[]{3,2,0,4,5};
        int target = 6;

        EASY_001_TwoSum solution = new EASY_001_TwoSum();
        int[] ans = solution.twoSum(arr,target);

        System.out.println("The answer to easy 001 two sum is ["+ ans[0]+", "+ ans[1]+ "]." );
    }
}
