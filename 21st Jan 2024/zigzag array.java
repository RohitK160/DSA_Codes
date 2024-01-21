/*Given an array arr of distinct elements of size N, the task is to rearrange the elements of the array in a zig-zag fashion so that the converted array should be in the below form: 

arr[0] < arr[1]  > arr[2] < arr[3] > arr[4] < . . . . arr[n-2] < arr[n-1] > arr[n]. 

NOTE: If your transformation is correct, the output will be 1 else the output will be 0. 

Example 1:

Input:
N = 7
Arr[] = {4, 3, 7, 8, 6, 2, 1}
Output: 3 7 4 8 2 6 1
Explanation: 3 < 7 > 4 < 8 > 2 < 6 > 1
Example 2:

Input:
N = 4
Arr[] = {1, 4, 3, 2}
Output: 1 4 2 3
Explanation: 1 < 4 > 2 < 3
Your Task:
You don't need to read input or print anything. Your task is to complete the function zigZag() which takes the array of integers arr and n as parameters and returns void. You need to modify the array itself.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

Constraints:
1 <= N <= 106
0 <= Arri <= 109

  */

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static PrintWriter ot;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int a[] = new int[n];
            String s[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++)
                a[i] = Integer.parseInt(s[i]);
            Solution soln = new Solution();
            soln.zigZag(a, n);
            boolean bool = isZigZag(a, n);
            if (bool)
                ot.println(1);
            else
                ot.println(0);
        }
        ot.close();
    }

    static boolean isZigZag(int a[], int n) {
        boolean flag = true;
        for (int i = 1; i < n; i++) {
            if (flag) {
                if (a[i - 1] > a[i])
                    return false;
            } else {
                if (a[i - 1] < a[i])
                    return false;
            }
            flag = !flag;
        }
        return true;
    }
}
// } Driver Code Ends

// User function Template for Java

class Solution {

    public static void zigZag(int[] arr, int n) {
        boolean flag = true;

        for (int i = 0; i < n - 1; i++) {
            if (flag) {
                // If the current element is greater than the next element, swap them
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            } else {
                // If the current element is less than the next element, swap them
                if (arr[i] < arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            }

            flag = !flag;
        }
    }

    // Utility function to swap elements in the array
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Utility function to print the array
    private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}