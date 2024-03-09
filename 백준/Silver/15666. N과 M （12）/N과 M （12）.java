import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int selected[], arr[],visited[];

    static StringBuilder sb = new StringBuilder();
    private static void pick(int cnt, int startIndex) {
        if(cnt==M) {
            for(int x : selected) {
                sb.append(x).append(" ");
            }
            sb.append("\n");
            return;
        }
        int check=-1;
        for(int i=startIndex;i<N;i++) {
            if(arr[i]==check) continue;
            selected[cnt]=arr[i];
            visited[i]=1;
            check=arr[i];
            pick(cnt+1,i);
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
        arr = new int[N];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            arr[i]=Integer.parseInt(st2.nextToken());
        }

        Arrays.sort(arr);

        pick(0,0);
        System.out.println(sb);

    }
}