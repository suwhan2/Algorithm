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
	static int T;

	static char grid[][];
	static int visited[][];
	static int count=0;
	static char p;

	
	static Queue<Pair> q = new LinkedList<>();
	
	private static boolean inRange(int x, int y) {
		return 0<=x && x<T && 0<=y && y<T;
	}
	private static boolean canGo(int x, int y) {
		if(!inRange(x,y)) return false;
		if(grid[x][y]!=p || visited[x][y]==1) return false;
		return true;
	}

	private static void push(int x, int y) {
		visited[x][y]=1;
		q.add(new Pair(x,y));
		
	}
	private static void BFS() {
		int dx[] = new int[] {0,1,0,-1};
		int dy[] = new int[] {1,0,-1,0};
		
		while(!q.isEmpty()) {
			Pair now = q.poll();
			int x = now.x;
			int y= now.y;
			
			for(int i=0;i<4;i++) {
				int newX = x+ dx[i];
				int newY = y+ dy[i];
				
				if(canGo(newX, newY)) {
					push(newX,newY);
				}
			}
		}
	}
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T= Integer.parseInt(br.readLine());
		
		grid= new char[T][T];
		visited= new int[T][T];
		for(int i=0;i<T;i++) {
			String strInput= br.readLine();
			for(int j=0;j<T;j++) {
				grid[i][j] = strInput.charAt(j);
			}
		}
		
		for(int i=0;i<T;i++) {
			for(int j=0;j<T;j++) {
				if(visited[i][j]==0) {
					p=grid[i][j];
					push(i,j);
					BFS();
					count+=1;
				}
			}
		}
		System.out.print(count+" ");
		count=0;
		
		for(int i=0;i<T;i++) {
			for(int j=0;j<T;j++) {
				visited[i][j]=0;
				if(grid[i][j]=='R') {
					grid[i][j]='G';
				}
			}
		}
		
		
		for(int i=0;i<T;i++) {
			for(int j=0;j<T;j++) {
				if(visited[i][j]==0) {
					p=grid[i][j];
					push(i,j);
					BFS();
					count+=1;
				}
			}
		}
		System.out.println(count);


		
		
	}
}

