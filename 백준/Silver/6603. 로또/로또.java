import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int k;
	static int arr[];
	static int pick[];
	private static void backTracking(int cnt,int startIdx) {
		if(cnt==6) {
			for(int x : pick) {
				System.out.print(x+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=startIdx;i<k;i++) {
			pick[cnt]=arr[i];
			backTracking(cnt+1,i+1);
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while(true) {
			st= new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			if(k==0) break;
			arr = new int[k];
			
			for(int i=0;i<k;i++) {
				arr[i]=Integer.parseInt(st.nextToken());
			}
			pick = new int[6];
			backTracking(0,0);
			System.out.println();
		}
	}
}

