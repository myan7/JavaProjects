package com.myjobhunting;
// https://leetcode.com/problems/capitalize-the-title/

/*
You are given a string title consisting of one or more words separated by a single space,
where each word consists of English letters.
Capitalize the string by changing the capitalization of each word such that:

If the length of the word is 1 or 2 letters, change all letters to lowercase.
Otherwise, change the first letter to uppercase and the remaining letters to lowercase.
Return the capitalized title.

Example 1:
Input: title = "capiTalIze tHe titLe"
Output: "Capitalize The Title"
Explanation:
Since all the words have a length of at least 3,
the first letter of each word is uppercase, and the remaining letters are lowercase.

Example 2:
Input: title = "First leTTeR of EACH Word"
Output: "First Letter of Each Word"
Explanation:
The word "of" has length 2, so it is all lowercase.
The remaining words have a length of at least 3,
so the first letter of each remaining word is uppercase, and the remaining letters are lowercase.

Example 3:
Input: title = "i lOve leetcode"
Output: "i Love Leetcode"
Explanation:
The word "i" has length 1, so it is lowercase.
The remaining words have a length of at least 3,
so the first letter of each remaining word is uppercase, and the remaining letters are lowercase.

Constraints:
1 <= title.length <= 100
title consists of words separated by a single space without any leading or trailing spaces.
Each word consists of uppercase and lowercase English letters and is non-empty.
 */
public class EASY_2129_CapitalizetheTitle {

    /*
    Runtime: 5 ms, faster than 72.54% of Java online submissions for Capitalize the Title.
    Memory Usage: 42.7 MB, less than 31.28% of Java online submissions for Capitalize the Title.
     */
    public String capitalizeTitle0(String title) {
        String[] arr = title.split(" ");
        StringBuilder sb = new StringBuilder();
        for(String str: arr)
        {
            if(str.length() <= 2)
                sb.append(str.toLowerCase()).append(" ");
            else
                sb.append(Character.toUpperCase(str.charAt(0))).append(str.substring(1).toLowerCase()).append(" ");
        }
        return sb.substring(0,title.length());
    }

    /*
    Runtime: 2 ms, faster than 93.22% of Java online submissions for Capitalize the Title.
    Memory Usage: 41.8 MB, less than 43.27% of Java online submissions for Capitalize the Title.
     */
    public String capitalizeTitle(String title) {
        char[] ch = title.toCharArray();
        int len = ch.length;

        for(int i = 0; i < len; ++i) {

            int firstIndex = i; // store the first index of the word

            while(i < len && ch[i] != ' ') {
                ch[i] = Character.toLowerCase(ch[i]);
                // converting the character at ith index to lower case ony by one
                ++i;
            }

            // if word is of length greater than 2, then turn the first character of the word to upper case
            if(i - firstIndex > 2) {
                ch[firstIndex] =  Character.toUpperCase(ch[firstIndex]);
                // converting the first character of the word to upper case
            }
        }
        return String.valueOf(ch); // return the final result by converting the char array into string    }

    }
}
