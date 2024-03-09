import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
class absComparator implements Comparator<Integer>{

	@Override
	public int compare(Integer o1, Integer o2) {
		if(Math.abs(o1)==Math.abs(o2)) {
			return o1-o2;
		}else {
			return Math.abs(o1)-Math.abs(o2);
		}
		
	}
	
}
public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>(1, new absComparator());
		for(int i=0;i<N;i++) {
			int intInput = Integer.parseInt(br.readLine());
			
			if(!pq.isEmpty()&&intInput==0) {
				System.out.println(pq.poll());
			}else if(pq.isEmpty() && intInput==0){ 
				System.out.println(0);
			}else {
				pq.offer(intInput);

			}
			
		}
	
    }
}










