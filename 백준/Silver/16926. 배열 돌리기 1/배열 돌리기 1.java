import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int R;
	static int grid[][];
	static int visited[][];
	static int visited2[][];
	static int ans[][];
	static int dx[];
	static int dy[];

	
	private static boolean inRange(int x, int y) {
		return 0<=x && x<N && 0<=y && y<M;
	}
	
	private static boolean canGo(int x,int y) {
		if(!inRange(x,y)) return false;
		if(visited[x][y]==1) return false;
		return true;
	}
	
	private static boolean canGo2(int x,int y) {
		if(!inRange(x,y)) return false;
		if(visited2[x][y]==-1) return false;
		return true;
	}

	private static void writeAns(int x,int y,int dir) {
		int startx=x;
		int starty=y;
		int dir2=dir;
		
		for(int i=0;i<R;i++) {
			if(canGo2(x+dx[dir2],y+dy[dir2])) {
				x=x+dx[dir2];
				y=y+dy[dir2];
			}else {
				dir2=(dir2+1)%4;
				x=x+dx[dir2];
				y=y+dy[dir2];
			}
			
		}

		ans[x][y]=grid[startx][starty];
		
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//입력부
		StringTokenizer st= new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		grid = new int[N][M];
		ans = new int[N][M];
		visited =new int[N][M];
		visited2 =new int[N][M];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				grid[i][j]=Integer.parseInt(st2.nextToken());
			}
		}
		
		
		
		//기능부
		dx= new int[] {0,1,0,-1};
		dy = new int[] {-1,0,1,0};
		int dir=0;
		int cx = 0;
		int cy = M-1;
		
		
		while(true) {
			writeAns(cx, cy,dir);
			
			visited[cx][cy]=1;
			
			int newX = cx+dx[dir];
			int newY = cy+dy[dir];
			if(canGo(newX,newY)) {
				cx=newX;
				cy=newY;
			}else {
				dir = (dir+1)%4;
				if(canGo(cx+dx[dir],cy+dy[dir])) {
					cx=cx+dx[dir];
					cy=cy+dy[dir];
					if(dir==0) {
						for(int i=0;i<N;i++) {
							for(int j=0;j<M;j++) {
								if(ans[i][j]!=0) {
									visited2[i][j]=-1;
								}
							}
						}
					}
				}else {
					break;
				}
			}
		}

		
		//출력부
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				System.out.print(ans[i][j]+" ");
			}
			System.out.println();
		}
		
	}
    
}
