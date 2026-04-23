// User function Template for Java

class Solution {
    public int[] st;
    List<Integer> querySum(int n, int arr[], int q, int queries[]) {
        // code here
        st = new int[4*n-1];
        build(0,0,n-1,arr);
        
        List<Integer> result = new ArrayList<>();
        
        for(int i=0;i<queries.length;i+=2){
            int a = queries[i];
            int b = queries[i+1];
            
            
            int res = query(0,0,n-1,a-1,b-1);
            
            result.add(res);
        }
        
        return result;
        
    }
    private void build(int i, int l, int r,int[] arr){
        //base case:
        if(l == r){
            st[i] = arr[l];
            return;
        }
        
        int mid = l+(r-l)/2;
        build(2*i+1,l,mid,arr);
        build(2*i+2,mid+1,r,arr);
        
        st[i] = st[2*i+1] + st[2*i+2];
    }
    
    private int query(int i, int l, int r, int start, int end){
        // 3 case:
        
        if(l>end || r<start){
            return 0;
        }else if( l>=start && r<=end){
            return st[i];
        }else{
            int mid = l+(r-l)/2;
            return query(2*i+1,l,mid,start,end) + query(2*i+2,mid+1,r,start,end);
        }
        
    }
    
    
}