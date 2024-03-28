import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.ArrayDeque;

class Pair{
	int x,y,time,k;
	public Pair(int x,int y,int time,int k) {
		this.x=x;
		this.y=y;
		this.k=k;
		this.time=time;
	}
}
public class Main {
	static int N,M;
	static char grid[][];
	static int goSumVisited[][];
	static int dx[] = new int[] {1,0,-1,0};
	static int dy[] = new int[] {0,1,0,-1};
	static Queue<Pair> q = new ArrayDeque<>();
	
	private static boolean inRange(int x,int y) {
		return 0<=x && x<N && 0<=y && y<M;
	}
	private static boolean waterCanGo(int x,int y) {
		if(!inRange(x,y)) return false;
		if(grid[x][y]=='*') return false;
		if(grid[x][y]=='X' || grid[x][y]=='D') return false;
		return true;
	}
	private static boolean goSumCanGo(int x,int y) {
		if(!inRange(x,y)) return false;
		if(goSumVisited[x][y]!=-1) return false;
		if(grid[x][y]=='X') return false;
		if(grid[x][y]=='*') return false;
		return true;
	}
	private static void bfs() {
		while(!q.isEmpty()) {
			Pair tmp = q.poll();
			int x = tmp.x;
			int y = tmp.y;
			if(tmp.k==1) {
				for(int i=0;i<4;i++) {
					int newX = x+dx[i];
					int newY = y+dy[i];
					if(goSumCanGo(newX,newY)) {
						goSumVisited[newX][newY]=tmp.time+1;
						q.offer(new Pair(newX,newY,tmp.time+1,1));
					}
				}
			}else {
				for(int i=0;i<4;i++) {
					int newX = x+dx[i];
					int newY = y+dy[i];
					if(waterCanGo(newX,newY)) {
						grid[newX][newY]='*';
						q.offer(new Pair(newX,newY,tmp.time+1,0));
					}
				}
			}
		}
	}
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N =Integer.parseInt(st.nextToken());
		M =Integer.parseInt(st.nextToken());
		grid=new char[N][M];
		goSumVisited = new int[N][M];
		Pair des=null;
		Pair startPoint=null;
		for(int i=0;i<N;i++) {
			String strInput = br.readLine();
			for(int j=0;j<M;j++) {
				goSumVisited[i][j]=-1;
				grid[i][j] = strInput.charAt(j);
				if(grid[i][j]=='S') {
					startPoint = new Pair(i,j,0,1);
					goSumVisited[i][j]=0;
				}
				else if(grid[i][j]=='*') {
					q.offer(new Pair(i,j,0,0));
				}
				else if(grid[i][j]=='D') des = new Pair(i,j,0,0);
			}
		}
		
		q.offer(startPoint);
		bfs();
		
		int x = des.x;
		int y = des.y;
		if(goSumVisited[x][y]==-1) {
			System.out.println("KAKTUS");
			
		}else {
			System.out.println(goSumVisited[x][y]);
		}
	}
}