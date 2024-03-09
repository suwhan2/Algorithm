import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int room[][];
	static int ans;
	static int dir;
	static int dx[];
	static int dy[];
	private static boolean inRange(int x, int y) {
		return 0<=x && x<N&&0<=y&&y<M;
	}
	private static boolean canGo(int x,int y) {
		if(room[x][y]==1||room[x][y]==2) return false;
		return true;
	}
	private static boolean canGo2(int x,int y) {
		if(room[x][y]==1) return false;
		return true;
	}
	private static void clean(int x, int y) {
		room[x][y]=2;
		ans++;		
	}
	private static boolean checkClean(int x,int y) {

		if(inRange(x+1,y) && room[x+1][y]==0) {
			return true;
		}
		if(inRange(x,y+1) && room[x][y+1]==0) {
			return true;
		}
		if(inRange(x-1,y) && room[x-1][y]==0) {
			return true;
		}
		if(inRange(x,y-1) && room[x][y-1]==0) {
			return true;
		}

		return false;
	}
	private static void simulation(int x,int y) {
		clean(x,y);
		if(checkClean(x,y)) {
			for(int i=0;i<4;i++) {
				dir=(dir+1)%4;
				int newX=x+dx[dir];
				int newY=y+dy[dir];
				if(canGo(newX,newY)) {
					simulation(newX,newY);
				}
			}

		}else {
			x=x-dx[dir];
			y=y-dy[dir];
			if(canGo2(x,y)) {
				ans--;
				simulation(x,y);
			}else {
				System.out.println(ans);
				System.exit(0);
			}
		}
	}
	
	
    public static void main(String[] args) throws NumberFormatException, IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N =Integer.parseInt(st.nextToken());
        M =Integer.parseInt(st.nextToken());
        room = new int[N][M];
		dx =new int[] {1,0,-1,0};
		dy =new int[] {0,1,0,-1};
        
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int r= Integer.parseInt(st2.nextToken());
        int c= Integer.parseInt(st2.nextToken());
        int startDir = Integer.parseInt(st2.nextToken());
        if(startDir ==0) {
        	dir=2;
        }
        else if(startDir==1) {
        	dir=1;
        }
        else if(startDir==2) {
        	dir=0;
        }else {
        	dir=3;
        }
        
        
        for(int i=0;i<N;i++) {
        	StringTokenizer st3 = new StringTokenizer(br.readLine());
        	for(int j=0;j<M;j++) {
        		room[i][j]=Integer.parseInt(st3.nextToken());
        	}
        }
        
        simulation(r,c);

    }
}










