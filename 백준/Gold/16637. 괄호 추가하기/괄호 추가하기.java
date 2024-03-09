
import java.io.*;
import java.util.*;

public class Main {
	static int N,ans;
	static char command[];
	static int num[];
	static boolean visited[];
	
	private static int miniCal(int x,int y,char z) {
		switch(z) {
		case '+':
			return x+y;
		
		case '-':
			return x-y;
		default:
			return x*y;
		}
	}
	private static int cal() {
		Deque<String> q = new ArrayDeque<>();
		for(int i=0;i<N/2+1;i++) {
			if(visited[i]) {
				if(i==N/2-1) {
					q.addLast(String.valueOf(miniCal(num[i], num[i+1], command[i])));
					i++;
				}else {
					q.addLast(String.valueOf(miniCal(num[i], num[i+1], command[i])));
					q.addLast(String.valueOf(command[i+1]));
					i++;
				}

			}else {
				if(i==N/2) {
					q.addLast(String.valueOf(num[i]));
				}else {
					q.addLast(String.valueOf(num[i]));
					q.addLast(String.valueOf(command[i]));
				}
				
			}
		}

		while(q.size()>1) {
			int a =Integer.parseInt(q.removeFirst());
			char c = q.removeFirst().charAt(0);
			int b = Integer.parseInt(q.removeFirst());
//			System.out.println(a+" "+b+" "+c);
			q.addFirst(String.valueOf(miniCal(a,b,c)));
		}
		return Integer.parseInt(q.pop());
	}
	
	private static void pick(int cnt) {
		if(cnt==N/2||cnt==N/2+1) {
			//계산
			int result =cal();
//			for(boolean x : visited) {
//				System.out.print(x+" ");
//			}
//			System.out.println();
//			System.out.println(result);
			ans=Math.max(ans, result);
			return;
		}
		
			visited[cnt]=true;
			pick(cnt+2);
			visited[cnt]=false;
			pick(cnt+1);
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		// 부분집합으로 괄호 뽑기 두개씩
		// 최댓값 계산
		command = new char[N/2];
		num = new int[N/2+1];
		visited = new boolean[N/2+1];
		ans=Integer.MIN_VALUE;
		
		int cnt=0;
		String strInput = br.readLine();
		for(int i=0;i<N;i++) {	
			if(i%2==0) {
				num[cnt]=strInput.charAt(i)-'0';
			}else {
				command[cnt] = strInput.charAt(i);
				cnt++;
			}
		}
		
		pick(0);
		System.out.println(ans);
	}
}
