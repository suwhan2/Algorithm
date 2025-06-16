import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum =Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int tmp=0;
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            tmp+=Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken());
        }


        if(tmp!=sum){
            System.out.println("No");
        }else{
            System.out.println("Yes");
        }
    }
}