import java.util.*;
import java.io.*;

class Node{
    int idx, cost;
    public Node(int idx,int cost){
        this.idx=idx;
        this.cost=cost;
    }
}

public class Main{
    static int V,E;
    static List<ArrayList<Node>> graph;
    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        int start = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        for(int i=0;i<V+1;i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<E;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(s).add(new Node(e,c));
        }

        int[] dist = new int[V+1];
        for(int i=0;i<=V;i++){
            dist[i] = Integer.MAX_VALUE;
        }
        PriorityQueue<Node> q = new PriorityQueue<Node>((o1,o2) -> Integer.compare(o1.cost, o2.cost));
        q.offer(new Node(start,0));
        dist[start] = 0;
        while(!q.isEmpty()){
            Node curNode = q.poll();
            if(dist[curNode.idx] < curNode.cost){
                continue;
            }
            for(int i=0; i<graph.get(curNode.idx).size(); i++){
                Node nxtNode = graph.get(curNode.idx).get(i);
                if(dist[nxtNode.idx] > curNode.cost + nxtNode.cost){
                    dist[nxtNode.idx] = curNode.cost + nxtNode.cost;
                    q.offer(new Node(nxtNode.idx, dist[nxtNode.idx]));
                }
            }
        }

        for(int i=1;i<dist.length;i++){
            if(dist[i]==Integer.MAX_VALUE){
                System.out.println("INF");
            }else{
                System.out.println(dist[i]);
            }
        }

    }
}