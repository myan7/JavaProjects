package com.myjobhunting;


// https://leetcode.com/problems/first-unique-character-in-a-string/
public class EASY_387_FirstUniqueCharacterInAString {
    // 9ms
    public int firstUniqChar(String s) {
        // s consists of only lowercase English letters.
        int[] alphabet = new int[26];
        for(int i = 0; i < s.length(); i++)
        {
            alphabet[s.charAt(i) - 'a']++;
        }
        for(int i = 0; i < s.length(); i++)
        {
            if(alphabet[s.charAt(i) - 'a'] == 1)
                return i;
        }
        return -1;
    }

    // 2ms
    public int firstUniqChar1(String s) {

        int f = Integer.MAX_VALUE;
        for(char i ='a'; i<='z'; i++){
            int idx = s.indexOf(i);
            if(idx!=-1 && idx == s.lastIndexOf(i)){
                f = Math.min(f,idx);
            }
        }
        if(f==Integer.MAX_VALUE){
            return -1;
        }
        return f;
    }
}
