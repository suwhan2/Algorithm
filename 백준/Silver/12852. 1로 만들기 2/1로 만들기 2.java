import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int memo[],check[];
	private static int  dp(int n) {
		int tmp = dp(n-1);
		if(n%2==0) {
			tmp = Math.max(tmp,dp(n/2));
		}
		if(n%3==0) {
			tmp =Math.max(tmp, dp(n/3));
		}
		tmp = Math.max(tmp,dp(n/3));
		
		memo[n]=tmp+1;
		
		return memo[n];
	}
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        memo= new int[N+1];
        check = new int[N+1];
        
        if(N<3) {
        	for(int i=1;i<=N;i++) {
        		memo[i]=1;
        		check[i]=1;
        	}
        }
        else {
        	memo[1]=1;
            memo[2]=1;
            memo[3]=1;
            check[1]=1;
            check[2] =2;
            check[3]=3;
            
            for(int i=4;i<=N;i++) {
            	int num=1;
            	int tmp = memo[i-1];
        		if(i%2==0) {
        			int tmp2=tmp;
        			tmp = Math.min(tmp,memo[i/2]);
        			if(tmp2!=tmp) {
        				num=2;
        			}
        		}
        		if(i%3==0) {
        			int tmp2= tmp;
        			tmp =Math.min(tmp, memo[i/3]);
        			if(tmp2!=tmp) {
        				num=3;
        			}
        		}
        		
        		
        		
        		memo[i]=tmp+1;
        		check[i]=num;
            }
        }
        
        if(N==1) System.out.println(0);
        else {
        	System.out.println(memo[N]);
        }
        
        sb.append(N+" ");
        while(N!=1) {
        	if(check[N]==1) {
        		N--;
        	}else {
        		N = N/check[N];
        	}
        	
        	sb.append(N+" ");
        	
        	
        }
        System.out.println(sb);

        
        
    }
}