//{ Driver Code Starts
// Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            ArrayList<Integer>ans = obj.articulationPoints(V, adj);
            for (int i =0 ;i < ans.size (); i++) 
                System.out.print (ans.get (i) + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution
{
    static int timer=1;
    //Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> articulationPoints(int V,ArrayList<ArrayList<Integer>> adj)
    {
        // Code here
        int[] tin = new int[V];
        int[] vis = new int[V];
        int[] low = new int[V];
        int[] mark =new int[V];
        
        for(int i=0;i<V;i++){
            if(vis[i]!=1){
                dfs(i,-1,adj,tin,vis,low,mark);
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=0;i<V;i++){
            if(mark[i]==1){
                res.add(i);
            }
        }
        if(res.size()==0){
            res.add(-1);
        } 
        return res;
    }
    
    public void dfs(int node,int par,ArrayList<ArrayList<Integer>> adj,int[] tin,int[] vis,int[] low,int[] mark){
        vis[node]=1;
        
        tin[node] = low[node] = timer;
        timer++;
        int child=0;
        for(int ele : adj.get(node)){
            if(ele==par) continue;
            
            if(vis[ele]!=1){
                dfs(ele,node,adj,tin,vis,low,mark);
                
                low[node] = Math.min(low[node],low[ele]);
                child++;
                
                if(low[ele] >= tin[node] && par!=-1){
                    mark[node]=1;
                }
                
            }else{
                low[node] = Math.min(low[node],tin[ele]);
            }
            
        }
        if(child>1 && par==-1){
            mark[node]=1;
        }
    }
}