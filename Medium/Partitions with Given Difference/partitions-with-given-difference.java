//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int d;
            d = Integer.parseInt(br.readLine());
            
            
            int[] arr = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.countPartitions(n, d, arr);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
    static int[][] memo;
    static int mod = 1000000007;
    public int countPartitions(int n, int d, int[] arr) {
        // code here
        // s = s1+s2 
        // d = s1-s2
        // ----------
        // s+d =2[s1]
        // s+d/2 == s1  
        
        int sum = Arrays.stream(arr).sum();
        int s1 = (sum+d)/2;
        
        if((sum+d)%2!=0) return 0;
        
        memo = new int[n+1][s1+1];
        Arrays.stream(memo).forEach(a->Arrays.fill(a,-1));
        return solveTab(arr,n,s1);
        
    }
    // TC - O(2^n)
	// SC - O(n*sum)
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
	// TC - O(n*sum)
	// SC - O(n*sum)
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
	// TC - O(n*sum)
	// SC - 2*O(sum)
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
        
 