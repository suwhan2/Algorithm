import java.io.*;
import java.util.*;

class Pair{
    int x,y;
    public Pair(int x,int y){
        this.x=x;
        this.y=y;
    }
}
public class Main{
    static char[][] grid;
    static List<Pair> bombList;
    static Queue<Pair> q;
    static boolean[][] visited;
    static int[] dx= new int[]{1,0,-1,0};
    static int[] dy= new int[]{0,1,0,-1};

    static int ans=0;
    private static boolean inRange(int x,int y){
        return 0<=x && x<12 && 0<=y && y<6;
    }


    private static boolean check(){
        boolean isPuyo = false;
        visited = new boolean[12][6];
        for(int i=0;i<12;i++){
            for(int j=0;j<6;j++){
                if(grid[i][j]!='.' && !visited[i][j]){

                    q = new ArrayDeque<>();
                    q.offer(new Pair(i,j));
                    bombList = new ArrayList<>();
                    int result = bfs();
//                    System.out.println(result);

                    if(result>=4){
                        for(Pair b : bombList){
                            grid[b.x][b.y]='.';
                        }
                        isPuyo = true;
                    }
                }
            }
        }
        return isPuyo;
    }
    private static int bfs(){
        int cnt=0;
        while(!q.isEmpty()) {
            Pair tmp = q.poll();
            int x = tmp.x;
            int y = tmp.y;
            bombList.add(new Pair(x,y));

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (inRange(nx, ny) && !visited[nx][ny] && grid[x][y] == grid[nx][ny]) {
                    visited[nx][ny] = true;
                    cnt++;
                    q.offer(new Pair(nx, ny));
                }
            }
        }
        return cnt;
    }
    private static void drop(){
        List<Character> tmp;
        for(int i=0;i<6;i++){
            tmp = new ArrayList<>();
            for(int j=11;j>=0;j--){
                if(grid[j][i]!='.'){
                    tmp.add(grid[j][i]);
                }
            }

            while(tmp.size()<12){
                tmp.add('.');
            }

            for(int j=11;j>=0;j--){
                grid[j][i] = tmp.get(11-j);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        grid = new char[12][6];
        for(int i=0;i<12;i++){
           grid[i] = br.readLine().toCharArray();
        }

        while(true){
//            for(int i=0;i<12;i++){
//                for(int j=0;j<6;j++){
//                    System.out.print(grid[i][j]);
//                }
//                System.out.println();
//            }
//            System.out.println();
            boolean result = check();
            if(result){
                ans++;
                drop();
            }
            else break;
        }

        System.out.println(ans);
    }
}