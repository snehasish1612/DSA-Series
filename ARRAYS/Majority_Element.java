//Given an array nums of size n, return the majority element.
//The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

//Example 1:
//Input: nums = [3,2,3]
// Output: 3

// Example 2:
// Input: nums = [2,2,1,1,1,2,2]
// Output: 2

//Solution:-

//Using Brute Force Approach [O(n^2)]
class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        for(int val : nums){
            int freq = 0;
            for(int d : nums){
                if(d == val)
                    freq++;
            }
            if(freq > n/2)
                return val;
        }
        return -1;
    }
}

//Using Optimize Approach [O(nlogn)]
class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int freq = 1, ans = nums[0], n = nums.length;

        for(int i = 1; i < n; i++){
            if(nums[i] == nums[i - 1])
                freq++;
            else{
                freq = 1;
                ans = nums[i];
            }

            if(freq > n/2)
                return ans;
        }

        return ans;
    }
}

//Using Moories Voting Algo [O(n)]
class Solution {
    public int majorityElement(int[] nums) {
        int freq = 0, ans = 0, n = nums.length;

        for(int i = 0; i < n; i++){
            if(freq == 0)
                ans = nums[i];
            
            if(ans == nums[i])
                freq++;
            else
                freq--;
        }

        return ans;
    }
}
