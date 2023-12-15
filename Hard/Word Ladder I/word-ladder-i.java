//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String[] wordList = new String[n];
            for(int i = 0; i < n; i++){
                wordList[i] = br.readLine().trim();
            }
            String startWord, targetWord;
            startWord = br.readLine().trim();
            targetWord = br.readLine().trim();
            Solution obj = new Solution();
            int ans = obj.wordLadderLength(startWord, targetWord, wordList);
            System.out.println(ans);
       }
    }
}

// } Driver Code Ends


class Solution
{
    public int wordLadderLength(String startWord, String targetWord, String[] wordList)
    {
        // BFS ::: APPROCH  ::
        
        HashSet<String> st = new HashSet<>();
        for(String str :wordList){
            st.add(str);
        }
        Queue<Pair> que = new LinkedList<>();
        que.offer(new Pair(startWord,1));
        st.remove(startWord);
        while(!que.isEmpty()){
            String word =que.peek().word;
            int dist =que.peek().dist;
            que.poll();
            if(word.equals(targetWord) == true) return dist;
            
            for(int i=0;i<word.length();i++){
                for(char ch='a';ch<='z';ch++){
                    char replace[] =word.toCharArray();
                    replace[i]=ch;
                    String newreplaced =new String(replace);
                    if(st.contains(newreplaced)==true){
                        st.remove(newreplaced);
                        que.offer(new Pair(newreplaced,dist+1));
                    }
                }
            }
        }
        return 0;
        
    }
    static class Pair{
        int dist;
        String word;
        Pair(String _str,int _dist){
            this.word=_str;
            this.dist=_dist;
        }
    }
}