package com.arrays.problems.easy;

/**
 * First occurrence of number in Array.
 * arr = [6, 7, 8, 4, 1] , num = 4
 * <p>
 * Quick iteration on array
 */

public class LinearSearch {

    private static int findIndexLinearSearch(int[] arr, int n, int target) {
        for (int i = 0; i < n; i++) {
            if (arr[i] == target)
                return i;
        }
        return -1;
    }
}
