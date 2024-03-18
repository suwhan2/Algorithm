import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int memo[];
	
	private static int dp(int n) {
		
		if(memo[n]==0) {
			memo[n] =(dp(n-2)%10007) + (dp(n-1)%10007);
		}
		return (memo[n]%10007);
	}
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N =Integer.parseInt(br.readLine());
        memo = new int[N];
        
        if(N <=2) {
        	System.out.println(N);
        }else {
        	memo[0]=1;
            memo[1]=2;
            memo[2]=3;
            
            System.out.println(dp(N-1)%10007);
        }
        
       
           
    }
}