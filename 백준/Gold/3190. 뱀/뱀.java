import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;
import java.util.*;
class Command{
    int t;
    char dir;
    public Command(int x, char c){
        this.t = x;
        this.dir = c;
    }
}
class Pair{
    int x,y;
    public Pair(int x,int y){
        this.x=x;
        this.y=y;
    }
}
public class Main{
    static int N,K,L;
    static int[][] grid;
    static Command[] cmd;
    static int cmdCnt=0;

    static int[] dx = new int[]{0,1,0,-1};
    static int[] dy = new int[]{1,0,-1,0};
    static int d =0;
    static Queue<Pair> q = new ArrayDeque<>();
    private static boolean inRange(int x,int y){
        return 0<=x && x<N && 0<=y && y<N;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N =Integer.parseInt(br.readLine());
        grid= new int[N][N];
        K = Integer.parseInt(br.readLine());
        for(int i=0;i<K;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            grid[x-1][y-1]=1;
        }

        L = Integer.parseInt(br.readLine());
        cmd = new Command[L];
        for(int i=0;i<L;i++){
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0);
            cmd[i] = new Command(t,c);
        }

        grid[0][0]=2;
        q.offer(new Pair(0,0));
        Pair curr = new Pair(0,0);
        int time=0;

        while(true){
            time++;
            int nx = curr.x+dx[d];
            int ny = curr.y+dy[d];
            if(!inRange(nx,ny)) break;
            if(grid[nx][ny]==2) break;
            curr.x=nx;
            curr.y=ny;
            if(grid[curr.x][curr.y]!=1){
                Pair p =q.poll();
                grid[p.x][p.y]=0;
            }
            grid[curr.x][curr.y]=2;
            q.offer(new Pair(curr.x, curr.y));

            //회전
            if(cmdCnt<L && cmd[cmdCnt].t==time){
                if(cmd[cmdCnt].dir=='D'){
                    d=(d+1)%4;
                }else{
                    d=(d-1);
                    if(d==-1) d=3;
                }
                cmdCnt++;
            }


        }
        System.out.println(time);
    }
}