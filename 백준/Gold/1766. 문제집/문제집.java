import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] priorQuizCount = new int[N+1];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0;i<N+1;i++){
            graph.add(new ArrayList<>());
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            graph.get(first).add(second);
            priorQuizCount[second]++;
        }
        for(int i=1;i<priorQuizCount.length;i++){
            if(priorQuizCount[i]==0){
                pq.offer(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            int nodeNo = pq.poll();
            sb.append(nodeNo).append(" ");
            List<Integer> list = graph.get(nodeNo);
            for (Integer integer : list) {
                priorQuizCount[integer]--;
                if (priorQuizCount[integer] == 0) {
                    pq.offer(integer);
                }
            }
        }
        System.out.println(sb);
    }
}