package com.myjobhunting;

public class EASY_108_ConvertSortedArraytoBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0 ) return null;
        return helper(nums,0,nums.length-1);
    }

    private TreeNode helper(int[] arr, int left, int right)
    {
        if(left > right)
            return null;
        int mid = left + (right-left)/2;
        TreeNode root = new TreeNode(arr[mid]);
        root.left = helper(arr,left,mid-1);
        root.right = helper(arr,mid+1,right);
        return root;
    }


}
