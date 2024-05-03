import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	static int N,M,K;
	static int ans=0;
	static int memo[][][];
	
	private static boolean inRange(int x,int y) {
		return 0<=x && x<=M && 0<=y && y<=K;
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		memo = new int[N][M+1][K+1];
		st= new StringTokenizer(br.readLine());
		int startM = Integer.parseInt(st.nextToken());
		int startK = Integer.parseInt(st.nextToken());
		
		if(inRange(startM,startK)) {
			memo[0][startM][startK]=1; 
			ans=1;
		}

		for(int i=1;i<N;i++) {
			st= new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			if(inRange(m,k)) {
				if(memo[i-1][m][k]==0) {
					memo[i][m][k]=1;
					ans=Math.max(ans,1);
				}
				
			}
			
			for(int j=0;j<M+1;j++) {
				for(int l=0;l<K+1;l++) {
					if(memo[i-1][j][l]!=0) {
						int tmpx = j+m;
						int tmpy = l+k;
						if(inRange(tmpx,tmpy)) {
							memo[i][tmpx][tmpy] = memo[i-1][j][l]+1;
							ans=Math.max(ans, memo[i][tmpx][tmpy]);
						}
						memo[i][j][l]=Math.max(memo[i-1][j][l],memo[i][j][l]);
						

					}
				}
				
			}
		}
		
		System.out.println(ans);
	}
}

