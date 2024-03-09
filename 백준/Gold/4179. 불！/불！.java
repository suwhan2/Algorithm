import java.io.*;
import java.util.*;

class Pair{
	int x,y;

	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
}

public class Main {
	static int N;
	static int M;
	static char grid[][];
	static int visited[][];
	static int visited2[][];
	static int distance[][];
	static int distance2[][];
	static int ans=1000;
	static boolean excape=false;
	static Queue<Pair> fireQ = new LinkedList<>();
	static Queue<Pair> JihoonQ = new LinkedList<>();
	
	
	private static boolean inRange(int x, int y) {
		return 0<=x && x<N && 0<=y && y<M;
	}
	
	private static boolean fireCanGo(int x, int y) {
		if(!inRange(x,y)) return false;
		if(grid[x][y]=='#' || visited[x][y]==1) return false;
		return true;
	}
	private static boolean jihoonCanGo(int x, int y, int num) {
		if(!inRange(x,y)){
			if(ans>num+1) {
				ans=num+1;
				
			}
			
			excape=true;
			return false;
		}
		
		if(grid[x][y]=='#' || visited2[x][y]==1) return false;
		return true;
	}
	
	
	private static void firePush(int x, int y,int cnt) {
		distance[x][y]=cnt;
		visited[x][y]=1;
		fireQ.add(new Pair(x,y));
	}
	
	private static void jihoonPush(int x, int y,int cnt) {
		distance2[x][y]=cnt;
		visited2[x][y]=1;
		JihoonQ.add(new Pair(x,y));
	}
	private static void fireBFS() {
		int dx[] = new int[] {0,1,0,-1};
		int dy[] = new int[] {1,0,-1,0};
		
		while(!fireQ.isEmpty()) {
			Pair now = fireQ.poll();
			int x = now.x;
			int y= now.y;
			
			for(int i=0;i<4;i++) {
				int newX = x+ dx[i];
				int newY = y+ dy[i];
				
		
				if(fireCanGo(newX, newY)) {
					
					firePush(newX,newY,distance[x][y]+1);
				}
			}
		}
	}
	private static void jihoonBFS() {
		int dx[] = new int[] {0,1,0,-1};
		int dy[] = new int[] {1,0,-1,0};
		
		while(!JihoonQ.isEmpty()) {
			Pair now = JihoonQ.poll();
			int x = now.x;
			int y= now.y;
			
			for(int i=0;i<4;i++) {
				int newX = x+ dx[i];
				int newY = y+ dy[i];
				
					if(jihoonCanGo(newX, newY,distance2[x][y])) {
						if(distance[newX][newY]==-1||distance2[x][y]+1<distance[newX][newY]) {
							jihoonPush(newX,newY,distance2[x][y]+1);
						}
						
					}
						
				
			}

		}
	}
	
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		grid= new char[N][M];
		visited= new int[N][M];
		visited2 = new int[N][M];
		distance = new int[N][M];
		distance2 = new int[N][M];
		
		for(int i=0;i<N;i++) {
			String s= br.readLine();
			for(int j=0;j<M;j++) {
				grid[i][j] = s.charAt(j);
				distance[i][j]=-1;
				distance2[i][j]=-1;
				
				if(grid[i][j]=='F') {
					distance[i][j]=0;
					firePush(i, j, 0);
				}
				if(grid[i][j]=='J') {
					distance2[i][j]=0;
					jihoonPush(i, j, 0);
				}
				
			}
		}
		
		fireBFS();
		jihoonBFS();

		if(excape) {
			System.out.println(ans);
		}else {
			System.out.println("IMPOSSIBLE");
		}
	}
}

