// Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
// You must do it in place.

// Example 1:
// Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
// Output: [[1,0,1],[0,0,0],[1,0,1]]

// Example 2:
// Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
// Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]

//Solution:-
//Using TC: O(m * n), SC: O(m + n)
class Solution {
    public void setZeroes(int[][] matrix) {
       int m = matrix.length, n = matrix[0].length;
       boolean[] row = new boolean[m];
       boolean[] col = new boolean[n];

       for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 0){
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(row[i] || col[j])
                    matrix[i][j] = 0;
            }
        }
    }
}

//Optimized Approach (In Place): TC: O(m*n), SC: O(1)
class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean firstRow = false, firstCol = false;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 0){
                    if(i == 0)  firstRow = true;
                    if(j == 0)  firstCol = true;

                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(matrix[0][j] == 0 || matrix[i][0] == 0)
                    matrix[i][j] = 0;
            }
        }

        if(firstRow){
            for(int j = 0; j < n; j++)
                matrix[0][j] = 0;
        }

        if(firstCol){
            for(int i = 0; i < m; i++)
                matrix[i][0] = 0;
        }
    }
}
