package com.myjobhunting;

public class EASY_557_ReverseWordsinaString_III {

    public String reverseWords(String s) {
        char[] ca = s.toCharArray();
        for (int start = 0; start < ca.length; start++) {
            if (ca[start] != ' ') {
                int end = start;
                while (end + 1 < ca.length && ca[end + 1] != ' ')  // make sure end will reach the last char
                {
                    end++;
                }
                swap(ca, start, end);
                start = end; // prepare to move on to the next word
            }
        }
        return new String(ca);
    }
    private void swap(char[] ca, int i, int j) {
        for (; i < j; i++, j--) {
            char tmp = ca[i];
            ca[i] = ca[j];
            ca[j] = tmp;
        }
    }

    public String reverseWords0(String s) {

        if(s == null || s.length() == 0)
            return s;

        String[] words = s.split(" ");
        StringBuilder output = new StringBuilder();

        for(String word : words)
        {
            StringBuilder temp = new StringBuilder(word);
            temp.reverse();
            output.append(temp + " ");
        }

        output.setLength(s.length());
        return output.toString();
    }
    // 6ms 45.6MB
    public String reverseWords2(String s) {
        char[] array = s.toCharArray();
        int i = 0;
        int start = 0;
        while (i < array.length) {
            if (array[i]==' ') {
                reverse(array, start, i-1);
                start = i+1;
            }
            i++;
        }
        // this is for the last word
        reverse(array, start, array.length-1);
        return String.valueOf(array);
    }

    private void reverse(char[] array, int start, int end) {
        while (start< end) {
            char temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }

    //11 ms	53.7 MB
    public String reverseWords1(String s) {
        String[] strList = s.split(" ");
        StringBuffer ans = new StringBuffer();
        for(String e : strList)
        {
            StringBuffer sb = new StringBuffer(e);
            ans.append(sb.reverse()+" ");
        }
        return ans.toString().substring(0,s.length());
    }
}
