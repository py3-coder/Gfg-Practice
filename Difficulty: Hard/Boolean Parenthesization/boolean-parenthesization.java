// User function Template for Java
class Solution {
    static int[][][] dp ;
    static int countWays(String s) {
        // code here
        int n = s.length();
        dp = new int[n+1][n+1][2];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                Arrays.fill(dp[i][j], -1);  
            }
        }
        return solve(0,s.length()-1,1,s,dp);
        
    }
    static int solve(int i,int j,int isTrue,String s,int[][][] dp){
        //base cases :
        if(i>j) return 0;
        if(i==j){
            if(isTrue==1) return(s.charAt(i)=='T')?1:0;
            else return(s.charAt(i)=='F')?1:0;
            
        }
        int ways=0;
        for(int k=i+1;k<j;k+=2){
            
            int leftTrue =0,leftFalse=0,rightTrue=0,rightFalse=0;
            if(dp[i][k-1][1]!=-1){
                leftTrue = dp[i][k-1][1];
            }else{
                leftTrue = solve(i,k-1,1,s,dp);
            }
            if(dp[i][k-1][0]!=-1){
                leftFalse=dp[i][k-1][0];
            }else{
                leftFalse=solve(i,k-1,0,s,dp);
            }
            if(dp[k+1][j][1]!=-1){
                rightTrue=dp[k+1][j][1];
            }else{
                rightTrue=solve(k+1,j,1,s,dp);
            }
            if(dp[k+1][j][0]!=-1){
                rightFalse=dp[k+1][j][0];
            }else{
                rightFalse=solve(k+1,j,0,s,dp);
            }
            
            if(s.charAt(k)=='&'){
                if(isTrue==1){
                    ways+= leftTrue*rightTrue;
                }else{
                    ways+= (leftTrue*rightFalse) +(leftFalse*rightTrue) +(leftFalse*rightFalse);
                }
            }else if(s.charAt(k)=='|'){
                if(isTrue==1){
                    ways+= (leftTrue*rightFalse) +(leftFalse*rightTrue) +(leftTrue*rightTrue) ;
                }else{
                    ways+=leftFalse*rightFalse;
                }
            }else if(s.charAt(k)=='^'){
                if(isTrue==1){
                    ways+= (leftTrue*rightFalse) +(leftFalse*rightTrue);
                }else{
                    ways+= (leftFalse*rightFalse)+(leftTrue*rightTrue);
                }
            }
        }
        
        return dp[i][j][isTrue]=ways;
    }
}