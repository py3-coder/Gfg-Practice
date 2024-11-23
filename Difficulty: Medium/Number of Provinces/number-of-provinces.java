//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int V = Integer.parseInt(read.readLine());
            
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            for(int i=0; i<V; i++)
            {
                String S[] = read.readLine().split(" ");
                ArrayList<Integer> temp = new ArrayList<>();
                for(int j=0; j<V; j++)
                    temp.add(Integer.parseInt(S[j]));
                adj.add(temp);
            }

            Solution ob = new Solution();
            System.out.println(ob.numProvinces(adj,V));
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // code here
        ArrayList<ArrayList<Integer>> adjLs =new ArrayList<>();
        for(int i=0;i<V;i++){
            adjLs.add(new ArrayList<>());
        }
        
        for(int i=0;i<V;i++){
            for(int j=0;j<V;j++){
                if(adj.get(i).get(j) == 1 && i!=j){
                    adjLs.get(i).add(j);
                    adjLs.get(j).add(i);
                }
            }
        }
        
        int[] vis  = new int[V+1];
        int cnt=0;
        for(int i=0;i<V;i++){
            if(vis[i]!=1){
                cnt++;
                dfs(i,adjLs,vis);
            }
        }
        return cnt;
        
        
    }
    static void dfs(int node ,ArrayList<ArrayList<Integer>> adj ,int[] vis ){
        vis[node]=1;
        for(int adjNode : adj.get(node)){
            if(vis[adjNode]!=1){
                dfs(adjNode , adj, vis);
            }
        }
    }
};