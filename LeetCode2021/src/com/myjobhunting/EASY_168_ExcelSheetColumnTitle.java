package com.myjobhunting;

public class EASY_168_ExcelSheetColumnTitle {

    public String convertToTitle(int columnNumber) {
        StringBuffer sb = new StringBuffer();
        while(columnNumber>0)
        {
            sb.append((char)((columnNumber-1)%26+'A'));
            columnNumber = (columnNumber-1)/26;
        }
        return sb.reverse().toString();
    }

    /* 52
        I output B@, but it is supposed to be AZ
     */
    public String convertToTitle1(int columnNumber) {
        StringBuffer sb = new StringBuffer();
        while(columnNumber > 26 )
        {
            int mod = columnNumber%26;
            if(mod == 0) {
                sb.append('Z');
                columnNumber = columnNumber / 26-1;
            }
            else
            {
                sb.append( (char)('A' +(mod-1)));
                columnNumber = columnNumber / 26;
            }
        }
        sb.append( (char)('A'+ (columnNumber-1)));

        return sb.reverse().toString();
    }
}
