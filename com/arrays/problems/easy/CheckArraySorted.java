package com.arrays.problems.easy;

/**
 * Start from index 1, ... check if prev smaller or equal to
 */

public class CheckArraySorted {

    private static boolean isArraySorted(int[] arr, int n) {
        for (int i = 1; i < n; i++) {
            if (arr[i] >= arr[i - 1]) {
            } else
                return false;
        }
        return true;
    }
}
