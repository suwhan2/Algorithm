import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		StringBuilder sb= new StringBuilder();
		boolean[] picked = new boolean[N+1];
		List<Integer> al = new ArrayList<>();
		pick(0,N,M,picked,al);
	}
	
	public static void pick(int cnt,int N,int M,boolean[] picked,List<Integer> al) {
		if(cnt==M) {
			for(int j:al) {
				System.out.print(j+" ");
			}
			System.out.println();
			return;
		}
		for(int i=1;i<=N;i++) {
			if(picked[i]==true) {
				continue;
			}
			al.add(i);
			picked[i]=true;
			pick(cnt+1,N,M,picked,al);
			picked[i]=false;
			al.remove(al.size()-1);
		}
	}
}
