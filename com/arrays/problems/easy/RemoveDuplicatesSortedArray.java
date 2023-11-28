package com.arrays.problems.easy;

import java.util.Arrays;

/**
 * Brute Force - Set data structure
 * ... iterate Array -> put in Set,
 * ... insert in starting of array, Set 0, 1,2 ...
 * ... insert to Set logN - 1 elements, so NlogN
 * ... TC-> NLogN + N
 * SC -> O(N)
 * <p>
 * Two pointer approach ->
 * 1st element is always there as it's unique
 * ... 2nd place which is not equivalent to prev.,
 * ... check who is next which is not there and so on....
 * ... TC -> O(N), SC -> O(1)
 */

public class RemoveDuplicatesSortedArray {

    private static int[] removeDuplicatesSortedArray(int[] arr, int n) {
        int i = 0;
        for (int j = 1; j < n; j++) {
            if (arr[j] != arr[i]) {
                arr[i + 1] = arr[j];
                i++;
            }
        }
        //Replace the remaining elements with -1
        for (int k = i + 1; k < n; k++)
            arr[k] = -1;
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 2, 2, 2, 3, 3};
        System.out.println(Arrays.toString(removeDuplicatesSortedArray(arr, arr.length)));
    }
}
