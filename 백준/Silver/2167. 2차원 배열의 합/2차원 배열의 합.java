import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] grid = new int[N][M];

        for(int i=0;i<N;i++){
            st= new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        StringBuilder sb = new StringBuilder();

        int q = Integer.parseInt(br.readLine());
        for(int i=0;i<q;i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken())-1;
            int y1 = Integer.parseInt(st.nextToken())-1;
            int x2 = Integer.parseInt(st.nextToken())-1;
            int y2 = Integer.parseInt(st.nextToken())-1;

            int sum=0;
            for(int j=x1;j<=x2;j++){
                for(int k=y1;k<=y2;k++){
                    sum+=grid[j][k];
                }
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }
}