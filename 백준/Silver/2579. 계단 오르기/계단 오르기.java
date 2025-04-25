import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n  = Integer.parseInt(br.readLine());
        int[] stair = new int[n+1];
        int[][] memo = new int[2][n+1];
        for(int i=0;i<n;i++){
            stair[i+1]=Integer.parseInt(br.readLine());
        }

        if(n==1) System.out.println(stair[1]);
        else{
            memo[0][1] = 0;
            memo[1][1]=stair[1];

            memo[0][2] = stair[1];
            memo[1][2] = stair[1]+stair[2];


            for(int i=3;i<=n;i++){
                memo[0][i] =memo[1][i-1];
                memo[1][i] = Math.max(memo[1][i-2],memo[0][i-2]+stair[i-1])+stair[i];
            }

            System.out.println(memo[1][n]);
        }
    }

}