import java.util.ArrayList;
import java.util.*;

public class Solution {
    public static ArrayList<Integer> kthSmallLarge(ArrayList<Integer> arr, int n, int k) {
        //Write your code here
        Collections.sort(arr);
        ArrayList<Integer> num = new ArrayList<>();
        num.add(arr.get(k-1)); //kth smallest lement
        num.add(arr.get(n-k)); //kth largest element
        return num;
    }
}
