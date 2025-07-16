// Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
// The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
// You must write an algorithm that runs in O(n) time and without using the division operation.

// Example 1:
// Input: nums = [1,2,3,4]
// Output: [24,12,8,6]

// Example 2:
// Input: nums = [-1,1,0,-3,3]
// Output: [0,0,9,0,0]

//Solution:-

//Optimal Approach 1: TC: O(n), SC: O(n) [Extra Space]
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        //Prefix calculation
        int[] prefix = new int[n];
        prefix[0] = 1;
        for(int i = 1; i < n; i++)
            prefix[i] = prefix[i - 1] * nums[i - 1];
        
        //Suffix Calculation
        int[] suffix = new int[n];
        suffix[n - 1] = 1;
        for(int i = n - 2; i >= 0; i--)
            suffix[i] = suffix[i + 1] * nums[i + 1];
        
        //Answer Calculation
        int[] ans = new int[n];
        for(int i = 0; i < n; i++)
            ans[i] = prefix[i] * suffix[i];
            
        return ans;
    }
}

//Optimial Approach 2: TC: O(n), SC: O(1) extra (excluding result array)
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        //Prefix calculation
        ans[0] = 1;
        for(int i = 1; i < n; i++)
            ans[i] = ans[i - 1] * nums[i - 1];
        
        //Suffix Calculation
        int suffix = 1;
        for(int i = n - 2; i >= 0; i--){
            suffix *= nums[i + 1];
            ans[i] *= suffix;
        }
        
        return ans;
    }
}
