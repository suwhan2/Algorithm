import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int person[];
	static boolean visited[];
	static List<Integer> bfsList;
	static Queue<Integer> q = new ArrayDeque<>();
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		person= new  int[N+1];
		visited = new boolean[N+1];
		bfsList = new ArrayList<>();
		List<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<N+1;i++) {
			graph.add(new ArrayList<>());
		}
		
		st= new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		for(int i=0;i<n;i++) {
			bfsList.add(Integer.parseInt(st.nextToken()));
		}
		
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			int start =Integer.parseInt(st.nextToken());
			person[start]++;
			
			for(int j=0;j<k-1;j++) {
				int p = Integer.parseInt(st.nextToken());
				graph.get(p).add(start);
				graph.get(start).add(p);
				start = p;
			}
		}
		for(int x : bfsList) {
			if(!visited[x]) {
				q.offer(x);
				person[x]=0;
				while(!q.isEmpty()) {
					int tmp = q.poll();
					for(int i=0;i<graph.get(tmp).size();i++) {
						int target = graph.get(tmp).get(i);
						if(visited[target]) continue;
						q.offer(target);
						visited[target]=true;
						person[target]=0;
					}
				}
			}
		}
		int ans=0;
		for(int i=0;i<N+1;i++) {
			ans+=person[i];
		}
		System.out.println(ans);
	}
}
