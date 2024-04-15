import java.io.IOException;
import java.io.*;
import java.util.*;
public class Main {
	static int N,S;
	static int[] arr;
	static int sum=0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		arr= new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		int a = 0;
		int b = 0;
		sum=arr[a];
		int ans=Integer.MAX_VALUE;
		
		while(true) {
			if(b>N-1) break;
			if(a>b) {
				b++;
				if(b<=N-1) {
					sum+=arr[b];
					continue;
				}
			}
			if(sum>=S) {
				ans=Math.min(ans,(b-a+1));
				sum-=arr[a];
                a++;
				
			}
			else if(sum<S) {
				b++;
				if(b<=N-1) {
					sum+=arr[b];
				}
				
			}			
		}
		
		if(ans==Integer.MAX_VALUE) {
			System.out.println(0);
		}else {
			System.out.println(ans);
		}		
	}
}

