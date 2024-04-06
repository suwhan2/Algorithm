import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n,m;
    static int graph[][];
    static boolean visited[];

    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        graph = new int[n+1][n+1];
        visited = new boolean[n+1];
        StringTokenizer st;
        for(int i=0;i<m;i++){
            st= new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b]=1;
            graph[b][a]=1;
        }

        List<Integer> fl = new ArrayList<>();
        for(int i=2;i<n+1;i++){
            if(graph[1][i]==1){
                visited[i]=true;
                fl.add(i);
            }
        }

        for(int x : fl){
            for(int i=2;i<n+1;i++){
                if(graph[x][i]==1){
                    visited[i]=true;
                }
            }
        }
        int ans=0;
        for(int i=2;i<n+1;i++){
            if(visited[i]) ans++;
        }
        System.out.println(ans);
    }
}



