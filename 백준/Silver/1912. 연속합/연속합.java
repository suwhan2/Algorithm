import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int arr[];
	static long memo[];
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N =Integer.parseInt(br.readLine());
		arr = new int[N];
		memo = new long[N];
		StringTokenizer st= new StringTokenizer(br.readLine());
		long ans=Long.MIN_VALUE;
		int check=0;
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
			if(arr[i]<0) check++; 
			memo[i]= Long.MIN_VALUE;
		}
		if(check==N) {
			Long m = Long.MIN_VALUE;
			for(int i=0;i<N;i++) {
				m=Math.max(m, arr[i]);
			}
			System.out.println(m);
		}else {
			if(N==1) {
				if (arr[N-1]>0) {
					memo[N-1]=arr[N-1];
				}else {
					memo[N-1]=0;
				}
				System.out.println(memo[N-1]);
			}else {
				if (arr[N-1]>0) {
					memo[N-1]=arr[N-1];
				}else {
					memo[N-1]=0;
				}
				
				for(int i=N-2;i>=0;i--) {
					memo[i] = Math.max(arr[i],arr[i]+memo[i+1]);
				}
				for(int i=0;i<N;i++) {
					ans=Math.max(ans, memo[i]);
				}
				System.out.println(ans);
			}
		}
		
    }
}