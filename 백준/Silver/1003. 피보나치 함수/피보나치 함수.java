import java.io.*;

public class Main {
    static Integer[][] memo;
    private static Integer[] fibonacci(int N) {
        if(memo[N][0] == null || memo[N][1] == null) {
            memo[N][0] = fibonacci(N - 1)[0] + fibonacci(N - 2)[0];
            memo[N][1] = fibonacci(N - 1)[1] + fibonacci(N - 2)[1];
        }
        return memo[N];
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        memo = new Integer[41][2];
        memo[0][0]=1;
        memo[0][1]=0;
        memo[1][0]=0;
        memo[1][1]=1;

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<t;i++){
            int n = Integer.parseInt(br.readLine());
            fibonacci(n);
            sb.append(memo[n][0]).append(" ").append(memo[n][1]).append("\n");
        }
        System.out.println(sb);
    }
}