package com.arrays.problems.easy;

/**
 * Missing number from 1 to N
 * Brute Force : take every number and check if exist or not
 * Better Approach : hash array -> N + 1
 * ... iterate and check which is marked as 0
 * Optimal Approach :
 * ... sum/xor [sum = n * (n+1) /2]
 * ... s2, add digits and then subtract from sum
 * ... xor,  a^a = 0, 2^2 = 0, 5^5 = 0, 2^2 ^ 5^5 = 0, 0^any number = number
 */

public class MissingNumber {

    private static int findMissingNumberBF(int[] arr, int n) {
        int i, flag = 0;
        for (i = 1; i <= n; i++) {
            flag = 0;
            for (int j = 0; j < n - 1; j++) {
                if (arr[j] == i) {
                    flag = 1;
                    break;
                }
            }
        }
        if (flag == 0) return i;  // O (N * N), SC O(1)
        return -1;
    }

    private static int findMissingNumberHashing(int[] arr, int n) {
        int[] hash = new int[n + 1];
        for (int i = 0; i < n; i++)
            hash[arr[i]] = 1;
        for (int i = 0; i < n; i++) {
            if (hash[i] == 0) return i;
        }
        return -1;
    }

    private static int findMissingNumberOptimalSum(int[] arr, int n) {
        int sum = (n * (n + 1)) / 2;
        int s2 = 0;
        for (int i = 0; i < n; i++)
            s2 += arr[i];
        return sum - s2; //TC -> O(n) , SC -> O(1)
    }

    private static int findMissingNumberOptimalXor(int[] arr, int n) {
        int xor1 = 0;
        int xor2 = 0;
        for (int i = 0; i < n - 1; i++) {
            xor2 = xor2 ^ arr[i];
            xor1 = xor1 ^ (i + 1);
        }
        xor1 = xor1 ^ n;
        return xor1 ^ xor2; //TC -> O(n) SC -> O(1)
    }


}
