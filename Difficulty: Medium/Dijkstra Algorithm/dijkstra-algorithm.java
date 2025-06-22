class Solution {
    public int[] dijkstra(int V, int[][] edges, int src) {
        // code here
        int[] dist= new int[V];
        Arrays.fill(dist, 100001);
        dist[src] = 0;
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            int u=edge[0],v=edge[1],d=edge[2];
            adj.get(u).add(new int[]{v,d});
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(a[0]-b[0]));
        
        pq.offer(new int[]{src , 0});
        
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            
            for(int[] ngbr : adj.get(curr[0])){
                if(dist[ngbr[0]]>ngbr[1]+curr[1]){
                    dist[ngbr[0]] = ngbr[1]+curr[1];
                    pq.offer(new int[]{ngbr[0],dist[ngbr[0]]});
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