import java.io.*;

public class Main{

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        StringBuilder sb= new StringBuilder();
        sb.append(a).append("??!");
        System.out.println(sb);
    }
}