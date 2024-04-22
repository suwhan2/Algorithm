import java.io.IOException;
import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.util.StringTokenizer;


public class Main {
	static int N;
	static int A[];
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		A = new int[N];
		StringTokenizer st= new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(A);
		int ans=A[0];
		for(int i=1;i<N;i++) {
			A[i]=A[i-1]+A[i];
			ans+=A[i];
		}
		System.out.println(ans);
	}
}
