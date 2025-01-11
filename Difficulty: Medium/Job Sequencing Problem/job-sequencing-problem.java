//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Job {
    int id, profit, deadline;

    Job(int x, int y, int z) {
        this.id = x;
        this.deadline = y;
        this.profit = z;
    }
}

class GfG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String[] jobIDStrings = sc.nextLine().split(" ");
            String[] deadlineStrings = sc.nextLine().split(" ");
            String[] profitStrings = sc.nextLine().split(" ");

            // Convert the input strings to integer arrays
            int[] jobIDs = new int[jobIDStrings.length];
            int[] deadlines = new int[deadlineStrings.length];
            int[] profits = new int[profitStrings.length];

            for (int i = 0; i < jobIDStrings.length; i++) {
                jobIDs[i] = Integer.parseInt(jobIDStrings[i]);
                deadlines[i] = Integer.parseInt(deadlineStrings[i]);
                profits[i] = Integer.parseInt(profitStrings[i]);
            }
            Solution obj = new Solution();
            ArrayList<Integer> ans = obj.JobSequencing(jobIDs, deadlines, profits);
            System.out.println(ans.get(0) + " " + ans.get(1));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends




class Solution {

    public ArrayList<Integer> JobSequencing(int[] id, int[] deadline, int[] profit) {
        // code here..
      int[][] job = new int[id.length][3];
      for(int i = 0; i<id.length; i++){
         job[i][0] = id[i];
         job[i][1] = deadline[i];
         job[i][2] = profit[i];
      }
      Arrays.sort(job, (a, b) -> b[2] - a[2]);
      int max = 0;
      for(int i = 0; i<id.length; i++){
          max = Math.max(max, job[i][1]);
      }
      int[] allocate = new int[max+1];
      int tprofit = 0;
      int count = 0;
      Arrays.fill(allocate, -1);
      for(int i = 0; i<id.length; i++){
          for(int j = job[i][1]-1; j>=0; j--){
              if(allocate[j] == -1){
                  allocate[j] = 1;
                  tprofit+= job[i][2];
                  count++;
                  break;
              }
          }
      }
      return new ArrayList<>(Arrays.asList(count, tprofit));
    }
}
