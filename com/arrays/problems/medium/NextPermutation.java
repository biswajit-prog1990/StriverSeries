package com.arrays.problems.medium;

/**
 * Permutation - n! ways they can be arranged (in sorted order)
 * arr[] = [3,1,2] -> 123<132<213... and so on
 * Next Permutation - find next permutation after [3,1,2] -> 3,2,1
 * ... if no one after 3,2,1 then output first possible rearrangement
 * Brute Force - Generate all permutations, (sorted order)
 * ... linear search find where the element lies
 * ... next index will be ans, if it doesn't exist then first will be ans
 * ... find permutation using recursion (N!*N)
 * Optimal Solution -
 * arr[] - [2,1,5,4,3,0,0]
 * ... 1. longer prefix match
 * ... (find the breakpoint) where a[i] < a[i+1]
 * ... 2. find someone > 1, but the smallest one so that you stay close
 * ... 3. Try to place remaining in sorted order
 * Algorithm :
 * ... 1. for(i=n-2; i>=0; i--) {
 * if(a[i] < a[i+1])
 * {
 * ind = i;
 * break;
 * }
 * }
 * <p>
 * if(ind == -1)
 * rev(arr)
 * 2. for(i=n-1; i>=ind; i--) {
 * if(arr[i] > arr[ind])
 * {
 * swap(arr[i], arr[ind]);
 * break;
 * }
 * }
 * 3. rev(arr, ind-1, n-1) //Next permutation found
 */

public class NextPermutation {

    private static int[] findNextPermutation(int[] arr, int n) {
        int ind = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                //break index found
                ind = i;
                break;
            }
        }
        if (ind == -1) {
            reverse(arr, 0, n - 1);
            return arr;
        }
        for (int i = n - 1; i > ind; i--) {
            if (arr[i] > arr[ind]) {
                int temp = arr[i];
                arr[i] = arr[ind];
                arr[ind] = temp; //swap arr[i], arr[ind]
                break;
            }
        }
        //Reverse the array as last step
        reverse(arr, ind + 1, n);
        return arr;
    }

    private static void reverse(int[] arr, int i, int i1) {
        while (i <= i1) {
            int temp = arr[i];
            arr[i] = arr[i1];
            arr[i1] = temp;
            i++;
            i1--;
        }
    }
}
