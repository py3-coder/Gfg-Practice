/* The functions which
builds the segment tree */
class GfG {
    static int st[];

    public static int[] constructST(int arr[], int n) {
        // Add your code here
        st = new int[4*n];
        buildST(0,0,n-1,arr);
        
        return st;
    }
    
    private static void buildST(int i, int l,int r, int[] arr ){
        //base case:
        if(l == r){
            st[i] = arr[l];
            return;
        }
        
        int mid = l+(r-l)/2;
        buildST(2*i+1,l,mid,arr);
        buildST(2*i+2,mid+1,r,arr);
        
        st[i] = Math.min(st[2*i+1] , st[2*i+2]);
    }

    /* The functions returns the
      min element in the range
      from l and r */
    public static int RMQ(int st[], int n, int l, int r) {
        // Add your code here
        return query(0,0,n-1,l,r);
        
    }
    private static int query(int i, int l, int r, int start, int end){
        //3 case:
        if(l>end || r<start) return Integer.MAX_VALUE;
        
        if(l>=start && r<=end) return st[i];
        
        int mid = l+(r-l)/2;
        return Math.min(query(2*i+1,l,mid,start,end) , query(2*i+2,mid+1,r,start,end));
    }
}