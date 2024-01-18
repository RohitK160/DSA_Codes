/*Given a binary array nums, return the maximum number of consecutive 1's in the array.

 

Example 1:

Input: nums = [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.
Example 2:

Input: nums = [1,0,1,1,0,1]
Output: 2
 

Constraints:

1 <= nums.length <= 105
nums[i] is either 0 or 1. */

public class maxConsOnes {

    public static int findMaxConsecutiveOnes(int[] no) {
        int maxC = 0;
        int currCount = 0;

        for (int num : no) {
            if (num == 1) {
                currCount++;
                maxC = Math.max(maxC, currCount);
            } else {
                currCount = 0;
            }
        }

        return maxC;
    }

    public static void main(String[] args) {
        int[] no1 = { 1, 1, 0, 1, 1, 1 };
        System.out.println("Example 1 Output: " + findMaxConsecutiveOnes(no1));

        int[] no2 = { 1, 0, 1, 1, 0, 1 };
        System.out.println("Example 2 Output: " + findMaxConsecutiveOnes(no2));
    }
}
