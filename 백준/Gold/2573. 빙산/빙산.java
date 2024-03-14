import java.io.BufferedReader;
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
class Main{
	static int N,M,findCount;
	static int grid[][],tmp[][];
	static int startX,startY,ans,iceCount=0;
	static boolean visited[][];
	static int dx[] = new int[] {1,0,-1,0};
	static int dy[] = new int[] {0,1,0,-1};
	static Queue<Pair> q = new ArrayDeque<>();
	
	private static void bfs() {
		while(!q.isEmpty()) {
			Pair t = q.poll();
			int x= t.x;
			int y= t.y;
			for(int i=0;i<4;i++) {
				int newX = x +dx[i];
				int newY = y +dy[i];
				if(grid[newX][newY]==0) {
					tmp[x][y]++;
					continue;
				}
				if(!visited[newX][newY]){
					visited[newX][newY]=true;
					findCount++;
					q.offer(new Pair(newX,newY));	
				}
			}
		}
	}
	
	private static void erase() {
		boolean check = false;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(tmp[i][j]>0) {
					int a = grid[i][j]-tmp[i][j];
					if(a<=0) {
						grid[i][j]=0;
						iceCount--;
					}
					if(a>0)grid[i][j]=a;	
            }
		}
	}
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(grid[i][j]!=0) {
					startX =i;
					startY=j;
				}			
			}
		}
		q.offer(new Pair(startX,startY));	
	}
	
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		grid = new int[N][M];
		
		boolean check=false;
		for(int i=0;i<N;i++) {
			st= new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
				if(grid[i][j]!=0 && !check) {
					startX=i;
					startY=j;
					check=true;
				}
				if(grid[i][j]!=0) {
					iceCount++;
				}
			}
		}
		q.offer(new Pair(startX,startY));
		
		while(iceCount!=0) {
			visited = new boolean[N][M];
			tmp = new int[N][M];
			visited[startX][startY]=true;
			findCount=1;
			bfs();
			if(findCount!=iceCount) break;
			erase();
			ans++;
		}
		if(iceCount==0) ans=0;
		System.out.println(ans);
	}
}