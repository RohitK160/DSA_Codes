
/*Given an unsorted array of size N. Find the first element in array such that all of its left elements are smaller and all right elements to it are greater than it.

Note: Left and right side elements can be equal to required element. And extreme elements cannot be required element.

 

Example 1:

Input:
N = 4
A[] = {4, 2, 5, 7}
Output:
5
Explanation:
Elements on left of 5 are smaller than 5
and on right of it are greater than 5.
 

Example 2:

Input:
N = 3
A[] = {11, 9, 12}
Output:
-1
 

Your Task:  
You don't need to read input or print anything. Your task is to complete the function findElement() which takes the array A[] and its size N as inputs and returns the required element. If no such element present in array then return -1.

 

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

 

Constraints:
3 <= N <= 106
1 <= A[i] <= 106

 */
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int[] a = new int[n];
            String[] inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }

            Compute obj = new Compute();
            System.out.println(obj.findElement(a, n));

        }
    }
}
// } Driver Code Ends

// User function Template for Java

class Compute {

    static int findElement(int[] A, int N) {
        int[] leftMax = new int[N];
        int[] rightMin = new int[N];

        // Fill leftMax array
        leftMax[0] = Integer.MIN_VALUE;
        for (int i = 1; i < N; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], A[i - 1]);
        }

        // Fill rightMin array
        rightMin[N - 1] = Integer.MAX_VALUE;
        for (int i = N - 2; i >= 0; i--) {
            rightMin[i] = Math.min(rightMin[i + 1], A[i + 1]);
        }

        // Check for the element that satisfies the condition
        for (int i = 1; i < N - 1; i++) {
            if (A[i] > leftMax[i] && A[i] < rightMin[i]) {
                return A[i];
            }
        }

        return -1; // No such element found
    }
}