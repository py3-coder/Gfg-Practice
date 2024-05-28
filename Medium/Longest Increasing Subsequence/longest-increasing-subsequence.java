//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {

        // taking input using Scanner class
        Scanner sc = new Scanner(System.in);

        // taking total testcases
        int t = sc.nextInt();
        while (t > 0) {

            // taking size of array
            int n = sc.nextInt();
            int array[] = new int[n];

            // inserting elements in the array
            for (int i = 0; i < n; ++i) {
                array[i] = sc.nextInt();
            }

            // creating an object of class Solution
            Solution ob = new Solution();

            // calling longestSubsequence() method of class
            // Solution
            System.out.println(ob.longestSubsequence(n, array));
            t--;
        }
    }
}
// } Driver Code Ends




class Solution {
    // Function to find length of longest increasing subsequence.
    static int longestSubsequence(int n, int a[]) {
        return solveBS(n,a);
        // code here
    }
    // TC : nlogn
    // SC : n
    public static int solveBS(int n,int[] arr){
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(arr[0]);
        
        for(int i=1;i<n;i++){
            if(arr[i]>temp.get(temp.size()-1)){
                temp.add(arr[i]);
            }else{
                int pos = bs(temp,arr[i]);
                temp.set(pos,arr[i]);
            }
        }
        return temp.size();
    }
    public static int bs(ArrayList<Integer> temp , int target){
        int l =0,h = temp.size()-1;
        
        while(l<=h){
            int m = l+(h-l)/2;
            
            if(target == temp.get(m)){
                return m ;
            }else if(temp.get(m)>target){
                h = m-1;
            }else{
                l = m+1;
            }
        }
        return l;
    }
}