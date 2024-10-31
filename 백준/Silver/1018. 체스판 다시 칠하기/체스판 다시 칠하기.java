import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static int N,M;
    static char[][] grid;
    static int ans = Integer.MAX_VALUE;

    private static void cal(int x,int y){
        char[][] cp = new char[8][8];
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                cp[i][j]=grid[x+i][y+j];
            }
        }
        
        int cnt=0;

        for(int i=1;i<8;i++){
            if(cp[i][0]==cp[i-1][0]){
                cnt++;
                if(cp[i][0]=='W') cp[i][0]='B';
                else{
                    cp[i][0]='W';
                }
            }
        }

        for(int i=0;i<8;i++){
            for(int j=1;j<8;j++){
                if(cp[i][j]==cp[i][j-1]){
                    cnt++;
                    if(cp[i][j]=='W') cp[i][j]='B';
                    else cp[i][j]='W';

                }
            }
        }

        int tmp = 64-cnt;
        tmp = Math.min(tmp,cnt);
        ans = Math.min(ans,tmp);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        N =Integer.parseInt(st.nextToken());
        M =Integer.parseInt(st.nextToken());
        grid =new char[N][M];
        for(int i=0;i<N;i++){
            String inputStr = br.readLine();
            for(int j=0;j<M;j++){
                grid[i][j] = inputStr.charAt(j);
            }
        }

        for(int i=0;i<=N-8;i++){
            for(int j=0;j<=M-8;j++){
                cal(i,j);
            }
        }

        System.out.println(ans);



    }
}