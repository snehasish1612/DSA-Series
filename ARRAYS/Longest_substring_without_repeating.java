// Given a string s, find the length of the longest substring without duplicate characters.

// Example 1:
// Input: s = "abcabcbb"
// Output: 3
// Explanation: The answer is "abc", with the length of 3.
  
// Example 2:
// Input: s = "bbbbb"
// Output: 1
// Explanation: The answer is "b", with the length of 1.
  
// Example 3:
// Input: s = "pwwkew"
// Output: 3
// Explanation: The answer is "wke", with the length of 3.
// Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

//Solution: Time Complexity: O(n), Space Complexity: O(1)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int[] dict = new int[256]; //ASCII character set size
        Arrays.fill(dict, -1); //Initialize with -1

        int maxLen = 0, start = -1;
        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            if(dict[ch] > start)
                start = dict[ch];   //Update start to the index of last occurence
            dict[ch] = i;   //Store or update the index of last occurence
            maxLen = Math.max(maxLen, i - start);
        }

        return maxLen;
    }
}
