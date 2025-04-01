import java.io.*;
import java.util.*;
class Pair{
    int x,y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static int R,C,T;
    static int[][] grid;
    static Queue<Pair> q = new ArrayDeque<>();
    static int[] dx = new int[]{1,0,-1,0};
    static int[] dy = new int[]{0,1,0,-1};
    private static boolean inRange(int x,int y){
        return 0<=x && x<R && 0<= y && y<C;
    }

    private static void diffusion(){

        int[][] tmpGrid = new int[R][C];


        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(grid[i][j]>0){
                    int amt = grid[i][j]/5;
                    int cnt=0;
                    for(int k=0;k<4;k++){
                        int nx = i+dx[k];
                        int ny = j+dy[k];

                        if(inRange(nx,ny) && grid[nx][ny]!=-1){
                            tmpGrid[nx][ny]+= amt;
                            cnt++;
                        }
                    }

                    tmpGrid[i][j]-=(amt*cnt);
                }
            }
        }


        //변경사항 반영
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                grid[i][j]+=tmpGrid[i][j];
            }
        }


    }
    private static void topAirFresh(int x){

        for(int i=x-1;i>=1;i--){
            grid[i][0]=grid[i-1][0];
        }
        for(int i=0;i<C-1;i++){
            grid[0][i]=grid[0][i+1];
        }
        for(int i=0;i<x;i++){
            grid[i][C-1] = grid[i+1][C-1];
        }
        for(int i=C-1;i>=2;i--){
            grid[x][i] = grid[x][i-1];
        }
        grid[x][1]=0;

    }
    private static void bottomAirFresh(int x){

        for(int i=x+1;i<R-1;i++){
            grid[i][0]=grid[i+1][0];
        }
        for(int i=0;i<C-1;i++){
            grid[R-1][i] = grid[R-1][i+1];
        }
        for(int i=R-1;i>=x+1;i--){
            grid[i][C-1]=grid[i-1][C-1];
        }
        for(int i=C-1;i>=2;i--){
            grid[x][i] = grid[x][i-1];
        }
        grid[x][1]=0;
    }


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=  new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        grid = new int[R][C];

        int ax=0;

        boolean check = false;
        for(int i=0;i<R;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<C;j++){
                grid[i][j]= Integer.parseInt(st.nextToken());
                if(grid[i][j]==-1 && !check) {
                    ax=i;
                    check=true;
                }
            }
        }

        for(int q=0;q<T;q++){
            diffusion();
            topAirFresh(ax);
            bottomAirFresh(ax+1);
        }


        int ans =0;
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                ans+=grid[i][j];
            }
        }
        System.out.println(ans+2);
    }
}