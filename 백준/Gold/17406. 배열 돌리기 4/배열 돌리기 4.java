import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class TurnInformation{
	int r,c,s;

	public TurnInformation(int r, int c, int s) {
		super();
		this.r = r;
		this.c = c;
		this.s = s;
		
		
	}
	
}
public class Main{
	static int N,M,K;
	static TurnInformation tiList[];
	static int grid[][],selected[];
	static boolean visited[];
	static int minimumGridSum = Integer.MAX_VALUE;
	static int dx[] = new int[] {1,0,-1,0};
	static int dy[] = new int[] {0,1,0,-1};
	
	private static void turn(TurnInformation t) {
		int startX = t.r-t.s-1;
		int startY = t.c-t.s-1;
		int endX = t.r+t.s-1;
		int endY = t.c+t.s-1;
		int p=2*(t.s);
		
		
		while(true) {
			if(p==0) break;
			int dir=0;
			int tmp = grid[startX][startY];
			int x = startX;
			int y = startY;
			for(int i=0;i<4;i++) {
				for(int j=0;j<p;j++) {
					int newX=x+dx[dir];
					int newY=y+dy[dir];
					grid[x][y] = grid[newX][newY]; 
					x=newX;
					y=newY;
				}
				dir++;
			}
			grid[startX][startY+1]=tmp;
			
			p-=2;
			startX++;
			startY++;
			
		}
		
		
	}
	private static void reverseTurn(TurnInformation t) {
		int startX = t.r-t.s-1;
		int startY = t.c-t.s-1;
		int endX = t.r+t.s-1;
		int endY = t.c+t.s-1;
		
		int p=2*(t.s);
		
		
		while(true) {
			if(p==0) break;
			int dir=1;
			int tmp = grid[startX][startY];
			int x = startX;
			int y = startY;
			for(int i=0;i<4;i++) {
				for(int j=0;j<p;j++) {
					int newX=x+dx[dir];
					int newY=y+dy[dir];
					grid[x][y] = grid[newX][newY]; 
					x=newX;
					y=newY;
				}
				dir--;
				if(dir<0) {
					dir=3;
				}
			}
			grid[startX+1][startY]=tmp;
			
			p-=2;
			startX++;
			startY++;
		}
			
	}
	private static int findGridSum() {
		int minAns=Integer.MAX_VALUE;
		for(int i=0;i<N;i++) {
			int count=0;
			for(int j=0;j<M;j++) {
				count += grid[i][j];
			}
			minAns = Math.min(minAns, count);
		}
		return minAns;
	}

	private static void backTracking(int cnt) {
		if(cnt==K) {
			int tmp =findGridSum();
			minimumGridSum = Math.min(minimumGridSum, tmp);

			return;
		}
		
		for(int i=0;i<K;i++) {
			if(visited[i]) continue;
			
			turn(tiList[i]);
			visited[i]=true;
			backTracking(cnt+1);
			reverseTurn(tiList[i]);
			visited[i]=false;

		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//입력부
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		tiList = new TurnInformation[K];
		grid = new int[N][M];
		selected = new int[K];
		visited = new boolean[K];
		for(int i=0;i<N;i++) {
			st= new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(br.readLine());
			tiList[i] = new TurnInformation(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		//기능부
		//무조건 다 뽑아야 하는 nPn의 경우에는 그냥 백트래킹 하기
		backTracking(0);
		
		//출력부
		System.out.println(minimumGridSum);

	}
	
}
