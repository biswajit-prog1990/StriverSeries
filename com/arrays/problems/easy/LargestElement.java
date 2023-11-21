package com.arrays.problems.easy;

import java.util.Arrays;

/**
 * Brute Force approach - Sort the array and output the last element as highest
 */

public class LargestElement {

    private static int findLargestElementBruteForce(int[] arr, int n) {
        Arrays.sort(arr);
        return arr[n-1];
    }



}