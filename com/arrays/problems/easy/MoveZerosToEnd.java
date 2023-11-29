package com.arrays.problems.easy;

import java.util.Arrays;

/**
 * arr[] = {1, 0, 2, 3, 2, 0, 0, 4, 5, 1}
 * Brute Force : iterate the array, check non-zero and keep adding to array
 * ... temp[] and put to front of array, assign remaining pos to 0
 * <p>
 * Optimal Solution : two pointer approach swap the values
 */

public class MoveZerosToEnd {

    private static int[] moveZerosEndBruteForce(int[] arr, int n) {
        int j = 0;
        //Count unique elements in array
        int cntr = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0)
                cntr++;
        }
        int[] temp = new int[cntr];
        //Add to temp array
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0)
                temp[j++] = arr[i];
        }
        //Add to array
        System.arraycopy(temp, 0, arr, 0, temp.length);
        for (int i = temp.length; i < n; i++)
            arr[i] = 0;
        return arr;
    }

    private static int[] moveZerosEndOptimal(int[] arr, int n) {
        int j = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                j = i;
                break;
            }
        }  //O(X - where 0 found)
        //Start i to next j
        if (j != -1) {
            for (int i = j + 1; i < n; i++) {
                if (arr[i] != 0) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    j++;
                }
            } //O(Remaining n - X)
            //TC -> O(n) SC -> O(1)
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 0, 2, 3, 2, 0, 0, 4, 5, 1};
        int n = arr.length;
        System.out.println(Arrays.toString(moveZerosEndBruteForce(arr, n)));
        System.out.println(Arrays.toString(moveZerosEndOptimal(arr, n)));
    }
}
