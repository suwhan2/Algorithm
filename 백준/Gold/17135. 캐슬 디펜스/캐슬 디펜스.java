import java.io.*;
import java.util.*;

class Pair{
    int x,y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static int N,M,D;
    static int grid[][],tmp[][];
    static List<Pair> targetList;
    static boolean visited[][];
    static int dx[] = new int[]{0,-1,0};
    static int dy[] = new int[]{-1,0,1};
    static int selected[];
    static int playTime=0;
    static Queue<Pair> q = new ArrayDeque<>();
    static int largestEnemyRemoved=0;

    private static boolean inRange(int x, int y){
        return 0<=x&&x<N && 0<=y && y<M;
    }
    private static boolean canGo(int x,int y){
        if(!inRange(x,y)) return false;
        if(visited[x][y]) return  false;
        return true;
    }
    private static void bfs(int a,int b){
        while (!q.isEmpty()){
            Pair tmp1 =q.poll();
            int x=tmp1.x;
            int y = tmp1.y;


            if(tmp[x][y]==1){
                if((Math.abs(a-x)+Math.abs(b-y))<D){
                    targetList.add(new Pair(x,y));
                    break;
                }
                //삭제 리스트에 추가하기
            }
            for(int i=0;i<3;i++){
                int newX = x+dx[i];
                int newY = y+dy[i];
                if(canGo(newX,newY)){
                    visited[newX][newY]=true;
                    q.offer(new Pair(newX,newY));
                }
            }
        }
    }
    //내리는 함수
    private static void makeNextTurn(){
        for(int i=N-1;i>=0;i--){
            for(int j=0;j<M;j++){
                if(i==N-1){
                    if(tmp[i][j]==1) tmp[i][j]=0;
                }else{
                    if(tmp[i][j]==1){
                        tmp[i][j]=0;
                        tmp[i+1][j]=1;
                    }
                }
            }
        }
    }
    private static void simulation(){
        tmp = new int[N][M];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                tmp[i][j]=grid[i][j];
            }
        }

        int count=0;
        for(int i=0;i<playTime;i++){
            //지정 타킷을 저장할 자료구조
//            targetList = new ArrayList<>();
            for(int j=0;j<3;j++){
                visited = new boolean[N][M];
                q.offer(new Pair(N-1,selected[j]));
                bfs(N-1,selected[j]);
                q.clear();
                //selected에서 하나씩 꺼내서 거리확인 왼쪽부터
                //bfs쓰자
                //타깃 지정
            }
            //타깃 지정된것들 지우기
            for(Pair t: targetList){
                if(tmp[t.x][t.y]!=0){
                    tmp[t.x][t.y]=0;
                    // count++;
                    count++;
                }
            }
            targetList.clear();
            //내리기
            makeNextTurn();
        }
        largestEnemyRemoved = Math.max(largestEnemyRemoved,count);
    }
    private static void pick(int cnt, int startIdx){
        if(cnt==3){
            simulation();
            return;
        }
        for(int i=startIdx;i<M;i++){
            selected[cnt]=i;
            pick(cnt+1,i+1);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        grid = new int[N+1][M];
        selected = new int[3];
        targetList = new ArrayList<>();
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
                if(playTime==0 && grid[i][j]==1){
                    playTime=N-i;
                }
            }
        }
        //조합으로 M개의 자리중 3명의 궁수 자리 뽑기
        //뽑을때마다 시뮬후에 최댓갑 갱신
        pick(0,0);
        System.out.println(largestEnemyRemoved);
    }
}