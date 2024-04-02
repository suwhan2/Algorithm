import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class BottleState{
	int a,b,c;
	public BottleState(int a, int b, int c) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
	}
}
public class Main{
	static int A,B,C;
	static boolean visited[][][];
	static Queue<BottleState> q = new ArrayDeque<>();
	
	private static BottleState pump(int a,int b,int c,int dir) {
		int tmp=0;
		switch(dir) {
		
		case 0:
			tmp = a+b;
			if(B>=tmp) return new BottleState(0, tmp, c);
			else return new BottleState(tmp-B, B, c);
		case 1:
			tmp = a+c;
			if(C>=tmp) return new BottleState(0,b,tmp);
			else return new BottleState(tmp-C,b,C);
		case 2:
			tmp = b+a;
			if(A>=tmp) return new BottleState(tmp,0,c);
			else return new BottleState(A,tmp-A,c);
		case 3:
			tmp = b+c;
			if(C>=tmp) return new BottleState(a,0,tmp);
			else return new BottleState(a,tmp-C,C);
		case 4:
			tmp=c+a;
			if(A>=tmp) return new BottleState(tmp,b,0);
			else return new BottleState(A,b,tmp-A);
		default:
			tmp=c+b;
			if(B>=tmp) return new BottleState(a,tmp,0);
			else return new BottleState(a,B,tmp-B);
		} 

	}
	private static void bfs() {
		while(!q.isEmpty()) {
			BottleState tmp = q.poll();
			int a = tmp.a;
			int b= tmp.b;
			int c= tmp.c;
			
			for(int i=0;i<6;i++) {
				BottleState resultPump= pump(a,b,c,i);
				if(!visited[resultPump.a][resultPump.b][resultPump.c]) {
					visited[resultPump.a][resultPump.b][resultPump.c]=true;
					q.offer(resultPump);
				}
			}
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A= Integer.parseInt(st.nextToken());
		B= Integer.parseInt(st.nextToken());
		C= Integer.parseInt(st.nextToken());
		visited = new boolean[A+1][B+1][C+1];
		q.offer(new BottleState(0, 0, C));
		bfs();
		for(int i=0;i<C+1;i++) {
			for(int j=0;j<B+1;j++) {
				if(visited[0][j][i]) {
					System.out.print(i+" ");
					break;
				}
			}
		}
	}
}