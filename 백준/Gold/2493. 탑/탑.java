import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> monotonicStack = new Stack<>();
        List<Integer> indexArr = new ArrayList<>();
        
        //입력부
        int N = Integer.parseInt(br.readLine());
        int intInput[]= new int[N];
        
        String arr[] = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            intInput[i] = Integer.parseInt(arr[i]);
        }
        
        for(int i=0;i<N;i++) {
        	
        	if(monotonicStack.size()==0) {
        		monotonicStack.add(i);
        		indexArr.add(0);
        	}
        	else if(intInput[monotonicStack.peek()]>intInput[i]) {
        		indexArr.add(monotonicStack.peek()+1);
        		monotonicStack.add(i);
        		
        	}else {
        		while(true) {
        			monotonicStack.pop();
        			if(monotonicStack.isEmpty()) {
        				monotonicStack.add(i);
        				indexArr.add(0);
        				break;
        			}
        			else if(intInput[monotonicStack.peek()]>intInput[i]) {
        				indexArr.add(monotonicStack.peek()+1);
        				monotonicStack.add(i);
        				break;
        			}
        		}
        	}

        }
        
        for(int x : indexArr) {
        	System.out.print(x+" ");
        }
    }

}