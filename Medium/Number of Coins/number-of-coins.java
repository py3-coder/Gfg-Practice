//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int v = sc.nextInt();
                    int m = sc.nextInt();
                    int coins[] = new int[m];
                    for(int i = 0;i<m;i++)
                        coins[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minCoins(coins, m, v));
                }
        }
}    
// } Driver Code Ends


class Solution{

	public int minCoins(int coins[], int M, int V) 
	{ 
	    // Your code goes here
	    //1. Recursion::
	    // TC : O(m^v)
	    //SC : O(1) --> Aux O(n):
	    //return solveRec(coins.length,coins,V);
	    
	    //2. Memo
	    int n=coins.length;
	    int memo[][] = new int[n+1][V+1];
	    Arrays.stream(memo).forEach(a->Arrays.fill(a,-1));
	    return solveMemo(n,coins,V,memo)==Integer.MAX_VALUE-1?-1:solveMemo(n,coins,V,memo);
	}
	public static int solveRec(int n,int coins[],int sum){
	    //Base ::
	    if(sum==0) return 0;
	    if(n==0) return Integer.MAX_VALUE-1;
	    if(coins[n-1]>sum){
	        return solveRec(n-1,coins,sum);
	    }else{
	        return Math.min(1+solveRec(n,coins,sum-coins[n-1]),solveRec(n-1,coins,sum));
	    }
	}
	public static int solveMemo(int n,int coins[],int sum,int [][]memo){
	    if(sum==0) return 0;
	    if(n==0) return Integer.MAX_VALUE-1;
	    
	    if(memo[n][sum]!=-1){
	        return memo[n][sum];
	    }
	    if(coins[n-1]>sum){
	        return memo[n][sum] =solveMemo(n-1,coins,sum,memo);
	    }else{
	        return memo[n][sum] =Math.min(1+solveMemo(n,coins,sum-coins[n-1],memo),solveMemo(n-1,coins,sum,memo));
	    }
	}
}