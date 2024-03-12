import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Position{
	int x,y,z;
	int dis;
	public Position(int x, int y, int z,int dis) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
		this.dis=dis;
	}
	
}
public class Main {
	static int L,R,C;
	static char grid[][][];
	static int visited[][][];
	static int dx[] =new int[] {1,0,-1,0,0,0};
	static int dy[] =new int[] {0,1,0,-1,0,0};
	static int dz[] =new int[] {0,0,0,0,1,-1};
	static Position start;
    static Position finish;
    static Queue<Position> q = new ArrayDeque<>();
	
    private static boolean inRange(int x,int y,int z) {
    	return 0<=x && x<R && 0<=y && y<C && 0<=z && z<L;
    }
    private static boolean canGo(int x,int y,int z) {
    	if(!inRange(x,y,z)) return false;
    	if(visited[z][x][y]!=-1 || grid[z][x][y]=='#') return false;
    	return true;
    }
    private static void bfs() {
    	while(!q.isEmpty()) {
    		Position tmp = q.poll();
    		int x =tmp.x;
    		int y = tmp.y;
    		int z = tmp.z;
    		for(int i=0;i<6;i++) {
    			int newX = x+dx[i];
    			int newY = y+dy[i];
    			int newZ = z+dz[i];
    			if(canGo(newX,newY,newZ)) {
    				visited[newZ][newX][newY]=tmp.dis+1;
    				q.offer(new Position(newX,newY,newZ,tmp.dis+1));
    			}
    		}
    	}
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
        	StringTokenizer st= new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
           
            if(L==0 && R==0 &&C==0) {
            	break;
            }
            grid = new char[L][R][C];
            visited = new int[L][R][C];
            for(int k=0;k<L;k++) {
            	for(int i=0;i<R;i++) {
            		String strInput = br.readLine();
                	for(int j=0;j<C;j++) {
                		visited[k][i][j] = -1;
                		grid[k][i][j] = strInput.charAt(j);
                		if(grid[k][i][j]=='S') {
                			start = new Position(i,j,k,0);
                		}
                		if(grid[k][i][j]=='E') {
                			finish = new Position(i,j,k,-1);
                		}
                	}
                }
            	String trash1 = br.readLine();
            	
            }
            
            visited[start.z][start.x][start.y] = 0;
            q.offer(start);
            bfs();
            
            
            if(visited[finish.z][finish.x][finish.y]==-1) {
            	System.out.println("Trapped!");
            }else {
            	System.out.println("Escaped in "+(visited[finish.z][finish.x][finish.y])+" minute(s).");
            }

        }
        
    }
}