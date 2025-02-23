import java.util.*;
import java.io.*;

public class Main{
    static int N,M;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> d1 = new HashMap<>();
        HashMap<Integer, String> d2 = new HashMap<>();


        for(int i=1;i<=N;i++){
            String name = br.readLine();
            d1.put(name,i);
            d2.put(i,name);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<M;i++){
            String q = br.readLine();
            if(49 <= q.charAt(0) && q.charAt(0) <= 57){
                sb.append(d2.get(Integer.parseInt(q))).append("\n");

            }else{
                sb.append(d1.get(q)).append("\n");
            }
        }
        System.out.println(sb);

    }
}