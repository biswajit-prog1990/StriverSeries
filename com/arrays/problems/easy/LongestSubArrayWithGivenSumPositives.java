package com.arrays.problems.easy;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Brute force - Generate all subarrays
 * ... take two pointers i, j (start from i)
 * ... subarray i->j, move j till it reaches last
 * ... then move i
 * <p>
 * Better solution - hashing
 * ... if there exist a subarray with sum k
 * ... as (.) as last element
 * ... check previous sum as x-k, and that is the subarray
 * <p>
 * [1,2,3,1,1,1,1,1,4,2,3]
 * Hashmap - sum = 0 [1->0] sum = 3, len = 2 [3->1], check length also
 * <p>
 * Optimal solution - two pointer approach
 * ... sliding window approach, trip from left
 * ... [1,2,3,1,1,1,1,1,3,3]  k = 6
 * ...  pointer1 -> 0th index, sum = 1, len = 0
 * ... pointer 2 -> increase till it reaches subarray k [len = j-i+1] maxlen
 * ... if(sum > k) minus 1 and move 1st pointer, ...
 * ... move exceeds stop
 */

public class LongestSubArrayWithGivenSumPositives {

    private static int findLongestSubArrayBF(int[] arr, int n, int k) {
        int len = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = 0;
                for (int l = i; l < j; l++)
                    sum += arr[l];
                if (sum == k) len = Math.max(len, j - i + 1);
            }
        }
        return len;
    }

    private static int findLongestSubArrayBFOptimized(int[] arr, int n, int k) {
        int len = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                if (sum == k) len = Math.max(len, j - i + 1);
            }
        }
        return len;
    }

    private static int findLongestSubArrayBetter(int[] arr, int n, int k) {
        Map<Long, Integer> preSumMap = new LinkedHashMap<>();
        long sum = 0;
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (sum == k) maxLen = Math.max(maxLen, i + 1);
            long rem = sum - k;
            if (preSumMap.containsKey(rem)) {
                int len = i - preSumMap.get(rem);
                maxLen = Math.max(maxLen, len);
            }
            if (!preSumMap.containsKey(sum)) preSumMap.put(sum, i);
        }
        return maxLen; //O(N log N) -> Ordered Map, O(N*1) -> Unordered Map
        // but worst case can be O(N*N) if collisions occur
        //SC -> O(N) [worst case every index has unique prefix sum]
    }

    private static int findLongestSubArrayOptimal(int[] arr, int n, int k) {
        int left = 0, right = 0;
        long sum = arr[0];
        int maxLen = 0;
        while (right < n) {
            while (left <= right && sum > k) {
                sum -= arr[left];
                left++;
            }
            if (sum == k)
                maxLen = Math.max(maxLen, right - left + 1);
            right++;
            if (right < n)
                sum += arr[right];
        }
        return maxLen; //TC -> O(2N) SC -> O(1)
    }
}
