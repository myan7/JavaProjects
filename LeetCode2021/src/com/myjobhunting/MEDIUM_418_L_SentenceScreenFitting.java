package com.myjobhunting;
// https://leetcode.com/problems/sentence-screen-fitting/

/*
Given a rows x cols screen and a sentence represented as a list of strings,
return the number of times the given sentence can be fitted on the screen.

The order of words in the sentence must remain unchanged,
and a word cannot be split into two lines. A single space must separate two consecutive words in a line.

Example 1:
Input: sentence = ["hello","world"], rows = 2, cols = 8
Output: 1
Explanation:
hello---
world---
The character '-' signifies an empty space on the screen.

Example 2:
Input: sentence = ["a", "bcd", "e"], rows = 3, cols = 6
Output: 2
Explanation:
a-bcd-
e-a---
bcd-e-
The character '-' signifies an empty space on the screen.

Example 3:
Input: sentence = ["i","had","apple","pie"], rows = 4, cols = 5
Output: 1
Explanation:
i-had
apple
pie-i
had--
The character '-' signifies an empty space on the screen.

Constraints:
1 <= sentence.length <= 100
1 <= sentence[i].length <= 10
sentence[i] consists of lowercase English letters.
1 <= rows, cols <= 2 * 104
 */
public class MEDIUM_418_L_SentenceScreenFitting {

    public int wordsTyping(String[] sentence, int rows, int cols) {
        //用dp
        //存的值有两个，若某行的起始word idx == i，那么记录
        //1. 下一行的起始idx： nextRowStartWith[i] = idx
        //2. 迄今为止完成的sentence数量：sentenceCountSofar[i] = count;
        int n = sentence.length;
        int[] wordLengths = new int[n];
        for (int i=0; i<n; i++)
            wordLengths[i] = sentence[i].length();

        int[] nextRowStartsWithWordIdx = new int[n];
        int[] sentenceCountSoFar = new int[n];
        //整个for循环都是为了得到如果某“一”行的起始idx为某值，就是计算dp结果集
        //而取结果的循环是按行来循环，在 //36 - 循环每一行，第一行起始idx==0
        for (int i=0; i<n; i++) {
            //这个idx是while循环需要的
            int idx = i;
            int sentenceCount = 0;
            int currRowLength = 0;
            while (wordLengths[idx] + currRowLength<= cols) {
                currRowLength+=wordLengths[idx]+1;
                idx++;

                if (idx==n) {
                    idx = 0;
                    sentenceCount++;
                }
            }
            nextRowStartsWithWordIdx[i] = idx;
            sentenceCountSoFar[i] = sentenceCount;
        }
        int res = 0;
        int startIdx = 0;
        //36 - 循环每一行，第一行起始idx==0
        for (int i=0; i<rows; i++) {
            res+=sentenceCountSoFar[startIdx];
            startIdx = nextRowStartsWithWordIdx[startIdx];
        }

        return res;
    }
    /*
    Runtime: 4 ms, faster than 99.43% of Java online submissions for Sentence Screen Fitting.
    Memory Usage: 39.3 MB, less than 60.59% of Java online submissions for Sentence Screen Fitting.
     */
    public int wordsTyping3(String[] sentence, int rows, int cols) {
        String s = String.join(" ", sentence) + " ";
        int len = s.length(), count = 0;
        int[] map = new int[len];
        for (int i = 1; i < len; ++i) {
            map[i] = s.charAt(i) == ' ' ? 1 : map[i-1] - 1;
        }
        for (int i = 0; i < rows; ++i) {
            count += cols;
            count += map[count % len];
        }
        return count / len;
    }

    /*
    Runtime: 10 ms, faster than 75.08% of Java online submissions for Sentence Screen Fitting.
    Memory Usage: 42 MB, less than 15.18% of Java online submissions for Sentence Screen Fitting.
    https://medium.com/@rebeccahezhang/leetcode-418-sentence-screen-fitting-9d6258ce116e
     */
    public int wordsTyping2(String[] sentence, int rows, int cols) {
        // this looks nicer than a for loop.
        String s = String.join(" ", sentence) + " ";

        // curr indicates the curr length of the sentence with repeat
        // or it (curr or curr%len) indicates the next character, because index starts from 0;
        // take ["a", "bcd", "e"], rows = 3, cols = 6 as an example
        // s is "a_bcd_e_", 8 is the len, last index is 7
        int curr = 0, len = s.length();
        for (int i = 0; i < rows; i++)
        {
            // when i is 0, curr = 6, the first line will be "a_bcd_",
            // notice that index 6 is 'e', so going to the else part.
            // because index 5 is ' ', no need to remove illegal char
            // enter the next line, i = 1
            // curr += 6, curr = 12, the whole string should be "a_bcd_e_a_bc"
            // the char on 12 is 'd', on 11 is c, so it will enter else, and we need to remove the illegal chars
            // curr becomes 10, because we cannot have bc without d in the second row.
            // so after the second row, curr is pointing to the last char of "a_bcd_e_a_"
            // enter the next line i = 2
            // curr += 6, curr = 16, the whole string should be "a_bcd_e_a_bcd_e_"
            // index 16 is 'a', and before it happens to be a ' '.
            curr += cols;
            if (s.charAt(curr % len) == ' ')
            {
                curr++;
            } else
            {
                while (curr > 0 && s.charAt((curr-1) % len) != ' ')
                {
                    curr--;
                }
            }
        }
        return curr/len;
    }

    /*
    Runtime: 21 ms, faster than 33.33% of Java online submissions for Sentence Screen Fitting.
    Memory Usage: 42 MB, less than 15.18% of Java online submissions for Sentence Screen Fitting.
     */
    public int wordsTyping1(String[] sentence, int rows, int cols) {
        /*
        in the first for loop we compute the number of words that can be placed in the row if ith word is used as the starting word.
        This is saved as memo[i]. Note that this value can be greater than n.
        In the next for loop we calculate how many words are placed in each row based on memo[i].
        Imagine placing the 0th word in the row-0, then this row will hold memo[0] words.
        Next, which word will be placed on the start of next row?
        We calculate that using memo[k] % n (Remember memo[i] can be greater than n).
        */
        int n = sentence.length;
        int[] memo = new int[n];

        for(int i = 0; i < n; i++) {
            int length = 0, words = 0, index = i;
            while(length + sentence[index % n].length() <= cols) {
                length += sentence[index % n].length();
                length += 1; // space
                index++;
                words++;
            }
            memo[i] = words;
        }

        int words = 0;
        for(int i = 0, index = 0; i < rows; i++) {
            words += memo[index];
            index = (memo[index] + index) % n;
        }

        return words/n;
    }

    /*
    Runtime: 1628 ms, faster than 13.14% of Java online submissions for Sentence Screen Fitting.
    Memory Usage: 39.5 MB, less than 65.96% of Java online submissions for Sentence Screen Fitting.
    sometimes it will exceed time limit if submit several times.
    51 / 51 test cases passed, but took too long.
     */
    public int wordsTyping0(String[] sentence, int rows, int cols) {
        int[] lens = new int[sentence.length];
        for(int i = 0; i < sentence.length;i++)
        {
            lens[i] = sentence[i].length();
            if(lens[i] > cols)
                return 0;
        }
        int ans = 0;
        int len = 0;
        int total = rows*cols;
        while(total >= 0  )
        {
            for(int i: lens)
            {
                len += i;
                if(len < cols)
                {
                    len++; // this is for the blank
                    total = total - i-1;
                }
                else if(len == cols)
                {
                    len = 0;
                    total = total - i;
                }
                else {
                    total = total - (i - (len - cols));
                    len = i+1; // carry the current word + blank
                    total = total - i-1;
                }
            }
            if(total < 0)
                return ans;
            ans++;
        }
        return ans;
    }
}
