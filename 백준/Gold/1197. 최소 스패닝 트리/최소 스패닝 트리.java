
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge>{
	int a,b,weight;

	public Edge(int a, int b, int weight) {
		super();
		this.a = a;
		this.b = b;
		this.weight = weight;
	}

	@Override
	public int compareTo(Edge o) {
		return Integer.compare(this.weight, o.weight);
	}
	
	
}
class Main{
	static int V,E;
	static Edge edgeList[];
	static int parents[];
	
	
	private static void make() {
		for(int i=0;i<V;i++) {
			parents[i]=i;
		}
	}
	private static int find(int num) {
		if(parents[num]==num) return num;
		else return parents[num]=find(parents[num]);
	}
	
	private static boolean union(int a,int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return false;
		parents[bRoot]=aRoot;
		return true;
	}
	public static void main(String args[]) throws Exception{
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer st= new StringTokenizer(br.readLine());
		 V = Integer.parseInt(st.nextToken());
		 E = Integer.parseInt(st.nextToken());
		 parents = new int[V];
		 
		 edgeList = new Edge[E];
		 for(int i=0;i<E;i++) {
			 st = new StringTokenizer(br.readLine());
			 edgeList[i] = new Edge(Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken()));
			 
		 }
		 
		 Arrays.sort(edgeList);
		 make();
		 
		 int weight=0;
		 int cnt=0;
		 for(int i=0;i<E;i++) {
			 if(!union(edgeList[i].a,edgeList[i].b)) continue;
			 weight+=edgeList[i].weight;
			 if(++cnt==V-1) break;
		 }
		 
		 System.out.println(weight);
	}
}