import java.util.*;
import java.io.*;


class Pair{
    int x,y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static int M,N,K;
    static boolean[][] grid;
    static int dx[] =new int[]{1,0,-1,0};
    static int dy[] =new int[]{0,1,0,-1};
    static int size=1;
    static Queue<Pair> q =new ArrayDeque<>();
    static PriorityQueue<Integer> pq = new PriorityQueue<>();

    private static boolean inRange(int x,int y){
        return 0<=x && x<M &&0<=y && y<N;
    }
    private static void bfs(){
        while(!q.isEmpty()){
            Pair cur = q.poll();
            int x = cur.x;
            int y= cur.y;

            for(int i=0;i<4;i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(inRange(nx,ny) && !grid[nx][ny] ){
                    grid[nx][ny]= true;
                    q.offer(new Pair(nx,ny));
                    size++;
                }
            }

        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M =Integer.parseInt(st.nextToken());
        N =Integer.parseInt(st.nextToken());
        K =Integer.parseInt(st.nextToken());
        grid = new boolean[M][N];
        int x1,y1,x2,y2;
        for(int i=0;i<K;i++){
            st= new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());

            for(int j=x1;j<x2;j++){
                for(int k=y1;k<y2;k++){
                    grid[k][j]=true;
                }
            }
        }

        int cnt=0;
        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                if(grid[i][j]) continue;
                grid[i][j]=true;
                q.offer(new Pair(i,j));
                cnt++;
                bfs();
                pq.offer(size);
                size=1;
            }
        }

        System.out.println(cnt);
        while (!pq.isEmpty()){
            System.out.print(pq.poll()+" ");
        }


    }
}
