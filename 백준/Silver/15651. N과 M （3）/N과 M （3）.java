import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//순열
public class Main {
	
	static int N;
	static int M;
	static int arr[];
	static int selected[];
	static boolean visited[];
	static StringBuilder sb;
	
	private static void simulation(int cnt) {
		if(cnt==M) {
			for(int x: selected) {
				sb.append(x+" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=0;i<N;i++) {
			selected[cnt]=arr[i];
			visited[i]=true;
			simulation(cnt+1);
			visited[i]=false;
		}
	}
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	sb = new StringBuilder();
    	arr = new int[N];
    	selected = new int[M];
    	visited = new boolean[N];
    	
    	for(int i=0;i<N;i++) {
    		arr[i]=i+1;
    	}
    	
    	simulation(0);
    	System.out.println(sb);
    }
}