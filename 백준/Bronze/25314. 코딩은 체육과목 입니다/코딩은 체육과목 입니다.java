import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        n = n/4;

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            sb.append("long ");
        }
        sb.append("int");
        System.out.println(sb);
    }
}