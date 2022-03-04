package com.myjobhunting;
// https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop/

import java.util.Stack;

/*
Given the array prices where prices[i] is the price of the ith item in a shop.
There is a special discount for items in the shop,
if you buy the ith item, then you will receive a discount equivalent to prices[j]
where j is the minimum index such that j > i and prices[j] <= prices[i],
otherwise, you will not receive any discount at all.

Return an array
where the ith element is the final price you will pay for the ith item of the shop considering the special discount.

Example 1:
Input: prices = [8,4,6,2,3]
Output: [4,2,4,2,3]
Explanation:
For item 0 with price[0]=8 you will receive a discount equivalent to prices[1]=4, therefore, the final price you will pay is 8 - 4 = 4.
For item 1 with price[1]=4 you will receive a discount equivalent to prices[3]=2, therefore, the final price you will pay is 4 - 2 = 2.
For item 2 with price[2]=6 you will receive a discount equivalent to prices[3]=2, therefore, the final price you will pay is 6 - 2 = 4.
For items 3 and 4 you will not receive any discount at all.

Example 2:
Input: prices = [1,2,3,4,5]
Output: [1,2,3,4,5]
Explanation: In this case, for all items, you will not receive any discount at all.

Example 3:
Input: prices = [10,1,1,6]
Output: [9,0,1,6]

Constraints:
1 <= prices.length <= 500
1 <= prices[i] <= 10^3
 */
public class EASY_1475_FinalPricesWithaSpecialDiscountinaShop {

    /* monotonic increasing stack.
    the idea is to keep pushing element to the stack if it is increasing.
    find the first element that smaller than the top of the stack.
    Runtime: 5 ms, faster than 36.14% of Java online submissions for Final Prices With a Special Discount in a Shop.
    Memory Usage: 44.5 MB, less than 24.72% of Java online submissions for Final Prices With a Special Discount in a Shop.
     */
    public int[] finalPrices(int[] prices) {
        Stack<Integer> s = new Stack<>();
        for(int i = 0; i < prices.length; i++)
        {
            while(!s.isEmpty() && prices[s.peek()] >= prices[i])
            {
                prices[s.peek()] -= prices[i];
                s.pop();
            }
            s.push(i);
        }
        return prices;
    }

    public int[] finalPrices1(int[] prices) {
        Stack<Integer> s = new Stack<>();
        int price;
        for (int i = prices.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && s.peek() > prices[i]) s.pop();
            price = prices[i];
            prices[i] = s.isEmpty() ? price : price - s.peek();
            s.push(price);
        }
        return prices;
    }

    // initial solution
    /*
    Runtime: 1 ms, faster than 99.66% of Java online submissions for Final Prices With a Special Discount in a Shop.
    Memory Usage: 44.2 MB, less than 38.80% of Java online submissions for Final Prices With a Special Discount in a Shop.
     */
    public int[] finalPrices0(int[] prices) {
        // the last one has nobody to compare, so no discount for the last one.
        for(int i = 0 ; i < prices.length-1; i++)
        {
            int index = i+1;
            int min = prices[i+1];
            while(index< prices.length-1 && prices[i] < prices[index])
                index++;
            prices[i] = prices[i]-prices[index] >=0 ? prices[i]-prices[index] : prices[i];
        }
        return prices;
    }
}
