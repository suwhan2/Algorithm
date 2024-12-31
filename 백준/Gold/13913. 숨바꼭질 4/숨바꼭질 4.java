import java.util.*;
import java.io.*;

class Pair{
    int index, cnt;
    public Pair(int index, int cnt) {
        this.index = index;
        this.cnt = cnt;
    }
}

public class Main{
    static boolean[] visited = new boolean[100001];
    static int[] history = new int[100001];
    static Queue<Pair> q = new ArrayDeque<>();
    static int N,K;
    private static boolean inRange(int x){
        return 0<=x && x<=100000;
    }

    private static int bfs(){
        while(!q.isEmpty()){
            Pair cur = q.poll();
            if(cur.index==K) return cur.cnt;

            for(int i=0;i<3;i++){
                int nx;

                if(i==0) nx=cur.index+1;
                else if (i==1) nx=cur.index-1;
                else nx = cur.index*2;

                if(inRange(nx) && !visited[nx]){
                    visited[nx]=true;
                    q.offer(new Pair(nx,cur.cnt+1));
                    history[nx]=cur.index;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=  new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        q.offer(new Pair(N,0));

        StringBuilder sb = new StringBuilder();
        sb.append(bfs()).append("\n");

        Stack<Integer> tmp = new Stack<>();
        int t=K;
        while(t!=N){
            tmp.push(t);
            t=history[t];
        }
        tmp.push(N);

        while(!tmp.isEmpty()){
            sb.append(tmp.pop()).append(" ");
        }

        System.out.println(sb);

    }
}