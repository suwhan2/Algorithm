
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main{
	static int T,N,M;
	static int arrA[],arrB[];

	
	public static void main(String args[]) throws Exception{
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 T = Integer.parseInt(br.readLine());
		 for(int t=0;t<T;t++) {
			 StringTokenizer st= new StringTokenizer(br.readLine());
			 N = Integer.parseInt(st.nextToken());
			 M = Integer.parseInt(st.nextToken());
			 arrA = new int[N];
			 arrB = new int[M];
			 st=new StringTokenizer(br.readLine());
			 for(int i=0;i<N;i++) {
				 arrA[i] =Integer.parseInt(st.nextToken());
			 }
			 
			 st=new StringTokenizer(br.readLine());
			 for(int i=0;i<M;i++) {
				 arrB[i] =Integer.parseInt(st.nextToken());
			 }
			 
			 Arrays.sort(arrA);
			 Arrays.sort(arrB);
			 int ans=0;
			 int target=M-1;
			 for(int i=N-1;i>=0;i--) {
				 while(arrA[i]<=arrB[target]) {
					 target--;
					 if(target==-1)break;
				 }
				 if(target==-1) break;
				 ans+=(target+1);
			 }
			 
			 System.out.println(ans);

		 }
		 
	}
}

