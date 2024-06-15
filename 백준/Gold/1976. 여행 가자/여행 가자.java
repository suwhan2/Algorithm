import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[][] grid;
    static int[] plan;
    static boolean[] visited;
    static Queue<Integer> q = new ArrayDeque<>();
    
    private static void tour(){
            while(!q.isEmpty()){
                int current = q.poll();
                for(int i=0;i<N;i++){
                    if(grid[current][i]==1 && !visited[i]){
                        q.offer(i);
                        visited[i] = true;
                    }
                }
            }
    }

    public static void main(String[] args) throws IOException {
        // 입력부
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        plan = new int[M];
        grid = new int[N][N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++){
            plan[i] = Integer.parseInt(st.nextToken());
        }
        // 구현부
        q.offer(plan[0]-1);
        visited[plan[0]-1]=true;
        tour();
        //출력부
        for(int x : plan){
            if(!visited[x-1]){
                System.out.println("NO");
                System.exit(0);
            }
        }
        System.out.println("YES");
    }
}