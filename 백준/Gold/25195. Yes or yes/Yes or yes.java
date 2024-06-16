import java.util.*;
import java.io.*;

class Node{
    int vertex;
    Node next;
    public Node(int vertex, Node next) {
        this.vertex = vertex;
        this.next = next;
    }
}
public class Main{
   static int N,M,S;
   static Node[] adjList;
   static int[] fan;
   static boolean check = false;
   private static void dfs(int current){
       if(fan[current]==1) return;
       if(adjList[current]==null){
            check=true;
            return;
       }
       for(Node tmp = adjList[current]; tmp!=null; tmp=tmp.next){
           dfs(tmp.vertex);
       }
   }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        adjList = new Node[N+1];
        fan = new int[100001];

        for(int i=0;i<M;i++){
            st= new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adjList[from] = new Node(to,adjList[from]);
        }

        S = Integer.parseInt(br.readLine());
        st= new StringTokenizer(br.readLine());
        for(int i=0;i<S;i++){
            fan[Integer.parseInt(st.nextToken())]=1;
        }

        if(fan[1]==1) System.out.println("Yes");
        else{
            dfs(1);
            System.out.println(check?"yes":"Yes");
        }
    }
}