package com.myjobhunting;

//https://leetcode.com/problems/happy-number/
// if there will be an infinite loop, try using 2 pointers to get out of it.

import java.util.HashSet;
import java.util.Set;

public class EASY_202_HappyNumber {

    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        do{
            slow = findSquare(slow);
            fast = findSquare(findSquare(fast));
            //Fast is one ahead of slow
            //takes square twice
        }
        while(slow!=fast);
        if(slow==1){
            return true; //Return true when slow pointer becomes 1
        }
        //It keeps on repeating if it doesn't become 1
        return false;
    }
    private int findSquare(int number){
        //Finding square of sum of all digits
        int ans = 0;
        while(number>0){
            int rem = number % 10;
            ans += rem*rem;
            number /=10;
        }
        return ans;
    }


    public boolean isHappy1(int n) {
        if(n==1 || n==7)
            return true;
        if(n==0)
            return false;
        int sq=0;
        while(true)
        {
            sq=0;
            while(n!=0)
            {
                int x=n%10;
                sq+=(x*x);
                n/=10;
            }
            if(sq/10==0)
                break;
            n=sq;
        }
        if(sq==1 || sq==7)
            return true;
        return false;
    }

    public boolean isHappy0(int n) {
        int slowRunner = n;
        int fastRunner = getNext(n);
        while (fastRunner != 1 && slowRunner != fastRunner) {
            slowRunner = getNext(slowRunner);
            fastRunner = getNext(getNext(fastRunner));
        }
        return fastRunner == 1;
    }
    public int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;
    }




    public boolean isHappy2(int n) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        int[] intArr = {1,49,97,13,82,68};
        int[] intArr2 = { 2,4,5,9,25,29,85,16,37,58,61,65,89,145,42,36,45,41,17,50,64,52,29};
        for(int i : intArr)
        {
            set.add(i);
        }
        for(int i : intArr2)
        {
            set2.add(i);
        }
        return helper(n,set,set2);
    }

    public int findNum(int n){
        int sum=0;
        while(n!=0){
            int rem = n%10;
            sum += rem*rem;
            n /=10;
        }
        return sum;
    }

    public boolean helper(int n, Set<Integer> set, Set<Integer> set2)
    {
        if (set.contains(n))
            return true;
        else if(set2.contains(n))
            return false;
        else
        {
            int num = findNum(n);
            return helper(num,set,set2);
        }
    }
}
