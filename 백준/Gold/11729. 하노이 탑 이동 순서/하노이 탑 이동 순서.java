import java.io.*;
import java.util.*;


public class Main {
    static int N;
    static StringBuilder sb;
    static int count=0;

    private static void simulation(int a, int b, int n){
        if(n == 1){
            sb.append(a+" "+b+"\n");
            count++;
            return;
        }

        simulation(a,6-a-b,n-1);
        sb.append(a+" "+b+"\n");
        count++;
        simulation(6-a-b,b,n-1);

    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        sb = new StringBuilder();

        simulation(1,3,N);
        System.out.println(count);
        System.out.println(sb);

    }
}

