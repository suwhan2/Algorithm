import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String strInput = br.readLine();
		Stack<String> s = new Stack<>();
		//( 열면 steel 추가
		//()레이저 발견시 count+=steel
		//)닫을때 count+=1, steel-=1
		
		int count=0;
		int steel=0;
		
		for(int i=0;i<strInput.length()-1;i++) {
			if(strInput.charAt(i)=='(') {
				if(strInput.charAt(i+1)==')') {
					count+=steel;
					i+=1;
				}else {
					s.push(String.valueOf(strInput.charAt(i)));
					steel+=1;
				}
				
			}
			else {
				s.pop();
				count+=1;
				steel-=1;				
			}
		}
		
		if(count==0) {
			System.out.println(0);
		}
		else if(!s.isEmpty()){ 
			System.out.println(count+1);
		}else{
			System.out.println(count);
		}
		
	}
}
