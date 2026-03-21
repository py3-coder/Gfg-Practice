class Solution {
    public int spanningTree(int V, int[][] edges) {
        // code here
        // Prims algo :
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] edge : edges){
            int u = edge[0] , v = edge[1] , d = edge[2];
            adj.get(u).add(new int[]{v,d});
            adj.get(v).add(new int[]{u,d});
        }
        int[] vis = new int[V];
        // wt , node , parent:
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(a[0]-b[0]));
        // o wt  , oth node , -1 parent comming from beginning:
        pq.offer(new int[]{0,0,-1});
        List<int[]> mstEdges = new ArrayList<>();
        int sum=0;
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            if(vis[curr[1]]==1) continue;
            vis[curr[1]]=1;
            if(curr[2]!=-1){
                sum+=curr[0];
                mstEdges.add(new int[]{curr[1],curr[2]});
            }
            for(int[] ngbr : adj.get(curr[1])){
                int v = ngbr[0];
                int d = ngbr[1];
                pq.offer(new int[]{d,v,curr[1]});
            }
        }
        
        return sum;
    }
}
