package com.myjobhunting;

public class EASY_069_Sqrt_x {

    public int mySqrt(int x) {
        if(x == 1) {
            return 1;
        }
        int start = 1, end = x/2;
        while(start <= end) {
            int mid = start + (end - start)/2;
            long square = (long) mid*mid;
            if(x == square) {
                return mid;
            }
            else if(square < x) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        return end;
    }
    public int mySqrt2(int x) {
        if (x == 0)
            return 0;
        int left = 1, right = x/2;
        while (true)
        {
            int mid = left + (right - left)/2;
            if (mid > x/mid)
            {
                right = mid - 1;
            }
            else
            {
                if (mid + 1 > x/(mid + 1))
                    return mid;
                left = mid + 1;
            }
        }
    }

    /*Time Limit Exceeded*/
    public int mySqrt3(int x) {
        if (x == 0) return 0;
        else if (x <= 3)    return 1;
        else{
            int start = x/2;
            while (x/start < start )
            {
                start --;
            }
            return start;
        }
    }
}
