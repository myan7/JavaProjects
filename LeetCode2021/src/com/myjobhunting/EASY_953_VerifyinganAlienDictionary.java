package com.myjobhunting;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/verifying-an-alien-dictionary/
/*
In an alien language, surprisingly, they also use English lowercase letters, but possibly in a different order.
The order of the alphabet is some permutation of lowercase letters.

Given a sequence of words written in the alien language, and the order of the alphabet,
return true if and only if the given words are sorted lexicographically in this alien language.

Example 1:

Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
Output: true
Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.

Example 2:
Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
Output: false
Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.

Example 3:
Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
Output: false
Explanation: The first three characters "app" match, and the second string is shorter (in size.)
According to lexicographical rules "apple" > "app", because 'l' > '∅', where '∅' is defined as the blank character which is less than any other character (More info).


Constraints:

1 <= words.length <= 100
1 <= words[i].length <= 20
order.length == 26
All characters in words[i] and order are English lowercase letters.
 */
public class EASY_953_VerifyinganAlienDictionary {

    //Initial solution
    /*
    Runtime: 1 ms, faster than 75.71% of Java online submissions for Verifying an Alien Dictionary.
    Memory Usage: 41.8 MB, less than 62.47% of Java online submissions for Verifying an Alien Dictionary.
     */
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> orderMap = new HashMap<>();
        int val = 1;
        for(char c : order.toCharArray())
            orderMap.put(c,val++);

        for(int i = 1; i < words.length; i++)
        {
            int index = 0;
            while(index < words[i-1].length() || index < words[i].length())
            {
                char ch1 = index >= words[i-1].length()? '_' : words[i-1].charAt(index);
                char ch2 = index >= words[i].length()? '_': words[i].charAt(index);
                if(orderMap.getOrDefault(ch1,0) < orderMap.getOrDefault(ch2,0))
                    break;
                else if(orderMap.getOrDefault(ch1,0) == orderMap.getOrDefault(ch2,0))
                    index++;
                else
                    return false;
            }
        }
        return true;
    }
}
