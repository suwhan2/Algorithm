import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
	static int R;
	static int C;
	static char grid[][];
	static int visited[][];
	static int count=0;
	static boolean check=false;
	
	private static boolean inRange(int x,int y) {
		return 0<=x && x<R && 0<=y && y<C;
	}
	
	private static boolean canGo(int x,int y) {
		if(!inRange(x, y)) return false;
		if(visited[x][y]==1 || grid[x][y]=='x') return false;
		return true;
	}
	
	
	private static void DFS(int x,int y) {	
		int dx[] = new int[]{-1,0,1};
		int dy[] = new int[]{1,1,1};
		visited[x][y]=1;
			
		if(y==C-1) {
			//확정 후 끝내기
			count++;
			check=true;
			return;
				
		}
			
		if(!checking(x,y)) { //막히면
			return;
		}

		for(int i=0;i<3;i++) {
			int newX = x+dx[i];
			int newY = y+dy[i];
				
			if(canGo(newX,newY)){
				DFS(newX,newY);
				if(check) {
					break;
				}
			}
		}
	}
	
	private static boolean checking(int x, int y) {
		if(canGo(x+1,y+1) || canGo(x,y+1)|| canGo(x-1,y+1)) return true;
		return false;
	}
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	R= Integer.parseInt(st.nextToken());
    	C= Integer.parseInt(st.nextToken());
    	grid = new char[R][C];
    	visited = new int[R][C]; 
    	
    	for(int i=0;i<R;i++) {
    		String strInput = br.readLine();
    		for(int j=0;j<C;j++) {
    			grid[i][j] = strInput.charAt(j);
    		}
    	}
    	
    	for(int i=0;i<R;i++) {
    		
    		DFS(i,0);
    		check=false;

        	
    	}

    	System.out.println(count);    	
    }
}