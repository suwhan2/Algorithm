import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int selected[], arr[];
	static StringBuilder sb = new StringBuilder();
	private static void pick(int cnt,int start) {
		if(cnt==M) {
			for(int x : selected) {
				sb.append(x+" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=start;i<N;i++) {
			selected[cnt]=arr[i];
			pick(cnt+1,i);
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		selected = new int[M];
		arr = new int[N];
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st2.nextToken());
		}
		
		Arrays.sort(arr);
		
		pick(0,0);
		System.out.println(sb);
		
	}
}
