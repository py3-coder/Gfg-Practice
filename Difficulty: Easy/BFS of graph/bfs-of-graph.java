class Solution {
    // Function to return Breadth First Search Traversal of given graph.
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        int n = adj.size();
        int[] vis = new int[n];
        Queue<Integer> que = new LinkedList<>();
        vis[0]=1;
        que.offer(0);
        ArrayList<Integer> res=new ArrayList<>();
        
        while(!que.isEmpty()){
            int node = que.poll();
            res.add(node);
            for(int ngbr : adj.get(node)){
                if(vis[ngbr]!=1){
                    que.offer(ngbr);
                    vis[ngbr]=1;
                }
            }
        }
        return res;
    }
}