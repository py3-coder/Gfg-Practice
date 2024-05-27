//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG{
    public static void main(String args[]) throws IOException{
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int N=sc.nextInt();
            int M=sc.nextInt();
            
            int [][]grid=new int[N][M];
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    grid[i][j]=sc.nextInt();
                    
                }
            }
            
            Solution obj=new Solution();
            long res=obj.solve(N, M, grid);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int[][][] memo;
    public int solve(int n, int m, int grid[][]){
        // Code here
        memo = new int[n][m][m];
        Arrays.stream(memo).forEach(plane -> Arrays.stream(plane).forEach(row -> Arrays.fill(row,-1)));
        return solveRec(0,0,m-1,n,m,grid);
    }
    
    public int solveRec(int i,int j1,int j2,int n,int m,int[][] grid){
        //Base Case ::
        if(j1<0 || j2<0 || j1>=m || j2>=m ){
            return (int)-1e8;
        }
        
        if(memo[i][j1][j2]!=-1){
            return memo[i][j1][j2];
        }
        if(i == n-1 ){
            if(j1==j2){
                return grid[i][j1];
            }else{
                return grid[i][j1]+ grid[i][j2];
            }
        }
        
        
        // 3 - state - > 3 state  --> 9 state 
        int maxi = (int)-1e8;
        for(int dj1=-1;dj1<2;dj1++){
            for(int dj2=-1;dj2<2;dj2++){
                int val =0;
                //
                if(j1 == j2 ){
                    val = grid[i][j1];
                }else{
                    val = grid[i][j1] + grid[i][j2];
                }
                
                val += solveRec(i+1,j1+dj1,j2+dj2,n,m,grid);
                
                maxi = Math.max(maxi,val);
                
            }
        }
        return memo[i][j1][j2] =maxi ;
    }
}