import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int L,C;
	static char arr[],selected[];
	static StringBuilder sb= new StringBuilder();
	private static boolean check() {
		int count=0;
		for(char x : selected) {
			if(x=='a' || x=='e'|| x=='u'|| x=='i'|| x=='o') {
				count++;
			}
		}
		
		if(count>=1 && (L-count)>=2) {
			return true;
		}
		return false;
	
	}
	private static void pick(int cnt, int startIdx) {
		if(cnt==L) {
			if(check()) {
				for(char x : selected) {
					sb.append(x);
				}
				sb.append("\n");
			}
			return;
		}
		
		for(int i=startIdx;i<C;i++) {
			selected[cnt]=arr[i];
			pick(cnt+1,i+1);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[C];
		selected = new char[L];
		
		
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for(int i=0;i<C;i++) {
			arr[i] = st2.nextToken().charAt(0);
		}
		Arrays.sort(arr);
		pick(0,0);	
		System.out.println(sb);
	}
}
