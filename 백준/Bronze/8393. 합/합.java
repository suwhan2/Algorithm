import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t =Integer.parseInt(br.readLine());
        System.out.println((t*(t+1)/2));
    }
}