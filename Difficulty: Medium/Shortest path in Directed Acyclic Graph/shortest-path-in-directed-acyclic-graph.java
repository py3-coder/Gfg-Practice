// User function Template for Java
class Solution {

    public int[] shortestPath(int V, int E, int[][] edges) {
        // Code here
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] edge : edges){
            int u=edge[0],v=edge[1],d=edge[2];
            adj.get(u).add(new int[]{v,d});
        }
        int[] vis = new int[V];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<V;i++){
            if(vis[i]!=1){
                dfs(i,vis,adj,st);
            }
        }
        
        int[] dist=new int[V];
        Arrays.fill(dist,100001);
        dist[0]=0;
        
        while(!st.isEmpty()){
             int node=st.pop();
             for(int[] ngbr : adj.get(node)){
                 if(dist[node]+ngbr[1]<dist[ngbr[0]]){
                     dist[ngbr[0]] = dist[node]+ngbr[1];
                 }
             }
        }
        for(int i = 0; i < V; i++) {
            if(dist[i] == 100001) {
                dist[i] = -1;
            }
        }
        return dist;
    }
    public void dfs(int i, int[] vis,List<List<int[]>> adj,Stack<Integer> st){
        vis[i]=1;
        for(int[] ngbr : adj.get(i)){
            if(vis[ngbr[0]]!=1){
                dfs(ngbr[0],vis,adj,st);
            }
        }
        st.push(i);
    }
}