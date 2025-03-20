import java.util.*;
import java.io.*;

public class Main {
    static int N,M;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        boolean[] visited = new boolean[N+1];
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<=N;i++){
            graph.add(new ArrayList<>());
        }

        StringTokenizer st;
        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        visited[1]=true;
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(1);
        int cnt=0;
        while(!q.isEmpty()){
            int tmp = q.poll();

            for(int cur : graph.get(tmp)){
                if(!visited[cur]){
                    q.offer(cur);
                    visited[cur]=true;
                    cnt++;
                }
            }
        }
        System.out.println(cnt);


    }
}