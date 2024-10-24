import java.io.*;
import java.util.*;

public class Main{
    static List<Integer>[] graph;
    static int[] visited;
    static int V;
    static int E;
    static Queue<Integer> q;
    private static boolean bfs(int start, int color){
        q = new ArrayDeque<>();
        q.offer(start);
        visited[start]=color;

        while(!q.isEmpty()){
            int cur = q.poll();

            for(int x : graph[cur]){
                if(visited[cur]==visited[x]) return false;

                if(visited[x] == 0){
                    visited[x] = visited[cur] * -1;
                    q.offer(x);
                }
            }
        }
        return true;

    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());


        for(int t=0;t<T;t++){
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            graph = new ArrayList[1 + V];
            for(int i=0;i<V+1;i++){
                graph[i] = new ArrayList<>();
            }

            visited = new int[V+1];
            for(int i=0;i<E;i++){
                st = new StringTokenizer(br.readLine());
                int node1 = Integer.parseInt(st.nextToken());
                int node2 = Integer.parseInt(st.nextToken());
                graph[node1].add(node2);
                graph[node2].add(node1);
            }

            boolean canDouble = false;
            for(int i=1;i<=V;i++){
                if(visited[i]==0){
                    canDouble = bfs(i,1);
                }
                if(!canDouble) break;
            }

            if(canDouble) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}