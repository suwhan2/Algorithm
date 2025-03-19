import java.io.*;
import java.util.*;
class Pair{
    int x,y;
    public Pair(int x,int y){
        this.x=x;
        this.y=y;
    }
}

public class Main {
    static int N;
    static boolean[][] grid;
    static Integer[] cmd = new Integer[1025];
    static int[] dx = new int[]{1,0,-1,0};
    static int[] dy = new int[]{0,-1,0,1};
    private static int check(){
        int cnt=0;
        for(int i=0;i<100;i++){
            for(int j=0;j<100;j++){
                if(grid[i][j] && grid[i+1][j] && grid[i][j+1] && grid[i+1][j+1]) cnt++;
            }
        }
        return cnt;
    }
    private static void draw(int x,int y, int d ,int g){
        cmd[1]=d;
        grid[y][x]=true;
        int point =1;
        for(int i=0;i<g;i++){
            int index = point;
            for(int j=point;j>=1;j--){
                index++;
                cmd[index] = (cmd[j]+1)%4;
            }
            point=index;
        }


        int curx= x;
        int cury= y;
        for(int i=1;i<=point;i++){
            int nx = curx+dx[cmd[i]];
            int ny = cury+dy[cmd[i]];
            grid[ny][nx]=true;
            cury=ny;
            curx=nx;

        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        grid = new boolean[101][101];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());

            draw(x,y,d,g);
        }
        System.out.println(check());
    }
}