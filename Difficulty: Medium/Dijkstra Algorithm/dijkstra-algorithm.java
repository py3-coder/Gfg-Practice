class Solution {
    public int[] dijkstra(int V, int[][] edges, int src) {
        int[] dist = new int[V];
        Arrays.fill(dist,100001);
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int d = edge[2];        
            adj.get(u).add(new int[]{v, d});
            adj.get(v).add(new int[]{u, d});
        }
        dist[src]=0;
        // dist , node:
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(a[0]-b[0]));
        pq.offer(new int[]{0,src});
        
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int currD = curr[0];
            for(int[] ngbr : adj.get(curr[1])){
                if(dist[ngbr[0]]>currD+ngbr[1]){
                    dist[ngbr[0]] = currD+ngbr[1];
                    pq.offer(new int[]{dist[ngbr[0]],ngbr[0]});
                }
            }
        }
        for(int i=0;i<V;i++){
            if(dist[i]==100001){
                dist[i] = -1;
            }
        }
        
        return dist;
        
    }
}