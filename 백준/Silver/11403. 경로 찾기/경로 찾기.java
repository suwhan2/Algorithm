import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int graph[][],result[][];
    static boolean visited[];
    static Queue<Integer> q = new ArrayDeque<>();

    private static void bfs(int n){
        while(!q.isEmpty()){
            int friend = q.poll();
            for(int i=0;i<N;i++){
                if(graph[friend][i]==1 && !visited[i]){
                    visited[i]=true;
                    q.offer(i);
                    result[n][i]=1;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        graph = new int[N][N];
        visited = new boolean[N];
        StringTokenizer st;
        for(int i=0;i<N;i++){
            st= new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                graph[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        result=new int[N][N];

        for(int i=0;i<N;i++){
            visited = new boolean[N];
            q.offer(i);
            bfs(i);
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                System.out.print(result[i][j]+" ");
            }
            System.out.println();
        }
    }
}