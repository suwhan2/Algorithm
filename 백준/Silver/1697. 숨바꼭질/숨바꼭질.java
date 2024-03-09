import java.io.*;
import java.util.*;


public class Main {
	static int N;
	static int K;
	static int visited[];
	static int time[];
	static int ans;
	static int tmp;
	static Queue<Integer> q = new LinkedList<>();
	
	
	private static boolean inRange(int x) {
		return 0<=x && x<100001;
	}
	
	private static boolean canGo(int x) {
		if(!inRange(x)) return false;
		if(visited[x]==1) return false;
		return true;
	}
	
	private static void push(int x,int cnt) {
		if(x==K) {
			ans=cnt;
		}
		time[x]=cnt;
		q.add(x);
		visited[x]=1;
		
	}
	
	private static void BFS() {
		int dx[] = new int[] {0,-1,1};
		
		while(!q.isEmpty()) {
			int x = q.poll();
			for(int i=0;i<3;i++) {
				if(i==0) {
					int newX=2*x;
					if(canGo(newX)) {
						push(newX,time[x]+1);
					}
				}else {
					int newX = x+dx[i];
					if(canGo(newX)) {
						push(newX,time[x]+1);
					}
				}
				
			}
		}
	}
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		visited=new int[100001];
		time=new int[100001];
		
		push(N,0);
		BFS();

	System.out.println(ans);
	}
}

