import java.io.*;
import java.util.*;
public class Main{
    static int N,M,V;
    static List<Integer>[] graph;
    static boolean[] visited;
    static StringBuilder sb;
    static Queue<Integer> q;

    private static void dfs(int cnt){
        visited[cnt]=true;
        sb.append(cnt).append(" ");

        for(int x : graph[cnt]){
            if(!visited[x]){
                visited[x]=true;
                dfs(x);
            }
        }
    }
    private static void bfs(){
        while(!q.isEmpty()){
            int cur = q.poll();
            sb.append(cur).append(" ");

            for(int x :graph[cur]){
                if(!visited[x]){
                    visited[x]=true;
                    q.offer(x);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N+1];
        for(int i=0;i<=N;i++){ graph[i] = new ArrayList<>(); }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
        for(int i=1;i<=N;i++){
            Collections.sort(graph[i]);
        }

        //dfs
        sb= new StringBuilder();
        visited = new boolean[N+1];
        dfs(V);
        sb.append("\n");
        //bfs
        q = new ArrayDeque<>();
        visited = new boolean[N+1];
        q.offer(V);
        visited[V]=true;
        bfs();

        System.out.println(sb);
    }
}