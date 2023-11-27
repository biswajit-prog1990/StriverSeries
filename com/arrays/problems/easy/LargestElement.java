package com.arrays.problems.easy;

import java.util.Arrays;

/**
 * Brute Force approach - Sort the array and output the last element as highest
 */

public class LargestElement {

    private static int findLargestElementBruteForce(int[] arr, int n) {
        Arrays.sort(arr); // O(n log n) SC -> O(1)
        return arr[n - 1];
    }

    private static int findLargestElementOptimized(int[] arr, int n) {
        int largest = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > largest)
                largest = arr[i];
        }
        return largest;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 6, 19, 22, 1, 0, 16, 7, 6, 2, 22, 94, 56};
        int n = arr.length;
        long startTime1 = System.currentTimeMillis();
        System.out.println("Largest Element : " + findLargestElementBruteForce(arr, n));
        long endTime1 = System.currentTimeMillis();
        System.out.println("Time Taken Brute Force : " + (endTime1 - startTime1) * 10);
        long startTime = System.currentTimeMillis();
        System.out.println("Largest Element : " + findLargestElementOptimized(arr, n));
        long endTime = System.currentTimeMillis();
        System.out.println("Time Taken Optimized : " + (endTime - startTime) * 10);
    }

}