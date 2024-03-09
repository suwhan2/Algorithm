
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
        	String[] strInput = bf.readLine().split(" ");
        	if(strInput[0].equals("push")) {
        		stackInt.push(Integer.parseInt(strInput[1]));
        	}
        	else if(strInput[0].equals("pop")){
        		if(stackInt.isEmpty()) {
        			System.out.println(-1);
        		}else {
        			System.out.println(stackInt.pop());
        		}        		
        	}
        	else if(strInput[0].equals("size")){
        		System.out.println(stackInt.size());
        	}
        	else if(strInput[0].equals("empty")){
        		if(stackInt.isEmpty()) {
        			System.out.println(1);
        		}else {
        			System.out.println(0);
        		}
        	}
        	else{
        		if(stackInt.isEmpty()) {
        			System.out.println(-1);
        		}else {
        			System.out.println(stackInt.peek());
        		}
        	}
        }

    }
}

