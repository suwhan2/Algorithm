import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
public class Main {
	static int N,d,k,c;
	static int[] sushi,kind;
	static int maxKind=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		kind =new int[d+1];
		sushi = new int[N];
		for(int i=0;i<N;i++) {
			sushi[i]=Integer.parseInt(br.readLine());
		}
		Set<Integer> hs = new HashSet<>();
		for(int i=0;i<k;i++) {
			hs.add(sushi[i]);
			kind[sushi[i]]++;
		}
		hs.add(c);
		maxKind = Math.max(maxKind,hs.size());
		for(int i=1;i<N;i++) {
			kind[sushi[i-1]]--;
			if(kind[sushi[i-1]]==0) {
				hs.remove(sushi[i-1]);
				
				}
			hs.add(sushi[(i+k-1)%N]);
			kind[sushi[(i+k-1)%N]]++;
			hs.add(c);
			maxKind = Math.max(maxKind,hs.size());
		}
		System.out.println(maxKind);
	}
}
