//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        
        int[] vis = new int[adj.size()];
        
        for(int i=0;i<adj.size();i++){
            if(vis[i]!=1){
                if(dfs(i,-1,adj,vis)==true){
                    return true;
                }
            }
        }
        return false;
    }
    
    public static boolean dfs(int node,int par,ArrayList<ArrayList<Integer>> adj,int[] vis){
        vis[node]=1;
        
        for(int adjNode : adj.get(node)){
            if(vis[adjNode]!=1){
                if(dfs(adjNode , node, adj,vis)==true){
                    return true;
                }
            }
            else if(vis[adjNode]==1 && par != adjNode){
                    return true;
            }
        }
        return false;
    }
}