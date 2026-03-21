// User function Template for Java

class Solution {
    public int[] bellmanFord(int V, int[][] edges, int src) {
        // code here
        // tc : V*E
        int[] dist = new int[V];
        Arrays.fill(dist,(int)1e8);
        dist[src]=0;
        for(int i=0;i<V;i++){
            for(int[] edge : edges){
                int u = edge[0] ,v = edge[1],wt = edge[2];
                if(dist[u]!=(int)1e8 && dist[v]>dist[u]+wt){
                    dist[v] = dist[u]+wt;
                }
            }
        }
        
        //check if neg cycle:
        for(int[] edge : edges){
            int u = edge[0] , v = edge[1],wt = edge[2];
            if(dist[u]!=(int)1e8 && dist[v]>dist[u]+wt){
                //still tires to reduce  means a neg wt cycle:
                return new int[]{-1};
            }
        }
        
        return dist;
        
    }
}
