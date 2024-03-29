import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int arr[],list[];
	
	private static int binarySearch(int key) {
		int low = 0;
		int high=N-1;
		while(low<=high) {
			int mid=(low+high)/2;
			if(key==arr[mid]) return 1;
			else if(key<arr[mid]) high=mid-1;
			else low=mid+1;
		}
		return 0;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr= new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {arr[i] = Integer.parseInt(st.nextToken());}
		Arrays.sort(arr);		
		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) {
			System.out.println(binarySearch(Integer.parseInt(st.nextToken())));
		}
	}
}