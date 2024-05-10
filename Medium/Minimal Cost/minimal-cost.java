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
            int K=sc.nextInt();
            int []arr=new int[N];
            for(int i=0;i<N;i++){
                arr[i]=sc.nextInt();
            }
            Solution obj=new Solution();
            int res=obj.minimizeCost(arr,N,K);
            System.out.println(res);
            
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int[] memo;
    public int minimizeCost(int arr[],int N,int K){
        
        //Recursion ::
        // TC : (k^n)
        // SC : O(n)
        //return solveRec(arr,N-1,K);
        
        // Memoization
        memo = new int[N];
        Arrays.fill(memo,-1);
        return solveMemo(arr,N-1,K);
    }
    public int solveRec(int[] arr,int indx,int k){
        if(indx==0) return 0;
        int mini = Integer.MAX_VALUE;
        for(int j=1;j<=k;j++){
            if(indx-j>=0){
                int cost = solveRec(arr,indx-j,k)+Math.abs(arr[indx]-arr[indx-j]);
                mini =Math.min(mini,cost);
            }
        }
        return mini;
    }
    public int solveMemo(int[] arr,int indx,int k){
        if(indx==0) return 0;
        if(memo[indx]!=-1){
            return memo[indx];
        }
        int mini = Integer.MAX_VALUE;
        for(int j=1;j<=k;j++){
            if(indx-j>=0){
                int cost = solveMemo(arr,indx-j,k)+Math.abs(arr[indx]-arr[indx-j]);
                mini =Math.min(mini,cost);
            }
        }
        return memo[indx]=mini;
    }
}

