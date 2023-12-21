//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;


// } Driver Code Ends
//User function Template for Java

class Solution {
    
    public List<Integer> numOfIslands(int rows, int cols, int[][] operators) {
        //Your code here
        List<Integer> res = new ArrayList<>();
        int[][] vis = new int[rows][cols];
        DisjointSet ds = new DisjointSet(rows*cols);
        int cnt =0;
        
        for(int i=0;i<operators.length;i++){
            int row =operators[i][0];
            int col =operators[i][1];
            if(vis[row][col]==1){
                res.add(cnt);
                continue;
            }
            vis[row][col] = 1;
            cnt++;
            int[] drow ={0,1,0,-1};
            int[] dcol ={1,0,-1,0};
            
            for(int k=0;k<4;k++){
                int nrow =row+drow[k];
                int ncol =col+dcol[k];
                
                if(nrow>=0 && nrow <rows && ncol>=0 && ncol<cols && vis[nrow][ncol]==1){
                    int nodeId =row*cols+col;
                    int adjnodeId =nrow*cols+ncol;
                    
                    if(ds.findPar(nodeId)!=ds.findPar(adjnodeId)){
                        cnt--;
                        ds.unionbySize(nodeId,adjnodeId);
                    }
                }
            }
            res.add(cnt);
        }
        return res;
    }
    
}

class DisjointSet{
    List<Integer> size =new ArrayList<>();
    List<Integer> parent =new ArrayList<>();
    
    DisjointSet(int  n){
        for(int i=0;i<=n;i++){
            size.add(1);
            parent.add(i);
        }
    }
    
    public int findPar(int node){
        if(node == parent.get(node)){
            return node;
        } 
        
        int tempar = findPar(parent.get(node));
        parent.set(node,tempar);
        return parent.get(node);
    }
    
    public void unionbySize(int u ,int v){
        int ulp_u =findPar(u);
        int ulp_v =findPar(v);
        
        if(ulp_u == ulp_v) return; 
        
        if(size.get(ulp_u)>size.get(ulp_v)){
            parent.set(ulp_v,ulp_u);
            size.set(ulp_u,size.get(ulp_u)+size.get(ulp_v));
        }else{
            parent.set(ulp_u,ulp_v);
            size.set(ulp_v,size.get(ulp_u)+size.get(ulp_v));
        }
    }
}

//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int  k= sc.nextInt();
            int[][] a = new int[k][2];
            for(int i=0;i<k;i++){
            
                a[i][0] = sc.nextInt();
                a[i][1] = sc.nextInt();
            }
            
            Solution obj = new Solution();
            List<Integer> ans = obj.numOfIslands(n,m,a);
           
            for(int i:ans){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends