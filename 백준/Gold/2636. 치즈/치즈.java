import java.io.*;
import java.util.*;

class Pair {
    int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int N, M;
    static int dx[] = new int[]{1, 0, -1, 0};
    static int dy[] = new int[]{0, 1, 0, -1};
    static int grid[][], depth[][];
    static boolean visited[][];
    static boolean check=false;
    static int eraseCount=0;
    static int oneCount=0;

    static Queue<Pair> q = new ArrayDeque<>();

    private static boolean inRange(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < M;
    }

    private static boolean canGo(int x, int y) {
        if (!inRange(x, y)) return false;
        if (visited[x][y] || grid[x][y]==2) return false;
        if(grid[x][y] == 1){
            check=true;
            grid[x][y]=2;
            return false;
        }
        return true;
    }

    private static void push(int x, int y) {
        visited[x][y] = true;
        q.offer(new Pair(x, y));
//        depth[x][y] = d;
    }

    private static void bfs() {
        while (!q.isEmpty()) {
            Pair tmp = q.poll();
            int x = tmp.x;
            int y = tmp.y;
            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                if (canGo(newX, newY)) {
                    push(newX, newY);
                }
            }
        }
    }
    private static boolean meetAir(int x, int y) {
        if (inRange(x - 1, y) && grid[x - 1][y] == 0) return true;
        if (inRange(x, y - 1) && grid[x][y - 1] == 0) return true;
        if (inRange(x + 1, y) && grid[x + 1][y] == 0) return true;
        if (inRange(x, y + 1) && grid[x][y + 1] == 0) return true;
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        grid = new int[N][M];
        depth = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                if(grid[i][j]==1) oneCount++;
            }
        }
//        push(0,0);
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < M; j++) {
//                if (grid[i][j] == 1 && meetAir(i, j)) {
//                    push(i, j, 0);
//                    //to-do 구멍뚫린거 해결하자
//                }
//            }
//        }
        int count=0;
//        visited = new boolean[N][M];
//        push(0,0);
//        bfs();
//        for(int i=0;i<N;i++){
//            for(int j=0;j<M;j++){
//                if(grid[i][j]==2) {
//                    grid[i][j] = 0;
//                    eraseCount++;
//                    oneCount--;
//                }
//
//            }
//        }
        while(true){
            eraseCount=0;
            count++;
            check=false;
            visited = new boolean[N][M];
            push(0,0);
            bfs();
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(grid[i][j]==2) {
                        grid[i][j] = 0;
                        eraseCount++;
                        oneCount--;
                    }
                }
            }
            if(!check) break;
            if(oneCount==0) break;
        }



        System.out.println(count);
        System.out.println(eraseCount);
//        bfs();
//        for(int i=0;i<N;i++){
//            for(int j=0;j<M;j++){
//                System.out.print(grid[i][j]+" ");
//            }
//            System.out.println();
//        }

//        int maxTime = 0;
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < M; j++) {
//                maxTime = Math.max(maxTime, depth[i][j]);
//            }
//        }
//        int lastCheeseCount = 0;
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < M; j++) {
//                if (depth[i][j] == maxTime) {
//                    lastCheeseCount++;
//                }
//            }
//        }
//
//        System.out.println(maxTime);
//        System.out.println(lastCheeseCount);

    }
}
