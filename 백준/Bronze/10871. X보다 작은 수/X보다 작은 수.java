import java.util.*;
import java.io.*;

public class Main{
	static int N,X;
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N =Integer.parseInt(st.nextToken());		
		X =Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++){
			int target = Integer.parseInt(st.nextToken());
			if(target<X){
				sb.append(target).append(" ");
			}
		}
		System.out.println(sb);
	}
}