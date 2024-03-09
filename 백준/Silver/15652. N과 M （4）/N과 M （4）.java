
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.SyncFailedException;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static  int M;
    static int selected[];
    static int arr[];
    private static void simulation(int cnt, int startIdx){
        if(cnt==M){
            for(int x : selected){
                System.out.print(x+" ");
            }
            System.out.println();
            return;
        }

        for(int i=startIdx;i<=N;i++){
            selected[cnt]=i;
            simulation(cnt+1,i);
        }



    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        selected = new int[M];
        arr = new int[N];

        for(int i=0;i<N;i++){
            arr[i]=i+1;
        }
        simulation(0,1);

    }
}
