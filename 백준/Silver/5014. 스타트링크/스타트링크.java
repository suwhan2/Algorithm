import java.util.*;
import java.io.*;

class Pair{
    int index, count;

    public Pair(int index, int count) {
        this.index = index;
        this.count = count;
    }
}

public class Main {
    static int F,S,G,U,D;
    static Queue<Pair> q = new ArrayDeque<>();
    static boolean[] visited;
    static int[] dx;      

    private static boolean inRange(int x){
        return 0<x && x<=F;
    }

    private static int bfs(){
        while(!q.isEmpty()){
            Pair tmp = q.poll();

            if(tmp.index==G) return tmp.count;

            for(int i=0;i<2;i++){
                int nx = tmp.index+dx[i];
                if(inRange(nx) && !visited[nx]){
                    visited[nx] = true;
                    q.offer(new Pair(nx,tmp.count+1));
                }
            }
        }

        return -1;
    }

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        F = Integer.parseInt(st.nextToken());
        visited = new boolean[F+1];
        visited[0]=true;

        S = Integer.parseInt(st.nextToken());
        q.offer(new Pair(S,0));
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        dx = new int[]{U,-D};
        
        int ans = bfs();
        
        if(ans==-1) System.out.println("use the stairs");
        else System.out.println(ans);


    }
}
