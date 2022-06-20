int  isPossible(vector<int>a, int n, int players, int minDist) {
    int cnt =1;
    int curPosition = a[0];
    for( int i=1;i<n;i++)
   {
       if(a[i] - curPosition >=minDist)
       {
           cnt++;
           curPosition =a[i];
       }
   }
   if(cnt>=players)return true;
   return false;
   }
int chessTournament(vector<int> positions , int n ,  int c){
 sort(positions.begin(),positions.end());
   int low =1  ;
   int high = positions[n-1]-positions[0];
   while(low<=high)
   {
       int mid = (low+high)>>1;               
       if(isPossible(positions,n,c,mid))
       {
           low =mid+1;        
       }
      else
       {
           high =mid-1;
       }
   }
   return high;
}
