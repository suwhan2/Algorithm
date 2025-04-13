import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int T= Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb= new StringBuilder();
        
        for(int t=0;t<T;t++){
            Queue<Integer> q = new ArrayDeque<>();

            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[] impList = new int[N];

            st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++){
               impList[i]=Integer.parseInt(st.nextToken());
               q.offer(i);
            }

            int cnt=1;
            while(!q.isEmpty()){
                int cur = q.poll();
                boolean cantOut = false;

                for(int i=0;i<N;i++){
                    if(cur==i)continue;
                    if(impList[cur]<impList[i])cantOut=true;
                }

                if(cantOut) q.offer(cur);
                else{
                    if(cur==M){
                        sb.append(cnt).append("\n");
                        break;
                    }
                    impList[cur]=0;
                    cnt++;
                }
            }
        }
        System.out.println(sb);
    }
}