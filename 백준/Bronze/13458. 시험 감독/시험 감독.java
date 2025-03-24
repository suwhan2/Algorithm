import java.util.*;
import java.io.*;

public class Main {
    static int N,B,C;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] classState = new int[N];
        for(int i=0;i<N;i++){
            classState[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        B= Integer.parseInt(st.nextToken());
        C= Integer.parseInt(st.nextToken());


        long ans = N;
        for(int i=0;i<N;i++){
            if((classState[i]-B)<=0) continue;

            else if((classState[i]-B)%C==0){
                ans+=(classState[i]-B)/C;
            }
            else {
                ans+=((classState[i]-B)/C+1);
            }
        }
        System.out.println(ans);
    }
}