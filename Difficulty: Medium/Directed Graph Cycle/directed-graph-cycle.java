class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        List<List<Integer>> adj  = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
        }
        
        int[] vis = new int[V];
        int[] pathVis = new int[V];
        
        for(int i=0;i<V;i++){
            if(vis[i]!=1){
                if(dfs(i,adj,pathVis,vis)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(int node, List<List<Integer>> adj ,int[] pathVis , int[] vis){
        vis[node]=1;
        pathVis[node]=1;
        
        
        for(int ngbr : adj.get(node)){
            if(vis[ngbr]!=1){
                if(dfs(ngbr,adj,pathVis,vis)) return true;
            }else if(vis[ngbr]==1 && pathVis[ngbr]==1){
                return true;
            }
        }
        pathVis[node]=0;
        return false;
    }
}