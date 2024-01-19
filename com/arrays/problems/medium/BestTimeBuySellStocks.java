package com.arrays.problems.medium;

/**
 * arr[] = [7,1,5,3,6,4]
 * price of stock day 1 -> 7, day 2 -> 1, ... and so on
 * n no. of days, decide a day when to buy stock and when to sell stock
 * ... buy before and sell later to find maximum profit
 * ... buy and sell can be done only once
 * ... if you are selling on ith day,
 * ... you buy on the min price from 1st to (i-1)th day
 * ... mini = a[0], profit = 0
 * for(i ->1 ... n) ... cost = a[i] - mini
 * ... profit = max(profit, cost) mini = min(mini, a[i])
 */

public class BestTimeBuySellStocks {

    private static int findMaxProfit(int[] arr, int n) {
        int mini = arr[0], profit = 0;
        for (int i = 0; i < n; i++) {
            int cost = arr[i] - mini;
            profit = Math.max(profit, cost);
            mini = Math.min(mini, arr[i]);
        }
        return profit;
    }
}
