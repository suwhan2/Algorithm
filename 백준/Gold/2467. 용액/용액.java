import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
	static int N;
	static long arr[];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st= new StringTokenizer(br.readLine());
		arr = new long[N];
		for(int i=0;i<N;i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		
		int low = 0;
		int high = N-1;
		long ans = 2_000_000_001L;
		int resultA=0;
		int resultB=0;
		
		while(low<high) {
			long sum=arr[low]+arr[high];
			if(Math.abs(ans)>Math.abs(sum)) {
				resultA=low;
				resultB=high;
				ans=sum;
			}
			if(sum>0) {
				high--;
			}else if(sum<0) {
				low++;
			}else {
				System.out.println(arr[resultA]+" "+arr[resultB]);
				System.exit(0);
			}
			
		}
		System.out.println(arr[resultA]+" "+arr[resultB]);
	}
}