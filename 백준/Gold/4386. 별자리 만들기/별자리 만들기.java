import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Pair{
	double x,y;

	public Pair(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	
}
public class Main {
	static class Vertex implements Comparable<Vertex>{
		int no;
		double weight;

		public Vertex(int no, double weight) {
			super();
			this.no = no;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Vertex o) {
			return Double.compare(this.weight, o.weight);
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int V = Integer.parseInt(in.readLine());
		Pair arr[] = new Pair[V];
		double[][] adjMatrix = new double[V][V]; 
		boolean[] visited = new boolean[V]; 
		double[] minEdge = new double[V]; 
		
		
		for(int i=0;i<V;i++) {
			StringTokenizer st= new StringTokenizer(in.readLine());
			arr[i] = new Pair(Double.parseDouble(st.nextToken()),Double.parseDouble(st.nextToken()));
		}
		
		for(int i=0;i<V;i++) {
			for(int j=0;j<i;j++) {
				if(i==j) continue;
				if(adjMatrix[i][j]!=0) continue;
				adjMatrix[i][j] = adjMatrix[j][i] = Math.sqrt(Math.pow(Math.abs(arr[i].x-arr[j].x),2)+Math.pow(Math.abs(arr[i].y-arr[j].y),2));
				
			}
		}
		
		PriorityQueue<Vertex> pq = new PriorityQueue<>(); // ----------------------------------------------
		Arrays.fill(minEdge,Integer.MAX_VALUE); 
		minEdge[0]=0; 
		pq.offer(new Vertex(0,minEdge[0]));
		
		double result = 0; 
		int c=0;
		while(!pq.isEmpty()) {
			
			Vertex minVertex =pq.poll();
			if(visited[minVertex.no]) continue;
			
			result += minVertex.weight;
			visited[minVertex.no] =true;
			if(++c==V)break;

			for(int i=0;i<V;i++) {
				if(!visited[i] && adjMatrix[minVertex.no][i]!=0 
						&& adjMatrix[minVertex.no][i]<minEdge[i]) {
					minEdge[i] = adjMatrix[minVertex.no][i];
					pq.offer(new Vertex(i,minEdge[i]));
					
				}
			}
			
		}
		
		System.out.printf("%.2f",result);	
	}
}
