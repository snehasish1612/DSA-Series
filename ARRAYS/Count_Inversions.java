// Given an array of integers arr[]. You have to find the Inversion Count of the array. 
// Note : Inversion count is the number of pairs of elements (i, j) such that i < j and arr[i] > arr[j].
  
// Examples:
  
// Input: arr[] = [2, 4, 1, 3, 5]
// Output: 3
// Explanation: The sequence 2, 4, 1, 3, 5 has three inversions (2, 1), (4, 1), (4, 3).
  
// Input: arr[] = [2, 3, 4, 5, 6]
// Output: 0
// Explanation: As the sequence is already sorted so there is no inversion count.
  
// Input: arr[] = [10, 10, 10]
// Output: 0
// Explanation: As all the elements of array are same, so there is no inversion count.

//Solution: Using Merge Sort: Time Complexity: O(n log n), Space Complexity: O(n)
class Solution {
    static int inversionCount(int arr[]) {
        // Code Here
        int n = arr.length;
        return mergeSort(arr, 0, n - 1);
    }
    
    static int mergeSort(int arr[], int st, int end){
        if(st < end){
            int mid = (st + end) / 2;
            
            int leftCount = mergeSort(arr, st, mid);
            int rightCount = mergeSort(arr, mid + 1, end);
            
            int mergeCount = merge(arr, st, mid, end);
            
            return leftCount + rightCount + mergeCount;
        }
        return 0;
    }
    
    static int merge(int arr[], int st, int mid, int end){
        int[] temp = new int[end - st + 1];
        int i = st, j = mid + 1, k = 0;
        int invCount = 0;
        
        while(i <= mid && j <= end){
            if(arr[i] <= arr[j])
                temp[k++] = arr[i++];
            else{
                temp[k++] = arr[j++];
                invCount += (mid - i + 1);
            }
        }
        
        while(i <= mid) temp[k++] = arr[i++];
        
        while(j <= end) temp[k++] = arr[j++];
        
        for(int idx = 0; idx < temp.length; idx++)
            arr[idx + st] = temp[idx];
        
        return invCount;
    }
}
