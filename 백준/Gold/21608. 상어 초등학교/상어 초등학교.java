import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int info[][],grid[][];
	static int dx[] = new int[]{1,0,-1,0};
	static int dy[] = new int[] {0,1,0,-1};
	
	private static boolean inRange(int x,int y) {
		return 0<=x && x<N && 0<=y && y<N;
	}
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N =Integer.parseInt(br.readLine());
		info = new int[N*N][5];
		grid = new int[N][N];
		for(int i=0;i<N*N;i++) {
			StringTokenizer st= new StringTokenizer(br.readLine());
			for(int j=0;j<5;j++) {
				info[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		
		for(int i=0;i<(N*N);i++) {
			int num = info[i][0];
			
			int maxNoneSeatOfCanSit=0;
			int maxNoneSeat=0;
			int maxCanSit=0;
			int seatXOfCanSit=-1;
			int seatYOfCanSit=-1;
			int seatX=-1;
			int seatY=-1;
			
			for(int j=0;j<N;j++) {
				for(int k=0;k<N;k++) {
					if(grid[j][k]!=0) continue;
					int zeroCount=0;
					int canSit=0;
					for(int l=0;l<4;l++) {
						int newX = j+dx[l];
						int newY = k+dy[l];
						if(inRange(newX,newY)) {
							if(grid[newX][newY]==0) zeroCount++;
							else if (grid[newX][newY]==info[i][1] ||grid[newX][newY]==info[i][4]||grid[newX][newY]==info[i][2]||grid[newX][newY]==info[i][3]) {
								canSit++;
							}
						}
					}
					if(maxNoneSeat<zeroCount) {
						maxNoneSeat=zeroCount;
						seatX=j;
						seatY=k;
					}
					if(canSit>=maxCanSit) {
						if(canSit>maxCanSit) {
							maxCanSit=canSit;
							maxNoneSeatOfCanSit=zeroCount;
							seatXOfCanSit=j;
							seatYOfCanSit=k;
						}
						else if(canSit==maxCanSit) {
							if(maxNoneSeatOfCanSit<zeroCount) {
								maxNoneSeatOfCanSit=zeroCount;
								seatXOfCanSit=j;
								seatYOfCanSit=k;
							}
						}
					}
				}
			}
			if(seatXOfCanSit==-1 && seatX==-1) {
				
				boolean check=false;
				for(int q=0;q<N;q++) {
					for(int w=0;w<N;w++) {
						if(grid[q][w]==0) {
							grid[q][w]=num;
							check=true;
							break;
						}
					}
					if(check)break;
				}
			
			}else if(seatXOfCanSit==-1) {
				grid[seatX][seatY]=num;
			}
			else {
				grid[seatXOfCanSit][seatYOfCanSit]=num;
			}
		}
		int ans=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				int num = grid[i][j];
				for(int k=0;k<N*N;k++) {
					if(info[k][0]==num) {
						num=k;
						break;
					}	
				}
				int count=0;
				for(int k=0;k<4;k++) {
					int newX = i+dx[k];
					int newY = j+dy[k];
					if(inRange(newX,newY)) {
						if(grid[newX][newY]==info[num][1] ||grid[newX][newY]==info[num][4]||grid[newX][newY]==info[num][2]||grid[newX][newY]==info[num][3]) {
							count++;
						}
					}
				}
				if(count==1) ans+=1;
				if(count==2) ans+=10;
				if(count==3) ans+=100;
				if(count==4) ans+=1000;
			}
		}
		System.out.println(ans);	
    }
}