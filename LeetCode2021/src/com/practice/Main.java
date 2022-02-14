package com.practice;

public class Main {
    public static void main(String[] args)
    {
        /*
        MS_OA_003_MinimumAdjacentSwapstoMakePalindrome solution = new MS_OA_003_MinimumAdjacentSwapstoMakePalindrome();
        String s1 = "bcaab";
        int ans = solution.minSwaps(s1);
        System.out.println(ans);
         */

        /*
        MS_OA_004_LexcicographicallySmallestString solution = new MS_OA_004_LexcicographicallySmallestString();
        String t = "abcdea";
        System.out.println(solution.smallestString(t));
        */

        ///*
        MS_OA_007_RemoveOne5 solution = new MS_OA_007_RemoveOne5();
        int val = -5505;
        int ans = solution.getMaxbyRemovingOne5(val);
        System.out.println(ans);
        //*/



        /*
        MS_OA_008_GetSign solution = new MS_OA_008_GetSign();
        int[] t = {1,2,0,-3};
        System.out.println(solution.getSign(t));
        */

        /*
        Learning_DP test = new Learning_DP();
        // for time lapse calculation
        long start = 0, end = 0;


        canSum test
        int target = 7;
        int[] numbers = new int[]{2,3,6,9};
        System.out.println(test.canSumRec(target,numbers));
        */

        /*
        GridTraveller test

        int[][] matrix = new int[18][18];
        int m = matrix.length;
        int n = matrix[0].length;
        */

        /*
        start = System.currentTimeMillis();
        System.out.println(test.gridTravellerRecur(matrix));
        end = System.currentTimeMillis();
        System.out.println("recursive grid takes "+ (end-start) + " ms to count traversal ways of a "+m+" by "+ n +" matrix.");

        start = System.currentTimeMillis();
        System.out.println(test.gridTravellerDP(matrix));
        end = System.currentTimeMillis();
        System.out.println("DP grid call takes "+ (end-start) + " ms to count traversal ways of a "+m+" by "+ n +" matrix.");

        2333606220
        recursive grid call uses 7388 ms to count traversal ways of 3 by 2 matrix.
        2333606220
        DP grid call uses 0 ms to count traversal ways of 3 by 2 matrix.
         */

        /*Fibonacci test
        start = System.currentTimeMillis();
        System.out.println(test.fibonacciRecur(50));
        end = System.currentTimeMillis();
        System.out.println("recursive fib call uses "+ (end-start) + " ms to calculate the 50th number in the series.");

        start = System.currentTimeMillis();
        System.out.println(test.fibonacciDP(50));
        end = System.currentTimeMillis();
        System.out.println("DP fib call uses "+ (end-start) + " ms to calculate the 20th number in the series.");
        */
        /*
        12586269025
        recursive fib call uses 29648 ms to calculate the 50th number in the series.
        12586269025
        DP fib call uses 0 ms to calculate the 20th number in the series.
         */
    }
}
