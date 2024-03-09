import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;


class Pair{
	long key;
	int value;
	public Pair(long key, int value) {
		super();
		this.key = key;
		this.value = value;
	}
	
}
class Main{
	static int N,C;
	static List<Pair> arr =new ArrayList<>();
	static List<Long> check = new ArrayList<>();
	
	
	
	static Comparator<Pair> comp = new Comparator<Pair>() {
		@Override
		public int compare(Pair o1, Pair o2) {
			if(o1.value !=o2.value) {
				return o2.value-o1.value;
			}
			else {
				return 0;
			}
		}
		
	};
	
	public static void main(String args[]) throws Exception{
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer st= new StringTokenizer(br.readLine());
		 N = Integer.parseInt(st.nextToken());
		 C = Integer.parseInt(st.nextToken());
		 st= new StringTokenizer(br.readLine());
		 for(int i=0;i<N;i++) {
			 Long tmp = Long.parseLong(st.nextToken());
			 if(check.contains(tmp)) {
				 for(Pair x : arr) {
					 if(x.key==tmp) {
						 x.value++;
					 }
				 }
			 }else {
				 check.add(tmp);
				 arr.add(new Pair(tmp,1));
			 }
		 }
		 
		arr.sort(comp);
		
		for(Pair x : arr) {
			for(int i=0;i<x.value;i++) {
				System.out.print(x.key+" ");
			}
		}

	}
}

