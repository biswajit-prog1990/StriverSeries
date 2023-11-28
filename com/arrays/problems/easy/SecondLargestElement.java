package com.arrays.problems.easy;

import java.util.Arrays;

/**
 * Brute Force : Sort the array, largest - arr[n-1],
 * ... start from n-2th index, check if equivalent to largest
 * ... ignore, else return secondLargest
 * Better Solution : first pass -> largest
 * ... secondLargest = -1, check if arr[i] > secondLargest && !largest
 * ... return secondLargest
 * Optimal Solution : continuously keep checking largest and prev is secondLargest
 * ... check if < largest but >secondLargest then add
 */

public class SecondLargestElement {

    private static int findSecondLargestBruteForce(int[] arr, int n) {
        Arrays.sort(arr); //O(n log n)
        int largest = arr[n - 1];
        int secondLargest = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] != largest) {
                secondLargest = arr[i];
                break;
            }
        }
        return secondLargest; //O(n)
    }

    private static int findSecondLargestBetterSolution(int[] arr, int n) {
        int largest = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > largest)
                largest = arr[i];
        }
        int sLargest = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i] > sLargest && arr[i] != largest)
                sLargest = arr[i];
        }
        return sLargest;
    }

    private static int findSecondLargestOptimalSolution(int[] arr, int n) {
        int largest = arr[0];
        int sLargest = -1;
        for (int i = 1; i < n; i++) {
            if (arr[i] > largest) {
                sLargest = largest;
                largest = arr[i];
            } else if (arr[i] < largest && arr[i] > sLargest)
                sLargest = arr[i];
        }
        return sLargest;
    }

    private static int findSecondSmallestOptimalSolution(int[] arr, int n) {
        int smallest = arr[0];
        int sSmallest = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            if (arr[i] < smallest) {
                sSmallest = smallest;
                smallest = arr[i];
            } else if (arr[i] != smallest && arr[i] < sSmallest)
                sSmallest = arr[i];
        }
        return sSmallest;
    }
}
