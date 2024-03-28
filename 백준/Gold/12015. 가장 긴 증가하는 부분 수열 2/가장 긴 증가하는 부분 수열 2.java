import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int arr[],lis[];
	
	private static int binarySearch(int low,int high,int key) {
		int mid=0;
		while(low<high) {
			mid=(low+high)/2;
			if(lis[mid]<key) {
				low=mid+1;
			}else {
				high=mid;
			}
		}
		return high;
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr= new int[N];
		lis = new int[N];
		StringTokenizer st= new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		lis[0]=arr[0];
		int cnt=0;
		for(int i=1;i<N;i++) {
			if(arr[i]>lis[cnt]) {
				lis[++cnt]=arr[i];
			}
			else {
				int target = binarySearch(0,cnt,arr[i]);
				lis[target]=arr[i];
			}	
		}
		System.out.println(cnt+1);
	}
}