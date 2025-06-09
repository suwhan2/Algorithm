import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B= Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(br.readLine());

        int h =(B+C)/60;
        int ansM = (B+C)%60;

        int ansH = (A+h)%24;


        StringBuilder sb= new StringBuilder();
        sb.append(ansH).append(" ").append(ansM);
        System.out.println(sb);

    }
}