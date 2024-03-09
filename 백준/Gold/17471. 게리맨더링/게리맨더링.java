
import java.io.*;
import java.util.*;

public class Main {
    static int citizen[];
    static int grid[][];
    static int N,pickedPoint,notPickedPoint,visitedCount,dfs1Count,dfs2Count;
    static int totalCitizen=0;
    static int ans=Integer.MAX_VALUE;
    static boolean visited[],dfsVisited[];
    private static void dfs1(int index){
        dfsVisited[index]=true;

        for(int i=0;i<N;i++){
            if(grid[index][i]==1 && !dfsVisited[i] &&visited[i]){
                dfs1Count++;
                dfs1(i);
            }
        }
    }
    private static void dfs2(int index){
        dfsVisited[index]=true;
        for(int i=0;i<N;i++){
            if(grid[index][i]==1 && !dfsVisited[i] &&!visited[i]){
                dfs2Count++;
                dfs2(i);
            }
        }
    }
    private static void pick(int cnt, int NumOfPeople) {
        if(cnt==N) {
            visitedCount=0;
            for(int i=0;i<N;i++){
                if(visited[i]){
                    visitedCount++;
                    pickedPoint=i;
                }else {
                    notPickedPoint=i;
                }
            }
            if(visitedCount==N || visitedCount==0) {
                return;
            }

            if(canDivide()) {
                ans =Math.min(ans,Math.abs(totalCitizen-(2*NumOfPeople)));
            }
            return;
        }

        visited[cnt]=true;
        pickedPoint=cnt;
        pick(cnt+1,NumOfPeople+citizen[cnt]);

        visited[cnt]=false;
        notPickedPoint=cnt;
        pick(cnt+1,NumOfPeople);
    }
    private static boolean canDivide() {
        dfs1Count=1;
        dfs2Count=1;

        dfsVisited = new boolean[N];
        dfs1(pickedPoint);
        if(dfs1Count!=visitedCount) return false;

        dfsVisited = new boolean[N];
        dfs2(notPickedPoint);
        if(dfs2Count != (N-visitedCount)) return false;
        //bfs or dfs
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        grid =new int[N][N];
        citizen = new int[N];
        visited = new boolean[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            citizen[i] = Integer.parseInt(st.nextToken());
            totalCitizen += citizen[i];
        }
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            for(int j=0;j<m;j++) {
                int nearZone = Integer.parseInt(st.nextToken())-1;
                grid[i][nearZone] =1;
            }
        }
        pick(0,0);
        if(ans==Integer.MAX_VALUE) {
            System.out.println(-1);
        }else {
            System.out.println(ans);
        }

    }
}
