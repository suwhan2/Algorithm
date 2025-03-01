import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main{
    static int P;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        P = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        LinkedList<Integer> line;
        for(int t=0;t<P;t++){
            int cnt=0;
            st = new StringTokenizer(br.readLine());
            sb.append(st.nextToken()).append(" ");
            line = new LinkedList<>();

            for(int i=0;i<20;i++){
                int num = Integer.parseInt(st.nextToken());
                if(i==0) line.add(num);
                else{
                    int idx =0;
                    for(int n : line){
                        if(n>num) break;
                        idx++;
                    }
                    line.add(idx,num);
                    cnt+=(line.size()-idx-1);
                }
            }
            sb.append(cnt);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}