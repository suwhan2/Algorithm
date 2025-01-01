import java.util.*;
import java.io.*;


class Pair{
    int x,y,z,cnt,day;

    public Pair(int x, int y, int z, int cnt,int day) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.cnt = cnt;
        this.day=day;
    }
}
public class Main{

    static Queue<Pair> q = new ArrayDeque<>();
    static int[][][] grid;
    static int N,M,K;
    static int[] dx = new int[]{1,0,-1,0};
    static int[] dy = new int[]{0,1,0,-1};

    private static boolean inRange(int x,int y){
        return 0<=x && x<N && 0<=y &&y<M;
    }
    private static void fill(int x,int y,int z){
        for(int i=z;i<K;i++){
            grid[i][x][y]=2;
        }
    }

    private static int bfs(){
        while(!q.isEmpty()){
            Pair tmp = q.poll();
            int x= tmp.x;
            int y= tmp.y;
            int z = tmp.z;

            if(x==(N-1) && y==(M-1)) return tmp.cnt;

            for(int i=0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nz = z;
                if(inRange(nx,ny)){
                    if(grid[nz][nx][ny]==2) continue;
                    if(grid[nz][nx][ny]==1){
                        if(z==(K-1)) continue;
                        if(tmp.day==-1){
                            q.offer(new Pair(x,y,z,tmp.cnt+1,tmp.day*-1));
                            continue;
                        }
                    }

                    if(grid[nz][nx][ny]==1) nz+=1;
                    fill(nx,ny,nz);
                    q.offer(new Pair(nx,ny,nz,tmp.cnt+1,tmp.day*-1));
                }
            }
        }
        return -1;
    }

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken())+1;

        grid = new int[K][N][M];

        for(int i=0;i<N;i++){
            String strInput = br.readLine();
            for(int j=0;j<M;j++){
                int num = strInput.charAt(j)-'0';
                for(int k=0;k<K;k++){
                        grid[k][i][j]=num;
                }
            }
        }

        grid[0][0][0]=2;
        q.offer(new Pair(0,0,0,1,1));
        int ans =bfs();
        System.out.println(ans);

    }
}