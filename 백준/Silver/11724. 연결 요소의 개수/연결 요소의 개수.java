import java.util.*;
import java.io.*;

public class Main{
    static int N,M;
    static Queue<Integer> q = new ArrayDeque<>();
    static int ans=0;
    static boolean[] visited;
    static List<ArrayList<Integer>> graph;
    private static void bfs(){
        while(!q.isEmpty()){
            int tmp = q.poll();

            for(int x : graph.get(tmp)){
                if(!visited[x]){
                    q.offer(x);
                    visited[x]=true;
                }
            }
        }
        ans++;
    }
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for(int i=0;i<=N;i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int f = Integer.parseInt(st.nextToken());
            graph.get(s).add(f);
            graph.get(f).add(s);
        }

        visited = new boolean[N+1];
        for(int i=1;i<=N;i++){
            if(!visited[i]){
                q.offer(i);
                visited[i]=true;
                bfs();
            }
        }
        System.out.println(ans);
    }
}