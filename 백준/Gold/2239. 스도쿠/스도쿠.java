import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
	static int grid[][];
	static boolean visited[];
	
	
	private static boolean canPut(int x,int y) {
		visited = new boolean[10];
		for(int i=0;i<9;i++) {
			if(grid[x][i]==0) continue;
			if(visited[grid[x][i]]) return false;
			visited[grid[x][i]]=true;
		}
		visited = new boolean[10];
		for(int i=0;i<9;i++) {
			if(grid[i][y]==0) continue;
			if(visited[grid[i][y]]) return false;
			visited[grid[i][y]]=true;
		}
		
		int tmpx = x/3;
		int tmpy = y/3;
		
		visited = new boolean[10];
		for(int i=tmpx*3;i<tmpx*3+3;i++) {
			for(int j=tmpy*3;j<tmpy*3+3;j++) {
				if(grid[i][j]==0) continue;
				if(visited[grid[i][j]]) return false;
				visited[grid[i][j]]=true;
			}
		}
		
		return true;
	}
	private static void backTracking(int cnt,int x,int y) {


		if(cnt==81) {
			for(int i=0;i<9;i++) {
				for(int j=0;j<9;j++) {
					System.out.print(grid[i][j]);
				}
				System.out.println();
			}
			System.exit(0);
		}
		
		if(grid[x][y]!=0) {
			if(y==8) {
				backTracking(cnt+1,x+1,0);
			}else {
				backTracking(cnt+1,x,y+1);
			}
			return;
		}
		
		for(int i=1;i<=9;i++) {
			grid[x][y]=i;

			if(canPut(x,y)){
				if(y==8) {
					backTracking(cnt+1,x+1,0);
				}else {
					backTracking(cnt+1,x,y+1);
					
				}
			}
			grid[x][y]=0;
		}
		
		
	}
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		grid = new int[9][9];
		for(int i=0;i<9;i++) {
			String strInput = br.readLine();
			for(int j=0;j<9;j++) {
				grid[i][j] = strInput.charAt(j)-'0';
			}
		}

		backTracking(0,0,0);
	}
}