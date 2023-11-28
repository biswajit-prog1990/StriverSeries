package com.arrays.problems.easy;

import java.util.Arrays;

/**
 * [1, 2, 3, 4, 5] -> Rotate 1 element [2, 3, 4, 5, 1] (left rotation)
 * Optimal Solution -> TC O(N), SC O(1)
 */

public class LeftRotateArrayOnePlace {

    private static int[] leftRotateOnePlace(int[] arr, int n) {
        int temp = arr[0];
        for (int i = 1; i < n; i++)
            arr[i - 1] = arr[i];
        arr[n - 1] = temp;
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(leftRotateOnePlace(arr, arr.length)));
    }
}
