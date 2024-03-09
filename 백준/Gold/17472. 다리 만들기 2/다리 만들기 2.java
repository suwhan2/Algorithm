import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

class Bridge implements Comparable<Bridge>{
	int from,to,distance;

	public Bridge(int from, int to, int distance) {
		super();
		this.from = from;
		this.to = to;
		this.distance = distance;
	}

	@Override
	public int compareTo(Bridge o) {
		
		return Integer.compare(this.distance,o.distance);
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
public class Main{
	static int N,M,landNum;
	static int grid[][];
	static boolean visited[][];
	static int parents[];
	static int dx[] = new int[] {1,0,-1,0};
	static int dy[] = new int[] {0,1,0,-1};
	static int dir=0;
	static Bridge bridgeList[];
	static Queue<Pair> q = new ArrayDeque<>();
	static int EList[][];
	
	private static boolean inRange(int x,int y) {
		return 0<=x && x<N&&0<=y && y<M;
	}
	private static boolean canGo(int x,int y) {
		if(!inRange(x,y)) return false;
		if(visited[x][y] || grid[x][y]==0) return false;
		return true;
	}
	private static void push(int x,int y, int num) {
		visited[x][y]=true;
		grid[x][y]=num;
	}
	
	private static void dfs(int x,int y) {
			for(int i=0;i<4;i++) {
				int newX = x+dx[i];
				int newY = y+dy[i];
				if(canGo(newX,newY)) {
					push(newX,newY,landNum);
					dfs(newX,newY);
				}
			}
		
	}
	
	private static boolean canGo2(int x,int y,int d,int value) {
		if(!inRange(x,y)) return false;
		if(visited[x][y] || grid[x][y]==value) return false;
		if(grid[x][y]!=0) {
			//from: value to:grid[x][y] distance:d 간선만들기
			if(EList[value][grid[x][y]]>d && d>1) {
				EList[value][grid[x][y]]=d;
			}
			return false;
		}
		return true;
	}	
	private static void dfs2(int x,int y,int d,int value) {
				int newX = x+dx[dir];
				int newY = y+dy[dir];
				if(canGo2(newX,newY,d+1,value)) {
					visited[newX][newY]=true;
					dfs2(newX,newY,d+1,value);
				}else{	
					return;
				}
	}
	//uninon-find
	private static void make() {
		parents = new int[landNum];
		for(int i=1;i<=landNum-1;i++) {
			parents[i]=i;
		}
	}
	private static int find(int a) {
		if(a==parents[a])return a;
		return parents[a] = find(parents[a]);
	}
	private static boolean union(int a,int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return false;
		parents[bRoot] = aRoot;
		return true;
	}
	
	
	
	
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        grid = new int[N][M];
        visited = new boolean[N][M];

             
        
        for(int i=0;i<N;i++) {
        	st= new StringTokenizer(br.readLine());
        	for(int j=0;j<M;j++) {
        		grid[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        //섬표시하기
        //섬의 갯수는 landNum-1
        landNum=1;
        for(int i=0;i<N;i++) {
        	for(int j=0;j<M;j++) {
        		if(grid[i][j]==1 && !visited[i][j]) {
        			push(i,j,landNum);
        			dfs(i,j);
        			landNum++;
        		}
        	}
        }
        
        EList = new int[landNum][landNum];
        for(int i=0;i<landNum;i++) {
        	for(int j=0;j<landNum;j++) {
        		EList[i][j]=100;
        	}
        }
                
//        for(int i=0;i<N;i++) {
//        	for(int j=0;j<M;j++) {
//        		System.out.print(grid[i][j]+" ");
//        	}
//        	System.out.println();
//        }
        //간선 찾기
        
        for(int i=0;i<N;i++) {
        	for(int j=0;j<M;j++) {
        		if(grid[i][j]!=0) {
        			visited = new boolean[N][M];
        			visited[i][j]=true;
        			for(int k=0;k<4;k++) {
        				dir=k;
        				dfs2(i,j,-1,grid[i][j]);
        			}
        		}
        	}
        
        }
//        
//        System.out.println("ELIST----------------------");
//        for(int i=0;i<N;i++) {
//        	for(int j=0;j<M;j++) {
//        		System.out.print(EList[i][j]+" ");
//        	}
//        	System.out.println();
//        }
//        

       
        int count=0;
        for(int i=1;i<landNum;i++) {
        	for(int j=i+1;j<landNum;j++) {
        		if(EList[i][j]!=100) {
        			//to-do브릿지 추가하기
        			count++;
        		}
        	}
        }
//        System.out.println(count);
        int p=0;
        bridgeList = new Bridge[count];
//        System.out.println("Only ELIST----------------------");
        for(int i=1;i<landNum;i++) {
        	for(int j=i+1;j<landNum;j++) {
        		if(EList[i][j]!=100) {
        			//to-do브릿지 추가하기
        			bridgeList[p] =new Bridge(i, j, EList[i][j]);
        			p++;
//        			System.out.println(i+" "+j+" "+EList[i][j]);
        		}
        	}
        }
        
        if(count==0) {
        	System.out.println(-1);
        	System.exit(0);
        }
        
        Arrays.sort(bridgeList);
//        System.out.println("BridgeInfo------------------------");
//        for(Bridge x : bridgeList) {
//        	System.out.println(x.from+" "+x.to+" "+x.distance);
//        }
//        
        make();
        int distance =0;
        int cnt=0;
        for(Bridge bridge : bridgeList) {
        	if(!union(bridge.from,bridge.to)) continue;
        	distance +=bridge.distance;
        	if(++cnt == landNum-2) break;
        }
        
        if(cnt!=(landNum-2)) {
        	System.out.println(-1);
        }else {
        	System.out.println(distance);
        }
        
        //그래프 탐색해서 모두 연결될때까지 시도
        //union-find
        //mst
       
        // 1. 각섬을 이을 수 있다면 거리를 가중치고 그래프 만들기
        // 2. mst 찾기 
        // 3. union-find 크루스칼
        
        //다리를 만드는 조건 
        //1. 좌표 두개를 비교했을때 x나y가 같다.
        //2. 거리가 2이상이다.
        //3. 비교할 좌표는 섬의 가장자리만
        //4. 가장 작은 거리의 다리로 만들기
        
        //만들수있으면 다만들어놓고 크루스컬 돌리기
       
    }
}

