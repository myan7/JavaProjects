package com.myjobhunting;

// https://leetcode.com/problems/implement-strstr/

/*
Implement strStr().
Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Clarification:
What should we return when needle is an empty string?
This is a great question to ask during an interview.

For the purpose of this problem, we will return 0 when needle is an empty string.
This is consistent to C's strstr() and Java's indexOf().



Example 1:

Input: haystack = "hello", needle = "ll"
Output: 2
Example 2:

Input: haystack = "aaaaa", needle = "bba"
Output: -1
Example 3:

Input: haystack = "", needle = ""
Output: 0


Constraints:

0 <= haystack.length, needle.length <= 5 * 104
haystack and needle consist of only lower-case English characters.
 */
public class EASY_028_Implement_strStr {
    /*
    KMP algorithm Knuth-Morris-Pratt Algorithm
    https://www.youtube.com/watch?v=V5-7GzOfADQ&ab_channel=AbdulBari
    Longest Prefix Suffix
    also check LC 459. Repeated Substring Pattern
    Runtime: 3 ms, faster than 99.69% of Java online submissions for Repeated Substring Pattern.
    Memory Usage: 42.7 MB, less than 85.69% of Java online submissions for Repeated Substring Pattern.
    O(M+N)
     */
    public int strStr_KMP(String haystack, String needle) {
        int n = needle.length();
        if(n == 0) return 0;
        int h = haystack.length();
        if(h < n ) return -1;

        int[] lps = new int[n];
        int prevLPS = 0, i = 1;
        // construct LPS
        while( i < n)
        {
            if(needle.charAt(i) == needle.charAt(prevLPS))
            {
                lps[i] = ++prevLPS;
                i++;
            }
            else if(prevLPS == 0)
                {
                    lps[i] = prevLPS;
                    i++;
                }
            else
            {
                prevLPS = lps[prevLPS-1];
            }
        }
        i = 0;
        int j = 0;
        while(i < h)
        {
            if(haystack.charAt(i) == needle.charAt(j))
            {
                i++;
                j++;
            }
            else
            {
                if(j == 0)
                {
                    i++;
                }
                else // if curr i in haystack is not the same as curr j in needle, move j to the value of lps[j-1];
                {
                    j = lps[j-1];
                }
            }
            if(j == n)
                return i-n;
        }
        return -1;
    }

    /*
    Runtime: 8 ms, faster than 91.99% of Java online submissions for Implement strStr().
    Memory Usage: 43.4 MB, less than 34.97% of Java online submissions for Implement strStr().
     */
    public int strStr_20220320(String haystack, String needle) {
        int nLen = needle.length();
        int hLen = haystack.length();
        if(nLen == 0) return 0;
        if(nLen > hLen) return -1;

        for(int i = 0; i <= hLen-nLen; i++)
        {
            int j = 0, m = i;
            for(j = 0; j < nLen; j++)
            {
                if(m < hLen && haystack.charAt(m) == needle.charAt(j))
                {
                    if( i+nLen-1 < hLen && haystack.charAt(i+nLen-1) != needle.charAt(nLen-1))
                        break;
                    else
                        m++;
                }
                else
                    break;
            }
            if(m-i == needle.length())
                return i;
        }
        return -1;
    }


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

    public static void main(String[] args)
    {
        String str = "ababcabcabababd";
        String pattern = "ababd";
        EASY_028_Implement_strStr so = new EASY_028_Implement_strStr();
        so.strStr_KMP(str,pattern);
        str = "abaacabaac";
        System.out.println(repeatedSubstringPattern(str));
    }

    // LC 459
    public static boolean repeatedSubstringPattern(String s) {
        //This is the kmp issue
        int[] prefix = kmp(s);
        // if there is a pattern, the last element in LPS, will not be 0
        int len = prefix[s.length()-1];
        int n = s.length();
        return (len > 0 && n%(n-len) == 0);
    }
    private static int[] kmp(String s){
        int len = s.length();
        int[] res = new int[len];
        char[] ch = s.toCharArray();
        int i = 0, j = 1;
        res[0] = 0;
        while(i < ch.length && j < ch.length){
            if(ch[j] == ch[i]){
                res[j] = i+1;
                i++;
                j++;
            }else{
                if(i == 0){
                    res[j] = 0;
                    j++;
                }else{
                    i = res[i-1];
                }
            }
        }
        return res;
    }

}
