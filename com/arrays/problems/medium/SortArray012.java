package com.arrays.problems.medium;

/**
 * arr[] = [0,1,2,0,1,2,1,2,0,0,0,1]
 * <p>
 * Brute Force - Use any of Sorting algos [NLogN], SC-> N
 * Better Solution -
 * ... do single iteration, keep three var countZero, countOne, countTwo
 * ... if reached end, then assign to original array
 * ... loop from 0 -> countZero
 * ... loop from countZero to countZero + countOne
 * ... loop from countOne + countOne to n //O(N) + O(N), SC -> O(1)
 * <p>
 * Optimal Solution -
 * Dutch National Flag Algorithm :
 * ... use three pointers low, mid, high
 * Rule 1 : [0 ... low -1] = 0      Extreme left
 * Rule 2 : [low ... mid - 1] = 1
 * Rule 3 : [high+1 ... n-1] = 2
 * mid -> high [random 0/1/2]
 * ... a[mid] == 0, 1, 2
 * ... starting put mid as 0, high as n-1 [as array is unsorted]
 * ... swap(a[low], a[mid])
 * ... new unsorted -> mid+1 -> high, so move mid one position ahead
 * ... per Rule1, 0... low-1 -> 0 (sorted), so move low as well
 * ... if 1 found, move mid
 * ... if 2 found, swap(a[mid], a[high]) high--
 */

public class SortArray012 {

    private static void sort012Optimal(int[] arr, int n) {
        int low = 0, mid = 0, high = n - 1;
        while (mid <= high) {
            if (arr[mid] == 0) {
                int temp = arr[low];
                arr[low] = arr[mid];
                arr[mid] = temp;
                low++;
                mid++;
            } else if (arr[mid] == 1)
                mid++;
            else {
                int temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;
                high--;
            }
        }
    }
}
