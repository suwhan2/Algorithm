import java.util.*;
import java.io.*;

public class Main{
    static int N,M;
    static int[] priorQuizCount;
    static ArrayList<ArrayList<Integer>> graph;
    static PriorityQueue<Integer> pq;

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        priorQuizCount = new int[N+1];
        graph = new ArrayList<>();
        for(int i=0;i<N+1;i++){
            graph.add(new ArrayList<>());
        }
        pq = new PriorityQueue<>();

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
            sb.append(nodeNo+" ");
            List<Integer> list = graph.get(nodeNo);
            for(int i=0;i<list.size();i++){
                priorQuizCount[list.get(i)]--;
                if(priorQuizCount[list.get(i)]==0){
                    pq.offer(list.get(i));
                }
            }

        }

        System.out.println(sb);
    }
}