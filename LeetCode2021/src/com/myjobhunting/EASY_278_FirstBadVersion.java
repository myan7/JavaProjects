package com.myjobhunting;
//https://leetcode.com/problems/first-bad-version/

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */
abstract class VersionControl // just mimic the structure
{
    int version = 0;
    abstract boolean isBadVersion(int version);
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
                end = mid;// want to keep the first bad version
        }
        return begin;
    }
    public int firstBadVersion2(int n) {
        // return firstBadVersion(1, n);
        int left = 1, right = n;
        while (left < right) {
            int mid = left + (right - left)/2;
            if (isBadVersion(mid)) {
                right = mid; // want to keep the first bad version
            } else {
                left = mid + 1;
            }
        }

        return right;
    }

    /*
    Runtime: 12 ms, faster than 99.45% of Java online submissions for First Bad Version.
    Memory Usage: 38.2 MB, less than 94.45% of Java online submissions for First Bad Version.
     */
    public int firstBadVersion3(int n) {
        int left = 1;
        int right = n;

        while(left <= right)
        {
            int mid = left + (right - left)/2;
            if(!isBadVersion(mid))
                left = mid+1;
            else
                right = mid-1;
        }
        return left;

    }
    @Override
    boolean isBadVersion(int version) {
        if(super.version == version)
            return true;
        return false;
    }
}
