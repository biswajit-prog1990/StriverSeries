package com.arrays.problems.easy;

import java.util.Arrays;

/**
 * arr[] = {1,2,3,4,5,6,7}  d=2, [3,4,5,6,7,1,2]
 * d=7 , on 7 rotations original array
 * d=8, 7+1 [1 rotation]
 * d=9, 7+2 [2 rotations] ... and so on
 * Rotations = d%N
 * <p>
 * Brute Force - d=2, store 2 elements in temp, then rotate and put in back
 * ... TC -> O(n+d), SC -> O(d)
 * <p>
 * Optimal Solution - Observation
 * ... 4, 5, 6, 7, 1, 2, 3
 * ... reverse first three elements 3, 2, 1
 * ... reverse last three elements 7, 6, 5, 4
 * ... reverse again 4, 5, 6, 7, 1, 2, 3
 * reverse(a, a+d)        O(d)
 * reverse(a+d, a+n)      O(n-d)
 * reverse(a, a+n)        O(n)
 * TC -> O(2n), SC -> O(1)
 */

public class LeftRotateArrayKPlaces {

    private static int[] leftRotateKPlacesBruteForce(int[] arr, int n, int d) {
        int[] temp = new int[d];
        System.arraycopy(arr, 0, temp, 0, d);
        //Start shifting 3 -> 0, 4 -> 1, 5 -> 2, ... and so on
        //i-dth index
        for (int i = d; i < n; i++)
            arr[i - d] = arr[i];
        //Enter the remaining elements
        //n-d [7-3] = 4
        int j = 0;
        for (int k = n - d; k < n; k++)
            arr[k] = temp[j++];
        return arr;
    }

    private static int[] leftRotateOptimized(int[] arr, int n, int k) {
        reverse(arr, 0, n - k - 1);
        reverse(arr, n - k, n - 1);
        reverse(arr, 0, n - 1);
        return arr;
    }

    private static void reverse(int[] arr, int i, int i1) {
        while (i <= i1) {
            int temp = arr[i];
            arr[i] = arr[i1];
            arr[i1] = temp;
            i++;
            i1--;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        int n = arr.length;
        int d = 3;
        System.out.println(Arrays.toString(leftRotateKPlacesBruteForce(arr, n, d)));
        System.out.println(Arrays.toString(leftRotateOptimized(arr, n, d)));
    }
}
