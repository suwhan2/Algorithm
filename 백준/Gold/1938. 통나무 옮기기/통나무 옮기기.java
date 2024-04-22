import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

class Train{
	int x,y,z,time;

	public Train(int x, int y,int z,int time) {
		super();
		this.x = x;
		this.y = y;
		this.z=z;
		this.time=time;
	}
	
}
public class Main{
	static int N;
	static int ans=Integer.MAX_VALUE;
	static char grid[][];
	static boolean visited[][][];
	static Queue<Train> q = new ArrayDeque<>();
	static int dx[] = new int[] {1,0,-1,0};
	static int dy[] = new int[] {0,1,0,-1};
	
	private static boolean inRange2(int x,int y) {
		return 0<=x && x<N && 0<=y && y<N;
	}
	
	private static boolean inRange(int x,int y,int z) {

		if(z==0) {
			if(inRange2(x,y-1) && inRange2(x,y+1)) return true;
		}
		if(z==1) {
			if(inRange2(x+1,y) && inRange2(x-1,y)) return true;
		}
		return false;
	}
	private static boolean canGo(int x,int y,int z,int t) {
		if(!inRange(x,y,z)) {
			return false;
		}
		if(visited[z][x][y]) {
			return false;
		}
		if(t==4) {
			//정사각형검사
			if(grid[x][y]=='1'|| grid[x-1][y-1]=='1'||grid[x-1][y]=='1'||grid[x-1][y+1]=='1'
					|| grid[x][y-1]=='1'||grid[x][y+1]=='1'
					|| grid[x+1][y-1]=='1'||grid[x+1][y]=='1'|| grid[x+1][y+1]=='1') return false;

		}
		if(t!=4) {
			//1있는지 검사
			if(z==0) {
				if(grid[x][y]=='1'||grid[x][y-1]=='1'||grid[x][y+1]=='1') return false;
			}else {
				if(grid[x][y]=='1'||grid[x+1][y]=='1'||grid[x-1][y]=='1') return false;
			}
		}
		return true;
	}
	private static boolean check(int x,int y,int z) {
		if(z==0) {
			if(grid[x][y-1]=='E' && grid[x][y+1]=='E') return true;
		}else {
			if(grid[x-1][y]=='E' && grid[x+1][y]=='E') return true;
		}
		return false;
	}

	private static void bfs() {
		while(!q.isEmpty()) {
			Train tmp = q.poll();
			if(check(tmp.x,tmp.y,tmp.z)) {
				ans = Math.min(ans,tmp.time);
			}
			
			for(int i=0;i<5;i++) {
				if(i==4) {
					int newZ = Math.abs(tmp.z-1);
					if(canGo(tmp.x,tmp.y,newZ,i)) {
						visited[newZ][tmp.x][tmp.y]=true;
						q.offer(new Train(tmp.x,tmp.y,newZ,tmp.time+1));
					}
				}else {
					int newX=tmp.x+dx[i];
					int newY = tmp.y+dy[i];
					if(canGo(newX,newY,tmp.z,i)) {
						visited[tmp.z][newX][newY]=true;
						q.offer(new Train(newX,newY,tmp.z,tmp.time+1));
					}
				}
			}
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		grid =new char[N][N];
		visited = new boolean[2][N][N];
		int cnt=0;
		int tmp=0;
		for(int i=0;i<N;i++) {
			String strInput = br.readLine();
			for(int j=0;j<N;j++) {
				grid[i][j]= strInput.charAt(j);
				if(grid[i][j]=='B') {
					if(cnt==1) {
						if(i==tmp) {
							q.offer(new Train(i,j,0,0));
							visited[0][i][j]=true;
						}else {
							q.offer(new Train(i,j,1,0));
							visited[1][i][j]=true;
						}
					}
					cnt++;
					tmp=i;
				}

			}
		}
		
		bfs();
		if(ans==Integer.MAX_VALUE) {
			System.out.println(0);
		}else {
			System.out.println(ans);
		}
		
		
	}
}
