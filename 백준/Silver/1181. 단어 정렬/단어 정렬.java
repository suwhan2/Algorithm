import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
class Main{
	static int N;
	static String grid[];
	
	static Comparator<String> comp = new Comparator<String>() {

		@Override
		public int compare(String o1, String o2) {
			if(o1.length()!=o2.length()) {
				return o1.length()-o2.length();
			}else {
				for(int i=0;i<o1.length();i++) {
					if(o1.charAt(i)!=o2.charAt(i)) {
						return (o1.charAt(i)-'0')-(o2.charAt(i)-'0');
					}
				}
			}
			return 0;
		}
		
	};
	public static void main(String args[]) throws Exception{
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer st= new StringTokenizer(br.readLine());
		 N = Integer.parseInt(st.nextToken());
		 grid =new String[N];
		 for(int i=0;i<N;i++) {
			 grid[i] = br.readLine();
		 }
		 
		 Arrays.sort(grid,comp);
		 
		 
		 System.out.println(grid[0]);
		 for(int i=1;i<N;i++) {
			 if(grid[i-1].equals(grid[i])) continue;
			 System.out.println(grid[i]);
		 }
		 
	}
}

