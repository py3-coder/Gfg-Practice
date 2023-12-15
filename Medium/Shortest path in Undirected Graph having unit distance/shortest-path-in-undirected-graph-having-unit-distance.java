//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m=sc.nextInt();
            int[][] edge = new int[m][2];
            for(int i=0;i<m;i++){
                edge[i][0]=sc.nextInt();
                edge[i][1]=sc.nextInt();
            }
            int src=sc.nextInt();
            Solution obj = new Solution();
            int res[] = obj.shortestPath(edge,n,m,src);
            for(int i=0;i<n;i++){
                System.out.print(res[i]+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        // BFS Approch ::
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0;i<m;i++){
            int[] temp =edges[i];
            adj.get(temp[0]).add(new Pair(temp[1],1));
            adj.get(temp[1]).add(new Pair(temp[0],1));
        }
        int[] dist =new int[n];
        Arrays.fill(dist,(int)1e9);
        Queue<Pair> que =new LinkedList<>();
        que.offer(new Pair(src,0));
        dist[src]=0;
        while(!que.isEmpty()){
            int currNode = que.peek().node;
            int wt = que.peek().wt;
            que.poll();
            
            for(Pair curr : adj.get(currNode)){
                int nodeVal =curr.node;
                int currWt =curr.wt;
                
                if(dist[currNode]+currWt<dist[nodeVal]){
                    dist[nodeVal] =dist[currNode]+currWt;
                    que.offer(new Pair(nodeVal,dist[currNode]+currWt));
                }
                
            }
        }
        for(int i=0;i<n;i++){
            if(dist[i]==(int)1e9){
                dist[i]=-1;
            }
        }
        return dist;
    }
    static class Pair{
        int node;
        int wt;
        Pair(int _node,int _wt){
            this.node =_node;
            this.wt=_wt;
        }
    }
}