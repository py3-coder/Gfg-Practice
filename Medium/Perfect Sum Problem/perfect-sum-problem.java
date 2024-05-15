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
                    int n = sc.nextInt();
                    int sum = sc.nextInt();
                    int arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                    arr[i] = sc.nextInt();
                    
                    Solution ob = new Solution();
                    System.out.println(ob.perfectSum(arr,n,sum));
                }
        }
}    
// } Driver Code Ends




class Solution{
    static int[][] memo;
    static int mod =1000000007;
	public int perfectSum(int arr[],int n, int sum) 
	{ 
	    memo = new int[n+1][sum+1];
	    Arrays.stream(memo).forEach(a->Arrays.fill(a,-1));
	    return solveRec(arr,n,sum);
	   
	   //Tabulation
	  // return solveTab(arr,n,sum);
	   
	   //optimisation
	   //return solveOptimise(arr,n,sum);
	    
	} 
	public int solveRec(int[] arr,int n, int sum){
	    if(n==0){
	        if(sum==0) return 1;
	        return 0;
	    }
	    
	    if(memo[n][sum]!=-1){
	        return memo[n][sum];
	    }
	    //not pick :-
	    if(arr[n-1]>sum){
	        return memo[n][sum]=solveRec(arr,n-1,sum);
	    }else{
	         memo[n][sum]=(solveRec(arr,n-1,sum-arr[n-1])%mod)+(solveRec(arr,n-1,sum)%mod);
	        return memo[n][sum]=memo[n][sum]%mod;
	    }
	}
	public int solveTab(int[] arr,int n,int sum){
	    int tab[][] = new  int[n+1][sum+1];
	    //base case ::-
	    for(int i=0;i<=n;i++){
	        for(int j=0;j<=sum;j++){
	            if(j==0){
	                tab[i][j]=1;
	            }
	            
	        }
	    }
	    
	    for(int i=1;i<=n;i++){
	        for(int j=0;j<=sum;j++){
	            if(arr[i-1]>j){
	                tab[i][j] = tab[i-1][j];
	            }else{
	                tab[i][j] = tab[i-1][j-arr[i-1]]%mod + tab[i-1][j]%mod;
	                tab[i][j]%=mod;
	            }
	        }
	    }
	    return tab[n][sum];
	}
	public int solveOptimise(int[] arr,int n,int sum){
	    int[] curr = new int[sum+1];
	    int[] prev = new int[sum+1];
	    
	    curr[0]=1;
	    prev[0]=1;
	    
	    for(int i=1;i<=n;i++){
	        for(int j=0;j<=sum;j++){
	            if(arr[i-1]>j){
	                curr[j] = prev[j];
	            }else{
	                curr[j] = prev[j-arr[i-1]]%mod + prev[j]%mod;
	                curr[j]%=mod;
	            }
	        }
	        
	        for(int k=0;k<prev.length;k++){
	            prev[k]=curr[k];
	        }
	    }
	    return curr[sum];
	}
}