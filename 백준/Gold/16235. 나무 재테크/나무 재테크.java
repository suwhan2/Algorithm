import java.io.*;
import java.util.*;

// 3000만
// 같은 격자에 여러 나무 가능 , 최대 100개
// 10x10  -> 작다 -> pq 100개 만들기 가능 -> 전체 하나의 pq로 관리가능?
// 1000년이라 수도 없이 늘어날 수 있음


// 봄 : pq 순회 -> 최대 100
class Tree{
    int x,y,age;
    public Tree(int x, int y, int age) {
        this.x = x;
        this.y = y;
        this.age = age;
    }
}

public class Main{
    static int N,M,K;
    static int[][] grid;
    static int[][] A;
    static int[] dx = new int[]{1,0,-1,0,1,-1,1,-1};
    static int[] dy = new int[]{0,1,0,-1,1,-1,-1,1};
    static PriorityQueue<Tree> pq;
    static List<Tree> deadList;
    static List<Tree> breedList;

    private static void spring(){
        List<Tree> tmp = new ArrayList<>();

        while(!pq.isEmpty()){
            Tree cur = pq.poll();

            if(grid[cur.x][cur.y]>=cur.age){
                grid[cur.x][cur.y]-=cur.age;
                tmp.add(new Tree(cur.x,cur.y,cur.age+1));

            }else{
                deadList.add(new Tree(cur.x,cur.y,cur.age));
            }
        }

        for(Tree t : tmp){
            if(t.age%5==0){
                breedList.add(new Tree(t.x,t.y,t.age));
            }
            pq.add(new Tree(t.x,t.y,t.age));
        }
    }

    private static void summer(){
        for(Tree t : deadList){
            grid[t.x][t.y]+=(t.age/2);
        }
        deadList.clear();
    }
    private static void fall(){
        for(Tree t :breedList){
            int x = t.x;
            int y = t.y;

            for(int i=0;i<8;i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(inRange(nx,ny)) pq.add(new Tree(nx,ny,1));
            }

        }
        breedList.clear();
    }
    private static void winter(){
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                grid[i][j]+=A[i][j];
            }
        }
    }

    private static boolean inRange(int x,int y){
        return 0<=x && x<N && 0<=y && y<N;
    }


    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        grid = new int[N][N];
        A = new int[N][N];
        pq = new PriorityQueue<Tree>((o1, o2) -> Integer.compare(o1.age, o2.age));
        deadList = new ArrayList<>();
        breedList = new ArrayList<>();
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                A[i][j] = Integer.parseInt(st.nextToken());
                grid[i][j] = 5;
            }
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            int z = Integer.parseInt(st.nextToken());
            pq.add(new Tree(x,y,z));
        }


        for(int i=0;i<K;i++){
            spring();
            summer();
            fall();
            winter();
        }

        System.out.println(pq.size());

    }
}