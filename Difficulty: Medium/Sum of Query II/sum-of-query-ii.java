//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    static class FastReader{ 
		BufferedReader br; 
		StringTokenizer st; 
  
		public FastReader(){ 
			br = new BufferedReader(new InputStreamReader(System.in)); 
		} 
  
		String next(){ 
			while (st == null || !st.hasMoreElements()){ 
				try{ st = new StringTokenizer(br.readLine()); } catch (IOException  e){ e.printStackTrace(); } 
			} 
			return st.nextToken(); 
		} 
  
		String nextLine(){ 
			String str = ""; 
			try{ str = br.readLine(); } catch (IOException e) { e.printStackTrace(); } 
			return str; 
		} 
		
		int nextInt(){
		    return Integer.parseInt(next());
		}
	}
	
    public static void main(String args[])throws IOException
    {
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int arr[] = new int[n];
            for(int i = 0;i < n;i++)
                arr[i] = sc.nextInt();
            int q = sc.nextInt();
            int queries[] = new int[2*q];
            for(int i = 0;i < 2*q;i++)
                queries[i] = sc.nextInt();
            
            Solution ob = new Solution();
            List<Integer> ans = new ArrayList<Integer>();
            ans = ob.querySum(n, arr, q, queries);
            StringBuilder out = new StringBuilder();
            for(int i = 0;i < ans.size();i++)
                out.append(ans.get(i) + " ");
            System.out.println(out);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public static int[] segmentTree;
    List<Integer> querySum(int n, int arr[], int q, int queries[])
    {
        List<Integer> result = new ArrayList<>();
        segmentTree = new int[4*n+1];
        buildTree(0,0,n-1,arr);
        for(int i=0;i<2*q;i+=2){
            int val = query(0,0,n-1,queries[i]-1,queries[i+1]-1);
            result.add(val);
        }
        return result;
    }
    public static void buildTree(int i,int l,int r,int[] nums){
        //base case :
        if(l == r){
            segmentTree[i] = nums[l];
            return ;
        }
        int mid = l+(r-l)/2;
        buildTree(2*i+1,l,mid,nums);
        buildTree(2*i+2,mid+1,r,nums);
        
        segmentTree[i] = segmentTree[2*i+1]+segmentTree[2*i+2];
    }
    
    public static int query(int i,int l,int r,int start,int end){
        //Case 1: out of scope :
        if(l>end || r<start){
            return 0;
        } // case 2: entire in range:
        if(l>=start && end>=r){
            return segmentTree[i];
        }
        //case 3: overlapping :
        int mid = l+(r-l)/2;
        return query(2*i+1,l,mid,start,end) + query(2*i+2,mid+1,r,start,end);
    }
}