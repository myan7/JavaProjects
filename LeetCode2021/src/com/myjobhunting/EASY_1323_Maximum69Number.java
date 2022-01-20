package com.myjobhunting;
//https://leetcode.com/problems/maximum-69-number/

public class EASY_1323_Maximum69Number {

    public int maximum69Number4 (int num) {
        StringBuffer sbr=new StringBuffer(Integer.toString(num));
        int x=sbr.indexOf("6");
        if(x==-1)return num;
        sbr.replace(x,x+1,"9");
        x=Integer.parseInt(sbr.toString());
        return x;
    }

    public int maximum69Number3 (int num) {
        int max = num;
        char[] numChar = String.valueOf(num).toCharArray();
        for (int i = 0; i < numChar.length; i++) {
            if (numChar[i] == '6') {
                numChar[i] = '9';
                break;
            }
        }
        int newNum = Integer.parseInt(new String(numChar));
        max = Math.max(newNum, max);
        return max;
    }

    public int maximum69Number0 (int num) {
        int ans = 0;
        int size = String.valueOf(num).length();
        int[] intArr = new int[size];
        int index = size-1;
        int carry = 1;
        while(num!= 0)
        {
            intArr[index] = num%10;
            num = num/10;
            carry = carry*10;
            index--;
        }
        for(int i = 0; i < size; i++)
        {
            if(intArr[i] == 6)
            {
                intArr[i] = 9;
                break;
            }
        }
        for(int i = 0; i < size; i++)
        {
            carry /= 10;
            ans = ans + intArr[i]*carry;
        }
        return ans;
    }
    public int maximum69Number1 (int num) {
        int temp = num;
        int size = String.valueOf(num).length();
        int[] intArr = new int[size];
        int index = size-1;
        int pos = size;
        int carry = 1;
        while(temp!= 0)
        {
            intArr[index] = temp%10;
            if(intArr[index] == 6)
                pos = index;
            temp = temp/10;
            index--;
        }
        for(int i = pos; i < size-1; i++)
        {
            carry *= 10;
        }

        if(pos != size)
            return num + 3*carry;
        return num;
    }

    public int maximum69Number2 (int num) {

        int count=0;
        int m=num;
        int rev=0;
        int ans=0;
        while(m>0){
            int rem=m%10;
            rev=rev*10+rem;
            m=m/10;
        }
        while(rev>0){
            int rem=rev%10;
            if(rem==6&&count==0){
                rem=9;
                count++;
            }
            ans=ans*10+rem;

            rev=rev/10;
        }
        return ans;
    }
}
