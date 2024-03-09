import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int numbers[];	
	static int start;
	static int finish;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		numbers=new int[N];
		StringTokenizer st2 = new StringTokenizer(br.readLine()," ");
		int makeSumArr=0;
		for(int i=0;i<N;i++) {
			makeSumArr+=Integer.parseInt(st2.nextToken());
			numbers[i]=makeSumArr;
		}
		
		for(int i=0;i<M;i++) {
		
			StringTokenizer st3 = new StringTokenizer(br.readLine()," ");
			start = Integer.parseInt(st3.nextToken())-1;
			finish = Integer.parseInt(st3.nextToken())-1;
			
			
			if(start==0) {
				System.out.println(numbers[finish]);
			}else {
				System.out.println(numbers[finish]-numbers[start-1]);
			}
			
			
		}
		
	}
	
		
}