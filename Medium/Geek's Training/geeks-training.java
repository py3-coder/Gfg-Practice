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
            int [][]points=new int[N][3];
            for(int i=0;i<N;i++){
                for(int j=0;j<3;j++){
                    points[i][j]=sc.nextInt();
                }
            }
            Solution obj=new Solution();
            int res=obj.maximumPoints(points,N);
            System.out.println(res);
            
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int[][] memo;
    public int maximumPoints(int points[][],int N){
        //
        memo = new int[N+1][4];
        Arrays.stream(memo).forEach(a->Arrays.fill(a,-1));
        return solveRec(N,-1,points);
    }
    public int solveRec(int n,int opt,int[][] points){
        //Base Case:
        
        if(n<=0) return 0;
        if(memo[n-1][opt+1]!=-1){
            return memo[n-1][opt+1];
        }
        int maxscore=0;
        for(int i=0;i<3;i++){
            if(i!=opt){
                int currsum = points[n-1][i] + solveRec(n-1,i,points);
                maxscore = Math.max(currsum,maxscore);
            }
        }
        return memo[n-1][opt+1]=maxscore;
    }
}