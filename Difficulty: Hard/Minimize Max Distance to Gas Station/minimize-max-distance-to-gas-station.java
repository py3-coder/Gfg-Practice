class Solution {
    public double minMaxDist(int[] stations, int K) {
        // lets think....
        int n = stations.length;
        int maxDis = 0;
        for(int i=1;i<n;i++){
            maxDis = Math.max(maxDis,stations[i]-stations[i-1]);
        }
        double low = 0.0  , high = maxDis*1.0;
        
        while(high - low > 1e-6){
            double mid = low+(high-low)/2;
            if(canPlaceStations(stations,mid,K)){
                high = mid;
            }else{
                low = mid;
            }
        }
        
        return high;
        
    }
    
    private boolean canPlaceStations(int[] stations,double dist, int k){
        int n = stations.length;
        int needed  = 0;
        for(int i=1;i<n;i++){
            int gap = stations[i]-stations[i-1];
            //needed += (int)Math.ceil((double)distanceGap/(double)dist);//not work
            //needed  += (int)Math.ceil(distanceGap / dist) - 1 ; work
            needed  += (int)(gap / dist); // work
            if(needed  > k) return false;
        }
        
        return needed <=k; 
    }
}
