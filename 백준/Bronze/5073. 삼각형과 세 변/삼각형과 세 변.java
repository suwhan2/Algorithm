import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> q = new PriorityQueue<>();
        HashSet<Integer> s = new HashSet<>();

        while(true){
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<3;i++){
                int n = Integer.parseInt(st.nextToken());
                if(n==0){
                    System.out.println(sb);
                    System.exit(0);
                }
                q.offer(n);
                s.add(n);
            }

            int a= q.poll();
            int b= q.poll();
            int c= q.poll();

            if(c>=(a+b)) sb.append("Invalid").append("\n");
            else{
                if(s.size()==1) sb.append("Equilateral").append("\n");
                else if (s.size()==2) sb.append("Isosceles").append("\n");
                else sb.append("Scalene").append("\n");
            }

            q.clear();
            s.clear();

        }


    }
}