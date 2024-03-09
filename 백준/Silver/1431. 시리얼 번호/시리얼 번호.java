import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
class Main{
	static int N;
	static String arr[];
	
	static Comparator<String> comp = new Comparator<String>() {
		@Override
		public int compare(String a, String b) {
			if( a.length()-b.length() !=0) {
				return a.length()-b.length();
			}else {
				int sum1=0;
				int sum2=0;
				for(int i=0;i<a.length();i++) {
					if(0<a.charAt(i)-'0'&&a.charAt(i)-'0'<10) {
						sum1+=(a.charAt(i)-'0');
					}
					if(0<b.charAt(i)-'0'&&b.charAt(i)-'0'<10) {
						sum2+=(b.charAt(i)-'0');
					}
				}
				if(sum1!=sum2) {
					return sum1-sum2;
				}else {
					for(int i=0;i<a.length();i++) {
						if(a.charAt(i)!=b.charAt(i)) {
							return a.charAt(i)-b.charAt(i);
						}
					}
				}
			}
			return 0;
		}
	};
	public static void main(String args[]) throws Exception{
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 N = Integer.parseInt(br.readLine());
		 arr = new String[N];
		 for(int i=0;i<N;i++) {
			 arr[i]=br.readLine();
		 }
		 Arrays.sort(arr,comp);
		 
		 for(int i=0;i<N;i++) {
			 System.out.println(arr[i]);
		 }
    }
}