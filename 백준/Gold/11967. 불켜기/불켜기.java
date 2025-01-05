import java.util.*;
import java.io.*;

class Pair{
    int x,y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main{

    static int N,M;
    static int ans =1;
    static ArrayList<Pair>[][] grid;
    static boolean[][] lightState;
    static boolean[][] visited;
    static int[] dx = new int[]{1,0,-1,0};
    static int[] dy = new int[]{0,1,0,-1};
    static Queue<Pair> q =new ArrayDeque<>();
    private static boolean inRange(int x,int y){
        return 1<=x && x<=N && 1<=y && y<=N;
    }

    private static boolean canGo(int x,int y){
        if(!inRange(x,y)) return false;
        if(!lightState[x][y]) return false;
        if(visited[x][y]) return false;
        return true;
    }
    private static boolean check(int x,int y){
        for(int i=0;i<4;i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(inRange(nx,ny) && visited[nx][ny]) return true;
        }
        return false;
    }
    private static void bfs(){
        while(!q.isEmpty()){
            Pair tmp = q.poll();
            int x = tmp.x;
            int y = tmp.y;
            
            if(!grid[x][y].isEmpty()){
                for(Pair p : grid[x][y]){
                    if(!lightState[p.x][p.y]){
                        lightState[p.x][p.y]=true;
                        ans++;
                        if(!visited[p.x][p.y] && check(p.x,p.y)){
                            q.offer(new Pair(p.x,p.y));
                            visited[p.x][p.y]=true;
                        }
                    }
                }
                grid[x][y].clear();
            }

            for(int i=0;i<4;i++){
                int nx = x +dx[i];
                int ny = y +dy[i];
                if(canGo(nx,ny)){
                    q.offer(new Pair(nx,ny));
                    visited[nx][ny]=true;
                }
            }
        }
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        grid = new ArrayList[N+1][N+1];
        for(int i=1;i<=N;i++){
            for(int j=0;j<=N;j++){
                grid[i][j] = new ArrayList();
            }
        }
        lightState = new boolean[N+1][N+1];
        lightState[1][1]=true;

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            grid[x][y].add(new Pair(a,b));
        }
        
        visited = new boolean[N+1][N+1];
        visited[1][1]=true;
        q.offer(new Pair(1,1));
        bfs();
            

        System.out.println(ans);
    }

}