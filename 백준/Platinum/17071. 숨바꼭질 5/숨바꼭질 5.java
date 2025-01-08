import java.util.*;
import java.io.*;

class Pair {
    int x, cnt;

    public Pair(int x,int cnt) {
        this.x = x;
        this.cnt = cnt;
    }
}
public class Main {
    static int N,K;
    static boolean[][] visited=new boolean[2][500001];
    private static boolean inRange(int x){
        return 0<= x && x<=500000;
    }

    private static int bfs(){
        if(N==K) return 0;

        Queue<Pair> q =new ArrayDeque<>();
        q.offer(new Pair(N,1));
        visited[0][N] = true;

        while(!q.isEmpty()){
            Pair cur = q.poll();
            int sum = (cur.cnt *(cur.cnt+1))/2;
            if((K+sum)>500000) return -1;

            // +1
            if(inRange(cur.x+1) && !visited[cur.cnt%2][cur.x+1]){
                q.offer(new Pair(cur.x+1,cur.cnt+1));
                visited[cur.cnt%2][cur.x+1]=true;
            }

            // -1
            if(inRange(cur.x-1) && !visited[cur.cnt%2][cur.x-1]){
                q.offer(new Pair(cur.x-1,cur.cnt+1));
                visited[cur.cnt%2][cur.x-1]=true;
            }
            // *2
            if(inRange(cur.x*2) && !visited[cur.cnt%2][cur.x*2]){
                q.offer(new Pair(cur.x*2,cur.cnt+1));
                visited[cur.cnt%2][cur.x*2]=true;
            }

            if(visited[cur.cnt%2][K+sum]) return cur.cnt;
        }

        return -1;
    }

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine());
        N =Integer.parseInt(st.nextToken());
        K =Integer.parseInt(st.nextToken());

        System.out.println(bfs());
    }
}