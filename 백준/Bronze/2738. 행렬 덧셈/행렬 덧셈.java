import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] grid = new int[n][m];

        for(int i=0;i<n;i++){
            st =new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                grid[i][j] =Integer.parseInt(st.nextToken());
            }
        }

        StringBuilder sb =new StringBuilder();
        for(int i=0;i<n;i++){
            st= new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                grid[i][j]+=Integer.parseInt(st.nextToken());
                sb.append(grid[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }
}