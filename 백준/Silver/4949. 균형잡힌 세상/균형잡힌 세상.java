import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String strInput = br.readLine();
			if(strInput.equals(".")) {
				break;
			}
			Stack<String> s =new Stack<>();
			boolean balanceCheck = true;
			for(int i=0;i<strInput.length();i++) {
				if(strInput.charAt(i)=='('||strInput.charAt(i)=='[') {
					s.push(String.valueOf(strInput.charAt(i)));
					
				}
				else if(strInput.charAt(i)==')') {
					if(!s.isEmpty()&&s.peek().equals("(")) {
						s.pop();
					}else {
						s.push(String.valueOf(strInput.charAt(i)));
					}
				}
				else if(strInput.charAt(i)==']') {
					if(!s.isEmpty()&&s.peek().equals("[")) {
						s.pop();
					}else {
						s.push(String.valueOf(strInput.charAt(i)));
					}
				}else {
					
				}
			}
			if(s.isEmpty()) {
				System.out.println("yes");
			}else {
				System.out.println("no");
			}
			
			
		}
	}
}
