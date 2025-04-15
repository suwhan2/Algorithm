import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        StringBuilder sb= new StringBuilder();
        sb.append("<");

        Queue<Integer> q= new ArrayDeque<>();
        for(int i=1;i<=N;i++){ q.offer(i); }

        while(q.size()>1){
            for(int i=0;i<K-1;i++){ q.offer(q.poll()); }
            sb.append(q.poll()).append(", ");
        }

        sb.append(q.poll()).append(">");
        System.out.println(sb);
    }
}