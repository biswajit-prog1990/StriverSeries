package com.arrays.problems.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * arr[] = [2,2,3,3,1,2,2]
 * find element which should appear more than n/2 times
 * Brute force - pick element and loop through array, cnt and check if >n/2
 * ... Better Solution -
 * ... hashing
 * ... Optimal Solution -
 * [Moore's voting algorithm]
 * initial cnt =0, el =0
 * start el=7, cnt=1..2... and if you don't find 7, decrease until 0
 * ... if count = 0, el = next element, count=1
 * 1. Apply moore's voting algo
 * 2. Verify if element got is majority or not (iterate through array and
 * ... find how many times occurred)
 */

public class MajorityElement {

    private static int findMajorityElementBF(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            int cntr = 0;
            for (int j = 0; j < n; j++) {
                if (arr[i] == arr[j])
                    cntr++;
            }
            if (cntr > n / 2) return arr[i];
        }
        return -1; //O(n^2)
    }

    private static int findMajorityElementBetter(int[] arr, int n) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < n; i++)
            mp.put(arr[i], mp.getOrDefault(arr[i], 0) + 1);
        //Count majority element
        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            if (entry.getValue() > n / 2)
                return entry.getKey();
        }
        return -1;  //O(N) worst case, best and average case O(N log N)
        //SC -> O(N)
    }

    private static int findMajorityElementOptimal(int[] arr, int n) {
        int cnt = 0, el = 0;
        for (int i = 0; i < n; i++) {
            if (cnt == 0) {
                cnt = 1;
                el = arr[i];
            } else if (arr[i] == el)
                cnt++;
            else
                cnt--;
        }
        int cnt1 = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == el) cnt1++;
        }
        if (cnt1 > n / 2)
            return el;
        return -1; //TC -> O(N) SC -> O(1)
    }
}
