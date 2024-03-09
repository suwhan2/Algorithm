import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int numbers[];	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		numbers=new int[M];
		
		findNumSet(0,1);
		
	}
	
	private static void findNumSet(int cnt, int start) {
		if(cnt==M) {
			for(int t:numbers) {
				System.out.print(t+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=start;i<=N;i++) {

			numbers[cnt]=i;
			findNumSet(cnt+1,i+1);

		}
	}
	
}