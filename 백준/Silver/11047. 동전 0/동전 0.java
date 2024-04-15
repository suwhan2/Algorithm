import java.io.IOException;
import java.io.*;
import java.util.*;
public class Main {
	static int N,K;
	static int[] coin;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		coin = new int[N];
		for(int i=0;i<N;i++) {
			coin[i]=Integer.parseInt(br.readLine());
		}
		int ans=0;
		for(int i=N-1;i>=0;i--) {
			ans+=(K/coin[i]);
			K=K%coin[i];
			if(K==0) {
				break;
			}
		}
		System.out.println(ans);
	}
}