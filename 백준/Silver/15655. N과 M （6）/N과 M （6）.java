
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static  int M;
    static int selected[];
    static int visited[];
    static int arr[];
    private static void simulation(int cnt,int startIdx){
        if(cnt==M){
            for(int x : selected){
                System.out.print(x+" ");
            }
            System.out.println();
            return;
        }

        for(int i=startIdx;i<N;i++){
            if(visited[i]==1) continue;
            selected[cnt]=arr[i];
            visited[i]=1;
            simulation(cnt+1,i);
            visited[i]=0;
        }



    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        selected = new int[M];
        visited = new int[N];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        arr = new int[N];

        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st2.nextToken());
        }
        Arrays.sort(arr);
        simulation(0,0);

    }
}
