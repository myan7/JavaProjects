package com.myjobhunting;
//https://leetcode.com/problems/reverse-vowels-of-a-string/

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class EASY_345_ReverseVowelsofaString {

    public String reverseVowels(String s) {
        String vowels = "aeiouAEIOU";
        char[] chars = s.toCharArray();
        int start = 0;
        int end = s.length()-1;
        while(start<end){

            while(start<end && !vowels.contains(chars[start]+""))
                start++;

            while(start<end && !vowels.contains(chars[end]+""))
                end--;

            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;

            start++;
            end--;
        }
        return new String(chars);
    }

    public String reverseVowels0(String s) {
        Stack<Character> vowels = new Stack<>();
        char[] sArr = s.toCharArray();
        for(char c: sArr)
        {
            if( c=='a'||c=='A'||c=='e'||c=='E'||
                c=='i'||c=='I'||c=='o'||c=='O'||
                c=='u'||c=='U')
            {
                vowels.push(c);
            }
        }
        for(int i = 0; i < sArr.length; i++ )
        {
            char c = sArr[i];
            if( c=='a'||c=='A'||c=='e'||c=='E'||
                c=='i'||c=='I'||c=='o'||c=='O'||
                c=='u'||c=='U')
            {
                sArr[i] = vowels.pop();
            }
        }
        return String.valueOf(sArr);
    }

    public String reverseVowels1(String s) {
        char[] list=s.toCharArray();
//		Set<Character> set=new HashSet<>();
//        set.add('a');
//        set.add('e');
//        set.add('i');
//        set.add('o');
//        set.add('u');
//        set.add('A');
//        set.add('E');
//        set.add('I');
//        set.add('O');
//        set.add('U');   this is not a good way to declare a set
        Set<Character> set = new HashSet<>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
        for( int i = 0,j = list.length-1;i < j; ){
            if(!set.contains(list[i])){
                i++;
                continue;
            }
            if(!set.contains(list[j])){
                j--;
                continue;
            }
            char temp=list[i];
            list[i]=list[j];
            list[j]=temp;
            i++;
            j--;
        }
        return String.valueOf(list);
    }

}
