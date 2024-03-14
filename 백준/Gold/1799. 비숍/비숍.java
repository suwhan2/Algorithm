import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int grid[][];
    static boolean visited[], visited2[];
    static int ans=0;

    private static void backTracking(int x,int y,int cnt, int currentPutChess,int h,int k) {
        if (k==1 && h==1) {
            if(cnt==((N*N)/2)+1) {
                ans = Math.max(ans, currentPutChess);
                return;
            }
        }else{
            if(cnt==(N*N)/2) {
                ans = Math.max(ans, currentPutChess);
                return;
            }
        }

        if(h==1){
            if(grid[x][y]==1 && !visited[x+y] && !visited2[x-y+(N-1)]) {
                check(x,y);
                if(y==N-1) {
                    backTracking(x+1,1,cnt+1,currentPutChess+1,h,k);
                }
                else if(y==N-2){
                    backTracking(x+1,0,cnt+1,currentPutChess+1,h,k);
                }

                else {
                    backTracking(x,y+2,cnt+1,currentPutChess+1,h,k);
                }
                uncheck(x,y);
            }

            if(y==N-1) {
                backTracking(x+1,1,cnt+1,currentPutChess,h,k);
            }
            else if(y==N-2){
                backTracking(x+1,0,cnt+1,currentPutChess,h,k);
            }

            else {
                backTracking(x,y+2,cnt+1,currentPutChess,h,k);
            }
        }else{
            if(grid[x][y]==1 && !visited[x+y] && !visited2[x-y+(N-1)]) {
                check(x,y);
                if(y==N-1) {
                    backTracking(x+1,0,cnt+1,currentPutChess+1,h,k);
                }
                else if(y==N-2){
                    backTracking(x+1,1,cnt+1,currentPutChess+1,h,k);
                }

                else {
                    backTracking(x,y+2,cnt+1,currentPutChess+1,h,k);
                }
                uncheck(x,y);
            }

            if(y==N-1) {
                backTracking(x+1,0,cnt+1,currentPutChess,h,k);
            }
            else if(y==N-2){
                backTracking(x+1,1,cnt+1,currentPutChess,h,k);
            }

            else {
                backTracking(x,y+2,cnt+1,currentPutChess,h,k);
            }
        }

    }

    private static void check(int x,int y) {
        visited[x+y]=true;
        visited2[x-y+(N-1)]=true;
        grid[x][y]=3;
    }
    private static void uncheck(int x,int y) {
        visited[x+y]=false;
        visited2[x-y+(N-1)]=false;
        grid[x][y]=1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        grid =new int[N][N];
        visited = new boolean[2*N-1];
        visited2 = new boolean[2*N-1]; // +(N-1)해주기
        for(int i=0;i<N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if(N==1){
            System.out.println(1);
        }else{
            backTracking(0,0,0,0,N%2,1);
            int tmp = ans;
            ans=0;
            backTracking(0,1,0,0,N%2,2);
            System.out.println(tmp+ans);
        }

    }
}