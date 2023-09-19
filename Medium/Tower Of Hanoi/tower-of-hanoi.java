//{ Driver Code Starts
// Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class Recursion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();//total testcases
        while (T-- > 0) {
            Hanoi obj = new Hanoi();
            int N;
            
            //taking input N
            N = sc.nextInt();

            //calling toh() method 
            System.out.println(obj.toh(N, 1, 3, 2));
        }
    }
}






// } Driver Code Ends


// User function Template for Java


// avoid space at the starting of the string in "move disk....."
class Hanoi {
    public static long count;
    public long toh(int N, int from, int to, int aux) {
        // Your code here
        //Lets Apply B H I method ::
       count=0;
       recursion(N,from,to,aux);
       return count;
    }
    public static void recursion(int n,int s,int d , int h ){
        count++;
        //Base Case ::
        if(n==1){
            System.out.println("move disk "+n+" from rod "+s+" to rod "+d);
            return;
        }
        recursion(n-1,s,h,d);
        System.out.println("move disk "+n+" from rod "+s+" to rod "+d);
        recursion(n-1,h,d,s);
    }
}
