import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair{
    int x,y;
    public Pair(int x, int y) {
        super();
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static int N,M;
    static int grid[][];
    static boolean visited[][];
    static Queue<Pair> q = new ArrayDeque<>();
    static int dx[]= new int[] {1,0,-1,0};
    static int dy[] = new int[] {0,1,0,-1};
    static int rainbowBlock=0;

    private static boolean inRange(int x ,int y) {
        return 0<=x && x<N && 0<=y && y<N;
    }
    private static boolean canGo(int x,int y,int num) {
        if(!inRange(x,y)) return false;
        if(visited[x][y]) return false;
        if(grid[x][y]==-1 || grid[x][y]==-2) return false;
        if(grid[x][y]!=0 && grid[x][y]!=num) return false;
        return true;
    }
    private static int bfs(int num) {
        int count=1;
        while(!q.isEmpty()) {
            Pair tmp = q.poll();
            int x= tmp.x;
            int y= tmp.y;

            for(int i=0;i<4;i++) {
                int newX=x+dx[i];
                int newY=y+dy[i];
                if(canGo(newX,newY,num)) {
                    if(grid[newX][newY]==0) rainbowBlock++;
                    visited[newX][newY]=true;
                    count++;
                    q.offer(new Pair(newX,newY));
                }
            }
        }
        return count;
    }
    private static void drop() {
        for(int i=0;i<N;i++) {
            int tmp[] = new int[N];
            int index=N-1;
            for(int j=N-1;j>=0;j--) {
                if(grid[j][i]==-1) {
                    while(index!=j) {
                        tmp[index]=-2;
                        index--;
                    }
                    tmp[index]=grid[j][i];
                    index--;
                }else if(grid[j][i]!=-2) {
                    tmp[index]=grid[j][i];
                    index--;
                }
            }
            if(index>=0) {
                while(index!=0) {
                    tmp[index]=-2;
                    index--;
                }
                tmp[0]=-2;
            }
            for(int j=0;j<N;j++) {
                grid[j][i]=tmp[j];
            }
        }
    }
    private static void turn() {
        int tmp[][] =new int[N][N];
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                tmp[N-1-j][i]=grid[i][j];
            }
        }

        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                grid[i][j]=tmp[i][j];
            }
        }
    }
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N =Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        grid= new int[N][N];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                grid[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        int ans=0;
        while(true) {
            visited = new boolean[N][N];
            int maxSize=1;
            int maxX=-1;
            int maxY=-1;
            int maxRainbowBlock=0;
            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    if(visited[i][j]) continue;
                    if(grid[i][j]==-1 || grid[i][j]==0 || grid[i][j]==-2) continue;
                    visited[i][j]=true;
                    q.offer(new Pair(i,j));
                    int currentSize =bfs(grid[i][j]);
                    for(int k=0;k<N;k++){
                        for(int l=0;l<N;l++){
                            if(grid[k][l]==0) visited[k][l]=false;
                        }
                    }
                    if(maxSize<=currentSize && currentSize!=1) {
                        if(maxSize<currentSize) {
                            maxSize=currentSize;
                            maxRainbowBlock=rainbowBlock;
                            maxX=i;
                            maxY=j;
                        }
                        else if(maxSize==currentSize){
                            if(maxRainbowBlock<=rainbowBlock) {
                            	maxRainbowBlock=rainbowBlock;
	                              maxX=i;
	                              maxY=j;
                            }
                        }
                    }
                    rainbowBlock=0;
                }
            }
            if(maxX==-1) {
                break;
            }else {
                ans+=(maxSize*maxSize);
                visited =new boolean[N][N];
                visited[maxX][maxY]=true;
                q.offer(new Pair(maxX,maxY));
                int trash = bfs(grid[maxX][maxY]);
                for(int i=0;i<N;i++) {
                    for(int j=0;j<N;j++) {
                        if(visited[i][j])grid[i][j]=-2;
                    }
                }
                rainbowBlock=0;
                drop();
                turn();
                drop();
            }
        }
        System.out.println(ans);
    }
}