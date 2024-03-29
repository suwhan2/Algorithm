import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
public class Main {
	static int N;
	static int arr[][];
	static int memo[];

	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		arr= new int[N+1][2];
		memo = new int[N+2];
		
		for(int i=1;i<=N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<2;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				
			}
		}
		for(int i=0;i<=N;i++) {
			arr[i][0]+=i;
		}
		
		for(int i=2;i<=N+1;i++) {
			int maxMemo=0;
			for(int j=1;j<i;j++) {
				if(arr[j][0]==i) {					
					maxMemo=Math.max(maxMemo, memo[j]+arr[j][1]);
				}
			}
			
			memo[i]=Math.max(memo[i-1],maxMemo);
			
		}
		System.out.println(memo[N+1]);
	}
}