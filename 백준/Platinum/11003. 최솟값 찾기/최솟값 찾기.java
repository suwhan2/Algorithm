import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Deque<int[]> dq = new ArrayDeque<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(st.nextToken());
			while(!dq.isEmpty() && dq.peekLast()[0] > num) { 
				dq.removeLast();
			}
			
			dq.addLast(new int[] {num,i});
			if(dq.peek()[1] < i-L+1){
				dq.removeFirst();
			}
			sb.append(dq.peek()[0]+" ");
			
		}
		System.out.println(sb);
	}
}