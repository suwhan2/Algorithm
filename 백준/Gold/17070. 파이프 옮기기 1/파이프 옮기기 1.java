import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
	static int N,dir;
	static int count=0;
	static int room[][];
	static int dx1[] = new int[] {0,1};
	static int dy1[] = new int[] {1,1};
	static int dx2[] = new int[] {1,0,1};
	static int dy2[] = new int[] {0,1,1};
	static int dx3[] = new int[] {1,1};
	static int dy3[] = new int[] {0,1};
	
	private static boolean inRange(int x,int y) {
		return 0<=x && x<N && 0<=y && y<N;
	}
	private static boolean canGo(int x,int y,int dir) {
		if(!inRange(x,y)) return false;
		if(room[x][y]==1) return false;
		if(dir==2) {
			if(inRange(x-1,y) && room[x-1][y]==1) return false;
			if(inRange(x,y-1)&&room[x][y-1]==1) return false;
		}
		return true;
	}
	
	private static void pick(int dir,int x,int y, int cnt) {
		if(x==N-1 && y==N-1) { 
			count++;
			
		}
		if(cnt==2*(N-2)) {
			
			return;
		}
		
		if(dir==2) {
			for(int i=0;i<3;i++) {
					switch(i) {
					case 0:
						if(canGo(x+dx2[i],y+dy2[i],3)) {
							pick(3,x+dx2[i],y+dy2[i],cnt+1);
						}
						break;
					case 1:
						if(canGo(x+dx2[i],y+dy2[i],1)) {
							pick(1,x+dx2[i],y+dy2[i],cnt+1);
						}
						break;
					case 2:
						if(canGo(x+dx2[i],y+dy2[i],2)) {
							pick(2,x+dx2[i],y+dy2[i],cnt+1);
						}
						break;
					}
				
			}
		}
		else if(dir==1) {
			for(int i=0;i<2;i++) {
					switch(i) {
					case 0:
						if(canGo(x+dx1[i],y+dy1[i],1)) {
							pick(1,x+dx1[i],y+dy1[i],cnt+1);
						}
						break;
					case 1:
						if(canGo(x+dx1[i],y+dy1[i],2)) {
							pick(2,x+dx1[i],y+dy1[i],cnt+1);
						}
						break;
					}
				
			}
		}
		else {
			for(int i=0;i<2;i++) {
				
					switch(i) {
					case 0:
						if(canGo(x+dx3[i],y+dy3[i],3)) {
							pick(3,x+dx3[i],y+dy3[i],cnt+1);
						}
						break;
					case 1:
						if(canGo(x+dx3[i],y+dy3[i],2)) {
							pick(2,x+dx3[i],y+dy3[i],cnt+1);
						}
						break;
					}
				
			}
		}
		

	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		room = new int[N][N];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				room[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		pick(1,0,1,0);
		System.out.println(count);
		
	}
	
}
