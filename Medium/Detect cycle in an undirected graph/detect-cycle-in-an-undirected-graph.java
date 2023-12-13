//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
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
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int[] vis=new int[V];
        for(int i=0;i<V;i++){
            if(vis[i]!=1){
                // if(bfs(i,vis,adj)){
                //     return true;
                // }
                if(dfs(i,-1,vis,adj)==true){
                    return true;
                }
            }
        }
        return false;
        
    }
    public static boolean dfs(int node,int parent,int[] vis,ArrayList<ArrayList<Integer>> adj){
        vis[node] =1;
        for(int nodes : adj.get(node)){
            if(vis[nodes]!=1){
                if(dfs(nodes,node,vis,adj)==true){
                    return true;
                }
            }else if(vis[nodes]==1 && parent!=nodes){
                return true;
            }
        }
        return false;
    }
    public static boolean bfs(int node,int[] vis,ArrayList<ArrayList<Integer>> adj){
        vis[node]=1;
        Queue<Pair> que = new LinkedList<>();
        que.offer(new Pair(node,-1));
        
        while(!que.isEmpty()){
            Pair pp =que.poll();
            int curr =pp.val1;
            int parent =pp.val2;
            
            for(int adjNode : adj.get(curr)){
                if(vis[adjNode]!=1){
                    vis[adjNode]=1;
                    que.offer(new Pair(adjNode,curr));
                }else if(vis[adjNode]==1 && adjNode!=parent){
                    return true;
                }
            }
        }
        return false;
    }
    static class Pair{
        int val1;
        int val2;
        Pair(int _v1 ,int _v2){
            this.val1 =_v1;
            this.val2 =_v2;
        }
    }
}