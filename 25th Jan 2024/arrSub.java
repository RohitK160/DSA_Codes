/*
 * Given two arrays: a1[0..n-1] of size n and a2[0..m-1] of size m. Task is to check whether a2[] is a subset of a1[] or not. Both the arrays can be sorted or unsorted. There can be duplicate elements.
 

Example 1:

Input:
a1[] = {11, 7, 1, 13, 21, 3, 7, 3}
a2[] = {11, 3, 7, 1, 7}
Output:
Yes
Explanation:
a2[] is a subset of a1[]

Example 2:

Input:
a1[] = {1, 2, 3, 4, 4, 5, 6}
a2[] = {1, 2, 4}
Output:
Yes
Explanation:
a2[] is a subset of a1[]

Example 3:

Input:
a1[] = {10, 5, 2, 23, 19}
a2[] = {19, 5, 3}
Output:
No
Explanation:
a2[] is not a subset of a1[]
 

Your Task:  
You don't need to read input or print anything. Your task is to complete the function isSubset() which takes the array a1[], a2[], its size n and m as inputs and return "Yes" if arr2 is subset of arr1 else return "No" if arr2 is not subset of arr1.

 

Expected Time Complexity: O(max(n,m))
Expected Auxiliary Space: O(n)

Constraints:
1 <= n,m <= 105
1 <= a1[i], a2[j] <= 106
 */

import java.util.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            StringTokenizer stt = new StringTokenizer(br.readLine());

            long n = Long.parseLong(stt.nextToken());
            long m = Long.parseLong(stt.nextToken());
            long a1[] = new long[(int) (n)];
            long a2[] = new long[(int) (m)];

            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a1[i] = Long.parseLong(inputLine[i]);
            }
            String inputLine1[] = br.readLine().trim().split(" ");
            for (int i = 0; i < m; i++) {
                a2[i] = Long.parseLong(inputLine1[i]);
            }

            Compute obj = new Compute();
            System.out.println(obj.isSubset(a1, a2, n, m));

        }
    }
}

// } Driver Code Ends

// User function Template for Java

class Compute {
    public String isSubset(long a1[], long a2[], long n, long m) {
        HashSet<Long> set = new HashSet<>();
        HashMap<Long, Integer> frequencyMap = new HashMap<>();

        // Count the frequency of each element in a1
        for (int i = 0; i < n; i++) {
            set.add(a1[i]);
            frequencyMap.put(a1[i], frequencyMap.getOrDefault(a1[i], 0) + 1);
        }

        // Check if all elements of a2 are present in the HashSet
        for (int i = 0; i < m; i++) {
            if (set.contains(a2[i])) {
                frequencyMap.put(a2[i], frequencyMap.get(a2[i]) - 1);
                if (frequencyMap.get(a2[i]) == 0) {
                    set.remove(a2[i]);
                }
            } else {
                return "No";
            }
        }

        return "Yes";

    }
}