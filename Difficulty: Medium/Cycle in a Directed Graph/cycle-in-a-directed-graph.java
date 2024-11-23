//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++) list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends




/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // DFS ::
        int[] vis = new int[V];
        for(int i=0;i<V;i++){
            if(vis[i]!=1){
                if(dfs(i,vis,adj)==true){
                    return true;
                }
            }
        }
        return false;
    }
     public boolean dfs(int node , int[] vis ,ArrayList<ArrayList<Integer>> adj){
        vis[node]=1;
        for(int adjNode : adj.get(node)){
            if(vis[adjNode]==0){
                if(dfs(adjNode,vis,adj)){
                    return true;
                }
            }else if(vis[adjNode]==1){
                return true;
            }
        }
        vis[node]=2;
        return false;
    }    
}