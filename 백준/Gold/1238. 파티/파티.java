import java.util.*;
import java.io.*;
class Node{
    int index;
    int cost;

    public Node(int index, int cost) {
        this.index = index;
        this.cost = cost;
    }
}
public class Main{
    static int N,M,X;
    static int[] ans;
    static ArrayList<Node>[] graph;
    private static void Dijkstra(int n, int start){
        boolean[] check = new boolean[n + 1];
        int[] dist = new int[n + 1];
        int INF = Integer.MAX_VALUE;

        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<Node>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        pq.offer(new Node(start, 0));

        while(!pq.isEmpty()) {
            int nowVertex = pq.poll().index;

            if (check[nowVertex]) continue;
            check[nowVertex] = true;

            for (Node next : graph[nowVertex]) {
                if (dist[next.index] > dist[nowVertex] + next.cost) {
                    dist[next.index] = dist[nowVertex] + next.cost;

                    pq.offer(new Node(next.index, dist[next.index]));
                }
            }
        }

        if(start==X){
            for(int i=1;i<=N;i++) {
                if(i != INF) ans[i]+=dist[i];
            }
        }else{
            ans[start]+=dist[X];
        }


    }
    public static void main(String[] args)throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N =Integer.parseInt(st.nextToken());
        M =Integer.parseInt(st.nextToken());
        X =Integer.parseInt(st.nextToken());
        ans = new int[N+1];
        graph = new ArrayList[N+1];
        for (int i = 0; i <= N; i++)  graph[i] = new ArrayList<>();


        for(int i = 0 ; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[v].add(new Node(w, cost));
        }

        for(int i=1;i<=N;i++){
            Dijkstra(N,i);
        }

        int maxNum = 0 ;
        for(int x : ans){
            maxNum = Math.max(maxNum,x);
        }
        System.out.println(maxNum);

    }
}