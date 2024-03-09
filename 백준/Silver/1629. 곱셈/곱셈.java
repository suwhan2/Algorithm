import java.io.*;
import java.util.*;


public class Main {
	static long A;
	static long B;
	static long C;
	
	private static long cal(long cnt) {
		if(cnt==1) return A;
		else {
			long x= cal(cnt/2)%C;
			if(cnt%2==0) {
				return (x*x)%C;
			}else {
				return ((x*x)%C)*A%C;
			}
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
	
		long ans =cal(B);
		System.out.println(ans%C);
	}
	
	
}


