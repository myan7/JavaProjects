package com.myjobhunting;

public class EASY_058_LengthofLastWord {
    public int lengthOfLastWord(String s) {
        if (s == null)
            return 0;
        else
        {
            for (int i = s.length()-1; i >= 0 ; i-- )
            {
                if (s.charAt(i) != ' ')
                {
                    int cnt = 0;
                    int j = i;
                    while( j >= 0 && s.charAt(j) != ' ')
                    {
                        cnt++;
                        j--;
                    }
                    return cnt;
                }
            }
        }
        return -1;
    }

    public int lengthOfLastWord2(String s) {
        int length = 0;
        for (int i=s.length()-1;i>=0;i--) {
            if (s.charAt(i) != ' ') {
                length++;
            }
            else if (length > 0) {
                return length;
            }
        }
        return length;
    }
}
