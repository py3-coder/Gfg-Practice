//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            Solution obj = new Solution();
            ArrayList<Integer> ans = obj.longestIncreasingSubsequence(N, arr);
            for (int i = 0; i < ans.size(); i++) {
                System.out.print(ans.get(i) + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public ArrayList<Integer> longestIncreasingSubsequence(int n, int nums[]) {
        // Code here
        int[] dp = new int[n];
        int[] map = new int[n];
        ArrayList<Integer> lcs = new ArrayList<>();
        Arrays.fill(dp,1);
        
        int lastindex =0,maxi=0;
        for(int i=1;i<n;i++){
            map[i]=i;
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i] && 1+dp[j]>dp[i]){
                    dp[i] = 1+dp[j];
                    map[i] = j;
                }
            }
            if(maxi<dp[i]){
                maxi = dp[i];
                lastindex=i;
            }
        }
        lcs.add(nums[lastindex]);
        while(map[lastindex]!=lastindex){
            lcs.add(nums[map[lastindex]]);
            lastindex = map[lastindex];
        }
        Collections.reverse(lcs);
        return lcs;
        
    }
}
