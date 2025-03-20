
import java.util.*;
import java.io.*;

class Pair{
    int x,y;

    public Pair(int x,int y){
        this.x=x;
        this.y=y;
    }
}

public class Main{
    static int N,L,R;
    static int[][] map;
    static boolean[][] open;
    static int[] dx = new int[]{1,0,-1,0};
    static int[] dy = new int[]{0,1,0,-1};

    private static boolean inRange(int x,int y){
        return 0<= x && x<N && 0<=y && y<N;
    }

    private static boolean bfs(int x,int y){
        Queue<Pair> q = new ArrayDeque<>();
        List<Pair> history = new ArrayList<>();

        q.offer(new Pair(x,y));
        open[x][y]=true;
        history.add(new Pair(x,y));

        while(!q.isEmpty()){
            Pair tmp  = q.poll();

            for(int i=0;i<4;i++){
                int nx = tmp.x+dx[i];
                int ny = tmp.y+dy[i];
                if(inRange(nx,ny) && !open[nx][ny]){
                    int gap = Math.abs(map[tmp.x][tmp.y]-map[nx][ny]);
                    if(gap>=L && gap<=R){
                        q.offer(new Pair(nx,ny));
                        open[nx][ny]=true;
                        history.add(new Pair(nx,ny));
                    }
                }
            }
        }

        if(history.size()==1){
            return false;
        }
        else{
            int sum=0;
            for(Pair p : history){
                sum+=map[p.x][p.y];
            }
            int result = sum/(history.size());
            for(Pair p : history){
                map[p.x][p.y]=result;
            }
            return true;
        }

    }
    private static boolean check(){
        boolean result =false;
        open = new boolean[N][N];

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(open[i][j]) continue;
                if(bfs(i,j)) result=true;
            }
        }

        return result;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N  = Integer.parseInt(st.nextToken());
        L  = Integer.parseInt(st.nextToken());
        R  = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for(int i=0;i<N;i++){
            st= new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt=0;
        while(true){
            if(!check()) break;
            cnt++;
        }

        System.out.println(cnt);
    }
}