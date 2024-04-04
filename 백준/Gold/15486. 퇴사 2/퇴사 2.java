import java.util.*;
import java.io.*;

class Main {
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());
        
        int[] time = new int[n];
        int[] money = new int[n];
        StringTokenizer st;
        
        for (int i =0; i <n; i++) {
            st=new StringTokenizer(br.readLine());
            time[i]=Integer.parseInt(st.nextToken());
            money[i]=Integer.parseInt(st.nextToken());
        }
        
        int[] dp = new int[n+1];
        for (int i=0; i<n; i++) {
            if (i+time[i]<=n){ 
                dp[i+time[i]] = Math.max(dp[i+time[i]], dp[i]+money[i]);
            }
            dp[i+1]=Math.max(dp[i], dp[i+1]);
        }
        
        System.out.println(dp[n]);
    }

}