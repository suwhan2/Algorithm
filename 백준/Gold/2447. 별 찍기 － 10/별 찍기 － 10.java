import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    static int N;
    static String grid[][];
    static StringBuilder sb;

    private static void simulation(int n,int x,int y){
        if(n==1){
            grid[x][y]="*";
            return;
        }

        simulation(n/3,x,y);
        simulation(n/3,x,y+n/3);
        simulation(n/3,x,y+n/3+n/3);

        simulation(n/3,x+n/3,y);
        simulation(n/3,x+n/3,y+n/3+n/3);

        simulation(n/3,x+n/3+n/3,y);
        simulation(n/3,x+n/3+n/3,y+n/3);
        simulation(n/3,x+n/3+n/3,y+n/3+n/3);
        return;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        grid = new String[N][N];
        sb=new StringBuilder();

        simulation(N,0,0);

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(grid[i][j]==null){
                    sb.append(" ");
                }else{
                    sb.append(grid[i][j]);
                }

            }
            sb.append("\n");
        }

        System.out.println(sb);
}
}