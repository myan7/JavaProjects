package com.myjobhunting;

public class EASY_067_AddBinary {

    public String addBinary20220308(String a, String b) {
        StringBuilder sb = new StringBuilder();

        int i = a.length()-1, j = b.length()-1, carry = 0;

        while(i >= 0 || j >= 0 || carry == 1)
        {
            int sum = carry;
            if(i >= 0 )
                sum += a.charAt(i--) - '0';
            if(j >=0 )
                sum += b.charAt(j--) - '0';
            sb.insert(0,sum%2);
            carry = sum/2;
        }
        return sb.toString();
    }

    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();

        int aInd = a.length()-1;
        int bInd = b.length()-1;
        int carry = 0;
        while(aInd >= 0 || bInd >= 0){
            /* sum has to be refreshed every time, and the carry should be taken into consideration */
            int sum = carry;
            /* in ASCII table, '0' is 48 in decimal, '9' is 57 in decimal */
            if (aInd >= 0 ) sum += a.charAt(aInd--) - '0';
            if (bInd >= 0 ) sum += b.charAt(bInd--) - '0';
            sb.append(sum%2);
            carry = sum/2;
        }
        if (carry != 0 ) sb.append(carry);
        return sb.reverse().toString();
    }

    public String addBinary2(String a, String b) {
        if (a == null || a.isEmpty()){
            return b;
        }
        if (b == null || b.isEmpty()){
            return a;
        }
        StringBuilder revResult = new StringBuilder();
        int aLen = a.length()-1;
        int bLen = b.length()-1;
        int carry = 0;

        while (aLen >= 0 || bLen >= 0 || carry==1){
            carry += (aLen >= 0)? a.charAt(aLen--) - '0' : 0;
            carry += (bLen >= 0)? b.charAt(bLen--) - '0' : 0;
            revResult.append(carry % 2);
            carry = carry / 2;
        }

        return revResult.reverse().toString();
    }
}
