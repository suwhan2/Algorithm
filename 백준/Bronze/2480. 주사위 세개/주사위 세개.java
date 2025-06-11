import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int ans;
        if(a==b && b==c) ans = 10000+(a*1000);
        else if(a!=b && b!=c && a!=c){
            int tmp =a;
            tmp = Math.max(tmp,b);
            tmp = Math.max(tmp,c);
            ans = tmp*100;
        }
        else{
            if(a==b) ans = 1000+(a*100);
            else ans=1000+(c*100);
        }

        System.out.println(ans);
    }
}