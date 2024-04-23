//{ Driver Code Starts


import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{
	static BufferedReader br;
	static PrintWriter ot;
    public static void main(String args[]) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		ot = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine().trim());
		while(t-- > 0){
			String s[] = br.readLine().trim().split(" ");
			int V = Integer.parseInt(s[0]);
			int E = Integer.parseInt(s[1]);
			int edges[][] = new int[E][3];
			for(int i = 0; i < E; i++){
				s = br.readLine().trim().split(" ");
				edges[i][0] = Integer.parseInt(s[0]);
				edges[i][1] = Integer.parseInt(s[1]);
				edges[i][2] = Integer.parseInt(s[2]);
			}
			ot.println(new Solution().spanningTree(V, E, edges));
		}
		ot.close();
	}
}
// } Driver Code Ends


// User function Template for Java

class Solution{
	static int spanningTree(int V, int E, int edges[][]){

	    // Let's Do it with Prism Algo.
	    ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
	    for(int i=0;i<V;i++){
	        adj.add(new ArrayList<>());
	    }
	    
	    for(int[] edge : edges){
	        int u = edge[0];
	        int v =edge[1];
	        int wt =edge[2];
	        
	        adj.get(u).add(new ArrayList<>(Arrays.asList(v,wt)));
	        adj.get(v).add(new ArrayList<>(Arrays.asList(u,wt)));
	    }
	    
	    int[] vis =new int[V];
	    PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->(a.dist-b.dist));
	    pq.offer(new Pair(0,0));
	    int sum=0;
	    while(!pq.isEmpty()){
	        Pair pp = pq.poll();
	        int node =pp.node;
	        int dist =pp.dist;
	        if(vis[node]==1) continue;
	        
	        vis[node]=1;
	        sum+=dist;
	        
	        for(ArrayList<Integer> curr : adj.get(node)){
	            int currNode =curr.get(0);
	            int currWt =curr.get(1);
	            
	            if(vis[currNode]!=1){
	                pq.offer(new Pair(currNode,currWt));
	            }
	        }
	    }
	    return sum;
	}
}
class Pair{
    int node;
    int dist;
    
    
    Pair(int _n,int _d){
        this.node =_n;
        this.dist=_d;
    }
}