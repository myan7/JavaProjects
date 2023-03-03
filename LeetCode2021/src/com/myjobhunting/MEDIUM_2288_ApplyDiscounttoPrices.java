package com.myjobhunting;
// https://leetcode.com/problems/apply-discount-to-prices/

/*
A sentence is a string of single-space separated words where each word can contain digits, lowercase letters, and the dollar sign '$'. A word represents a price if it is a non-negative real number preceded by a dollar sign.

For example, "$100", "$23", and "$6.75" represent prices while "100", "$", and "2$3" do not.
You are given a string sentence representing a sentence and an integer discount. For each word representing a price, apply a discount of discount% on the price and update the word in the sentence. All updated prices should be represented with exactly two decimal places.

Return a string representing the modified sentence.

Example 1:
Input: sentence = "there are $1 $2 and 5$ candies in the shop", discount = 50
Output: "there are $0.50 $1.00 and 5$ candies in the shop"
Explanation:
The words which represent prices are "$1" and "$2".
- A 50% discount on "$1" yields "$0.50", so "$1" is replaced by "$0.50".
- A 50% discount on "$2" yields "$1". Since we need to have exactly 2 decimal places after a price, we replace "$2" with "$1.00".

Example 2:
Input: sentence = "1 2 $3 4 $5 $6 7 8$ $9 $10$", discount = 100
Output: "1 2 $0.00 4 $0.00 $0.00 7 8$ $0.00 $10$"
Explanation:
Applying a 100% discount on any price will result in 0.
The words representing prices are "$3", "$5", "$6", and "$9".
Each of them is replaced by "$0.00".

Constraints:
1 <= sentence.length <= 10^5
sentence consists of lowercase English letters, digits, ' ', and '$'.
sentence does not have leading or trailing spaces.
All words in sentence are separated by a single space.
All prices will be positive integers without leading zeros.
All prices will have at most 10 digits.
0 <= discount <= 100
 */
public class MEDIUM_2288_ApplyDiscounttoPrices {
    /*
    Runtime: 659 ms, faster than 16.67% of Java online submissions for Apply Discount to Prices.
    Memory Usage: 51.2 MB, less than 66.67% of Java online submissions for Apply Discount to Prices.
     */
    public String discountPrices(String sentence, int discount) {
        StringBuilder sb = new StringBuilder();
        String[] words = sentence.split(" ");
        for(String word: words)
        {
            StringBuilder tmp = new StringBuilder();
            if(word.length() == 0 || word == null || word.charAt(0) != '$')
                tmp.append(word);
            else
            {
                String val = word.substring(1);
                double d = 0;
                if(isNumber(val))
                {
                    d = Double.parseDouble(val);
                    d = d-d*(double)discount/100;
                    tmp.append("$").append(String.format("%.2f", d));
                }
                else
                    tmp.append(word);
            }
            sb.append(tmp).append(" ");
        }
        return sb.toString().substring(0,sb.length()-1);
    }

    private boolean isNumber(String str)
    {
        if(str == null || str.length() == 0)
            return false;
        try
        {
            double d = Double.parseDouble(str);
        }catch(NumberFormatException nfe)
        {
            return false;
        }
        return true;
    }

    /*
    Runtime: 62 ms, faster than 33.33% of Java online submissions for Apply Discount to Prices.
    Memory Usage: 67.6 MB, less than 66.67% of Java online submissions for Apply Discount to Prices.
     */
    public String discountPrices2(String sentence, int discount) {
        String [] vals = sentence.split(" ");

        StringBuilder sb = new StringBuilder();
        String s;
        double d;
        int v;

        for (int i = 0; i < vals.length; ++i){
            s = vals[i];

            if (isPrice(s)){
                d = Double.parseDouble(s.substring(1));
                d -= d * discount / 100;
                sb.append('$');
                sb.append((long) d);
                d %= 1;
                d *= 100;
                v = (int)d + (d % 1 >= 0.5 ? 1 : 0);
                sb.append('.');
                if (v < 10 )
                    sb.append(0);
                sb.append(v);
            }else{
                sb.append(s);
            }

            if (i < vals.length - 1)
                sb.append(' ');
        }

        return sb.toString();
    }

    private boolean isPrice(String s){
        if (s.length() < 2 || s.charAt(0) != '$' || s.charAt(1) == '0')
            return false;
        for (int i = 1; i < s.length(); ++i){
            if (s.charAt(i) < '0' || s.charAt(i) > '9') return false;
        }

        return true;
    }
}
