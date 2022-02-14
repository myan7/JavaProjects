package com.myjobhunting;

// https://leetcode.com/problems/minimum-deletions-to-make-string-balanced/

/*
You are given a string s consisting only of characters 'a' and 'b'.

You can delete any number of characters in s to make s balanced.
s is balanced if there is no pair of indices (i,j) such that i < j and s[i] = 'b' and s[j]= 'a'.

Return the minimum number of deletions needed to make s balanced.
1 <= s.length <= 105
s[i] is 'a' or 'b'.
 */
// similar to
// https://www.geeksforgeeks.org/minimum-deletions-from-string-to-reduce-it-to-string-with-at-most-2-unique-characters/

public class MEDIUM_1653_MinimumDeletionstoMakeStringBalanced {
    // the idea is to find how many b appears in the a half.
    //
    public int minimumDeletions0(String s) {
        int numDel = 0;
        int numB = 0;
        for(char c : s.toCharArray())
        {
            if(c == 'a')
                numDel = Math.min(numB,numDel+1);
            else
                numB++;
        }
        return numDel;
    }

    public int minimumDeletions(String s) {

        int n = s.length() ;

        int[] a = new int[n + 1] ;
        int[] b = new int[n + 1] ;

        for(int i = 1 ; i <= n ; i++) {

            a[i] += a[i - 1] ;
            a[i] += s.charAt(i - 1) == 'a' ? 1 : 0 ;

            b[i] += b[i - 1] ;
            b[i] += s.charAt(i - 1) == 'b' ? 1 : 0 ;

        }

        int max = a[n] ;
        for(int i = 1 ; i <= n ; i++) {
            max = Math.min(max , b[i] + (a[n] - a[i])) ;
        }
        return max ;
    }

    // 30 ms
    public int minimumDeletions2(String s) {
        int flips = 0 ;
        int ones = 0 ;
        for(int i=0 ; i<s.length() ; i++) {
            char ch = s.charAt(i) ;
            if(ch == 'a') {
                if(ones == 0) continue ;
                flips++ ;
            }else{
                ones++ ;
            }

            if(flips > ones) {
                flips = ones ;
            }
        }
        return flips ;
    }

    // 57ms
    public int minimumDeletions1(String s) {
        int n = s.length();
        int[] aSum = new int[n+1], bSum = new int[n+1];
        for (int i = 1; i<=n; i++) {
            aSum[i] = aSum[i-1];
            aSum[i] += s.charAt(i-1) == 'a' ? 1 : 0;
            bSum[i] = bSum[i-1];
            bSum[i] += s.charAt(i-1) == 'b' ? 1 : 0;
        }
        int ans = aSum[n]; // aSum[n] -> remove all a's and we have only b left
        for (int i = 1; i <= n; i++) {
            // prefix end at i is 'a' and suffix start at i+1 is 'b'
            ans = Math.min(ans, bSum[i]+(aSum[n]-aSum[i]));
        }
        return ans;
    }
}
