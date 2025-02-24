import java.util.*;
import java.io.*;

public class Main{
    static int K,L;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        HashMap<String,Integer> already = new HashMap<>();
        Queue<String> q = new ArrayDeque<>();
        for(int i=0;i<L;i++){
            String num = br.readLine();
            if(already.containsKey(num)){
                int cnt = already.get(num);
                already.replace(num,cnt+1);
                q.offer(num);

            }else{
                already.put(num,1);
                q.offer(num);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(K!=0){
            if(q.isEmpty()) break;
            String n = q.poll();
            if(already.get(n)==1){
                sb.append(n).append("\n");
                K--;
            }else{
                already.replace(n,already.get(n)-1);
            }
        }
        System.out.println(sb);

    }
}