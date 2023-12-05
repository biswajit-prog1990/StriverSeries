package com.arrays.problems.easy;

import java.util.*;

/**
 * Union a, b = a U b => Add all elements from both arrays
 * <p>
 * Brute Force - Unique elements (Map/Set)
 * ... Set -> iterate from first array, and then second array [TreeSet]
 * Union[] = size of Set
 * <p>
 * Optimal - Two pointer approach
 * i -> a1, j -> a2
 */

public class UnionTwoSortedArrays {

    private static int[] unionSortedArraysBF(int[] arr1, int[] arr2, int n, int m) {
        Set<Integer> sSet = new TreeSet<>();
        for (int i = 0; i < n; i++)
            sSet.add(arr1[i]); //TC (nlogn)
        //Add Second array elements
        for (int i = 0; i < m; i++)
            sSet.add(arr2[i]); //TC(nlogn)
        Iterator<Integer> it = sSet.iterator();
        int[] unionArray = new int[sSet.size()];
        int j = 0;
        while (it.hasNext()) {
            unionArray[j++] = it.next();
        }
        return unionArray;
        //TC -> O(n1 log n + n2 log n) + O(n1 + n2)
        //SC -> O(n1 + n2)
    }

    private static List<Integer> unionSortedArrayTwoPointer(int[] arr1, int[] arr2, int n, int m) {
        int i = 0, j = 0;
        List<Integer> unionArr = new ArrayList<>();
        while (i < n && j < m) {
            if (arr1[i] < arr2[j]) {
                if (unionArr.isEmpty() || unionArr.get(i - 1) != arr1[i])
                    unionArr.add(arr1[i]);
                i++;
            } else {
                if (unionArr.isEmpty() || unionArr.get(i - 1) != arr2[j])
                    unionArr.add(arr2[j]);
                j++;
            }
        }
        while (j < m) {
            if (unionArr.isEmpty() || unionArr.get(i - 1) != arr2[j])
                unionArr.add(arr2[j]);
            j++;
        }
        while (i < n) {
            if (unionArr.isEmpty() || unionArr.get(i - 1) != arr1[i])
                unionArr.add(arr1[i]);
            i++;
        }
        return unionArr;
    }
}
