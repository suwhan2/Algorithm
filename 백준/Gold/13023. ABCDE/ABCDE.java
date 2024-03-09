import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static Node[] grid;
	static int visited[];
	static boolean can =false;
	
	static class Node{
		int vertex;
		Node next;
		public Node(int vertex, Node next) {
			super();
			this.vertex = vertex;
			this.next = next;
		}
	}
	private static void dfs(int cnt,int start) {
		if(cnt==4) {
			can =true;
			return;
		}
		visited[start]=1;
		for(Node i=grid[start];i!=null;i=i.next) {
			if(visited[i.vertex]==0) {
				dfs(cnt+1,i.vertex);
				visited[i.vertex]=0;
			}
			if(can) break;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		List<Integer> al = new ArrayList<>();
		grid = new Node[N];
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			grid[from] = new Node(to,grid[from]); 
			grid[to]= new Node(from,grid[to]);
		}

		for(int i=0;i<N;i++) {
			visited = new int[N];
			dfs(0,i);
			if(can)break;
		}
		
		
		if(can) {
			System.out.println(1);
		}else {
			System.out.println(0);
		}
	}
}