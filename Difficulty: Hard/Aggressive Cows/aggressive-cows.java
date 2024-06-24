//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int n;
            n = sc.nextInt();

            int k;
            k = sc.nextInt();

            int[] v = new int[n];
            for (int i = 0; i < n; i++) v[i] = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.solve(n, k, v);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    public static int solve(int n, int k, int[] stalls) {
        Arrays.sort(stalls);
        int mini = Integer.MAX_VALUE;
        int maxi = 0;
        
        for(int stall : stalls){
            mini  = Math.min(mini , stall);
            maxi = Math.max(maxi , stall);
        }
        
        //edge :
        if( k == 2) {
            return maxi-mini;
        }
        int ans =-1;
        int  l =  0  , h = maxi-mini;
        while(l<=h){
            int m  = l+(h-l)/2;
            if(isPossible(m , k ,stalls)){
                ans = m ;
                l = m+1;
            }else{
                h = m-1;
            }
        }
        return ans;
    }
    
    public static boolean isPossible(int dist , int k , int[] stalls){
        int cnt =1;
        int prev = stalls[0];
        for(int i= 1 ;i<stalls.length ;i++){
           if((stalls[i]-prev)>=dist){
               cnt ++ ;
               if(cnt == k){
                   return true;
               }
               prev = stalls[i];
           }
        }
        return false ;
    }
}