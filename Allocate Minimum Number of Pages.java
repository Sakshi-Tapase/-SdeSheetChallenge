import java.lang.Math;
public class Solution {
    public static long ayushGivesNinjatest(int n, int m, int[] time) 
    {
        long start = 0;
        long end = 0;
        for(int i=0 ; i<m ; i++)
        {
            end = end + time[i];
            if(time[i]>start)
            {
                start = time[i];
            }
        }
        long ans = end;
        while(start <= end)
        {
            long mid = start + (end-start)/2;
            long sum = 0;
            int count = 1; 
            for(int i = 0; i<m ; i++)
            {
                if(sum + time[i] <= mid)          
                {
                    sum = sum + time[i];
                }
                else 
                {
                    count++;
                    sum = time[i];
                    
                }
            }
            if(count<=n)  
            {
                end = mid-1;
                ans = Math.min(ans,mid); 
            }
            else 
            {
                start = mid+1;
            }
        }
        return ans;
    }
}
