class Solution {
    public boolean isCycle(int V, int[][] edges) {
        // Appproch : BFS -- queue[(node , parent)]
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            int u=edge[0], v=edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int[] vis=new int[V];
        for(int i=0;i<V;i++){
            if(vis[i]!=1){
                if(bfs(i,vis,adj))return true; 
            }
        }
        return false;
    }
    public static boolean bfs(int node, int[] vis , List<List<Integer>> adj ){
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{node,-1});
        vis[node]=1;
        
        while(!que.isEmpty()){
            int[] tempNode = que.peek();
            que.poll();
            for(int ngbr : adj.get(tempNode[0])){
                if(vis[ngbr]!=1){
                    vis[ngbr]=1;
                    que.offer(new int[]{ngbr , tempNode[0]});
                }else{
                    if(ngbr!=tempNode[1])
                    return true;
                }
            }
        }
        return false;
    }
}