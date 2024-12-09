import java.io.*;
import java.util.*;

class Pair{
    int x,y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main{
    static int N;
    static int maxH=0;
    static int ans=1;
    static int[][] grid;
    static Queue<Pair> q = new ArrayDeque<>();
    static boolean[][] visited;


    static int[] dx = new int[]{1,0,-1,0};
    static int[] dy = new int[]{0,1,0,-1};

    private static boolean inRange(int x, int y){
        return 0<=x && x<N && 0<=y && y<N;
    }
    private static void simulation(int num){
        visited = new boolean[N][N];
        int cnt=0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(grid[i][j]>num && !visited[i][j]){
                    q.offer(new Pair(i,j));
                    visited[i][j]=true;
                    bfs(num);
                    cnt++;
                }
            }
        }

        ans = Math.max(ans,cnt);
    }
    private static void bfs(int num){
        while(!q.isEmpty()){
            Pair tmp = q.poll();
            int x = tmp.x;
            int y = tmp.y;

            for(int i=0;i<4;i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(inRange(nx,ny) && !visited[nx][ny] && grid[nx][ny]>num){
                    visited[nx][ny]=true;
                    q.offer(new Pair(nx,ny));
                }
            }
        }

    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        grid = new int[N][N];
        StringTokenizer st;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
                maxH = Math.max(maxH,grid[i][j]);
            }
        }

        for(int i=1;i<=maxH;i++){simulation(i);}

        System.out.println(ans);
    }
}