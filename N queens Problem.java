import java.util.*;

public class Solution {
    public static ArrayList<ArrayList<Integer>> solveNQueens(int n) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        int[][] board = new int[n][n];
        int[] col = new int[n];
        int[] tr = new int[2*n-1];
        int[] tl = new int[2*n-1];
        NQueenhelper(0,n,board,ans,col,tr,tl);
        return ans;
    }
    private static void NQueenhelper(int i,int n,int[][] board,ArrayList<ArrayList<Integer>> ans,int[] col,int[] tr,int[] tl){
        if(i==n){
            ArrayList<Integer> temp = new ArrayList<>();
            for(int[] k : board){
                for(int m = 0;m<k.length;m++)
                    temp.add(k[m]);
            }
            ans.add(temp);
            return;
        }
        for(int j=0;j<n;j++){
            if(col[j]==0 && tr[i+j]==0 && tl[n-1+i-j]==0){
                board[i][j] = 1;
                col[j]=tr[i+j]=tl[n-1+i-j]=1;
                NQueenhelper(i+1,n,board,ans,col,tr,tl);
                board[i][j] = 0;
                col[j]=tr[i+j]=tl[n-1+i-j]=0;
            }
        }
    }
}
