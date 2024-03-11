import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair{
	int x,y,z,depth;

	public Pair(int x, int y,int z,int depth) {
		super();
		this.z=z;
		this.x = x;
		this.y = y;
		this.depth=depth;
	}
	
}
class Main{
	static int N,M,K;
	static int grid[][][];
	static int ans=Integer.MAX_VALUE;
	static int visited[][][];
	static int dx[] = new int[] {1,0,-1,0};
	static int dy[] = new int[] {0,1,0,-1};
	static Queue<Pair> q = new ArrayDeque<>();
	
	
	private static boolean inRange(int x,int y) {
		return 0<=x && x<N && 0<=y && y<M;
	}
	private static boolean canGo(int x,int y,int z) {
		if(!inRange(x,y)) return false;
		if(visited[z][x][y] >0 || grid[z][x][y]==1) return false;
		return true;
	}
	
	private static void bfs() {
		
		while(!q.isEmpty()) {
			Pair t = q.poll();
			int x= t.x;
			int y= t.y;
			int z = t.z;
			
			for(int i=0;i<4;i++) {
				int newX = x +dx[i];
				int newY = y +dy[i];
				if(canGo(newX,newY,z)) {
					visited[z][newX][newY]=t.depth+1;
					if(newX==N-1 && newY==M-1) {
						q.clear();
						break;
					}
					q.offer(new Pair(newX,newY,z,t.depth+1));
					
				}
				else if(inRange(newX,newY)&&grid[z][newX][newY]==1 && z<K-1&&visited[z+1][newX][newY]==0) {
					visited[z+1][newX][newY]=t.depth+1;
					if(newX==N-1 && newY==M-1) {
						q.clear();
						break;
					}
					q.offer(new Pair(newX,newY,z+1,t.depth+1));
				}
				
			}
		}
	}
	

	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken())+1;
		grid= new int[K][N][M];
		visited = new int[K][N][M];
		for(int i=0;i<N;i++) {
			String strInput = br.readLine();
			for(int j=0;j<M;j++) {
				for(int k=0;k<K;k++) {
					grid[k][i][j] = strInput.charAt(j)-'0';
				}
				
			}
		}
		
		q.offer(new Pair(0,0,0,1));
		visited[0][0][0]=1;
		bfs();

		
		for(int i=0;i<K;i++) {
			if(visited[i][N-1][M-1]>0) {
				ans=Math.min(ans, visited[i][N-1][M-1]);
			}
		}
		if(ans==Integer.MAX_VALUE) {
			ans=-1;
		}
		System.out.println(ans);

	}
}