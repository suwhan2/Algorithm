import java.util.*;
import java.io.*;

public class Main{
    // 조합
    static int N,M;
    static int[] picked;
    static boolean[] isPicked;
    static StringBuilder sb = new StringBuilder();
    private static void pick(int cnt){
        if(cnt==M){
            for(int p : picked){
                sb.append(p).append(" ");
            }
            sb.append("\n");
            return;
        }


        for(int i=1;i<=N;i++){
//            if(isPicked[i]) continue;
            picked[cnt]=i;
            isPicked[i]=true;
            pick(cnt+1);
            isPicked[i]=false;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        isPicked = new boolean[N+1];
        picked = new int[M];
        pick(0);
        System.out.println(sb);
    }
}