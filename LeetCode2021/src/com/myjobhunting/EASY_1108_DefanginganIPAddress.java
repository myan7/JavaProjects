package com.myjobhunting;
// https://leetcode.com/problems/defanging-an-ip-address/
/*
Given a valid (IPv4) IP address, return a defanged version of that IP address.
A defanged IP address replaces every period "." with "[.]".

Example 1:
Input: address = "1.1.1.1"
Output: "1[.]1[.]1[.]1"
Example 2:

Input: address = "255.100.50.0"
Output: "255[.]100[.]50[.]0"


Constraints:

The given address is a valid IPv4 address.
 */
public class EASY_1108_DefanginganIPAddress {
    public String defangIPaddr(String address)
    {
        StringBuilder sb = new StringBuilder();
        for(char c : address.toCharArray())
        {
            if(c == '.')
                sb.append("[.]");
            else
                sb.append(c);
        }
        return sb.toString();
    }

    public String defangIPaddr0(String address) {
        return address.replace(".","[.]");
    }
}