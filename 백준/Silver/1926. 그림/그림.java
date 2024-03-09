import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair{
	int x,y;
	public Pair(int x, int y) {
		this.x =x;
		this.y=y;
	}
}

public class Main {
	static int n;
	static int m;
	
	public static int visited[][];
	public static Queue<Pair> q = new LinkedList<>();
	public static int maxAreaSize =0;
	public static int num;
	public static int grid[][];
	public static int ans=0;
	
	public static boolean inRange(int x, int y) {
		return 0<=x &&x<n && 0<=y && y<m;
	}
	
	public static void push(int x,int y){
		num++;
		visited[x][y]=1;
		q.add(new Pair(x,y));
	}
	
	public static boolean canGo(int x,int y) {
		if(!inRange(x, y)) return false;
		if(visited[x][y]==1 || grid[x][y]==0) return false;
		return true;
	}
	
	public static void BFS() {
		int []dx = new int[] {1,0,-1,0};
		int []dy = new int[] {0,1,0,-1};
		
		while(!q.isEmpty()) {
			Pair curr = q.poll();
			int x = curr.x;
			int y= curr.y;
			
			for(int i=0;i<4;i++) {
				int newX = x+dx[i];
				int newY = y+dy[i];
				if(canGo(newX,newY)) {
					push(newX,newY);
				}
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		grid = new int[n][m];
		visited = new int[n][m];
		
		for(int i=0;i<n;i++) {
			String[] s = br.readLine().split(" ");
			for(int j=0;j<m;j++) {
				grid[i][j] = Integer.parseInt(s[j]);
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(grid[i][j]==1 && visited[i][j]==0) {
					num=0;
					ans++;
					push(i,j);
					BFS();
					if(num>maxAreaSize) {
						maxAreaSize=num;
					}
				}
			}
		}
		
		System.out.println(ans);
		System.out.println(maxAreaSize);
		
		
		
	}
}