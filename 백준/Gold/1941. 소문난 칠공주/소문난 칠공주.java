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
    // 순서가 상관없이 7명을 뽑는다고 생각하자 = 조합(5x5이므로 가능)
    // 격자인데? -> 1차원으로 0~25로 생각하고 풀자, /%로 끊어서 구현
    // 칠공주의 조합이 dfs로는 구할 수 없다. bfs로 해야 분기 포함 모양을 캐치할 수 있다.
    // 조합짜고 cnt7이면 bfs로 연결여부 확인하고 ans++
    static int ans=0;
    static Character[][] classState;
    static boolean[] visited;
    static int[] dx = new int[]{1,0,-1,0};
    static int[] dy= new int[]{0,1,0,-1};
    private static boolean inRange(int x,int y){
        return 0<=x && x<5 && 0<=y && y<5;
    }

    private static boolean bfs(int x,int y){
        Queue<Pair> q =new ArrayDeque<>();
        boolean[][] tmpVisited = new boolean[5][5];
        tmpVisited[x][y]=true;
        q.offer(new Pair(x,y));
        int cnt=1;

        while(!q.isEmpty()){
            Pair tmp = q.poll();
            for(int i=0;i<4;i++){
                int nx = tmp.x+dx[i];
                int ny = tmp.y+dy[i];
                int nxt = nx*5 + ny;
                if(inRange(nx,ny) && !tmpVisited[nx][ny] && visited[nxt]){
                    tmpVisited[nx][ny]=true;
                    q.offer(new Pair(nx,ny));
                    cnt++;
                }
            }
        }
        return cnt==7;
    }
    private static void simulation(int x,int cnt,int yCount){
        if(yCount>=4){
            return;
        }

        if(cnt==7){
            int curIdx = x-1;
            if(bfs(curIdx/5, curIdx%5)){
                ans++;
            }
            return;
        }

        for(int i=x;i<25;i++){
            visited[i]=true;
            if(classState[i/5][i%5]=='Y'){
                simulation(i+1,cnt+1,yCount+1);
            }else{
                simulation(i+1,cnt+1,yCount);
            }
            visited[i]=false;
        }
    }
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        classState = new Character[5][5];
        visited = new boolean[25];
        for(int i=0;i<5;i++){
            String tmp = br.readLine();
            for(int j=0;j<5;j++){
                classState[i][j] = tmp.charAt(j);
            }
        }

        simulation(0,0,0);
        System.out.println(ans);
    }
}