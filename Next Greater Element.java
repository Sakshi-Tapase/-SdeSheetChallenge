public class Solution {

public static int[] nextGreater(int[] arr, int n) { 
 //Write Your code here
       int[] ans = new int[n]; 
       ans[n-1] = -1; // to handle last element case
       // For every Element
       for (int i = 0; i < n-1; i++) {
           // Find its next greater element
           for (int j = i + 1; j < n; j++) {
               if (arr[i] < arr[j]) {
                   ans[i] = arr[j];
                   break;
               }
               else{
                   ans[i]= -1;
               }
           }
       }
       return ans;    
}
}
