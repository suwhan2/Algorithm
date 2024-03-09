import java.io.*;
import java.util.*;

class Pair{
    int x,y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

}

public class Main {
    static int N;
    static int M;
    static int Q;
    static int grid[][];
    static int visited[][];
    static int count=0;



    static Stack<Pair> q = new Stack<>();

    private static boolean inRange(int x, int y) {
        return 0<=x && x<N && 0<=y && y<M;
    }
    private static boolean canGo(int x, int y) {
        if(!inRange(x,y)) return false;
        if(grid[x][y]==0 || visited[x][y]==1) return false;
        return true;
    }
    private static void push(int x, int y) {
        visited[x][y]=1;
        q.push(new Pair(x,y));

    }
    private static void BFS() {
        int dx[] = new int[] {0,1,0,-1};
        int dy[] = new int[] {1,0,-1,0};

        while(!q.isEmpty()) {
            Pair now = q.pop();
            int x = now.x;
            int y= now.y;

            for(int i=0;i<4;i++) {
                int newX = x+ dx[i];
                int newY = y+ dy[i];

                if(canGo(newX, newY)) {
                    push(newX,newY);
                }
            }
        }
    }


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T= Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            Q = Integer.parseInt(st.nextToken());

            grid= new int[N][M];
            visited= new int[N][M];

            for(int i=0;i<Q;i++) {
                StringTokenizer st2 = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st2.nextToken());
                int y = Integer.parseInt(st2.nextToken());

                grid[x][y] = 1;
            }

            for(int i=0;i<N;i++) {
                for(int j=0;j<M;j++) {
                    if(grid[i][j]==1 && visited[i][j]==0) {
                        push(i,j);
                        BFS();
                        count+=1;
                    }
                }
            }
            System.out.println(count);
            count=0;
        }

    }
}

