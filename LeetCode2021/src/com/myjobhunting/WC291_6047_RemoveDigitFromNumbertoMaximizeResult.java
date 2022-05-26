package com.myjobhunting;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class WC291_6047_RemoveDigitFromNumbertoMaximizeResult {

    public static void main(String[] args)
    {
        String number = "9992939415";
        //System.out.println(number.substring(2,2));
        char digit = '9';
        String ans = removeDigit(number,digit);
        System.out.println(ans);

    }

    public static String removeDigit(String number, char digit) {
        // if there is only one occurrence of the digit.
        int index = -1;
        String ans = "";
        int end = number.length();
        List<Integer> list = new ArrayList<>();

        if(number.lastIndexOf(digit) == number.indexOf(digit))
            return number.substring(0,number.indexOf(digit))+number.substring(number.indexOf(digit)+1,end);
        else
        {
            for(int i = 0; i < number.length(); i++)
            {
                char curr = number.charAt(i);
                if(curr == digit)
                    list.add(i);
            }
            for(int i = list.size()-1; i >=0; i--)
            {
                int currIndex = list.get(i);
                if(currIndex < end-1 && number.charAt(currIndex) < number.charAt(currIndex+1)) {
                    index = currIndex;
                }
            }
            if(index == -1)
                return number.substring(0,number.lastIndexOf(digit))+number.substring(number.lastIndexOf(digit)+1,end);
            else
                return number.substring(0,index)+number.substring(index+1,end);
        }
    }

}
