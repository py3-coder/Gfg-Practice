class Solution {

    static Boolean isSubsetSum(int arr[], int sum) {
        // code here
        //return solve(arr.length-1,arr,sum)==1?true:false;
        
        //return solveTab(arr,sum)==1?true:false;
        
        return solveTabSpaceOpt(arr,sum)==1?true:false;
    }
    // TC : 2^n SC : O(n)
    static int solve(int i , int[] nums,int target){
        //base :
        if(target==0) return 1;
        if(i<0)return 0;
        int pick=0,skip=0;
        if(target>=nums[i]){
            pick  = solve(i-1,nums,target-nums[i]);
        }
        skip = solve(i-1,nums,target);
        return (pick | skip);
    }
    static int solveTabSpaceOpt(int[] nums,int sum){
        int n = nums.length;
        int[] dp = new int[sum+1];
        
        dp[0]=1;
        if (nums[0] <= sum) {
            dp[nums[0]] = 1;
        }

        
        for(int i=1;i<n;i++){
            int[] cache = new int[sum+1];
            cache[0] = 1;
            for(int j=1;j<sum+1;j++){
                int pick=0,skip=0;
                if(j>=nums[i]){
                    pick = dp[j-nums[i]];
                }
                skip = dp[j];
                cache[j] = (pick | skip);
            }
            dp = cache;
        }
        return dp[sum];
    }
    // TC : O(n*target+1)  SC : O(n*target+1)
    static int solveTab(int[] nums,int sum){
        int n = nums.length;
        int[][] dp = new int[n][sum+1];
        
        for(int i=0;i<n;i++){
            dp[i][0] = 1;
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<sum+1;j++){
                int pick=0,skip=0;
                if(j>=nums[i]){
                    pick = dp[i-1][j-nums[i]];
                }
                skip = dp[i-1][j];
                
                dp[i][j] = (pick | skip);
            }
        }
        return dp[n-1][sum];
    }
}