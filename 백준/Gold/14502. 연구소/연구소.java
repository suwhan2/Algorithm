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
    static int ans=0;
    static int zeroCount=-3;
    static int[][] grid;
    static int[] pickList,picked;
    static int[] dx = new int[]{1,0,-1,0};
    static int[] dy = new int[]{0,1,0,-1};
    private static boolean inRange(int x,int y){
        return 0<=x && x<N && 0<=y && y<M;
    }
    private static int bfs(){
        boolean[][] visited = new boolean[N][M];
        Queue<Pair> q= new ArrayDeque<>();
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(grid[i][j]==2){
                    q.offer(new Pair(i,j));
                    visited[i][j]=true;
                }
            }
        }
        int virus = 0;

        while(!q.isEmpty()){
            Pair tmp = q.poll();

            for(int i=0;i<4;i++){
                int nx = tmp.x+dx[i];
                int ny = tmp.y+dy[i];
                if(inRange(nx,ny) && !visited[nx][ny] && grid[nx][ny]==0){
                    q.offer(new Pair(nx,ny));
                    visited[nx][ny]=true;
                    virus++;
                }
            }

        }
        return virus;
    }
    private static void simulation(int start,int cnt){
        if(cnt==3){
            int vCount =bfs();
            ans = Math.max(ans,zeroCount-vCount);
            return;
        }
        for(int i=start;i<=(N*M);i++){
            if(pickList[i]==0){
                picked[cnt]=i;
                grid[(i-1)/M][(i-1)%M]=1;
                simulation(i+1,cnt+1);
                grid[(i-1)/M][(i-1)%M]=0;

            }
        }
    }
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        grid = new int[N][M];
        pickList = new int[N*M+1];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                int tmp = Integer.parseInt(st.nextToken());
                if(tmp==0) zeroCount++;
                grid[i][j] = tmp;
                pickList[i*M+j+1]=tmp;
            }
        }
        picked = new int[3];
        simulation(1,0);
        System.out.println(ans);
    }
}