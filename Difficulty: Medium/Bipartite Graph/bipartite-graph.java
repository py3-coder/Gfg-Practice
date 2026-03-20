class Solution {
    public boolean isBipartite(int V, int[][] edges) {
        // Code here
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge: edges){
            int u =edge[0] , v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        int[] color = new int[V];
        int[] vis = new int[V];
        Arrays.fill(color,-1);
        color[0]=1;
        
        for(int i=0;i<V;i++){
            if(vis[i]!=1){
                if(!dfs(0,1,adj,vis,color)){
                    return false;
                }
            }
        }
        return true;
        
    }
    public boolean dfs(int node, int col , List<List<Integer>> adj , int[] vis,int[] color){
        vis[node]=1;
        for(int ngbr : adj.get(node)){
            if(vis[ngbr]!=1 && color[ngbr]==-1){
                color[ngbr] = (col==0)?1:0;
                if(!dfs(ngbr,color[ngbr],adj,vis,color)){
                    return false;
                }
            }else if(color[ngbr] == col){
                return false;
            }
        }
        return true;
    }
}