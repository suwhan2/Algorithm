import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] memo = new int[12];

        memo[1]=1;
        memo[2]=2;
        memo[3]=4;
        for(int i=4;i<=11;i++){
            memo[i]=memo[i-1]+memo[i-2]+memo[i-3];
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<T;i++){
            int n = Integer.parseInt(br.readLine());
            sb.append(memo[n]).append("\n");
        }
        System.out.println(sb);
    }
}