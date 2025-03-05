import java.util.*;
import java.io.*;

public class Main {
    static int N,M; //500 250,000
    static int ans=0;
    static int[][] grid;
    static int[] dx = new int[]{1,0,-1,0};
    static int[] dy = new int[]{0,1,0,-1};
    static boolean[][] visited;

    private static boolean inRange(int x,int y){
        return 0<=x && x<N && 0<=y && y<M;
    }

    private static void dfs(int x, int y, int cnt, int sum){
        if(cnt==4){
            ans = Math.max(ans,sum);
            return;
        }

        for(int i=0;i<4;i++){
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(inRange(nx,ny) && !visited[nx][ny]){

                if(cnt==2){
                    visited[nx][ny]=true; //하나먹고 가지는 않고 3으로 취급
                    dfs(x,y,cnt+1,sum+grid[nx][ny]);
                    visited[nx][ny]=false;
                }

                visited[nx][ny]=true;
                dfs(nx,ny,cnt+1,sum+grid[nx][ny]);
                visited[nx][ny]=false;
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        grid = new int[N][M];
        visited =new boolean[N][M];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());

            for(int j=0;j<M;j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                visited[i][j]=true;
                dfs(i,j,0,0);
                visited[i][j]=false;
            }
        }

        System.out.println(ans);
    }
}