import java.util.*;
import java.io.*;

import static java.lang.Math.min;

public class Main{
    static int N;
    static int[][] price;
    static int[][] memo;
    static int answer=Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        price = new int[N][3];


        for(int i = 0; i < N; i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<3;j++){
                price[i][j] =Integer.parseInt(st.nextToken());
            }
        }


        for(int i=0;i<3;i++){
            memo = new int[N][3];

            for(int j=0;j<3;j++) {
                memo[0][j] = Integer.MAX_VALUE;
                if (i == j) memo[0][i] = price[0][i];
            }

            for(int j=0;j<3;j++){
                memo[1][j] = price[1][j]+memo[0][i];
                if(i==j) memo[1][j]=Integer.MAX_VALUE;
            }

            for(int j=2;j<N;j++){
                for(int k=0;k<3;k++){
                    int tmp = min(memo[j-1][(k+1)%3],memo[j-1][(k+2)%3]);
                    memo[j][k] = price[j][k]+ tmp;
                }
            }
            for(int j=0;j<3;j++){
                if(i==j)continue;
                answer = Math.min(answer,memo[N-1][j]);
            }

        }
        System.out.println(answer);


    }
}