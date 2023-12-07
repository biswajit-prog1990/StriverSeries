package com.arrays.problems.easy;

/**
 * Brute Force - Take to temp array and store values from right
 * ... example - 1,2,3,4,5,6,7 , d  = 3 [5,6,7,1,2,3,4]
 */

public class RightRotateArrayKPlaces {

    private static int[] rightRotateArrayKPlacesBF(int[] nums, int k) {
        int n = nums.length;
        if (n == 0)
            return new int[]{};
        k %= n;
        if (k == 0)
            return new int[]{};
        int[] tempArr = new int[k];
        int j = 0;
        //Add data to tempArr
        for (int i = n - k; i < n; i++)
            tempArr[j++] = nums[i];
        //Add data to Arr
        for (int i = n - k - 1; i >= 0; i--)
            nums[i + k] = nums[i];
        //Add tempArr to nums
        for (int i = 0; i < k; i++)
            nums[i] = tempArr[i];
        return nums; //TC -> O(n + n + n), SC -> O(n) Extra space for temp array
    }

    private static void rightArrayKPlacesOptimal(int[] arr, int n, int d) {
        if (n == 0) return;
        d = d % n;
        //Reverse last d elements
        reverse(arr, n - d, n - 1);
        //Reverse first n-d elements
        reverse(arr, 0, n - d - 1);
        //Reverse whole array
        reverse(arr, 0, n - 1);
    }

    private static void reverse(int[] arr, int start, int end) {
        while (start <= end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
