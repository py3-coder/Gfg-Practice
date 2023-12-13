//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
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
        int[] pathvis = new int[V];
        
        for(int i=0;i<V;i++){
            if(vis[i]!=1){
                if(dfs(i,vis,pathvis,adj)==true){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(int node ,int[] vis,int[] pathvis ,ArrayList<ArrayList<Integer>> adj){
        vis[node] =1;
        pathvis[node]=1;
        
        for(int nodes :adj.get(node)){
            if(vis[nodes]!=1){
                if(dfs(nodes,vis,pathvis,adj)==true){
                    return true;
                }
            }else if(vis[nodes]==1 && pathvis[nodes]==1){
                return true;
            }
        }
        pathvis[node]=0;
        return false;
    }
}