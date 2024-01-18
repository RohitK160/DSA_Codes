/*Given an array arr[] of size N containing equal number of odd and even numbers. Arrange the numbers in such a way that all the even numbers get the even index and odd numbers get the odd index.
Note: There are multiple possible solutions, Print any one of them. Also, 0-based indexing is considered.

 

Example 1:

Input:
N = 6
arr[] = {3, 6, 12, 1, 5, 8}
Output:
1
Explanation:
6 3 12 1 8 5 is a possible solution.
The output will always be 1 if your
rearrangement is correct.
Example 2:
Input:
N = 4
arr[] = {1, 2, 3, 4}
Output :
1

Your Task:  
You don't need to read input or print anything. Your task is to complete the function reArrange() which takes an integer N and an array arr of size N as input and reArranges the array in Place without any extra space.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)


Constraints:
1 ≤ N ≤ 105
1 ≤ arr[i] ≤ 105 */

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());

            String S[] = read.readLine().split(" ");
            int[] arr = new int[N];

            for (int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            ob.reArrange(arr, N);

            System.out.println(check(arr, N));
        }
    }

    static int check(int arr[], int n) {
        int flag = 1;
        int c = 0, d = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                if (arr[i] % 2 == 1) {
                    flag = 0;
                    break;
                } else
                    c++;
            } else {
                if (arr[i] % 2 == 0) {
                    flag = 0;
                    break;
                } else
                    d++;
            }
        }
        if (c != d)
            flag = 0;

        return flag;
    }
}
// } Driver Code Ends

// User function Template for Java
class Solution {

    public static void reArrange(int[] arr, int N) {
        int evenIndex = 0;
        int oddIndex = 1;

        while (evenIndex < N && oddIndex < N) {
            // Find the next even number at an odd index
            while (evenIndex < N && arr[evenIndex] % 2 == 0) {
                evenIndex += 2;
            }

            // Find the next odd number at an even index
            while (oddIndex < N && arr[oddIndex] % 2 != 0) {
                oddIndex += 2;
            }

            if (evenIndex < N && oddIndex < N) {
                swap(arr, evenIndex, oddIndex);
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}