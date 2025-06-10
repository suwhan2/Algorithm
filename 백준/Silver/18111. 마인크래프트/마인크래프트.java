import java.util.*;
import java.io.*;

public class Main{
    static int N,M,B;
    static int[][] grid;
    private static int calculateTime(int h){
        int outCnt=0;
        int inCnt=0;


        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                int tmp = grid[i][j]-h;
                if(tmp<0) inCnt-=tmp;
                if(tmp>0) outCnt+=tmp;
            }
        }

        if(inCnt>(outCnt+B)) return -1;

        return (2*outCnt+inCnt);
    }
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        grid = new int[N][M];

        int maxB = 0;
        int minB = 256;
        for(int i=0;i<N;i++){
            st=  new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
                maxB = Math.max(maxB,grid[i][j]);
                minB = Math.min(minB,grid[i][j]);
            }
        }


        int ansT=Integer.MAX_VALUE;
        int ansH=grid[0][0];
        for(int i=minB;i<=maxB;i++){
            int result = calculateTime(i);
            if(result==-1) continue;
            if(result<=ansT){
                ansH = i;
                ansT = result;
            }

//            System.out.println(i+" "+result);
        }

        System.out.println(ansT+" "+ansH);

    }
}