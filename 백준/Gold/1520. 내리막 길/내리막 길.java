import java.io.*;
import java.util.*;

public class Main {
    static int M,N;
    static int[][] grid;
    static int[][] memo;
    static int[] dx =new int[]{1,0,-1,0};
    static int[] dy =new int[]{0,1,0,-1};

    private static boolean inRange(int x,int y){
        return 0<=x && x<M && 0<=y && y<N;
    }

    private static int dfs(int x,int y){
        if(x==M-1 && y==N-1){ return 1;}
        if(memo[x][y]!=-1) return memo[x][y];

        memo[x][y]=0;
        for(int i=0;i<4;i++){
            int newX = x+dx[i];
            int newY = y+dy[i];
            if(inRange(newX,newY)){
                if(grid[newX][newY]<grid[x][y]){
                    memo[x][y]+=dfs(newX,newY);
                }
            }
        }
        return memo[x][y];

    }
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        grid = new int[M][N];
        memo = new int[M][N];

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                memo[i][j]=-1;
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(dfs(0,0));

    }
}