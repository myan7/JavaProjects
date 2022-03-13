package com.myjobhunting;

public class MEDIUM_012_IntegertoRoman {


    /*
    Runtime: 7 ms, faster than 76.58% of Java online submissions for Integer to Roman.
    Memory Usage: 46.1 MB, less than 24.65% of Java online submissions for Integer to Roman.
     */
    public String intToRoman(int num) {
        final int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        final String[] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder sb = new StringBuilder();
        // Loop through each symbol, stopping if num becomes 0.
        for (int i = 0; i < values.length && num > 0; i++) {
            // Repeat while the current symbol still fits into num.
            while (values[i] <= num) {
                num -= values[i];
                sb.append(symbols[i]);
            }
        }
        return sb.toString();
    }

    // naive solution
    /*
    Runtime: 10 ms, faster than 49.93% of Java online submissions for Integer to Roman.
    Memory Usage: 44.7 MB, less than 51.79% of Java online submissions for Integer to Roman.
     */
    public String intToRoman0(int num) {
        StringBuilder sb = new StringBuilder();
        while(num != 0)
        {
            int count = 0;
            if(num / 1000 > 0 )
            {
                count = num/1000;
                while(count > 0)
                {
                    sb.append("M");
                    count--;
                }
                num %= 1000;
            }
            else if(num >= 900)
            {
                sb.append("C").append("M");
                num -= 900;
            }
            else if(num >= 500 )
            {
                sb.append("D");
                count = num/100-5;
                while(count > 0)
                {
                    sb.append("C");
                    count--;
                }
                num %= 100;
            }
            else if (num >= 400)
            {
                sb.append("C").append("D");
                num -= 400;
            }
            else if(num >= 100)
            {
                count = num/100;
                num -= count*100;
                while(count >0)
                {
                    sb.append("C");
                    count--;
                }
            }
            else if(num >= 90)
            {
                sb.append("X").append("C");
                num -=90;
            }
            else if(num >= 20)
            {
                if(num >= 50)
                {
                    sb.append("L");
                    count = (num-50)/10;

                    while(count >0)
                    {
                        sb.append("X");
                        count--;
                    }
                }
                else if(num >= 40)
                {
                    sb.append("X").append("L");
                }
                else
                {
                    count = num/10;
                    while(count > 0)
                    {
                        sb.append("X");
                        count--;
                    }
                }
                num %=10;
            }
            else if(num >= 10)
            {
                sb.append("X");
                num -=10;
            }
            else
            {
                if(num == 9)
                {
                    sb.append("IX");
                    num -=9;
                }

                else if(num >= 5)
                {
                    sb.append("V");
                    while(num > 5)
                    {
                        sb.append("I");
                        num--;
                    }
                    num = 0;
                }
                else if(num == 4)
                {
                    sb.append("IV");
                    num = 0;
                }
                else
                {
                    sb.append("I");
                    num-=1;
                }
            }
        }
        return sb.toString();
    }
}
