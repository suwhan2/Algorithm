import java.io.*;
import java.util.*;

public class Main {
    static int N,startPoint;
    static int ans=Integer.MAX_VALUE;
    static int grid[][];
    static boolean visited[];

    private static void backTracking(int cnt,int sum,int recentIndex){
        if(cnt == N){
            if(grid[recentIndex][startPoint]==0) return;
            ans = Math.min(ans,sum+grid[recentIndex][startPoint]);
            return;
        }

        for(int i=0;i<N;i++){
            if(grid[recentIndex][i]==0) continue;
            if(visited[i]) continue;
            visited[i]=true;
            backTracking(cnt+1,sum+grid[recentIndex][i],i);
            visited[i] =false;
            //백트래킹

        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        grid = new int[N][N];
        visited = new boolean[N];
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0;i<N;i++){
            startPoint=i;
            visited[i]=true;
            backTracking(1,0,i);
            visited[i]=false;
        }
        System.out.println(ans);
    }
}