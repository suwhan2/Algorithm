import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair{
	int x,y,startPoint;

	public Pair(int x,int y) {
		this.x=x;
		this.y=y;
	}
	
	public Pair(int x, int y,int startPoint) {
		super();
		this.x = x;
		this.y = y;
		this.startPoint=startPoint;
	}
}
public class Main{
	static int R,C,startx,starty,finishx,finishy;
	static char grid[][];
	static int visited[][];
	static Queue<Pair> q = new ArrayDeque<>();
	static Queue<Pair> q1 = new ArrayDeque<>();
	static Queue<Pair> q2 = new ArrayDeque<>();
	static Queue<Pair> newQ = new ArrayDeque<>();
	static Queue<Pair> newQ1 = new ArrayDeque<>();
	static Queue<Pair> newQ2 = new ArrayDeque<>();
	static int dx[] = new int[] {1,0,-1,0};
	static int dy[] = new int[] {0,1,0,-1};	
	static int time=0;
	
	private static boolean inRange(int x,int y) {
		return 0<=x && x<R && 0<=y && y<C;
	}
	
	private static boolean canGo(int x,int y,int startPoint) {
		if(!inRange(x,y)) return false;
		if(visited[x][y]==startPoint) return false;
		if(visited[x][y]==3) {
			return true;
		}
		
		if(visited[x][y]!=0 && visited[x][y]!=startPoint) {
				System.out.println(time);
				System.exit(0);
	
		}
		
		if(grid[x][y]=='X') {
			if(startPoint==1) {
				q1.offer(new Pair(x,y,startPoint));
			}else {
				q2.offer(new Pair(x,y,startPoint));
			}
			
			visited[x][y]=startPoint;
			grid[x][y]='.';
			return false;
		}
		return true;
	}
	private static boolean canGo2(int x,int y) {
		if(!inRange(x,y)) return false;
		if(visited[x][y]>0) return false;
		if(grid[x][y]=='X') {
			q.offer(new Pair(x,y));
			visited[x][y]=3;
			grid[x][y]='.';
			return false;
		}
		return true;
	}

	private static void bfs() {
		while(!newQ.isEmpty()) {
			Pair tmp = newQ.poll();
			int x= tmp.x;
			int y = tmp.y;
			for(int i=0;i<4;i++) {
				int newX = x+dx[i];
				int newY = y+dy[i];
				if(canGo2(newX,newY)) {
					visited[newX][newY]=3;
					newQ.offer(new Pair(newX,newY));
				}
			}
		}
	}
	private static void bfs1() {
		while(!newQ1.isEmpty()) {
			Pair tmp = newQ1.poll();
			int x= tmp.x;
			int y = tmp.y;
			for(int i=0;i<4;i++) {
				int newX = x+dx[i];
				int newY = y+dy[i];
				if(canGo(newX,newY,tmp.startPoint)) {
					visited[newX][newY]=tmp.startPoint;
					newQ1.offer(new Pair(newX,newY,tmp.startPoint));
				}
			}
		}
	}
	private static void bfs2() {
		while(!newQ2.isEmpty()) {
			Pair tmp = newQ2.poll();
			int x= tmp.x;
			int y = tmp.y;
			for(int i=0;i<4;i++) {
				int newX = x+dx[i];
				int newY = y+dy[i];
				if(canGo(newX,newY,tmp.startPoint)) {
					visited[newX][newY]=tmp.startPoint;
					newQ2.offer(new Pair(newX,newY,tmp.startPoint));
				}
			}
		}
	}
	private static void copyQueue(Queue a, Queue b) {
		while(!a.isEmpty()) {
			b.offer(a.poll());
		}
	}
	
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 	
        StringTokenizer st= new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        grid = new char[R][C];
        visited = new int[R][C];
  
        startx=-1;
        starty=-1;
        finishx=-1;
        finishy=-1;
      
        for(int i=0;i<R;i++) {
        	String strInput= br.readLine();
        	for(int j=0;j<C;j++) {
        		grid[i][j] = strInput.charAt(j);
        		if(grid[i][j]=='L') {
        			if(startx==-1) {
        				startx=i;
        				starty=j;
        				visited[i][j]=1;
        				newQ1.offer(new Pair(startx,starty,1));
        			}else {
        				finishx=i;
            			finishy=j;
            			visited[i][j]=2;
        		        newQ2.offer(new Pair(finishx,finishy,2));
        			}
        		}
        	}
        }
        
        
        
        bfs1();
        copyQueue(q1, newQ1);
        time++;
        bfs2();
        copyQueue(q2, newQ2);
        
        for(int i=0;i<R;i++) {
        	for(int j=0;j<C;j++) {
        		if(grid[i][j]=='.' && visited[i][j]==0) {
        			newQ.offer(new Pair(i,j));
        			bfs();
        		}
        	}
        }        
    	copyQueue(q, newQ);
        while(true) {      
        	
            bfs1();
            copyQueue(q1, newQ1);
            time++;
            bfs2();
            copyQueue(q2, newQ2);
            
        	bfs();
        	copyQueue(q, newQ);
        }
    }
}