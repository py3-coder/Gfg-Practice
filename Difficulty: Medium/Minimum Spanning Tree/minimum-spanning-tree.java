class Solution {
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        // Code Here.
        DisjointSet ds = new DisjointSet(V);
        List<int[]> edges = new ArrayList<>();
        
        for (int u = 0; u < V; u++) {
            for (int[] nei : adj.get(u)) {
                int v = nei[0], wt = nei[1];
                if (u < v)
                    edges.add(new int[]{u, v, wt});
            }
        }

        edges.sort((a, b) -> (a[2] - b[2]));

        int ans = 0;
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], wt = edge[2];
            if (ds.findPar(u) != ds.findPar(v)) {
                ans += wt;
                ds.unionBySize(u, v);
            }
        }
        return ans;
    }
}
class DisjointSet{
    List<Integer> parent;
    List<Integer> size;
    
    public DisjointSet(int n){
         parent = new ArrayList<>(n);
         size = new ArrayList<>(n);
         
         for(int i=0;i<n;i++){
            parent.add(i);
            size.add(1);
         }
    }
    
    public int findPar(int node){
        if(parent.get(node) == node) return node;
         
        int par = findPar(parent.get(node));
        parent.set(node,par);
        return parent.get(node);
    }
        
    public void unionBySize(int u,int v){
        int ulpu = findPar(u);
        int ulpv = findPar(v);
        
        if(ulpu == ulpv) return ;
        
        if(size.get(ulpu)>size.get(ulpv)){
            parent.set(ulpv,ulpu);
            size.set(ulpu , size.get(ulpu)+size.get(ulpv));
        }else{
            parent.set(ulpu,ulpv);
            size.set(ulpv , size.get(ulpu)+size.get(ulpv));
        }
    }
        
    
}