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
	static int targetX;
	static int targetY;
	static char grid[][];
	static int visited[][];
	static int distance[][];
	static int ans=0;

	
	static Queue<Pair> q = new LinkedList<>();
	private static boolean inRange(int x, int y) {
		return 0<=x && x<N && 0<=y && y<N;
	}
	private static boolean canGo(int x, int y) {
		if(!inRange(x,y)) return false;
		if(visited[x][y]==1) return false;
		return true;
	}
	private static void push(int x, int y,int cnt) {
		if(x==targetX && y== targetY) {
			ans=cnt;
		}
		distance[x][y]=cnt;
		visited[x][y]=1;
		q.add(new Pair(x,y));
	}
	private static void BFS() {
		int dx[] = new int[] {2,2,1,-1,-2,-2,-1,1};
		int dy[] = new int[] {-1,1,2,2,1,-1,-2,-2};
		
		while(!q.isEmpty()) {
			Pair now = q.poll();
			int x = now.x;
			int y= now.y;
			
			for(int i=0;i<8;i++) {
				int newX = x+ dx[i];
				int newY = y+ dy[i];
				
				if(canGo(newX, newY)) {
					push(newX,newY,distance[x][y]+1);
				}
			}
		}
	}
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			N=Integer.parseInt(br.readLine());
			grid= new char[N][N];
			visited= new int[N][N];
			distance = new int[N][N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x= Integer.parseInt(st.nextToken());
			int y= Integer.parseInt(st.nextToken());
			
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			targetX = Integer.parseInt(st2.nextToken());
			targetY = Integer.parseInt(st2.nextToken());
			push(x,y,0);
			BFS();
			System.out.println(ans);
			ans=0;
			
		}
		
		


	}
}