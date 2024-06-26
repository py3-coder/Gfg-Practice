//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String line1[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(line1[0]);
            int W = Integer.parseInt(line1[1]);
            String line2[] = in.readLine().trim().split("\\s+");
            int val[] = new int[N];
            for(int i = 0;i < N;i++)
                val[i] = Integer.parseInt(line2[i]);
            String line3[] = in.readLine().trim().split("\\s+");
            int wt[] = new int[N];
            for(int i = 0;i < N;i++)
                wt[i] = Integer.parseInt(line3[i]);
                
            Solution ob = new Solution();
            System.out.println(ob.knapSack(N, W, val, wt));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int[][] memo;
    static int knapSack(int N, int W, int val[], int wt[])
    {
        // code here
        
        //
        memo=  new int[N+1][W+1];
        Arrays.stream(memo).forEach(a->Arrays.fill(a,-1));
        return solveRec(N,W,val,wt);
    }
    
    public static int solveRec(int n,int w,int[] val ,int[] wt){
        //Base Casee ::
        if(n==0 || w==0){
            return 0;
        }
        
        if(memo[n][w]!=-1){
            return memo[n][w];
        }
        if(wt[n-1]>w){
            return memo[n][w]=solveRec(n-1,w,val,wt);
        }else{
            return memo[n][w]=Math.max(val[n-1]+solveRec(n,w-wt[n-1],val,wt),solveRec(n-1,w,val,wt));
        }
    }
}