import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static int N;
    static int grid[][];
    static int count[];

    private static void simulation(int n,int x,int y){
        if(n==1){
            count[grid[x][y]]++;
            return;
        }

        boolean check =false;
        for(int i=x;i<x+n;i++){
            for(int j=y;j<y+n;j++){
                if(grid[i][j]!=grid[x][y]){
                    check = true;
                    break;
                }
            }
        }

        if(check){
            simulation(n/2,x,y);
            simulation(n/2,x,y+n/2);
            simulation(n/2,x+n/2,y);
            simulation(n/2,x+n/2,y+n/2);
        }else{
            count[grid[x][y]]++;
        }
        return;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        grid = new int[N][N];
        count = new int[2];

        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        simulation(N,0,0);

        for(int x : count){
            System.out.println(x);
        }

}
}