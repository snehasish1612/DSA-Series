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

//Using Prefix Sum Approach: TC: O(n), SC: O(n)
class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0, n = nums.length;
        
        int[] prefixSum = new int[n];
        prefixSum[0] = nums[0];
        for(int i = 1; i < n; i++)
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            if(prefixSum[i] == k)
                count++;

            int val = prefixSum[i] - k;
            if(map.containsKey(val))
                count += map.get(val);
            
            map.put(prefixSum[i], map.getOrDefault(prefixSum[i], 0) + 1);
        }

        return count;
    }
}
