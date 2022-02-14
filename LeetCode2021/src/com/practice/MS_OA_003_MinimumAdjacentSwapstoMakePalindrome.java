package com.practice;
// https://algo.monster/problems/min_swaps_to_make_palindrome

/*
Given a string,
what is the minimum number of adjacent swaps required to convert a string into a palindrome.
If not possible, return -1.

Example 1:
Input: mamad
Output: 3
Explanation:
swap m with a => maamd
swap m with d => maadm
swap a with d => madam

Example 2:
Input: asflkj
Output: -1

Example 3:
Input: mideld
Output: 3
Explanation:
swap e with l => midled
swap e with d => midlde
swap l with d => middle

constraints:
all lower case
 */
public class MS_OA_003_MinimumAdjacentSwapstoMakePalindrome {
    public int minSwaps(String inp) {
        if(!canBeConverted(inp))
            return -1;
        int n = inp.length();
        char[] chArr = inp.toCharArray();
        int count = 0;
        int left=0, right = n-1;

        while(left < right){
            // check if the current position is palindrome
            // if is palindrome, move on to the next set
            if(chArr[left] == chArr[right]){
                left++;
                right--;
            }
            else  // if not palindrome,
            {
                int k = right;
                // find the corresponding character on the right-hand half.
                while(left < k && chArr[left] != chArr[k])
                {
                    k--;
                }
                // if size of the string is odd, the char in left is supposed to be in the middle point.
                if(left == k){
                    swap(chArr, left, left+1);
                    count++;
                }else{
                    swap(chArr, k, k+1);
                    count++;
                }
            }
        }
        return count;
    }
    private boolean canBeConverted(String s)
    {
        if(s == null || s.length() == 0)
            return false;
        int[] alphabet = new int[26];
        int oddCount = 0;
        for(char c: s.toCharArray())
        {
            alphabet[c-'a']++;
        }
        for(int val:alphabet)
        {
            if(val%2 != 0)
                oddCount++;
        }
        return oddCount <= 1;
    }

    private void swap(char[] arr, int i, int j){
        char t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
