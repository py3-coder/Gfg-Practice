//{ Driver Code Starts
import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[])throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        
        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(s[i]);

            Solution ob = new Solution();
            out.println(ob.cutRod(arr, n));
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution{
    static int[][] memo;
    public int cutRod(int price[], int n) {
        //code here
        int[] len = new int[n];
        for(int i=0;i<n;i++){
            len[i]=i+1;
        }
        int maxlen=n;
        
        memo =new int[n+1][n+1];
        Arrays.stream(memo).forEach(a->Arrays.fill(a,-1));
        return solveRec(n,maxlen,price,len);
    }
    
    public int solveRec(int n,int maxlen,int[] price ,int[] len){
        if(n==0 || maxlen==0){
            return 0;
        }
        
        if(memo[n][maxlen]!=-1){
            return memo[n][maxlen];
        }
        if(len[n-1]>maxlen){
            //can't add ::
            return memo[n-1][maxlen]=solveRec(n-1,maxlen,price,len);
        }else{
            // choices ::
            return memo[n-1][maxlen]=Math.max(price[n-1]+solveRec(n,maxlen-len[n-1],price,len),solveRec(n-1,maxlen,price,len));
            
        }
    }
}