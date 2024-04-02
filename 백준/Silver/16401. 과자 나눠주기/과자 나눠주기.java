import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int M,N;
	static int arr[];
	static int ans=0;
	
	private static boolean canDivide(int n) {
		long cnt=0;
		for(int i=0;i<N;i++) {
			cnt+=arr[i]/n;
			if(cnt>=M) return true;
		}
		return false;
	}
	private static void binarySearch() {
		int low = 1;
		int high = arr[N-1];
		while(low<=high) {
			int mid =(low+high)/2;
			if(canDivide(mid)) {
				ans=mid;
				low=mid+1;
			}else high=mid-1;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		st= new StringTokenizer(br.readLine());
		arr= new int[N];
		for(int i=0;i<N;i++){arr[i] = Integer.parseInt(st.nextToken());}
		Arrays.sort(arr);
		binarySearch();
		System.out.println(ans);
	}
}