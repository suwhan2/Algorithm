import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Fish{
	int num, dir;

	public Fish(int num, int dir) {
		super();
		this.num = num;
		this.dir = dir;
	}
	
}
class Pair{
	int x,y;

	public Pair(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
}
public class Main {
	static Fish[][] grid=new Fish[4][4];
	static int dx[] =new int[] {-1,-1,0,1,1,1,0,-1};
	static int dy[] =new int[] {0,-1,-1,-1,0,1,1,1};
	static int ans=0;
	static List<Pair> sharkCanMoveList = new ArrayList<>();
	
	private static void move(int x,int y) {
		int newX = x+dx[grid[x][y].dir];
		int newY = y+dy[grid[x][y].dir];
		if(grid[newX][newY]==null) {
			grid[newX][newY] = new Fish(grid[x][y].num,grid[x][y].dir);
			grid[x][y]=null;
		}else {
			Fish tmp = new Fish(grid[newX][newY].num,grid[newX][newY].dir);
			grid[newX][newY] = new Fish(grid[x][y].num,grid[x][y].dir);
			grid[x][y] = new Fish(tmp.num,tmp.dir);
		}
		

	}
	private static boolean canGoFish(int x,int y,int sharkx,int sharky) {
		if(!inRange(x,y)) return false;
		if(x==sharkx && y==sharky) return false;
		return true;
	}
	private static void moveFish(int sharkx,int sharky) {
		boolean check=false;
		for(int k=1;k<=16;k++) {
			check=false;
			for(int i=0;i<4;i++) {
				for(int j=0;j<4;j++) {
					if(grid[i][j]!=null &&grid[i][j].num==k) {
						//움직이기
						for(int l=0;l<8;l++) {
							if(canGoFish(i+dx[grid[i][j].dir],j+dy[grid[i][j].dir],sharkx,sharky)) {
								move(i,j);
								break;
							}else {
								grid[i][j].dir=(grid[i][j].dir+1)%8;
							}
						}

						check =true;
						break;
					}
				}
				if(check) break;
			}
		}
		
	}
	private static boolean inRange(int x,int y) {
		return 0<=x && x<4 && 0<=y && y<4;
	}
	private static List<Pair> sharkCanMove(int x,int y,int d) {
		
		List<Pair> sharkMoveList = new ArrayList<>();

		int newX=x+dx[d];
		int newY=y+dy[d];
		while(inRange(newX,newY)) {
			if(grid[newX][newY]!=null) {
				sharkMoveList.add(new Pair(newX,newY));
			}
			newX= newX+dx[d];
			newY= newY+dy[d];
		}
		
		return sharkMoveList;
	}
	
	private static void backTracking(int sharkX,int sharkY,int sharkDir,int eatenFish) {
		moveFish(sharkX,sharkY);
		List<Pair> sharkMove=sharkCanMove(sharkX,sharkY,sharkDir);
		if(sharkMove.size()==0) {
			ans=Math.max(ans, eatenFish);
			return;
		}
		Fish save[][] = new Fish[4][4];
		for(int q=0;q<4;q++) {
			for(int w=0;w<4;w++) {
				if(grid[q][w]!=null) {
					save[q][w]= new Fish(grid[q][w].num,grid[q][w].dir);
				}
				if(grid[q][w]==null) {
					save[q][w]=null;
				}
				
			}
		}
		
		for(Pair i : sharkMove) {
			int newX = i.x;
			int newY = i.y;
			int dir = grid[newX][newY].dir;
			int num = grid[newX][newY].num;
			grid[newX][newY]=null;
			backTracking(newX,newY,dir,eatenFish+num);
			//물고기 움직인거 원위치
			for(int q=0;q<4;q++) {
				for(int w=0;w<4;w++) {
					if(save[q][w]!=null) {
						grid[q][w]= new Fish(save[q][w].num,save[q][w].dir);
					}
					if(save[q][w]==null) {
						grid[q][w]=null;
					}
				}
			}
		}
		
		
	}
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        grid = new Fish[4][4];
        
        for(int i=0;i<4;i++) {
        	StringTokenizer st= new StringTokenizer(br.readLine());
        	for(int j=0;j<4;j++) {
        		int tmpNum = Integer.parseInt(st.nextToken());
        		int tmpDir = Integer.parseInt(st.nextToken())-1;
        		grid[i][j] = new Fish(tmpNum,tmpDir);
        	}
        }

        int tmp =grid[0][0].dir;
        int tmpNum = grid[0][0].num;
        grid[0][0]=null;
        backTracking(0,0,tmp,tmpNum);
        System.out.println(ans);
    }
}