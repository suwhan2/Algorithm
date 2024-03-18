import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
class Pair{
	int x,y,z;
	int num;
	public Pair(int x, int y, int z,int num) {
		super();
		this.x = x;
		this.y = y;
		this.z=z;
		this.num = num;
		
	}
}

public class Main {
	static int K,W,H;
	static int ans=Integer.MAX_VALUE;
	static int[][][] grid;
	static int dx[] = new int[] {1,0,-1,0,-1,-2,-2,-1,1,2,2,1};
	static int dy[] = new int[] {0,1,0,-1,-2,-1,1,2,2,1,-1,-2};
	static boolean visited[][][];
	static Queue<Pair> q= new ArrayDeque<>();
	
	private static boolean inRange(int x,int y,int z) {
		return 0<=x && x<H && 0<=y && y<W && 0<=z && z<K;
	}
	private static boolean canGo(int x,int y,int z) {
		if(!inRange(x,y,z)) return false;
		if(visited[z][x][y] || grid[z][x][y]==1) return false;
		return true;
	}
	
	
	private static void bfs() {
		while(!q.isEmpty()) {
			Pair tmp = q.poll();
			int x = tmp.x;
			int y= tmp.y;
			
			if(x==(H-1) && y==(W-1)) { ans = Math.min(ans, tmp.num);}
			
			if(tmp.z<K-1) {
				for(int i=0;i<12;i++) {
					int newX= x+dx[i];
					int newY= y+dy[i];
					if(i>=4) {
						if(canGo(newX,newY,tmp.z+1)) {
							for(int k=tmp.z+1;k<K;k++) {
								visited[k][newX][newY]=true;
							}
							
							q.offer(new Pair(newX,newY,tmp.z+1,tmp.num+1));
						}
					}else {
						if(canGo(newX,newY,tmp.z)) {
							for(int k=tmp.z;k<K;k++) {
								visited[k][newX][newY]=true;
							}
							q.offer(new Pair(newX,newY,tmp.z,tmp.num+1));
						}
					}
				}
			}else {
				for(int i=0;i<4;i++) {
					int newX= x+dx[i];
					int newY= y+dy[i];
					if(canGo(newX,newY,tmp.z)) {
						visited[tmp.z][newX][newY]=true;
						q.offer(new Pair(newX,newY,tmp.z,tmp.num+1));
					}
				}
			}
			
		}
	}
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K =Integer.parseInt(br.readLine())+1;
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        grid = new int[K][H][W];
        visited = new boolean[K][H][W];
        
        for(int i=0;i<H;i++) {
        	st= new StringTokenizer(br.readLine());
        	for(int j=0;j<W;j++) {
        		int tmp =Integer.parseInt(st.nextToken());
        		for(int k=0;k<K;k++) {
        			grid[k][i][j] = tmp;
        		}
        	}
        }
        
        q.offer(new Pair(0,0,0,0));
        visited[0][0][0]=true;
        bfs();
        
   
        if(ans==Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(ans);
        
    }
}