
import java.io.*;
import java.util.*;

class Pair{
    int x,y,cnt;
    public Pair(int x,int y,int cnt){
        this.x=x;
        this.y=y;
        this.cnt=cnt;
    }
}
public class Main{
    static int N;
    static int[][] grid;
    static boolean[][] visited;
    static Queue<Pair> q;
    static int[] dx = new int[]{1,0,-1,0};
    static int[] dy = new int[]{0,1,0,-1};
    private static boolean inRange(int x,int y){
        return 0<=x && x<N && 0<=y &&y<N;
    }
    private static boolean canGo(int x,int y,int n){
        if(!inRange(x,y)) return false;
        if(visited[x][y]) return false;
        if(grid[x][y]==n) return false;
        return true;
    }
    private static void bfs(int sp){
        while(!q.isEmpty()){
            Pair tmp =q.poll();
            int x = tmp.x;
            int y= tmp.y;

            for(int i=0;i<4;i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (inRange(nx, ny) && grid[nx][ny]==1) {
                    grid[nx][ny]+=sp;
                    q.offer(new Pair(nx,ny,0));
                }
            }
        }
    }
    private static int bfs2(int n){
        while(!q.isEmpty()){
            Pair tmp =q.poll();
            int x = tmp.x;
            int y = tmp.y;
            if(grid[x][y]!=0 && grid[x][y]!=n) return tmp.cnt;

            for(int i=0;i<4;i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (inRange(nx,ny) && !visited[nx][ny] && grid[nx][ny]!=n){
                        visited[nx][ny]=true;
                        q.offer(new Pair(nx,ny,tmp.cnt+1));

                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int ans=Integer.MAX_VALUE;
        N = Integer.parseInt(br.readLine());
        grid = new int[N][N];
        q = new ArrayDeque<>();

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int sp = 1;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(grid[i][j]==1){
                    q.offer(new Pair(i,j,0));
                    grid[i][j]+=sp;
                    bfs(sp);
                    sp++;
                }
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(grid[i][j]!=0){
                    visited = new boolean[N][N];
                    q.offer(new Pair(i,j,0));
                    int result = bfs2(grid[i][j]);
                    if(result!=-1) ans = Math.min(result,ans);
                    q.clear();
                }
            }
        }

        System.out.println(ans-1);
    }
}