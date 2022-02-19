package com.myjobhunting;
// https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/
/*
Given two string arrays word1 and word2,
return true if the two arrays represent the same string, and false otherwise.
A string is represented by an array if the array elements concatenated in order forms the string.

 */
public class EASY_1662_CheckIfTwoStringArraysareEquivalent {

    public boolean arrayStringsAreEqual0(String[] word1, String[] word2) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for(String str : word1)
            sb1.append(str);
        for(String str: word2)
            sb2.append(str);

        return sb1.toString().equals(sb2.toString());
    }

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String s1 = new String();
        String s2 = new String();
        for(String str: word1) s1 += str;
        for(String str: word2) s2 += str;
        return s1.equals(s2);
    }

    public boolean arrayStringsAreEqual2(String[] word1, String[] word2) {
        int p1=0, p2=0;
        int w1=0, w2=0;
        while(w1 < word1.length && w2<word2.length){
            if (word1[w1].charAt(p1) != word2[w2].charAt(p2)) return false;

            if (p1<word1[w1].length()-1){
                p1++;
            }
            else{
                p1=0;
                w1++;
            }
            if (p2<word2[w2].length()-1){
                p2++;
            }
            else{
                p2=0;
                w2++;
            }
        }
        return w1 == word1.length && w2 == word2.length;
    }
}
