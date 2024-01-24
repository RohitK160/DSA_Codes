
/*Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

 

Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
 

Constraints:

1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lowercase English letters. */
import java.util.*;;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String str = strs[0];// 1st element
        String str2 = strs[strs.length - 1];// last element
        int index = 0;
        while (index < str.length() && index < str2.length()) {
            if (str.charAt(index) == str2.charAt(index)) {
                index++;
            } else {
                break;
            }
        }
        return str.substring(0, index);

    }
}