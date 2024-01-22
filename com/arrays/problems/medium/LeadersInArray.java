package com.arrays.problems.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * arr[] = [10,22,12,3,0,6]
 * -> leaders : everything in right should be smaller
 * -> leaders : [22, 12, 6]
 * Brute force : go across every element and check using linear search if >
 * ... for(i = 0 -> n)
 * leader = true;
 * for(j = i+1 -> n)
 * if(a[j] > a[i])
 * leader = false; break;
 * if(leader == true) ans.add(a[i]) //O(n*n), O(n)
 * <p>
 * Optimal solution : check if array ele > max on right
 * max = INT_MIN
 * move from n -> 0 (back iteration), max = 6 ... keep on checking
 * ... update max and keep adding to the ans
 */

public class LeadersInArray {

    private static List<Integer> returnLeaders(int[] arr, int n) {
        int max = Integer.MIN_VALUE;
        List<Integer> ans = new ArrayList<>();
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] > max)
                ans.add(arr[i]);
            max = Math.max(max, arr[i]);
        }
        Collections.sort(ans);
        return ans; //O(n) + O(nlogn), SC -> O(n)
    }
}
