import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Deque<Integer> dq = new LinkedList<>();
		for(int i=1;i<=N;i++) {
			dq.add(i);
		}
		
		StringTokenizer nums = new StringTokenizer(br.readLine(), " ");
		int ans=0;
		for(int i=0;i<M;i++) {
			
			int n =Integer.parseInt(nums.nextToken());
			
			int pushLeftCount=0;
			while(dq.getFirst()!=n) {
				dq.add(dq.removeFirst());
				pushLeftCount+=1;
			}
			
			if((dq.size()-pushLeftCount)<=pushLeftCount) {
				ans+=(dq.size()-pushLeftCount);
			}else {
				ans+=pushLeftCount;
			}
			dq.removeFirst();
		}
		System.out.println(ans);
	}
}





