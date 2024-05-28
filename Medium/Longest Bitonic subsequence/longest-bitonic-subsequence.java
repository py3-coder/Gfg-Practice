//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            int[] nums = IntArray.input(br, n);

            Solution obj = new Solution();
            int res = obj.LongestBitonicSequence(n, nums);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    public static int LongestBitonicSequence(int n, int[] nums) {
        // code here
        return solveLIS(n,nums);
    }
    public static int solveLIS(int n,int[] nums){
        int[] inc = new int[n];
        int[] dec = new int[n];
        Arrays.fill(inc,1);
        Arrays.fill(dec,1);
        
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j] && 1+inc[j]>inc[i]){
                    inc[i] = 1+inc[j];
                }
            }
        }
        
        for(int i=n-1;i>=0;i--){
            for(int j=n-1;j>i;j--){
                if(nums[i]>nums[j] && 1+dec[j]>dec[i]){
                    dec[i] = 1+dec[j];
                }
            }
        }
        
        int ans =0;
        for(int i=0;i<n;i++){
            if(inc[i]>1 && dec[i]>1){
                ans =Math.max(ans,inc[i]+dec[i]-1);
            }
            
        }
        return ans;
    }
}
