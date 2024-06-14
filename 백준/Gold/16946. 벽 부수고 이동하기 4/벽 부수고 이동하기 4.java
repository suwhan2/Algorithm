import java.util.*;
import java.io.*;

class Pair{
    int x,y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main{
    static int N,M;
    static int[][] grid;
    static int[][] ans;
    static int zeroNum=1;
    static int[][] visited;
    static int[] dx= new int[]{1,0,-1,0};
    static int[] dy= new int[]{0,1,0,-1};
    static Queue<Pair> q = new ArrayDeque<>();
    static HashMap<Integer,Integer> hm = new HashMap<>();

    private static boolean inRange(int x,int y){
        return 0<=x && x<N && 0<=y && y<M;
    }
    private static boolean canGo(int x,int y){
        if(!inRange(x,y)) return false;
        if(visited[x][y]!=0) return false;
        if(grid[x][y]==1) return false;
        return true;

    }
    private static int calCanGo(int x,int y){
        HashSet<Integer> hs = new HashSet<>();
        for(int i=0;i<4;i++){
            int nx=x+dx[i];
            int ny=y+dy[i];
            if(inRange(nx,ny) && grid[nx][ny]==0){
                hs.add(visited[nx][ny]);
            };
        }

        int ans=0;
        for(Integer i:hs){
            ans+=hm.get(i);
        }
        return (ans+1)%10 ;
    }
    private static int calSameZero(int x,int y){

        visited[x][y]=zeroNum;
        int cnt=1;
        q.offer(new Pair(x,y));

        while(!q.isEmpty()){
            Pair p = q.poll();

            for(int k=0;k<4;k++){
                if(canGo(p.x+dx[k],p.y+dy[k])){
                    visited[p.x+dx[k]][p.y+dy[k]]=zeroNum;
                    cnt++;
                    q.offer(new Pair(p.x+dx[k],p.y+dy[k]));
                }
            }
        }

        return cnt;
    }
    public static void main(String[] args) throws IOException{
        // 입력부
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        grid = new int[N][M];
        ans = new int[N][M];

        for(int i = 0; i < N; i++){
            String strInput = br.readLine();
            for(int j = 0; j < M; j++){
                grid[i][j] = strInput.charAt(j)-'0';
            }
        }

        // 구현부
        visited = new int[N][M];
        for(int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
             if(grid[i][j]==0 && visited[i][j]==0){
                 hm.put(zeroNum,calSameZero(i,j));
                 zeroNum++;
             }
            }
        }
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(grid[i][j]==1){
                    sb.append(calCanGo(i,j));
                }else{
                    sb.append(0);
                }
            }
            sb.append("\n");
        }

        // 출력부
        System.out.println(sb.toString());
    }
}