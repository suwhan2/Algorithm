import java.io.IOException;
import java.io.*;
import java.util.*;
public class Main {
	static int N,M;
	static int[] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr= new int[N];
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		int a = 0;
		int b = 1;
		int ans=Integer.MAX_VALUE;
		while(true) {
			if(b>N-1) break;
			if(a==b) {
				b++;
				continue;
			}
			int tmp=arr[b]-arr[a];
			if(tmp>=M) {
				ans=Math.min(ans,tmp);
				a++;
			}
			else if(tmp<M) {
				b++;
			}			
		}
		System.out.println(ans);
		
	}
}

