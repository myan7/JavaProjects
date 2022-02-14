package com.myjobhunting;
//https://leetcode.com/problems/zigzag-conversion/

/*
Constraints:
1 <= s.length <= 1000
s consists of English letters (lower-case and upper-case), ',' and '.'.
1 <= numRows <= 1000
 */

import java.util.*;

public class MEDIUM_006_ZigzagConversion {

    // 5ms
    public String convert(String s, int numRows) {

        if (numRows == 1) return s;

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++)
            rows.add(new StringBuilder());

        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown; // index starts with 0, so numRows -1
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) ret.append(row);
        return ret.toString();
    }
    // 17 ms
    public String convert2(String s, int numRows)
    {
        Map<Integer,StringBuilder> map = new HashMap<>();
        int pos = 0;
        boolean incrementFlag = true;
        for( char c: s.toCharArray())
        {
            if(pos == numRows)
                incrementFlag = false;
            if(pos == 1)
                incrementFlag = true;
            if(incrementFlag)
                pos++;
            else
                pos--;

            if(!map.containsKey(pos))
                map.put(pos,new StringBuilder());
            map.get(pos).append(c);
        }
        StringBuilder sb = new StringBuilder();
        for(int i : map.keySet())
        {
            sb.append(map.get(i));
        }
        return sb.toString();
    }
    // 5ms
    public String convert1(String s, int numRows) {
        if (numRows == 1)
            return s;

        StringBuilder ret = new StringBuilder();
        int n = s.length();
        int cycleLen = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cycleLen) { //每次加一个周期
                ret.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n) //除去第 0 行和最后一行
                    ret.append(s.charAt(j + cycleLen - i));
            }
        }
        return ret.toString();
    }

    //1054ms 805ms
    public String convert0(String s, int numRows) {
        if(numRows == 1)
            return s;
        int len = s.length(), index = 0, flag = 1;
        char[][] mat = new char[numRows][len];
        String val = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz,.";
        StringBuilder sb = new StringBuilder();
        for(int i = 0, j = 0; i >= 0 && i < numRows && j >= 0 && j < len; )
        {
            if(index == len)
                break;
            mat[i][j] = s.charAt(index++);
            if(flag == 1 )
                i++;
            else {
                i--;
                j++;
            }
            if(i == numRows -1)
                flag = 0;
            else if( i == 0)
                flag = 1;
        }
        for(int i = 0 ; i < numRows; i++)
        {
            for(int j = 0; j < len; j++)
            {
                if(val.indexOf(mat[i][j]) != -1)
                    sb.append(mat[i][j]);
            }
        }
        return sb.toString();
    }
}
