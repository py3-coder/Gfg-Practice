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
class DistjointSet{
    List<Integer> size = new ArrayList<>();
    List<Integer> parent =new ArrayList<>();
    
    public DistjointSet(int n){
        for(int i=0;i<=n;i++){
            size.add(1);
            parent.add(i);
        }
    }
    
    public int findPar(int node){
        if(parent.get(node)==node){
            return node;
        }
        int par =findPar(parent.get(node));
        parent.set(node,par);
        return parent.get(node);
    }
    
    public void unionBySize(int u,int v){
        int utp_u =findPar(u);
        int utp_v =findPar(v);
        
        if(utp_u == utp_v) return;
        
        if(size.get(utp_u)>size.get(utp_v)){
            parent.set(utp_v,utp_u);
            size.set(utp_u,size.get(utp_u)+size.get(utp_v));
        }else{
            parent.set(utp_u,utp_v);
            size.set(utp_v,size.get(utp_u)+size.get(utp_v));
        }
    }
}
class Solution{
	static int spanningTree(int V, int E, int edges[][]){
	    // Code Here.
	    
	    List<Triple> edge = new ArrayList<>();
	    
	    for(int i=0;i<edges.length;i++){
	        edge.add(new Triple(edges[i][2],edges[i][0],edges[i][1]));
	    }
	    //Collections.sort(edge);
	    Collections.sort(edge, (a, b) -> (a.wt-b.wt));
	    
	    int minWt=0;
	    DistjointSet ds = new DistjointSet(V);
	    for(Triple curr : edge){
	        int wt =curr.wt;
	        int u =curr.u;
	        int v =curr.v;
	        
	        if(ds.findPar(u)!=ds.findPar(v)){
	            minWt+=wt;
	            ds.unionBySize(u,v);
	        }
	        
	    }
	    return minWt;
	    
	}
	static class Triple{
	    int wt;
	    int u;
	    int v;
	    
	    Triple(int _wt,int _u,int _v){
	        this.wt =_wt;
	        this.u =_u;
	        this.v=_v;
	    }
	}
}