import java.util.*;
import java.io.*;

public class Main{
    // 조합
    static int N,M;
    static int[] picked;
    static StringBuilder sb = new StringBuilder();
    private static void pick(int cnt,int start){
        if(cnt==M){
            for(int p : picked){
                sb.append(p).append(" ");
            }
            sb.append("\n");
            return;
        }


        for(int i=start;i<=N;i++){
            picked[cnt]=i;
            pick(cnt+1,i+1);
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        picked = new int[M];
        pick(0,1);
        System.out.println(sb);
    }
}