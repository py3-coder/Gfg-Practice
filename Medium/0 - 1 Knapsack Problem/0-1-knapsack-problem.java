//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])throws IOException
    {
        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        //reading total testcases
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            //reading number of elements and weight
            int n = Integer.parseInt(read.readLine());
            int w = Integer.parseInt(read.readLine());
            
            int val[] = new int[n];
            int wt[] = new int[n];
            
            String st[] = read.readLine().trim().split("\\s+");
            
            //inserting the values
            for(int i = 0; i < n; i++)
              val[i] = Integer.parseInt(st[i]);
             
            String s[] = read.readLine().trim().split("\\s+"); 
            
            //inserting the weigths
            for(int i = 0; i < n; i++)
              wt[i] = Integer.parseInt(s[i]);
              
            //calling method knapSack() of class Knapsack
            System.out.println(new Solution().knapSack(w, wt, val, n));
        }
    }
}




// } Driver Code Ends


class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int[][] memo =new int[1001][1001];
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
        Arrays.stream(memo).forEach(a-> Arrays.fill(a,-1));
        return solveRec(W,wt,val,n);
    } 
    public static int solveRec(int w,int[] wt,int[] val,int n){
        //Base Case ::
        if(w==0 || n==0) return 0;
        
        if(memo[w][n]!=-1){
            return memo[w][n];
        }
        if(w<wt[n-1]){
           return memo[w][n]=solveRec(w,wt,val,n-1);
        }
        int pick =val[n-1]+solveRec(w-wt[n-1],wt,val,n-1);
        int notpick =solveRec(w,wt,val,n-1);
        return memo[w][n]=Math.max(pick,notpick);
        
    }
}


