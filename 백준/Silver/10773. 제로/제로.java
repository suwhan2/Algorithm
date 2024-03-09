import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(bf.readLine());
		Stack<Integer> stackInt = new Stack<>();
		
		for(int i=0;i<K;i++) {
			int intInput = Integer.parseInt(bf.readLine());
			if(intInput==0) {
				stackInt.pop();
			}else {
				stackInt.push(intInput);
			}
			
		}
		int sum=0;
		
		while(!stackInt.isEmpty()) {
		sum+=stackInt.pop();
		}
		System.out.println(sum);
	}
}
