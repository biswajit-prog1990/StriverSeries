package com.arrays.problems.medium;

/**
 * Using Kadane's algorithm
 * whenever starting to form new subarray with sum > 0, started with sum
 * ... if(sum == 0) start = i;
 * ... ansStart = -1, ansEnd = -1;
 * ... if(sum > max) ansStart = start, ansEnd = i //TC ->O(N), SC-> O(1)
 */

public class PrintSubarrayWithMaximumSum {

    private static int[] findSubArraysMaximumSumOptimal(int[] arr, int n) {
        int sum = 0, max = arr[0];
        int ansStart = -1, ansEnd = -1, start = -1;
        for (int i = 0; i < n; i++) {
            if (sum == 0)
                start = i;
            sum += arr[i];
            if (sum > max) {
                max = sum;
                ansStart = start;
                ansEnd = i;
            }
            if (sum < 0) sum = 0;
        }
        return new int[]{ansStart, ansEnd};
    }
}
