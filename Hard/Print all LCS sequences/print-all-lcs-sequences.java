//{ Driver Code Starts
import java.io.*;
import java.util.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String ss = br.readLine();
            String[] S = ss.split(" ");
            String s = S[0];
            String t = S[1];
            Solution ob = new Solution();
            List<String> ans = new ArrayList<String>();
            ans = ob.all_longest_common_subsequences(s, t);
            for(int i = 0; i < ans.size(); i++)
            {
                System.out.print(ans.get(i) + " ");
            }
            System.out.println();
        }
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public List<String> all_longest_common_subsequences(String s, String t)
    {
        // Code here
        
        
        // Rec Fails  - 2^40 ~ 10^12 > 10^8 true ::
        int n = s.length();
        int m =t.length();
        //Set<String> res  = new <>();
        // solveRec(s,t,n,m,"",res);
        // int maxi=0;
        // for(String st : res){
        //     maxi = Math.max(st.length(),maxi);
            
        // }
        // List<String> ss = new ArrayList<>();
        // for(String st : res){
        //   ss.add(st);
        // }
        //Collections.sort(ss);
       // System.out.println(ss);
      
      
        return solveTab(s,t,n,m);
         
    }
    // TC - 30/40 Passed
    public void solveRec(String s1,String s2,int a,int b,String op,Set<String> st){
        if(a==0 || b==0){
            StringBuilder sb = new StringBuilder(op);
            sb.reverse();
            st.add(sb.toString());
            return ;
        }
        
        if(s1.charAt(a-1) == s2.charAt(b-1)){
            op+=s1.charAt(a-1);
            solveRec(s1,s2,a-1,b-1,op,st);
        }else{
            solveRec(s1,s2,a,b-1,op,st);
            solveRec(s1,s2,a-1,b,op,st);
        }
    }
    
    public List<String> solveTab(String s1,String s2,int n,int m){
        int[][] tab  = new int[n+1][m+1];
        
        //base case - initlisation 
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    tab[i][j] = 1+tab[i-1][j-1];
                }else{
                    tab[i][j] = Math.max(tab[i-1][j],tab[i][j-1]);
                }
            }
        }
        
        Set<String> set=new TreeSet<>();
        StringBuilder str=new StringBuilder();
        int lcs=tab[n][m];
        List<String> res=new ArrayList<>();
        printSeq(s1,s2,0,0,str,set,lcs);
        res.addAll(set);
        return res;
    }
    public void printSeq(String s,String t,int i1,int i2, StringBuilder str,Set<String> set,int lcs){
        if(lcs==0){
            set.add(str.toString());
            return ;
        }
        if(i1>=s.length()||i2>=t.length()){
            return ;
        }
        for(int i=i1;i<s.length();i++){
            for(int j=i2;j<t.length();j++){
                if(s.charAt(i)==t.charAt(j)){
                    str.append(s.charAt(i));
                    printSeq(s,t,i+1,j+1,str,set,lcs-1);
                    str.deleteCharAt(str.length()-1);
                }
            }
        }
    }
}