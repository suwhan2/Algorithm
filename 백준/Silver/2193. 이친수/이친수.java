import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static long memo[];
	private static long dp(int n) {
		if(memo[n]==0) {
			memo[n]= dp(n-1)+dp(n-2);
		}
		return memo[n];
	}
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N =Integer.parseInt(br.readLine());
		memo = new long[N];
		if(N>2) {
			memo[0]=1;
			memo[1]=1;
			System.out.println(dp(N-1));
		}else {
			System.out.println(1);
		}
    }
}