package com.myjobhunting;
//https://leetcode.com/problems/first-bad-version/

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */
class VersionControl // just mimic the structure
{
    public boolean isBadVersion(int version)
    {
        return true;
    }
}

public class EASY_278_FirstBadVersion extends VersionControl{
    public int firstBadVersion(int n) {
        int begin = 1;
        int end = n;

        while(begin < end)
        {
            int mid = begin + (end-begin)/2;
            if(!isBadVersion(mid))
                begin = mid+1;
            else
                end = mid;
        }
        return begin;
    }
    public int firstBadVersion2(int n) {
        // return firstBadVersion(1, n);
        int left = 1, right = n;
        while (left < right) {
            int mid = left + (right - left)/2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return right;
    }
}
