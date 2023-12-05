package com.arrays.problems.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Intersection - pick only the common elements, but repetition allowed
 * <p>
 * Brute Force - 1, ... check if 1 present, 2 present ... and so on
 * visited array -> [0, 0, 0, 0...]
 * 1 -> B array, 2 -> B array... and mark as visited
 * <p>
 * Optimal - Two pointer approach move pointers if matching else move each
 */

public class IntersectionSortedArray {

    private static int[] findIntersectionSortedArrayBF(int[] a, int[] b) {
        int n1 = a.length;
        int n2 = b.length;
        int[] visited = new int[n1 + n2];
        int[] intersect = new int[n1 + n2];
        int cntr = 0;
        for (int k : a) {
            for (int j = 0; j < n2; j++) {
                if (k == b[j] && visited[j] == 0) {
                    intersect[cntr++] = k;
                    visited[j] = 1;
                    break;
                }
                if (b[j] > k)
                    break;
            }
        } // TC -> O(n1 * n2)
        // SC -> O(n2)
        return intersect;
    }

    private static List<Integer> findIntersectionSortedArray(int[] a, int[] b) {
        int n = a.length;
        int m = b.length;
        int i = 0;
        int j = 0;
        List<Integer> output = new ArrayList<>();
        while (i < n && j < m) {
            if (a[i] < b[j])
                i++;
            else if (b[j] < a[i])
                j++;
            else {
                output.add(a[i]);
                i++;
                j++;
            }
        }
        return output;
    }
}
