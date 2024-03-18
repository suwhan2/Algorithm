import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] arr;
	static int[][] memo;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N =Integer.parseInt(br.readLine());
        arr = new int[N];
        memo = new int[2][N];
        for(int i=0;i<N;i++) {
        	arr[i] = Integer.parseInt(br.readLine());
        }
        
        if(N==1) {
        	System.out.println(arr[0]);
        }else {
        	memo[1][0]=arr[0];
            memo[0][0]=0;
            
            memo[1][1]=arr[1]+arr[0];
            memo[0][1] = arr[0];
            
            for(int q=2;q<N;q++) {
            	memo[0][q] = memo[1][q-1];
            	memo[1][q] = Math.max(memo[1][q-2],memo[0][q-2]+arr[q-1])+arr[q];
            			
            }
            
            System.out.println(memo[1][N-1]);
        }
          
    }
}


