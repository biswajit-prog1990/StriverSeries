package com.arrays.problems.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * arr[] = [3,1,-2,-5,2,-4] equal positives and negatives
 * .... rearrange as follows -
 * +,-,+,-... and so on but maintain order and
 * be like pos, neg, pos, neg ...
 * Brute Force - pos[], neg[] size n/2
 * ... positives put in pos and negatives put in neg
 * ... even index put in positives, odd index put in negatives
 * ... for(int i = 0 -> n/2) [arr[2*i] = pos[i]]
 * ... [arr[2*i+1] = neg[i]] // O(2N) , O(N)
 * Optimal - ans[] = pos -> even index, neg -> odd index
 * //O(N), O(N)
 * Variety 2 - if they are unequal
 * pos != neg, either pos > neg or neg > pos
 * arr[] = [1,2,-4,-5,3,6]
 * ans[] = [1,-4,2,-5,3,6]
 */

public class RearrangeArrayElementsBySign {

    private static int[] rearrangeArrayElementsEqual(int[] arr, int n) {
        int[] ans = new int[n];
        int posIndex = 0, negIndex = 1;
        for (int i = 0; i < n; i++) {
            if (arr[i] < 0) {
                ans[negIndex] = arr[i];
                negIndex += 2;
            } else {
                ans[posIndex] = arr[i];
                posIndex += 2;
            }
        }
        return ans;
    }

    private static int[] rearrangeArrayElementsUnequal(int[] arr, int n) {
        //need to fall back to brute force solution
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0)
                pos.add(arr[i]);
            else
                neg.add(arr[i]);
        }
        if (pos.size() > neg.size()) {
            for (int i = 0; i < neg.size(); i++) {
                arr[i * 2] = pos.get(i);
                arr[i * 2 + 1] = neg.get(i);
            }
            int index = neg.size() * 2;
            for (int i = neg.size(); i < pos.size(); i++) {
                arr[index] = pos.get(i);
                index++;
            }
        } else {
            for (int i = 0; i < pos.size(); i++) {
                arr[i * 2] = pos.get(i);
                arr[i * 2 + 1] = neg.get(i);
            }
            int index = pos.size() * 2;
            for (int i = pos.size(); i < neg.size(); i++) {
                arr[index] = neg.get(i);
                index++;
            }
        }
        return arr; //TC -> O(N) + O(min(pos, neg)) + O(leftovers)
    }
}
