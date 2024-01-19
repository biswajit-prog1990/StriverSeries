package com.arrays.problems.medium;

/**
 * Kadane's algorithm - Maximum subarray sum
 * [-2,1,-3,4,-1,2,1,-5,4] output - 6 [4,-1,2,1] largest Sum
 * Input : [-2,-3,4,-1,-2,1,5,-3]
 * Brute Force : Find all subarrays
 * for(i -> 0... n-1)
 * ... for(j -> 0... n-1)
 * ... for(k -> i...j) sum+= ... maxi = max(maxi, sum)
 * Optimize : for(i -> 0... n-1)
 * ... sum = 0
 * ... for(j -> 0... n-1)
 * sum+=a[j]
 * ... Kadane's algorithm
 * sum = 0, max = a[0] i-> 0 ... n
 * ... add a[i] to sum and check if > max, if not continue check if sum<0,
 * ... set sum 0
 */

public class MaximumSubArraySum {

    private static int findMaximumSubArraySumOptimal(int[] arr, int n) {
        int sum = 0, max = arr[0];
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            max = Math.max(sum, max);
            if (sum < 0) sum = 0;
        }
        return max;
    }
}
