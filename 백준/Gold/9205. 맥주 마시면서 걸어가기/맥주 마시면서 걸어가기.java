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
    static int N;
    static Pair[] map;
    static Queue<Integer> q;
    static boolean[] visited;
    private static void bfs(){
        while(!q.isEmpty()){
            int tmp = q.poll();
            int x = map[tmp].x;
            int y= map[tmp].y;

            for(int i=1;i<N+2;i++){
                if(!visited[i]){
                    if(Math.abs(x - map[i].x)+Math.abs(y-map[i].y)<=1000){
                        visited[i]= true;
                        q.offer(i);
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int t=0;t<T;t++){
            N = Integer.parseInt(br.readLine());
            map = new Pair[N+2];
            visited = new boolean[N+2];
            q= new ArrayDeque<>();
            for(int i=0;i<N+2;i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[i]= new Pair(x,y);
            }
            visited[0]=true;
            q.offer(0);
            bfs();

            if(visited[N+1]) System.out.println("happy");
            else System.out.println("sad");
        }

    }
}