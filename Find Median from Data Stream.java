import java.util.*;
public class Solution {
    public static void findMedian(int arr[])  {
        
        if(arr.length==0) return;
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>(Collections.reverseOrder());
        
        PriorityQueue<Integer> minHeap=new PriorityQueue<>();
        
        int median=arr[0];
        System.out.print(median+" ");
        maxHeap.add(arr[0]);
        for(int i=1;i<arr.length;i++){
            int num=arr[i];
            if(maxHeap.size()>minHeap.size()){
                if(median>num){
                    
                    minHeap.add(maxHeap.remove());
                    maxHeap.add(num);
                }else{
                    minHeap.add(num);
                }
                median=(minHeap.peek()+maxHeap.peek())/2;
            }else if(maxHeap.size()==minHeap.size()){
                // both part is equals
                if(num<median){
                    // num lesser than median should always go on left side
                    maxHeap.add(num);
                    median=maxHeap.peek();
                }else{
                    minHeap.add(num);
                    median=minHeap.peek();
                }
            }else{
               
                if(num>median){
                    
                    maxHeap.add(minHeap.poll());
                    minHeap.add(num);
                }else{
                    maxHeap.add(num);
                }
                median=(maxHeap.peek()+minHeap.peek())/2;
            }
            System.out.print(median+" ");
        }
     }
}
