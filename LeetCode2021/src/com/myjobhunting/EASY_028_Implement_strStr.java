package com.myjobhunting;

public class EASY_028_Implement_strStr {
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0)
            return 0;
        for( int i = 0; i< haystack.length();i++)
        {
            if( i+needle.length() <= haystack.length() && haystack.startsWith(needle, i))
                return i;
        }
        // if(needle==null)//if needle has no element returns 0;
        // {
        //      return 0;
        //
        //  }
        //  else return haystack.indexOf(needle);
        return -1;
    }

    public int strStr2(String haystack, String needle) {
        return haystack.contains(needle)? haystack.indexOf(needle): -1;
    }

    public int strStr3(String haystack, String needle) {
        if(haystack.equals(needle) || needle.equals("")){
            return 0;
        }
        return haystack.indexOf(needle);
    }

    public int strStr4(String haystack, String needle) {
        // base condition
        if (needle == "") return 0;

        int hLen = haystack.length();
        int nLen = needle.length();

        if (nLen > hLen) return -1;

        for (int i = 0; i < hLen-nLen+1; i++) {
            if (needle.equals(haystack.substring(i, i+nLen))) return i;
        }

        return -1;
    }


    public int strStr5(String haystack, String needle) {
        int h = haystack.length();
        int n = needle.length();
        // Step 1: Base case, if needle is empty
        if(n == 0){
            return 0;
        }
        // Step 2: Base case, if haystack is empty or less than needle
        else if(h < n){
            return -1;
        }
        // Step 3: Iterate the haystack
        for(int i=0;i<=h-n;i++){
            char current = haystack.charAt(i);
            // Step 4: Found first char in haystack which is equal to needle[0], this substring can be the possible solution
            if(current == needle.charAt(0) ){
                // Step 5: Check if last char of needle is same as the last char of possible solution
                if(haystack.charAt(i + n - 1) != needle.charAt(n-1)){
                    continue;
                }
                int haystackStart = i+1;
                int needleStart = 1;
                // Step 6: Check if all chars are same in both the strings
                while(haystackStart < h && needleStart < n && haystack.charAt(haystackStart) == needle.charAt(needleStart)){
                    haystackStart++;
                    needleStart++;
                }
                // Step 7: If needle is there, count of needlestart will become n
                if(needleStart == n){
                    return i;
                }
            }
        }
        return -1;
    }
}
