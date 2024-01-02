package com.arrays.problems.easy;

/**
 * [1,1,2,3,3,4,4]
 * Brute Force - navigate and check if number appears twice
 * Better Solution - hashing
 * Best Solution - XOR
 */

public class FindElementWhichOccursOnce {

    private static int findElementOccursOnceBF(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            int num = arr[i];
            int cntr = 0;
            for (int j = 0; j < n; j++) {
                if (arr[j] == num)
                    cntr++;
            }
            if (cntr == 1)
                return num;
        }
        return -1;
    }

    private static int findElementOccursOnceBetter(int[] arr, int n) {
        int max = arr[0];
        for (int i = 0; i < n; i++)
            max = Math.max(max, arr[i]);
        int[] hash = new int[max + 1];
        for (int i = 0; i < n; i++)
            hash[arr[i]]++;
        for (int i = 0; i < n; i++) {
            if (hash[arr[i]] == 1)
                return arr[i];
        }
        return -1; //TC -> O(3n), SC -> O(max)
    }

    private static int findElementOccursOnceOptimal(int[] arr, int n) {
        int xor = 0;
        for (int i = 0; i < n; i++)
            xor ^= arr[i];
        return xor;
    }
}
