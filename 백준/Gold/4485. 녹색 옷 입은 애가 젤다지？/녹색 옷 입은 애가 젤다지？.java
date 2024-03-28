import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair{
	int x,y,re;
	
	public Pair(int x, int y,int re) {
	super();
	this.x = x;
	this.y = y;
	this.re=re;
	}
}
public class Main {
	static int N;
	static int grid[][];
	static boolean visited[][];
	static int minDis[][];
	static int dx[] = new int[] {0,1,0,-1};
	static int dy[] = new int[] {1,0,-1,0};
	static Queue<Pair> q = new ArrayDeque<>();
	
	private static boolean inRange(int x,int y) {
		return 0<=x && x<N && 0<=y && y<N;
	}
//	private static boolean canGo(int x,int y,int lastX,int lastY) {
//		if(!inRange(x,y)) return false;
//		if(minDis[x][y]==Integer.MAX_VALUE) return true;
//		if((grid[x][y]+minDis[lastX][lastY])<minDis[x][y]) return true;
//		return false;		
//		
//	}
	private static void bfs() {
		boolean checkFirst =true;
		while(!q.isEmpty()) {
			Pair tmp = q.poll();
			int x = tmp.x;
			int y= tmp.y;
			
			if(!checkFirst && tmp.re==0) {
				int minNum=Integer.MAX_VALUE;
				for(int i=0;i<4;i++) {
					int newX= x+dx[i];
					int newY = y+dy[i];
					
					if(inRange(newX,newY)) {
						if(minDis[newX][newY]==Integer.MAX_VALUE) continue;
						minNum=Math.min(minNum, minDis[newX][newY]);
					}
				}
				minDis[x][y]=grid[x][y]+minNum;
			}
			checkFirst=false;
//			for(int i=0;i<4;i++) {
//				int newX= x+dx[i];
//				int newY = y+dy[i];
//				if(canGo(newX,newY,x,y)) {
//					q.offer(new Pair(newX,newY));
//				}
//			}
			
			for(int i=0;i<4;i++) {
				int newX= x+dx[i];
				int newY = y+dy[i];
				if(inRange(newX,newY)) {
					if((grid[newX][newY]+minDis[x][y])<minDis[newX][newY]) {
						minDis[newX][newY]=grid[newX][newY]+minDis[x][y];
						q.offer(new Pair(newX,newY,1));
					}
				}
			}
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt=1;
		while(true) {
			N = Integer.parseInt(br.readLine());
			if(N==0) break;
			grid = new int[N][N];
			visited = new boolean[N][N];
			minDis = new int[N][N];
			
			StringTokenizer st ;
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					grid[i][j] = Integer.parseInt(st.nextToken());
					minDis[i][j]= Integer.MAX_VALUE;
				}
			}
			minDis[0][0] =grid[0][0];
			q.offer(new Pair(0,0,0));
			bfs();
			
			System.out.println("Problem "+cnt+": "+minDis[N-1][N-1]);
			cnt++;
		}
	}
}
