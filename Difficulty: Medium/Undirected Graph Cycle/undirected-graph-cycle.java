class Solution {
    public boolean isCycle(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] edge : edges){
            int u = edge[0] , v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
    
        int[] vis = new int[V];
        for(int i=0;i<V;i++){
            if(vis[i]!=1){
                if(dfs(i,adj,-1,vis)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean dfs(int node , List<List<Integer>> adj ,int parent,int[] vis){
        vis[node]=1;
        for(int ngbr : adj.get(node)){
            if(vis[ngbr]!=1){
                if(dfs(ngbr , adj, node, vis)) return true;;
            }else if(vis[ngbr]==1 && parent!=ngbr){
                return true;
            }
        }
        return false;
    }
    
    
    
    
    
    
    
    
    
    
    
    
}