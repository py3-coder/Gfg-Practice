// User function Template for Java

class Solution {

    public int minDifference(int arr[]) {
        // Your code goes here
        int sum  = Arrays.stream(arr).sum();
        int s1 = (sum + 1) / 2;
        int s2 = solveTab(arr, s1);
        return Math.abs(sum - 2 * s2);
    }
    public int solveTab(int[] nums , int s1){
        int n = nums.length;
        int[] dp = new  int[s1+1];
        dp[0]=1;
        if(nums[0]<=s1){
            dp[nums[0]]=1;
        }

        for(int i=1;i<n;i++){
            int[] cache = new int[s1+1];
            cache[0]=1;
            for(int j=1;j<s1+1;j++){
                if(j>=nums[i]){
                    cache[j] = (dp[j-nums[i]] | dp[j]) ;
                }else{
                    cache[j] = dp[j];
                }
            }
            dp = cache;
        }
        int maxi=0;
        for(int i=0;i<s1+1;i++){
            if(dp[i]==1){
                maxi= Math.max(i,maxi);
            }
        }
        return maxi;
    }
}
