// User function Template for Java

class Sol {
    // arr : given array
    // n : size of arr
    // index : need to update
    // new_val : given value to which we need to update index
    // st : constructed segment-tree

    // Function to update a value in input array and segment tree.
    static void updateValue(int arr[], long st[], int n, int index, int val) {
        // Your code here
        arr[index] = val;
        updateSegmentTree(0,st,0,n-1,index,val);
        
        
    }
    
    private static void updateSegmentTree(int i , long st[] , int l, int r , int indx, int val){
        //
        //base case:
        if(l == r){
            st[i] = val;
            return ;
        }
        
        int mid = l+(r-l)/2;
        if(indx>mid){
            //right side:
            updateSegmentTree(2*i+2,st,mid+1,r,indx,val);
        }else{
            //left side:
            updateSegmentTree(2*i+1,st,l,mid,indx,val);
        }
        st[i] = st[2*i+1] + st[2*i+2];
    }

    // Function to return sum of elements in range from index qs (query start)
    // to qe (query end).
    public static long getSum(long st[], int n, int l, int r) {
        return query(0,0,n-1,l,r,st);
        
    }
    
    private static long query(int i ,int l, int r, int start, int end , long[] st){
        
        // 3 case:
        //1. out bound:
        //2. complete end
        // 3. overlapping bound:
        
        
        if(l>end || r<start){
            return 0;
        }else if(l>=start && r<=end){
            return st[i];
        }else{
            int mid = l+(r-l)/2;
            return query(2*i+1,l,mid,start,end,st) + query(2*i+2,mid+1,r,start,end,st);
        }
    }
}