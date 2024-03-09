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
public class Main{
    static int N,sharkPositionX,sharkPositionY;;
    static int sizeOfBabyShark = 2;
    static int grid[][],distance[][];
    static int dx[] = new int[] {-1,0,0,1};
    static int dy[] = new int[] {0,-1,1,0};
    static int eatenAmount=0;
    static boolean visited[][];
    static int time=0;
    static Queue<Pair> q = new ArrayDeque<>();

    private static boolean inRange(int x,int y) {
        return 0<=x && x<N && 0<=y && y<N;
    }
    private static boolean canGo(int x,int y) {
        if(!inRange(x,y)) return false;
        if(visited[x][y] || grid[x][y]>sizeOfBabyShark) return false;
        return true;
    }
    private static void push(int x,int y,int c) {
        visited[x][y]=true;
        q.offer(new Pair (x,y));
        distance[x][y]=c;
    }

    private static int bfs() {
    	int ansx=N;
    	int ansy=N;
    	int depth =Integer.MAX_VALUE;
    	while(!q.isEmpty()){
            Pair tmp = q.poll();
            int x= tmp.x;
            int y= tmp.y;
            if(distance[x][y]>depth) 
            	return depth+1;

            for(int i=0;i<4;i++) {
                int newX = x+dx[i];
                int newY = y+dy[i];
                if(canGo(newX,newY)) {
                    if(grid[newX][newY]!=0 && grid[newX][newY]<sizeOfBabyShark) {
                    	depth = distance[x][y];
                    	if(newX<ansx) {
                    		sharkPositionX=newX;
                            sharkPositionY=newY;
                            ansx=sharkPositionX;
                            ansy =sharkPositionY;

                    	}else if(ansx == newX && ansy>newY) {
                    		sharkPositionX=newX;
                            sharkPositionY=newY;
                            ansx=sharkPositionX;
                            ansy =sharkPositionY;
                    	}

                    }
                    push(newX,newY,distance[x][y]+1);
                }
            }
        }
    	return 0;
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        grid = new int[N][N];
        visited = new boolean[N][N];
        int x=0;
        int y=0;
        for(int i=0;i<N;i++) {
            StringTokenizer st= new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                if(grid[i][j]==9) {
                    x=i;
                    y=j;
                    sharkPositionX=x;
                    sharkPositionY=y;
                }
            }
        }
        grid[x][y]=0;
        while(true) {
            visited = new boolean[N][N];
            distance = new int[N][N];
            push(x,y,0);
            int addTime =bfs();
            q.clear();

            if(x==sharkPositionX && y==sharkPositionY){
                System.out.println(time);
                break;
            }
            time+=addTime;
            eatenAmount++;

            if(eatenAmount==sizeOfBabyShark){
                eatenAmount=0;
                sizeOfBabyShark++;
            }
            grid[sharkPositionX][sharkPositionY]=0;
            x=sharkPositionX;
            y=sharkPositionY;
        }
    }
}