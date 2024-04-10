import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class NodeInfo{
    int out,in;
    public NodeInfo(int out, int in) {
        this.out = out;
        this.in = in;
    }
}
public class Main{
    static int N,M,ans;
    static int graph[][];
    static NodeInfo node[];
    static boolean visited[];
    static Queue<Integer> q= new ArrayDeque<>();

    private static void bfs(int n) {
        while(!q.isEmpty()) {
            int tmp =q.poll();
            for(int i=1;i<=N;i++) {
                if(graph[tmp][i]==1 && !visited[i]) {
                    q.offer(i);
                    node[n].out++;
                    node[i].in++;
                    visited[i]=true;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N+1][N+1];
        node = new NodeInfo[N+1];
        for(int i=1;i<=N;i++){
            node[i]=new NodeInfo(0,0);
        }
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[b][a]=1;
        }
        ans = 0;
        for(int i=1;i<=N;i++) {
            visited = new boolean[N + 1];
            visited[i] = true;
            q.offer(i);
            bfs(i);
        }
        for(int i=1;i<=N;i++){
            if(node[i].in>=((N/2)+1) ||node[i].out>=((N/2)+1)) {
                ans++;
            }
        }
        System.out.println(ans);
    }
}