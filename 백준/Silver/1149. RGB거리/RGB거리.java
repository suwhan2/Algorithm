import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	static int N;
	static int price[][];
	static int[][] memo;
	
	private static int dp(int n) {
		for(int i=1;i<N;i++) {
			for(int j=0;j<3;j++) {
				switch(j) {
				case 0:
					memo[i][j]= price[i][j]+Math.min(memo[i-1][1],memo[i-1][2]);
					break;
				case 1:
					memo[i][j]= price[i][j]+Math.min(memo[i-1][0],memo[i-1][2]);
					break;
				case 2:
					memo[i][j]= price[i][j]+Math.min(memo[i-1][1],memo[i-1][0]);
					break;
					
				}
			}
		}
		
		int tmp =memo[n][0];
		for(int i=1;i<3;i++) {
			tmp = Math.min(tmp,memo[n][i]);
		}
		
		
		return tmp;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N =Integer.parseInt(br.readLine());
		price = new int[N][3];
		memo = new int[N][3];

		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<3;j++) {
				price[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		
		for(int i=0;i<3;i++) {
			memo[0][i]=price[0][i];
		}
		System.out.println(dp(N-1));

	}
}
