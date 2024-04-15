import java.io.IOException;
import java.io.*;
import java.util.*;
public class Main {
	static int N;
	static int[] rope;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		rope = new int[N];
		for(int i=0;i<N;i++) {
			rope[i]=Integer.parseInt(br.readLine());
		}
		int ans=0;
		Arrays.sort(rope);
		for(int i=0;i<N;i++) {
			int tmp = rope[i] *(N-i);
			ans = Math.max(ans, tmp);
		}
		System.out.println(ans);
	}
}