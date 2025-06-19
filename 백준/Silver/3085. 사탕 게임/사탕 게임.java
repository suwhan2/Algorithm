import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main{
    static int N;
    static int ans=1;
    static char[][] grid;

    private static void swapRow(int x,int y){
        char tmp = grid[x][y];
        grid[x][y]=grid[x][y+1];
        grid[x][y+1]=tmp;
    }
    private static void swapCol(int x,int y){
        char tmp = grid[x][y];
        grid[x][y] = grid[x+1][y];
        grid[x+1][y] = tmp;
    }
    private static void checkRow(int x,int y){
        int cnt=1;
        for(int i=1;i<N;i++){
            if(grid[x][i]==grid[x][i-1]){
                cnt++;
                ans = Math.max(ans,cnt);
            }else cnt=1;
        }

        cnt=1;
        for(int i=1;i<N;i++){
            if(grid[i][y]==grid[i-1][y]) {
                cnt++;
                ans = Math.max(ans,cnt);
            }else cnt=1;
        }
        cnt=1;
        for(int i=1;i<N;i++){
            if(grid[i][y+1]==grid[i-1][y+1]) {
                cnt++;
                ans = Math.max(ans,cnt);
            }else cnt=1;
        }
        
    }
    private static void checkCol(int x,int y){
        int cnt=1;
        for(int i=1;i<N;i++){
            if(grid[i][y]==grid[i-1][y]){
                cnt++;
                ans = Math.max(ans,cnt);
            }else cnt=1;
        }

        cnt=1;
        for(int i=1;i<N;i++){
            if(grid[x][i]==grid[x][i-1]) {
                cnt++;
                ans = Math.max(ans,cnt);
            }else cnt=1;
        }
        cnt=1;
        for(int i=1;i<N;i++){
            if(grid[x+1][i]==grid[x+1][i-1]) {
                cnt++;
                ans = Math.max(ans,cnt);
            }else cnt=1;
        }
    }
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        grid = new char[N][N];
        for(int i=0;i<N;i++){
                String input = br.readLine();
            for(int j=0;j<N;j++){
                grid[i][j] = input.charAt(j);
            }
        }
        
        //오른쪽 swap
        for(int i=0;i<N;i++){
            for(int j=0;j<N-1;j++){
                swapRow(i,j);
                checkRow(i,j);
                swapRow(i,j);
            }
        }
        //아래와 swap
        for(int i=0;i<N-1;i++){
            for (int j=0;j<N;j++){
                swapCol(i,j);
                checkCol(i,j);
                swapCol(i,j);
            }
        }
        System.out.println(ans);
    }
}