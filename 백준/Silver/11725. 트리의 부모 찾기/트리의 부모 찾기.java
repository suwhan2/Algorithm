import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static boolean visited[];
    static List<ArrayList<Integer>> list = new ArrayList<>();
    static int parents[];
    static Queue<Integer> q = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N];
        parents = new int[N];
        for(int i=0;i<N;i++){
            list.add (new ArrayList<>());
        }
        for(int i=0;i<N-1;i++){
            StringTokenizer st= new StringTokenizer(br.readLine());
            int a =Integer.parseInt(st.nextToken())-1;
            int b =Integer.parseInt(st.nextToken())-1;
            list.get(a).add(b);
            list.get(b).add(a);
        }

        //bfs
        q.add(0);
        visited[0]=true;
        while(!q.isEmpty()){
            int x = q.poll();
            for(int n : list.get(x)){
                if(!visited[n]){
                    visited[n]=true;
                    q.offer(n);
                    parents[n]=x;
                }
            }
        }

        for(int i=1;i<N;i++){
            System.out.println(parents[i]+1);
        }
    }
}