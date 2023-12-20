package com.arrays.problems.easy;

/**
 * [1,1,0,1,1,1,0,1,1] - max consecutive ones :3
 * Optimal -> cntr = 0, 1 found update cntr, found 0 then mark cntr  = 0
 */

public class MaximumConsecutiveOnes {

    private static int findMaxConsecutiveOnes(int[] arr, int n) {
        int cntr = 0, max = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                cntr++;
                max = Math.max(max, cntr);
            } else
                cntr = 0;
        }
        return max;
    }
}
