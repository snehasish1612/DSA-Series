// You are given an m x n integer matrix matrix with the following two properties:
//   Each row is sorted in non-decreasing order.
//   The first integer of each row is greater than the last integer of the previous row.
// Given an integer target, return true if target is in matrix or false otherwise.
// You must write a solution in O(log(m * n)) time complexity.

// Example 1:
// Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
// Output: true
  
// Example 2:
// Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
// Output: false

//Solution using Binary Search: Time Complexity: O(logm) + O(logn) = O(log(m*n)), Space Complexity: O(1)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int sR = 0, eR = m - 1;
        while(sR <= eR){
            int midR = sR + (eR - sR) / 2;

            if(matrix[midR][0] <= target && target <= matrix[midR][n - 1])
                return binarySearch(matrix[midR], target);
            else if(target > matrix[midR][n - 1])
                sR = midR + 1;
            else
                eR = midR - 1;
        }

        return false;
    }

    public boolean binarySearch(int[] mat, int target){
        int n = mat.length;
        int left = 0, right = n - 1;

        while(left <= right){
            int mid = left + (right - left) / 2;
            if(mat[mid] == target)  return true;
            else if(target > mat[mid])  left = mid + 1;
            else    right = mid - 1;
        }

        return false;
    }
}
