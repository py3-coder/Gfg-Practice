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
            int []arr=new int[N];
            for(int i=0;i<N;i++){
                arr[i]=sc.nextInt();
                
            }
            Solution obj=new Solution();
            int res=obj.minimumEnergy(arr,N);
            System.out.println(res);
            
        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution{
    static int[] memo;
    public int minimumEnergy(int arr[],int N){
        //code here
        
        // Recursion-
        // TC : O(2^n)
        // SC :O(n)
        //return solveRec(arr,0);
        
        
        memo = new int[N];
        Arrays.fill(memo,-1);
        // Memoization 
        return solveMemo(arr,0);
    }
    
    public int solveRec(int arr[] ,int indx){
        //Base Case ::
        if(indx>=arr.length-1) return 0;
        
        // take either one step or two step:-
        int one  = solveRec(arr,indx+1)+Math.abs(arr[indx]-arr[indx+1]);
        int two   = Integer.MAX_VALUE;
        if(arr.length-1-indx>=2){
            two = solveRec(arr,indx+2) +Math.abs(arr[indx]-arr[indx+2]);
        }
        return Math.min(one,two);
    }
    public int solveMemo(int arr[] ,int indx){
        //Base Case ::
        if(indx>=arr.length-1) return 0;
        
        if(memo[indx]!=-1){
            return memo[indx];
        }
        // take either one step or two step:-
        int one  = solveMemo(arr,indx+1)+Math.abs(arr[indx]-arr[indx+1]);
        int two   = Integer.MAX_VALUE;
        if(arr.length-1-indx>=2){
            two = solveMemo(arr,indx+2) +Math.abs(arr[indx]-arr[indx+2]);
        }
        return memo[indx]=Math.min(one,two);
    }
}