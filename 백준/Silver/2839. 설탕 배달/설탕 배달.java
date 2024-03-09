import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int tmp = N%5;
		if(tmp==0) {
			System.out.println(N/5);
		}else {
			int count=0;
			while(tmp<=N) {
				if(tmp%3==0) {
					System.out.println(N/5-count+(tmp/3));
					System.exit(0);
				}
				tmp+=5;
				count++;
			}
			System.out.println(-1);
		}
		
	}
}