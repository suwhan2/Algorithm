import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


class Pair{
    int x,y,z;
    public Pair(int x, int y,int z) {
        this.x = x;
        this.y= y;
        this.z=z;
    }
}


public class Main {
    static int N;
    static int M;
    static int H;
    static int grid[][][];
    static int visited[][][];
    static int distance[][][];
    static int tmp;
    static int minTime;
    static Queue<Pair> q = new LinkedList<>();

    //inRange
    private static boolean inRange(int x,int y,int z){
        return 0<=x && x<N && 0<=y && y<M&&0<=z && z<H;
    }

    //push
    private static void push(int x, int y,int z,int cnt){
        distance[z][x][y]=cnt;
        visited[z][x][y]=1;
        q.add(new Pair(x,y,z));
    }
    //canGo
    private static boolean canGo(int x,int y,int z){
        if(!inRange(x,y,z)) return false;
        if(visited[z][x][y]==1 || grid[z][x][y]==-1) return false;
        return true;
    }

    //bfs
    private static void BFS(){
        int dx[] = new int[]{1,0,-1,0,0,0};
        int dy[] = new int[]{0,1,0,-1,0,0};
        int dz[] = new int[]{0,0,0,0,1,-1};

        while(!q.isEmpty()){
            Pair now = q.poll();
            int x = now.x;
            int y= now.y;
            int z = now.z;
            
            for(int i=0;i<6;i++){
                int newX = x+dx[i];
                int newY = y+dy[i];
                int newZ = z+dz[i];

                if(canGo(newX,newY,newZ)){
                    push(newX,newY,newZ,distance[z][x][y]+1);
                }

            }
        }
    }


    public static void main(String[] args) throws NumberFormatException, IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        minTime=0;
        //입력부
        grid=new int[H][N][M];
        visited = new int[H][N][M];
    
        distance = new int[H][N][M];
        for(int k=0;k<H;k++) {
        	for(int i=0;i<N;i++) {
            	for(int j=0;j<M;j++) {
            		distance[k][i][j]=-1;
            	}
            }
        }
        
        
        for(int k=0;k<H;k++) {
        	for(int i=0;i<N;i++) {
        		StringTokenizer st2 = new StringTokenizer(br.readLine());
            	for(int j=0;j<M;j++) {
            		grid[k][i][j] = Integer.parseInt(st2.nextToken());
            	}
            }
        }

        int count=0;
        int oneCount=0;
        int count2=0;
        //기능부
        for(int k=0;k<H;k++) {
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(grid[k][i][j]==1){
                        push(i,j,k,0);  
                        oneCount+=1;
                    }
                    if(grid[k][i][j]==-1) {
                    	count+=1;

                }
            }
        }

        }
        
        
        BFS();
        for(int k=0;k<H;k++) {
	        for(int i=0;i<N;i++){
	            for(int j=0;j<M;j++){
	                if(distance[k][i][j]==-1){
	                    count2+=1;     
	                }
	                if(minTime<distance[k][i][j]) {
	                	minTime=distance[k][i][j];
	                }
	            }
	        }
        }
	        
        
        if(oneCount==N*M*H) {
        	System.out.println(0);
        }
        else if(count!=count2) {
        	System.out.println(-1);
        }else {
        	System.out.println(minTime);
        }
        

    
    }
}