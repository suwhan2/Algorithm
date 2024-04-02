import java.io.*;
public class Main {
	static int N;
	static long memo[][];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N =Integer.parseInt(br.readLine());
		memo= new long[N+1][10];
		for(int i=1;i<10;i++) memo[1][i]=1;
		for(int i=2;i<=N;i++) {
			for(int j=0;j<10;j++) {
				if(j==0) memo[i][j+1]=(memo[i][j+1]+memo[i-1][j])%1000000000;
			    else if(j==9) memo[i][j-1]=(memo[i][j-1]+memo[i-1][j])%1000000000;
                else {
					memo[i][j-1]=(memo[i][j-1]+memo[i-1][j])%1000000000;
					memo[i][j+1]=(memo[i][j+1]+memo[i-1][j])%1000000000;
				}
			}
		}
		long ans=0;
		for(int i=0;i<10;i++) {
			ans+=(memo[N][i]%1000000000);
		}
		System.out.println(ans%1000000000);
	}
}