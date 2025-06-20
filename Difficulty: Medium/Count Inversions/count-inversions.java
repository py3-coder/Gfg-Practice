// User function Template for Java

class Solution {
    // Function to count inversions in the array.
    static int inversionCount(int arr[]) {
        // First apporch to check all pair -> n^2:
        return mergeSort(arr , 0 , arr.length-1);
        
    }
    static int mergeSort(int[] temp , int low , int high){
        int cnt=0;
        if (low >= high) return cnt;
        int mid = low+(high-low)/2;
        cnt+=mergeSort(temp,low,mid);
        cnt+=mergeSort(temp,mid+1,high);
        cnt+=merge(temp,low,mid,high);
        
        return cnt;
    }
    static int merge(int[] temp ,int low,int mid , int high){
        ArrayList<Integer> curr = new ArrayList<>();
        int cnt=0;
        int right = mid+1 , left=low;
        while(left<=mid && right<=high){
            if(temp[left]>temp[right]){
                cnt += mid-left+1;
                curr.add(temp[right]);
                right++;
            }else{
                curr.add(temp[left]);
                left++;
            }
        }
        
        while (left <= mid) curr.add(temp[left++]);
        while (right <= high) curr.add(temp[right++]);
        
        //make array sorted:
        for(int i=low;i<=high;i++){
            temp[i] = curr.get(i-low);
        }
        return cnt;
    }
    
}