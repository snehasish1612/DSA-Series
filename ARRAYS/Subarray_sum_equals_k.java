// Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
// A subarray is a contiguous non-empty sequence of elements within an array.

// Example 1:
// Input: nums = [1,1,1], k = 2
// Output: 2
  
// Example 2:
// Input: nums = [1,2,3], k = 3
// Output: 2

//Solution:-

//Using Brute Force: TC: O(n²), SC: O(1)
class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0, n = nums.length;
        for(int i = 0; i < n; i++){
            int sum = 0;
            for(int j = i; j < n; j++){
                sum += nums[j];
                if(sum == k)
                    count++;
            }
        }
        return count;
    }
}
