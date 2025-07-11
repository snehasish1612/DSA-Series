// Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
//   1. 0 <= a, b, c, d < n
//   2. a, b, c, and d are distinct.
//   3. nums[a] + nums[b] + nums[c] + nums[d] == target
// You may return the answer in any order.

// Example 1:
// Input: nums = [1,0,-1,0,-2,2], target = 0
// Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]

// Example 2:
// Input: nums = [2,2,2,2,2], target = 8
// Output: [[2,2,2,2]]

//Solution: Using 2 Pointer Approach: Time Complexity: O(nlogn + n^3) or O(n^3), Space Complexity: O(Unique Groups)
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for(int a = 0; a < n; a ++){
            if(a > 0 && nums[a] == nums[a - 1]) continue;
            
            for(int b = a + 1; b < n; b++){
                if(b > a + 1 && nums[b] == nums[b - 1]) continue;
                int c = b + 1, d = n - 1;
                while(c < d){
                    long sum = (long) nums[a] + nums[b] + nums[c] + nums[d];

                    if(sum < target) c++;
                    else if(sum > target) d--;
                    else{
                        List<Integer> quadruplets = Arrays.asList(nums[a], nums[b], nums[c], nums[d]);
                        result.add(quadruplets);
                        c++; d--;

                        while(c < d && nums[c] == nums[c - 1]) c++;
                    }
                }
            }
        }

        return result;
    }
}
