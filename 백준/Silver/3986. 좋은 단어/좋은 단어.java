import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int count=0;
		for(int i=0;i<N;i++) {
			Stack<String> s = new Stack<>();
			String strInput = br.readLine();
			for(int j=0;j<strInput.length();j++) {
				if(!s.isEmpty()&&s.peek().equals(String.valueOf(strInput.charAt(j)))) {
					s.pop();
				}else {
					s.push(String.valueOf(strInput.charAt(j)));
				}
			}
			
			if(s.isEmpty()) {
				count+=1;
				
			}
		}
		System.out.println(count);
	}
}
