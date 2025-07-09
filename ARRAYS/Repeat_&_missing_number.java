//You are given a 0-indexed 2D integer matrix grid of size n * n with values in the range [1, n2]. 
//Each integer appears exactly once except a which appears twice and b which is missing. The task is to find the repeating and missing numbers a and b.
//Return a 0-indexed integer array ans of size 2 where ans[0] equals to a and ans[1] equals to b.

//Example 1:
// Input: grid = [[1,3],[2,2]]
// Output: [2,4]
// Explanation: Number 2 is repeated and number 4 is missing so the answer is [2,4].

// Example 2:
// Input: grid = [[9,1,7],[8,9,2],[3,4,6]]
// Output: [9,5]
// Explanation: Number 9 is repeated and number 5 is missing so the answer is [9,5].

//Solution using HashSet: Time Complexity: O(n²), Space Complexity: O(n²)
class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        Set<Integer> seen = new HashSet<>();
        int n = grid.length;
        int actualSum = 0, a = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(seen.contains(grid[i][j]))
                    a = grid[i][j];
                
                seen.add(grid[i][j]);
                actualSum += grid[i][j];
            }
        }

        int expectedSum = (n * n) * ((n * n) + 1) / 2;
        int b = expectedSum + a - actualSum;

        return new int[] {a, b};
    }
}
