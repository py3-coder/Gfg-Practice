//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Gfg
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            // arraylist of arraylist to represent graph
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            int V = Integer.parseInt(sc.next());
            int E = Integer.parseInt(sc.next());
            
            for(int i =0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= E; i++)
            {    int u = Integer.parseInt(sc.next());
                 int v = Integer.parseInt(sc.next());
                 
                 // adding directed edgese between 
                 // vertex 'u' and 'v'
                 adj.get(u).add(v);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.kosaraju(V, adj));
		}
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        //code here
        Stack<Integer> st = new Stack<>();
        int[] vis =new int[V];
        
        for(int i=0;i<V;i++){
            if(vis[i]!=1){
                dfs(i,vis,adj,st);
            }
        }
        
        ArrayList<ArrayList<Integer>> adjT = new ArrayList<>();
        for(int i=0;i<V;i++){
            vis[i]=0;
            adjT.add(new ArrayList<>());
        }
        for(int i=0;i<V;i++){
            for(int ele : adj.get(i)){
                adjT.get(ele).add(i);
            }
            //adjT.get(adj.get(i).get(1)).add(adj.get(i).get(0));
        }
        int scc=0;
        while(!st.isEmpty()){
            int node =st.peek();
            st.pop();
            if(vis[node]!=1){
                scc++;
                dfsSp(node,vis,adjT);
            }
        }
        return scc;
    }
    public static void dfsSp(int node,int[] vis,ArrayList<ArrayList<Integer>> adjT){
        vis[node]=1;
        for(int currNode : adjT.get(node)){
            if(vis[currNode]!=1){
                dfsSp(currNode,vis,adjT);
            }
        }
    }
    public static void dfs(int node,int[] vis,ArrayList<ArrayList<Integer>> adj,Stack<Integer> st){
        vis[node]=1;
        
        for(int currNode : adj.get(node)){
            if(vis[currNode]!=1){
                dfs(currNode,vis,adj,st);
            }
        }
        st.push(node);
    }
}
