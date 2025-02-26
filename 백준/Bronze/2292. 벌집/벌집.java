import java.io.*;

public class Main{
    static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int cnt=1;
        int ans=2;
        if(N==1) System.out.println(1);
        else{
            while(ans<=N){
                ans=ans+(6*cnt);
                cnt++;
            }
            System.out.println(cnt);
        }
    }
}