import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] grid;
    static int ans = Integer.MAX_VALUE;
    private static int calculate(int x,int y,int d1,int d2){
//        System.out.println(x+" "+y+" "+d1+" "+d2);
        int[] sum = new int[6];
        int[][] mark = new int[N][N];

        int curx =x;
        int cury=y;
        mark[x][y]=5;
        //마킹
        for(int i=0;i<d1;i++){
            curx++;
            cury--;
            mark[curx][cury]=5;
        }
        for(int i=0;i<d2;i++){
            curx++;
            cury++;
            mark[curx][cury]=5;
        }
        for(int i=0;i<d1;i++){
            curx--;
            cury++;
            mark[curx][cury]=5;
        }
        for(int i=0;i<d2-1;i++){
            curx--;
            cury--;
            mark[curx][cury]=5;
        }

        for(int i=0;i<x+d1;i++){
            for(int j=0;j<=y;j++){
                if(mark[i][j]==5)break;
                mark[i][j]=1;
            }
        }

        for(int i=0;i<=x+d2;i++){
            for(int j=N-1;j>y;j--){
                if(mark[i][j]==5)break;
                mark[i][j]=2;
            }
        }

        for(int i=x+d1;i<N;i++){
            for(int j=0;j<y-d1+d2;j++){
                if(mark[i][j]==5)break;
                mark[i][j]=3;
            }
        }
        for(int i=x+d2+1;i<N;i++){
            for(int j=N-1;j>=(y-d1+d2);j--){
                if(mark[i][j]==5)break;
                mark[i][j]=4;
            }
        }


        //계산
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
//                System.out.print(mark[i][j]+" ");
                if(mark[i][j]==0) mark[i][j]=5;
                sum[mark[i][j]]+=grid[i][j];
            }
//            System.out.println();
        }
//        System.out.println("___________________");
        // 최대 최소 반환
        int maxSum = 0;
        int minSum = Integer.MAX_VALUE;
        for(int i=1;i<=5;i++){
            maxSum = Math.max(maxSum,sum[i]);
            minSum = Math.min(minSum,sum[i]);
        }

        return maxSum-minSum;
    }


    private static void simulation(int x,int y){
        for(int i=1;i<=y;i++){
            for(int j=1;j<(N-y);j++){
                if(x+i+j>=N) break;
                ans = Math.min(ans,calculate(x,y,i,j));
                if(ans==0) return;
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        grid = new int[N][N];

        StringTokenizer st;

        for(int i=0;i<N;i++){
            st= new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<N-2;i++){
            for(int j=1;j<N-1;j++){
                simulation(i,j);
            }
        }
        System.out.println(ans);

    }
}