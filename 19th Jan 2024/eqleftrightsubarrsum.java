/*Given an array A of n positive numbers. The task is to find the first index in the array such that the sum of elements before it is equal to the sum of elements after it.

Note:  Array is 1-based indexed.

Example 1:

Input: 
n = 5 
A[] = {1,3,5,2,2} 
Output: 3 
Explanation: For second test case 
at position 3 elements before it 
(1+3) = elements after it (2+2). 
 

Example 2:

Input:
n = 1
A[] = {1}
Output: 1
Explanation:
Since its the only element hence
it is the only point.
Your Task:
The task is to complete the function equalSum() which takes the array and n as input parameters and returns the point. Return -1 if no such point exists.

Expected Time Complexily: O(N)
Expected Space Complexily: O(1)

Constraints:
1 <= n <= 106
1 <= A[i] <= 108 */

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        while (test-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[] A = new int[N];
            String[] str = br.readLine().trim().split(" ");
            for (int i = 0; i < N; i++)
                A[i] = Integer.parseInt(str[i]);
            Solution ob = new Solution();
            System.out.println(ob.equalSum(A, N));
        }
    }
}
// } Driver Code Ends

// User function Template for Java

class Solution {
    int equalSum(int[] A, int N) {
        if (N == 1) {
            return 1; // Single element is always the only point
        }

        long totalSum = 0; // Use long to avoid overflow
        long leftSum = 0;

        // Calculate the total sum of the array
        for (int num : A) {
            totalSum += num;
        }

        // Iterate through the array to find the index with equal sum
        for (int i = 1; i <= N; i++) {
            totalSum -= A[i - 1]; // Subtract current element from totalSum

            if (leftSum == totalSum) {
                return i; // Index with equal sum found (1-based indexing)
            }

            leftSum += A[i - 1];
        }

        // No such point exists
        return -1;
    }
}
