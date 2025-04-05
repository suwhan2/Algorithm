import java.io.*;
import java.util.*;
class Pair{
    int x,y,cnt;

    public Pair(int x, int y,int cnt) {
        this.x = x;
        this.y = y;
        this.cnt=cnt;
    }
}
public class Main {
    static int N,M;
    static int[][] grid;
    static List<Pair> virus = new ArrayList<>();
    static Pair[] picked;
    static int[] dx = new int[]{1,0,-1,0};
    static int[] dy = new int[]{0,1,0,-1};
    static int ans = Integer.MAX_VALUE;
    private static boolean inRange(int x,int y){
        return 0<=x && x<N && 0<=y && y<N;
    }
    private static void bfs(){
        Queue<Pair> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][N];
        int time=0;
        for(Pair p : picked){
            q.offer(p);
            visited[p.x][p.y]=true;
        }

        while(!q.isEmpty()){
            Pair cur = q.poll();
            if(grid[cur.x][cur.y]==0) time = Math.max(time,cur.cnt);


            for(int i=0;i<4;i++){
                int nx = cur.x+dx[i];
                int ny = cur.y+dy[i];

                if(inRange(nx,ny) && !visited[nx][ny] && grid[nx][ny]!=1){
                    visited[nx][ny]=true;
                    q.offer(new Pair(nx,ny,cur.cnt+1));
                }
            }
        }


        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(!visited[i][j] && grid[i][j]==0) return;
            }
        }
        ans =Math.min(ans,time);

    }

    private static void combination(int cnt, int startIndex){
        if(cnt==M){
            bfs();
            return;
        }

        for(int i=startIndex;i<virus.size();i++){
            picked[cnt] = virus.get(i);
            combination(cnt+1,i+1);
        }

    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        grid = new int[N][N];
        picked = new Pair[M];

        for(int i=0;i<N;i++){
            st= new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
                if(grid[i][j]==2) virus.add(new Pair(i,j,0));
            }
        }

        // 최대 10개중 M개를 뽑는 조합
        // 1억
        // bfs -> 최대 2500
        // 2500 x 1024 => 충분

        combination(0,0);
        if(ans==Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(ans);
    }
}