import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Pair{
    int num,dis;

    public Pair(int num, int dis) {
        this.num = num;
        this.dis = dis;
    }
}
public class Main {
    static int N;
    static int lowScore;
    static int score[];
    static int graph[][],result[][];
    static boolean visited[];
    static Queue<Pair> q = new ArrayDeque<>();

    private static void bfs(int n){
        int maxDis=0;
        while(!q.isEmpty()){
            Pair tmp = q.poll();
            maxDis=Math.max(maxDis,tmp.dis);
            for(int i=1;i<N+1;i++){
                if(graph[tmp.num][i]==1 && !visited[i]){
                    visited[i]=true;
                    q.offer(new Pair(i,tmp.dis+1));
                }
            }
        }
        score[n]=maxDis;
    }

    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        graph = new int[N+1][N+1];
        score = new int[N+1];
        lowScore=Integer.MAX_VALUE;
        StringTokenizer st;

        while(true){
            st= new StringTokenizer(br.readLine());
            int a= Integer.parseInt(st.nextToken());
            int b= Integer.parseInt(st.nextToken());
            if(a==-1 && b==-1) break;
            graph[a][b]=1;
            graph[b][a]=1;
        }


        for(int i=1;i<N+1;i++){
            visited = new boolean[N+1];

            q.offer(new Pair(i,0));
            visited[i]=true;
            bfs(i);
            lowScore=Math.min(lowScore,score[i]);
        }

        List<Integer> result = new ArrayList<>();
        int cnt=0;
        for(int i=1;i<N+1;i++){
            if(score[i]==lowScore){
                result.add(i);
                cnt++;
            }
        }
        System.out.println(lowScore+" "+cnt);
        for(int x : result){
            System.out.print(x+" ");
        }

    }
}