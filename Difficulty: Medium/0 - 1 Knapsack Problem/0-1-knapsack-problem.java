class Solution {
    static int knapsack(int W, int val[], int wt[]) {
        // code here
        int n = val.length;
        //return solve(n-1,W,val,wt);
        return solveTab(W,val,wt);
        //return solveTabSpaceOpt(W,val,wt);
    }
    static int solve(int n,int W , int[] val , int[] wt){
        //base case :
        if(n==0 || W==0) return 0;
        int pick=0,skip=0;
        if(W>=wt[n]){
            pick = val[n] + solve(n-1,W-wt[n],val,wt);
        }
        skip = solve(n-1,W,val,wt);
        return Math.max(pick,skip);
    }
    static int solveTab(int W , int[] val , int[] wt){
        int n =val.length;
        int[][] dp = new int[n+1][W+1];
        for(int i=1;i<n+1;i++){
            for(int j=1;j<W+1;j++){
                int pick=0,skip=0;
                if(j>=wt[i-1]){
                    pick = val[i-1] + dp[i-1][j-wt[i-1]];
                }
                skip = dp[i-1][j];
                dp[i][j] = Math.max(pick,skip);
            }
        }
        return dp[n][W];
    }
}
