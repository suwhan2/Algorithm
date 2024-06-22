import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] missionList = new int[N][2];
        PriorityQueue<Integer> pq= new PriorityQueue<>(Collections.reverseOrder());
        int ans=0;
        int startPoint=0;

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            startPoint=Math.max(startPoint,d);
            int w = Integer.parseInt(st.nextToken());
            missionList[i][0]=d;
            missionList[i][1]=w;
        }

        while(startPoint>0){
            for(int i=0;i<N;i++){
                if(missionList[i][0]==startPoint) pq.offer(missionList[i][1]);
            }
            if(!pq.isEmpty()) ans+=pq.poll();
            startPoint--;
        }
        System.out.println(ans);
    }
}