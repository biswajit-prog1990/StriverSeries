package com.arrays.problems.medium;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * arr[] = [2,6,5,8,11] target = 14
 * variation 1 - give if possible or not possible
 * variation 2 - find the indexes of the numbers where they are add up
 * <p>
 * Brute approach - check ele1 then check all the other ele
 * Better approach - Hashing
 * ... store somewhere in Map
 * ... hashmap -> ele, index
 * ... keep checking if diff present in hashmap, stop iterations
 * <p>
 * Optimal approach - Two pointer approach
 * Sort the array, left -> 2, right -> 11
 * ... left++ if less than target, more than 14 reduce right
 */

public class TwoSum {

    private static int[] findTwoSumBF(int[] arr, int target) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (arr[i] + arr[j] == target) return new int[]{i, j};
            }
        }
        return new int[]{};
    }

    private static int[] findTwoSumBFOptimized(int[] arr, int target) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] + arr[j] == target) return new int[]{i, j};
            }
        }
        return new int[]{};
    }

    private static int[] findTwoSumBetter(int[] arr, int target) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int a = arr[i];
            int more = target - a;
            if (map.containsKey(more)) return new int[]{map.get(more), i};
            map.put(a, i);
        }
        return new int[]{}; //TC -> O(N log N) SC-> O(N)
    }

    private static boolean findTwoSumOptimal(int[] arr, int target) {
        int n = arr.length;
        int left = 0, right = n - 1;
        Arrays.sort(arr);
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == target)
                return true;
            else if (sum < target) left++;
            else right--;
        }
        return false; //O(N) + O(N log N) - for sorting SC -> O(1)
    }
}
