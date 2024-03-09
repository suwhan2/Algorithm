import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


class Main{
	static int N;
	static long grid[];

	public static void main(String args[]) throws Exception{
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer st= new StringTokenizer(br.readLine());
		 N = Integer.parseInt(st.nextToken());
		 grid = new long[N];
		 int cnt=0;
		 while(st.hasMoreTokens()) {
			 String s = st.nextToken();
			 StringBuilder sb = new StringBuilder();
			 boolean check=false;
			 for(int i=s.length()-1;i>=0;i--) {
				 if(s.charAt(i)!=0) {
					 check =true;
				 }
				 
				 if(check) {
					 sb.append(String.valueOf(s.charAt(i)));
				 }
			 }
			 String tmp = String.valueOf(sb);
			 grid[cnt]=Long.valueOf(tmp);
			 cnt++;
		 }
		 
		 while(grid[N-1]==0) {
			 st= new StringTokenizer(br.readLine());
			 while(st.hasMoreTokens()) {
				 String s = st.nextToken();
				 StringBuilder sb = new StringBuilder();
				 boolean check=false;
				 for(int i=s.length()-1;i>=0;i--) {
					 if(s.charAt(i)!=0) {
						 check =true;
					 }
					 
					 if(check) {
						 sb.append(String.valueOf(s.charAt(i)));
					 }
				 }
				 String tmp = String.valueOf(sb);
				 grid[cnt]=Long.valueOf(tmp);
				 cnt++;
			 }
		 }
		 
		 Arrays.sort(grid);
		 for(long x :grid) {
			 System.out.println(x);
		 }
		 
	}
}

