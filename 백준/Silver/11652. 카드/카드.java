import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;


class Main{
	static int N;
	static long arr[];

	public static void main(String args[]) throws Exception{
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 N = Integer.parseInt(br.readLine());
		 arr = new long[N];
		 for(int i=0;i<N;i++) {
			 arr[i]=Long.parseLong(br.readLine());
		 }
		 Arrays.sort(arr);
		 int maxcount=0;
		 long ans=0;
		 int currentCount=1;
		 for(int i=1;i<N;i++) {
			 if(arr[i-1]==arr[i]) {
				 currentCount++;
			 }else {
				 if(maxcount<currentCount) {
					 maxcount=currentCount;
					 ans=arr[i-1];
				 }
				 currentCount=1;
			 }
		 }
		 if(maxcount<currentCount) {
			 maxcount=currentCount;
			 ans=arr[N-1];
		 }
		 System.out.println(ans);
		 
		 
	}
}