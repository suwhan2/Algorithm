import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


class Pair{
    int x,y;
    public Pair(int x, int y) {
        this.x = x;
        this.y= y;
    }
}


public class Main {
    static int N;
    static int M;
    static int grid[][];
    static int visited[][];
    static int distance[][];
    static int tmp;
    static int minTime;
    static Queue<Pair> q = new LinkedList<>();

    //inRange
    private static boolean inRange(int x,int y){
        return 0<=x && x<N && 0<=y && y<M;
    }

    //push
    private static void push(int x, int y,int cnt){
        distance[x][y]=cnt;
        visited[x][y]=1;
        q.add(new Pair(x,y));
    }
    //canGo
    private static boolean canGo(int x,int y){
        if(!inRange(x,y)) return false;
        if(visited[x][y]==1 || grid[x][y]==-1) return false;
        return true;
    }

    //bfs
    private static void BFS(){
        int dx[] = new int[]{1,0,-1,0};
        int dy[] = new int[]{0,1,0,-1};

        while(!q.isEmpty()){
            Pair now = q.poll();
            int x = now.x;
            int y= now.y;

            for(int i=0;i<4;i++){
                int newX = x+dx[i];
                int newY = y+dy[i];

                if(canGo(newX,newY)){
                    push(newX,newY,distance[x][y]+1);
                }

            }
        }
    }


    public static void main(String[] args) throws NumberFormatException, IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        minTime=0;
        //입력부
        grid=new int[N][M];
        visited = new int[N][M];
        distance = new int[N][M];
        for(int i=0;i<N;i++) {
        	for(int j=0;j<M;j++) {
        		distance[i][j]=-1;
        	}
        }
        for(int i=0;i<N;i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                grid[i][j] = Integer.parseInt(st2.nextToken());
            }
        }
        int count=0;
        int oneCount=0;
        int count2=0;
        //기능부

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(grid[i][j]==1){
                    push(i,j,0);  
                    oneCount+=1;
                }
                if(grid[i][j]==-1) {
                	count+=1;

            }
        }
        }
        
        
        BFS();

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(distance[i][j]==-1){
                    count2+=1;     
                }
                if(minTime<distance[i][j]) {
                	minTime=distance[i][j];
                }
            }
        }
        
        
        if(oneCount==N*M) {
        	System.out.println(0);
        }
        else if(count!=count2) {
        	System.out.println(-1);
        }else {
        	System.out.println(minTime);
        }
        

    
    }
}