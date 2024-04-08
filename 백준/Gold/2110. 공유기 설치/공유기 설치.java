import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Main{
	static int N,C;
	static int house[];
	private static int checkCanInstall(int n) {
		int cnt=2;
		int near=0;
        
		for(int i=1;i<=N-2;i++) {
			if(house[i]-house[near]>=n && house[N-1]-house[i]>=n) {
				cnt++;
				near=i;
			}
		}
        return cnt;
	}
	private static int binarySearch() {
		int low=0;
		int high=house[N-1]-house[0];
		int ans=house[N-1]-house[0];
		if(N>2) {
			while(low<=high) {
				
				int mid = (low+high)/2;
				if(low==high) mid=low;
				int result =checkCanInstall(mid);
				if(result<C) {
					high=mid-1;
					
				}else {
					ans=mid;
					low=mid+1;
				}
			}
		}

		return ans;
	}
    public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		house = new int[N];
		for(int i=0;i<N;i++) {
			house[i] = Integer.parseInt(br.readLine());	
		}
		Arrays.sort(house);

		System.out.println(binarySearch());
		
	}
}