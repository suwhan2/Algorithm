import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static int N;
    static int grid[][],memo[][];

    private static void dp(int n){
        for(int i=2;i<N;i++){
            for(int j=1;j<i;j++){
                memo[i][j] = Math.max(memo[i-1][j-1],memo[i-1][j])+grid[i][j];            }
        }
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        grid = new int[N][N];
        memo = new int[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
               grid[i][j]=-1;
               memo[i][j]=-1;
            }
        }

        for(int i=0;i<N;i++){
            StringTokenizer st =new StringTokenizer(br.readLine());
            for(int j=0;j<i+1;j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        memo[0][0] = grid[0][0];
        for(int i=1;i<N;i++){
            memo[i][0] = memo[i-1][0]+grid[i][0];
            memo[i][i] = memo[i-1][i-1]+grid[i][i];
        }

        dp(N);
        int ans=0;
        for(int i=0;i<N;i++){
            ans=Math.max(ans,memo[N-1][i]);
        }
        System.out.println(ans);
    }
}
