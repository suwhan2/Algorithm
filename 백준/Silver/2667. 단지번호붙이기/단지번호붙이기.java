import java.util.*;
import java.io.*;

class Pair{
    int x,y;
    public Pair(int x, int y){
        this.x=x;
        this.y=y;
    }
}
public class Main{
    static List<Integer> homeCountList = new ArrayList<>();
    static int[] dx = new int[]{1,0,-1,0};
    static int[] dy = new int[]{0,1,0,-1};
    static char[][] grid;
    static boolean[][] visited;
    static int N;
    static Queue<Pair> q =new ArrayDeque<>();
    private static boolean inRange(int x,int y){
        return 0<=x && x<N && 0<=y && y<N;
    }

    private static void bfs(){
        int cnt=1;
        while(!q.isEmpty()){
            Pair tmp =q.poll();
            int x= tmp.x;
            int y = tmp.y;

            for(int i=0;i<4;i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(inRange(nx,ny) && grid[nx][ny]=='1' && !visited[nx][ny]){
                    q.offer(new Pair(nx,ny));
                    visited[nx][ny]=true;
                    cnt++;
                }
            }
        }

        homeCountList.add(cnt);
    }


    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        grid =new char[N][N];
        visited = new boolean[N][N];

        for(int i=0;i<N;i++){
            String gridInput = br.readLine();
            for(int j=0;j<N;j++){
                grid[i][j] = gridInput.charAt(j);
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(grid[i][j]=='1' && !visited[i][j]){
                    q.offer(new Pair(i,j));
                    visited[i][j]=true;
                    bfs();
                }
            }
        }

        Collections.sort(homeCountList);
        System.out.println(homeCountList.size());
        for(int c : homeCountList){
            System.out.println(c);
        }


    }
}