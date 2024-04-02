import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static final int MOD = 1000000007;
	static int n, r, ans;
	public static void main(String[] args) throws IOException {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			run();
			System.out.println(ans);
		
	}
	static void run() {
		long numerator = 1;
		long denominator = 1;
		for (int i = 0; i < r; ++i) {
			numerator = (numerator * (n - i)) % MOD;
			denominator = (denominator * (r - i)) % MOD;
		}
		long denominatorRemainder = pow(denominator, MOD - 2);
		ans = (int) ((numerator * denominatorRemainder) % MOD);
	}
	static long pow(long num, long exponentiation) {
		if(exponentiation == 1) {
			return num;
		}
		long halfPow = pow(num, exponentiation/2);
		long res = halfPow * halfPow % MOD;
		if(exponentiation % 2 == 1) {
			res = res * num % MOD;
		}
		return res;
	}
}