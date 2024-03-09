
import java.io.*;
import java.util.*;

class Node{
    int to;
    Node next;

    public Node(int to, Node next) {
        this.to = to;
        this.next = next;
    }
}
public class Main {
    static int N,M;
    static Node adjList[];
    static boolean visited[];
    static int edgeCount[];
    static Queue<Integer> q = new ArrayDeque<>();

    private static void bfs(){
        while (!q.isEmpty()){
            int current = q.poll();
            System.out.print((current+1)+" ");

            for(Node tmp =adjList[current];tmp!=null;tmp=tmp.next){
                    edgeCount[tmp.to]--;
                    if(edgeCount[tmp.to]==0 && !visited[tmp.to]){
                        q.offer(tmp.to);
                        visited[tmp.to]=true;
                    }
                }
            }
        }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        adjList = new Node[N];
        visited = new boolean[N];
        edgeCount = new int[N];

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a =Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            adjList[a] = new Node(b,adjList[a]);
            edgeCount[b]++;
        }

        for(int i=0;i<N;i++){
            if(edgeCount[i]==0){
                q.offer(i);
                visited[i]=true;
            }
        }
        bfs();
    }
}
