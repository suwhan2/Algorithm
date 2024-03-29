import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static long arr[],list[];
	static int indexArr[];
	
	private static int binarySearch(int low,int high,long key) {
		int mid=0;
		while(low<high) {
			mid=(low+high)/2;
			if(list[mid]<key) {
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
		arr= new long[N];
		list = new long[N];
		indexArr = new int[N];
		StringTokenizer st= new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i]=Long.parseLong(st.nextToken());
		}
		list[0]=arr[0];
		indexArr[0]=0;
		int cnt=0;
		for(int i=1;i<N;i++) {
			if(arr[i]>list[cnt]) {
				list[++cnt]=arr[i];
				indexArr[i]=cnt;
			}
			else {
				int target = binarySearch(0,cnt,arr[i]);
				list[target]=arr[i];
				indexArr[i]=target;
			}	
		}

		System.out.println(cnt+1);
		Stack<Long> s = new Stack<>();
		for(int i=N-1;i>=0;i--) {
			if(indexArr[i]==cnt) {
				cnt--;
				s.push(arr[i]);
			}
		}
		StringBuilder sb = new StringBuilder();
		
		while(!s.isEmpty()) {
			sb.append(s.pop()+" ");
		}
		System.out.println(sb);

	}
}