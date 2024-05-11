//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if(ob.isSubsetSum(N, arr, sum))
            System.out.println(1);
            else
            System.out.println(0);

            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{

    static int[][] memo = new int[101][100001];
    static Boolean isSubsetSum(int N, int arr[], int sum){
        // code here
        
        // Recursion :-
        // TC :-  O(2^n)
        // SC :- O(n) -- Aux stack
        //return solveRec(0,N,arr,sum);
        
        //Memoization
        // TC : O(n*target)
        // SC : O(n*target) + O(n) -- Aux stack--
        //.stream(memo).forEach(a -> Arrays.fill(a, -1));
        //return solveMemo(0,N,arr,sum)==1?true:false;
        
        
        // Tabulation
        //TC : O(n*sum)
        //SC : O(n*sum)
        return solveTab(N,arr,sum)==1?true:false;
        
    }
    static boolean solveRec(int i,int n,int[] arr, int target){
        //Base Case ::
        if(i>=n) return false;
        if(target==0) return true;
        
        // Choice Diagram:-
  
        if(arr[i]<=target){
            // pick case
            // notpick case
            return (solveRec(i+1,n,arr,target-arr[i]) || solveRec(i+1,n,arr,target)) ;
        }
        //not pick since arr[i]> target::
        return solveRec(i+1,n,arr,target);
    }
    
    //Memoizatiom - Bottom up 
    static int solveMemo(int i,int n,int[] arr, int target){
        //Base Case ::
        if(i>=n) return 0;
        if(target==0) return 1;
        
        if(memo[i][target]!=-1){
            return memo[i][target];
        }
        // Choice Diagram:-
        if(arr[i]<=target){
            // pick case
            // notpick case
            return memo[i][target]=Math.max(solveMemo(i+1,n,arr,target-arr[i]) , solveMemo(i+1,n,arr,target)) ;
        }
        //not pick since arr[i]> target::
        return memo[i][target]=solveMemo(i+1,n,arr,target);
    }
    // reverse of recursion :- call
    static int solveTab(int n,int[]arr ,int target){
        int[][] tab = new int[n+1][target+1];
        // Base Case ::-
        for(int i=0;i<n+1;i++){
            for(int j=0;j<target+1;j++){
                if(i==0){
                    tab[i][j]=0;
                }
                if(j==0){
                    tab[i][j]=1;
                }
            }
        }
        
        for(int i=1;i<n+1;i++){
            for(int j=1;j<target+1;j++){
                
                if(arr[i-1]<=j){
                    tab[i][j] = Math.max(tab[i-1][j-arr[i-1]],tab[i-1][j]);
                }else{
                    tab[i][j] =tab[i-1][j];
                }
            }
        }
        return tab[n][target];
    }
}